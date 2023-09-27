#!/bin/sh

# Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
# Copyright (C) Dassault Systemes - 2022-2023 - Clement DAVID
#
# Helper script to build all Linux images
#

usage="Usage: $(basename "$0") --registry CI_REGISTRY_IMAGE --builder DOCKER_LINUX_BUILDER DOCKER_TAG
Build and push all Docker images to a specific DOCKER_TAG

where:
        --help                            show this help text and exit
    -r, --registry CI_REGISTRY_IMAGE      set the GitLab CI_REGISTRY_IMAGE to push images to
    -b, --builder DOCKER_LINUX_BUILDER    build the DOCKER_LINUX_BUILDER image, like CI_REGISTRY_IMAGE/linux-builder-BRANCH
    -p, --prebuild DOCKER_LINUX_PREBUILD  build the DOCKER_LINUX_PREBUILD image, like CI_REGISTRY_IMAGE/linux-prebuild-BRANCH
    -t, --testers                         build the CI_REGISTRY_IMAGE/{fedora, ubuntu, debian} images
        --runner                          build the CI_REGISTRY_IMAGE/linux-runner image from the tarball
    
Example to push images for mr325:
 docker login registry.gitlab.com/scilab/scilab
 .gitlab-ci/$(basename "$0") --registry registry.gitlab.com/scilab/scilab --builder registry.gitlab.com/scilab/scilab/linux-builder-main mr325
"

set -e

CI_REGISTRY_IMAGE=""
DOCKER_LINUX_BUILDER=""
DOCKER_LINUX_PREBUILD=""
DOCKER_TAG=""
TESTERS=""
RUNNER=""
while :
do
  case "$1" in
    -h | --help)
      echo "$usage"
      exit 0
      ;;
    -r | --registry)
      if [ $# -ne 0 ]; then
        CI_REGISTRY_IMAGE="$2"
      fi
      shift 2
      ;;
    -b | --builder)
      if [ $# -ne 0 ]; then
        DOCKER_LINUX_BUILDER="$2"
      fi
      shift 2
      ;;
    -p | --prebuild)
      if [ $# -ne 0 ]; then
        DOCKER_LINUX_PREBUILD="$2"
      fi
      shift 2
      ;;
    -t | --testers)
      TESTERS=testers
      shift 1
      ;;
    --runner)
      RUNNER=runner
      shift 1
      ;;
    --) # End of all options
      shift
      break
      ;;
    -*)
      echo "Error: Unknown option: $1" >&2
      exit 1 
      ;;
    *)  # No more options
      DOCKER_TAG="$1"
      break
      ;;
  esac
done

# check mandatory arguments
if test ! -n "${DOCKER_TAG}"; then
  echo "Error: undefined DOCKER_TAG argument" >&2
  exit 1
fi

# build the linux builder image
if test -n "${DOCKER_LINUX_BUILDER}"; then
  docker build -t "${DOCKER_LINUX_BUILDER}:${DOCKER_TAG}" \
    - <.gitlab-ci/Dockerfile.linux
  docker push "${DOCKER_LINUX_BUILDER}:${DOCKER_TAG}"
  docker rmi "${DOCKER_LINUX_BUILDER}:${DOCKER_TAG}"
fi

# build the linux dependencies image
if test -n "${DOCKER_LINUX_PREBUILD}"; then
  docker build -t "${DOCKER_LINUX_PREBUILD}:${DOCKER_TAG}" \
    --build-arg DOCKER_LINUX_BUILDER=$(echo $DOCKER_LINUX_PREBUILD | sed s/prebuild/builder/) \
    --build-arg DOCKER_TAG=${DOCKER_TAG} \
    - <.gitlab-ci/Dockerfile.linux.prebuild
  docker push "${DOCKER_LINUX_PREBUILD}:${DOCKER_TAG}"
  docker rmi "${DOCKER_LINUX_PREBUILD}:${DOCKER_TAG}"
fi

# build linux distribution
if test -n "${CI_REGISTRY_IMAGE}" && test -n "${TESTERS}"; then
  docker build -t "${CI_REGISTRY_IMAGE}/ubuntu-18.04:${DOCKER_TAG}" \
    --build-arg DISTRO=ubuntu:18.04 \
    - <.gitlab-ci/linux-images/Dockerfile.ubuntu
  docker build -t "${CI_REGISTRY_IMAGE}/ubuntu-20.04:${DOCKER_TAG}" \
    --build-arg DISTRO=ubuntu:20.04 \
    - <.gitlab-ci/linux-images/Dockerfile.ubuntu
  docker build -t "${CI_REGISTRY_IMAGE}/ubuntu-22.04:${DOCKER_TAG}" \
    --build-arg DISTRO=ubuntu:22.04 \
    - <.gitlab-ci/linux-images/Dockerfile.ubuntu
  docker build -t "${CI_REGISTRY_IMAGE}/fedora-37:${DOCKER_TAG}" \
    --build-arg DISTRO=fedora:37 \
    - <.gitlab-ci/linux-images/Dockerfile.fedora
  docker build -t "${CI_REGISTRY_IMAGE}/debian-11:${DOCKER_TAG}" \
    --build-arg DISTRO=debian:11 \
    - <.gitlab-ci/linux-images/Dockerfile.ubuntu
  
  docker push "${CI_REGISTRY_IMAGE}/ubuntu-18.04:${DOCKER_TAG}"
  docker push "${CI_REGISTRY_IMAGE}/ubuntu-20.04:${DOCKER_TAG}"
  docker push "${CI_REGISTRY_IMAGE}/ubuntu-22.04:${DOCKER_TAG}"
  docker push "${CI_REGISTRY_IMAGE}/fedora-37:${DOCKER_TAG}"
  docker push "${CI_REGISTRY_IMAGE}/debian-11:${DOCKER_TAG}"
  
  docker rmi "${CI_REGISTRY_IMAGE}/ubuntu-18.04:${DOCKER_TAG}"
  docker rmi "${CI_REGISTRY_IMAGE}/ubuntu-20.04:${DOCKER_TAG}"
  docker rmi "${CI_REGISTRY_IMAGE}/ubuntu-22.04:${DOCKER_TAG}"
  docker rmi "${CI_REGISTRY_IMAGE}/fedora-37:${DOCKER_TAG}"
  docker rmi "${CI_REGISTRY_IMAGE}/debian-11:${DOCKER_TAG}"
fi

# build a tagged docker image
if test -n "${CI_REGISTRY_IMAGE}" && test -n "${RUNNER}"; then
  docker build -t "${CI_REGISTRY_IMAGE}/linux-runner:${DOCKER_TAG}" \
    --build-arg "DOCKER_LINUX_BUILDER=${DOCKER_LINUX_BUILDER}:${DOCKER_TAG}" \
    --build-arg "DOCKER_LINUX_RUNNER=${CI_REGISTRY_IMAGE}/linux-runner" \
    --build-arg "DOCKER_TAG=${DOCKER_TAG}" \
    --build-arg "SCI_VERSION_STRING=${SCI_VERSION_STRING}" \
    -f .gitlab-ci/Dockerfile.linux.runner \
    - < "$SCI_VERSION_STRING.bin.$ARCH.tar.xz"
  docker push "${CI_REGISTRY_IMAGE}/linux-runner:${DOCKER_TAG}"
  docker rmi "${CI_REGISTRY_IMAGE}/linux-runner:${DOCKER_TAG}"
fi

docker image prune --force
exit 0

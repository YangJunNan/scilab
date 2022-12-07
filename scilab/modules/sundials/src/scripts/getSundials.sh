#!/bin/bash
SUNDIALS_VERSION=6.3.0
SUNDIALS_DIR=patched_sundials
rm -rf $SUNDIALS_DIR
rm -f sundials-$SUNDIALS_VERSION.tar.gz
curl -LO  https://github.com/LLNL/sundials/releases/download/v$SUNDIALS_VERSION/sundials-$SUNDIALS_VERSION.tar.gz
CMD="s/sundials-$SUNDIALS_VERSION/$SUNDIALS_DIR/"
tar --transform $CMD -xzf sundials-$SUNDIALS_VERSION.tar.gz
echo copy sundials_extension.h in $SUNDIALS_DIR/include/sundials/
cp sundials_extension.h $SUNDIALS_DIR/include/sundials/
cd $SUNDIALS_DIR
patch -p1 < ../sundials_extension.patch
patch -p1 < ../lapack.patch
mkdir build
cd build
cmake -DENABLE_OPENMP=ON ..
cd ..
cp build/include/sundials/*.h include/sundials
patch -p1 < ../sundials_export.h.patch
patch -p1 < ../sundials_config.h.patch
#rm -rf build
cd ..
cp -a $SUNDIALS_DIR ..

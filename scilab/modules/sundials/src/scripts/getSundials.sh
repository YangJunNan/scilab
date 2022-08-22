#!/bin/bash
SUNDIALS_VERSION=6.3.0
SUNDIALS_DIR=patched_sundials
rm -rf $SUNDIALS_DIR
rm -f sundials-$SUNDIALS_VERSION.tar.gz
wget https://github.com/LLNL/sundials/releases/download/v$SUNDIALS_VERSION/sundials-$SUNDIALS_VERSION.tar.gz
CMD="s/sundials-$SUNDIALS_VERSION/$SUNDIALS_DIR/"
tar --transform $CMD -xzf sundials-$SUNDIALS_VERSION.tar.gz
echo copy sundials_extension.h in $SUNDIALS_DIR/include/sundials/
cp sundials_extension.h $SUNDIALS_DIR/include/sundials/
cd $SUNDIALS_DIR
patch -p1 < ../sundials_extension.patch
patch -p1 < ../lapack.patch
mkdir build
cd build
cmake ..
cd ../..
cp $SUNDIALS_DIR/build/include/sundials/*.h $SUNDIALS_DIR/include/sundials
rm -rf $SUNDIALS_DIR/build/
cp -a patched_sundials ..

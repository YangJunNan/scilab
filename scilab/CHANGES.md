Welcome to Scilab 2024.1.0
==========================

This file details the changes between Scilab 2024.1.0 (this version), and the previous stable 2023.1.0 release (including information from 2024.0.0).
For changelogs of earlier releases, please see [Scilab 2024.0.0][1].

Summary:

- New features
- Obsolete functions & features
- Removed functions & features
- Installation, Compilation, Packaging, API/ABI changes
- Fixed bugs

Please report anything we could have missed, on the [mailing lists][2] or the [bug tracker][3].

[1]: https://help.scilab.org/docs/2023.1.0/en_US/CHANGES.html
[2]: https://www.scilab.org/about/community/mailing-lists
[3]: https://gitlab.com/scilab/scilab/-/issues

New features
------------

For a high-level description of the main new features of this release, please consult the [embedded help][4]. It is also available as the "What's new" page of the help, by simply typing `help` in the Scilab console.

[4]: modules/helptools/data/pages/homepage-en_US.html

In summary, the main new features and additions are:

### New functions

- Timeseries introduces a large set of functions and features to simplify the management of timed data and data tables in Scilab.
- `cvode()`, `arkode()`, `ida()` and `kinsol()` from [SUNDIALS](https://computing.llnl.gov/projects/sundials).
- `compress()` and `decompress()` functions manage compressed archives (ZIP, tar.gz and tar.xz files).
- `angle()` computes the argument of complex numbers, in radians.

### Language changes

- `arguments/end` keywords added: validate function input arguments in a standard way (using standard error messages) and faster than using Scilab code (`type`, `typeof`, ...).
  Some helpers have been added for this new block: `mustBeSameType`, `mustBeEqualDimsOrScalar`, ...
  Some Scilab functions (`modulo`, `pmodulo`, ...) and modules (`time`, ...) have been updated to use this new block hence enhancing their performances.
- `select/case` supports multiple cases with `cells`.
- When calling a function or extracting values, it is possible to skip an output argument. If a variable is named `_` the output value will not be assigned (e.g. `[r1, _, r3,...] = func(...)`).

### Web tools

- Use `curl` as default in `atomsDownload()` for all OS to handle local file repositories.
- `url_encode()` and `url_decode()` are added.
- Headers added as optional input arguments to `http_*` functions.
- Cookie management added to webtools module.

### Graphics

- New marker types added for graphic objects:
  - triangles pointing to data: upward, downward, left, right,
  - horizontal line (minus sign) centred on data,
  - vertical line centred on data.
- `errbar()` function uses horizontal line marks.
- `subplot()` manages `frame` uicontrols.

### Differential equations

- Several features added to `cvode()`, `arkode()`, `ida()` and `kinsol()` through optional arguments (`cvode()` and `ida()` have specific sensitivity features).
- Absolute and relative numerical tolerances added to `intl()` input arguments.

### Sparse matrices

- [ColPack](https://github.com/CSCsw/ColPack) graph colouring algorithms for sparse Jacobian computation have been integrated.

### String

- `strsubst()` manages group in replacement.
- `string()` accepts `lists`, `cells` and `structs`.

Obsolete functions or features
------------------------------

All these functions and features will be removed in Scilab 2025.0.0 (October 2024):

- `splitURL()`: Please use `url_split()` instead.
- `getURL()`: Please use `http_get()` instead.
- `sound()`: Please use `playsnd()` instead.

Removed Functions
-----------------

The following functions have been removed:

- `dnaupd()`, `dneupd()`, `dsaupd()`, `dseupd()`, `znaupd()`, `zneupd()`, obsolete since Scilab 2023.0.0. Please use `eigs()` instead.
- `plotframe()`, obsolete since Scilab 2023.0.0. Please use `plot2d([], [], 0, "011", " ", [xmin ymin ymax ymax])` instead.
- `svd(X, 0)`, obsolete since Scilab 2023.0.0. Please use `svd(X, "e")` instead.
- `xget('fpf')` and `xset('fpf')`, obsolete since Scilab 2023.0.0. Please use the `fpf` argument of `contour()`, `contourf()` and `contour2d()` instead.

Removed Features
----------------

The following features and usages have been removed or disabled:

- Matlab Sparse datatype has been removed (See #16285).

Compilation
-----------

- Required version of Autoconf updated to 2.71 (for Linux aarch64 and macOS Apple M1).
- Required version of Automake updated to 1.16.5 (for Linux aarch64 and macOS Apple M1).
- Required version of JDK updated to Java 17.
- Required version of JoGL updated to 2.5.0.
- Required version of HDF5 updated to 1.10.10.
- Required version of MATIO updated to 1.5.9.
- New dependency: libarchive >= 3.1 (used on `compress` and `decompress` functions).

Packaging & Supported Operating Systems
---------------------------------------

- 32-bit platforms are not supported (no binary versions released).

- Native macOS M1/arm64 build is provided (at least 2 x faster than Intel build using Rosetta emulation).

- Scilab embedded JVM is Java 17 without a memory usage limit. Java heap size limit can still be set in Preferences (General / Java Heap Memory).

- To run or compile Scilab, you might need:
  - Windows (amd64):
    - Windows 11 (Desktop)
    - Windows 10 (Desktop)
    - Windows 8 (Desktop)
  - macOS:
    - Intel-based Mac running macOS 10.9+ (run) and 10.14+ (compile)
    - M1-based Mac running macOS 11+ (run, compile).
  - Linux (amd64):
    - debian:11
    - ubuntu:18.04, 20.04, 22.04, 23.10
    - fedora:38

API/ABI modification
--------------------

- External toolboxes can use C++14, C++17, C++20 or more recent versions
- Javasci source/target version switched from 6 to 7 (minimal version supported by Java 17).
- Windows F2C compiler is no longer used due to its limited COMMON support, please use Intel Fortran Compiler Classic.

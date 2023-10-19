Welcome to Scilab 2024.0.0
==========================

This file details the changes between Scilab 2024.0.0 (this version), and the previous 2023.1.0 release.
For changelogs of earlier releases, please see [Scilab 2023.1.0][1].

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
- `angle()` computes the argument of complex numbers, in radians.
- `compress()` and `decompress()` functions manage compressed archive (ZIP, tar.gz and tar.xz files).
- `cvode()`, `arkode()`, `ida()` and `kinsol()` from [SUNDIALS](https://computing.llnl.gov/projects/sundials).

### Language changes

- `arguments/end` keywords added: validate function input arguments in a standard way (using standard error messages) and faster than using Scilab code (`type`, `typeof`, ...).
  Some helpers have been added for this new block: `mustBeSameType`, `mustBeEqualDimsOrScalar`, ...
  Some Scilab functions (`modulo`, `pmodulo`, ...) and modules (`time`, ...) have been updated to use this new block hence enhancing theirs performances.
- `select/case` now supports multiple cases with `cells`.
- When calling a function or extracting values, it is now possible to skip an output argument. If a variable is named `_` the output value will not be assigned (e.g. `[r1, _, r3,...] = func(...)`).

### Webtools

- Use `curl` as default in `atomsDownload()` for all OS to handle local file repositories.
- `url_encode()` and `url_decode()` are added.
- Add headers as optional input argument in `http_*` functions.
- Add cookie management in webtools module.

### Graphics

- New markers types added for graphic objects:
  - triangles pointing to data: upward, downward, left, right,
  - horizontal line (minus sign) centered on data,
  - vertical line centered on data.
- `errbar()` function now uses horiontal line marks.
- `subplot()` now manages `frame` uicontrols.

### Differential equations

- [ColPack](https://github.com/CSCsw/ColPack) graph coloring algorithms for sparse jacobian computation have been integrated.
- The `cvode()` and `ida()` functions have optional sensitivity features through extra arguments.
- Add absolute and relative numerical tolerances in `intl()` input arguments.

### String

- `strsubst()` now manages group in replacement.
- `string()` accepts list, cell and struct.

Obsolete functions or features
------------------------------

All these functions and features will be removed in Scilab 2025.0.0 (October 2024):

- `splitURL()`: please use `url_split()` instead.
- `getURL()`: please use `http_get()` instead.
- `sound()`: please use `playsnd()` instead.

Removed Functions
-----------------

The following functions have been removed:

- `dnaupd()`, `dneupd()`, `dsaupd()`, `dseupd()`, `znaupd()`, `zneupd()`, obsolete since Scilab 2023.0.0. Please use `eigs()` instead.
- `plotframe()`, obsolete since Scilab 2023.0.0. Please use `plot2d([], [], 0, "011", " ", [xmin ymin ymax ymax])` instead.
- `svd(X, 0)`, obsolete since Scilab 2023.0.0. Please use `svd(X, "e")` instead.
- `xget('fpf')` and `xset('fpf')`, obsolete since Scilab 2023.0.0. Please use `fpf` argument of `contour()`, `contourf()`, `contour2d()` instead.

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

- Scilab embedded JVM is Java 17.

- To run or compile Scilab, you might need:
  - Windows (amd64):
    - Windows 11 (Desktop)
    - Windows 10 (Desktop)
    - Windows 8 (Desktop)
  - macOS (amd64):
    - Intel-based Mac running macOS 10.9+ (run) and 10.14+ with Conda (compile)
    - Support of macOS Sonoma added
  - Linux (amd64):
    - debian:11
    - ubuntu:18.04, 20.04, 22.04, 23.10
    - fedora:38

API/ABI modification
--------------------

- Javasci source/target version switched from 6 to 7 (minimal version supported by Java 17).
- Windows F2C compiler is no more used due to its limited COMMON support, please use Intel Fortran Compiler Classic.

Issue Fixes
-----------

- [#6503](https://gitlab.com/scilab/scilab/-/issues/6503): `select/case` now supports grouped cases (e.g. `{1, 2}` matches `1`or `2`.).
- [#8339](https://gitlab.com/scilab/scilab/-/issues/8339): Mac OS X file browser was not working as expected.
- [#9123](https://gitlab.com/scilab/scilab/-/issues/9123): `strsubst()` did not handle group remplacement.
- [#11852](https://gitlab.com/scilab/scilab/-/issues/11852): File Browser did not update when creating a file from SciNotes (Save/Save As).
- [#11951](https://gitlab.com/scilab/scilab/-/issues/11951): Calls to `unzip.exe`, `zip.exe` and `gzip.exe` have been replaced by new `compress` and `decompress` functions.
- [#11979](https://gitlab.com/scilab/scilab/-/issues/11979): `csvTextScan()` returned unexpected results with blank space separators.
- [#12280](https://gitlab.com/scilab/scilab/-/issues/12280): `atomsExtract()` (`unzip` & `untar`) features are now available in other functions using new `compress` and `decompress` functions.
- [#13579](https://gitlab.com/scilab/scilab/-/issues/13579): `bar()` and `barh()` no more display useless and annoying warnings about data transpose.
- [#13601](https://gitlab.com/scilab/scilab/-/issues/13601): New `angle()` function has been added for calculating argument (angle) for a complex number.
- [#13841](https://gitlab.com/scilab/scilab/-/issues/13841): `toolbox_skeleton` no more contains a version requirement (considering it is given for current Scilab version).
- [#14037](https://gitlab.com/scilab/scilab/-/issues/14037): `light()` made graphics very unstable (`java.lang.NullPointerException`).
- [#14053](https://gitlab.com/scilab/scilab/-/issues/14053): Display of cell arrays with scalar components had regressed compared to Scilab 5.x.
- [#14068](https://gitlab.com/scilab/scilab/-/issues/14068): SciNotes not more backuped files on closing.
- [#14760](https://gitlab.com/scilab/scilab/-/issues/14760): `writeb()`, `write4b()`, `readb()` and `read4b()` functions documentation has been removed (functions were removed in Scilab 6.0.0).
- [#14797](https://gitlab.com/scilab/scilab/-/issues/14797): Tooltip no more worked for `edit` style uicontrols.
- [#14963](https://gitlab.com/scilab/scilab/-/issues/14963): Interrupting or abort execution of an uicontrol callback was not possible.
- [#15074](https://gitlab.com/scilab/scilab/-/issues/15074): There was a memory leak in figure `colormap` property management (also occuring in `addcolor()` and `color()`).
- [#15328](https://gitlab.com/scilab/scilab/-/issues/15328): Scilab is now compiled using JDK 17 and run with JRE 17.
- [#15568](https://gitlab.com/scilab/scilab/-/issues/15568): `savematfile()` did not support `boolean`/`logical` variables with version greater than 4.
- [#15570](https://gitlab.com/scilab/scilab/-/issues/15570): `savematfile()` and `loadmatfile()` corrupted UTF-8 character strings.
- [#15574](https://gitlab.com/scilab/scilab/-/issues/15574): `loadmatfile()` loaded logical arrays as `uint8` instead of as `booleans`.
- [#15727](https://gitlab.com/scilab/scilab/-/issues/15727): `savematfile()` returned an error when used with cells or structures including some `booleans`.
- [#15730](https://gitlab.com/scilab/scilab/-/issues/15730): `matfile_listvar()` and `loadmatfile()` crashed Scilab when the file contains some structure saved in version lesser than 7.3.
- [#15767](https://gitlab.com/scilab/scilab/-/issues/15767): `test_run("cacsd", "bug_13359")` randomly failed (graphics related issues).
- [#15790](https://gitlab.com/scilab/scilab/-/issues/15790): The label of a datatip customized with `polyline.display_function` and created in a batch session opened with the `-quit` option was not rendered.
- [#15837](https://gitlab.com/scilab/scilab/-/issues/15837): It was not possible to get reliable big integers (`int64`, `uint64`) from literal inputs.
- [#16256](https://gitlab.com/scilab/scilab/-/issues/16256): `loadmatfile()` trimed the value of a character string in a structure field to its first character with version greater than 6.
- [#16285](https://gitlab.com/scilab/scilab/-/issues/16285): `Matlab sparse` type (7) has been removed (was almost not used).
- [#16317](https://gitlab.com/scilab/scilab/-/issues/16317): `sci2exp(complex([1 1], [%nan %inf]))` was not correctly evaluable.
- [#16333](https://gitlab.com/scilab/scilab/-/issues/16333): `tree_show(Xcos_diagram)` crashed Scilab.
- [#16367](https://gitlab.com/scilab/scilab/-/issues/16367): `http_get()` did not work with long filenames.
- [#16533](https://gitlab.com/scilab/scilab/-/issues/16533): A `javax.media.opengl.GLException: Caught GLException: Not a GL2 implementation` exception sometimes occured in Xcos.
- [#16544](https://gitlab.com/scilab/scilab/-/issues/16544): On some platforms, plotting failed with Java messages.
- [#16595](https://gitlab.com/scilab/scilab/-/issues/16595): `string(macro)` and `tree2code()` returned wrong code for multiline arrays including some comments.
- [#16642](https://gitlab.com/scilab/scilab/-/issues/16642): `$` failed when defining an empty variable using `x=[], x(1:$)=1` and left `x` unchanged.
- [#16700](https://gitlab.com/scilab/scilab/-/issues/16700): `scifunc_block_m` block behavior changed since Scilab 6.0.0 (Scilab 5.x behavior restored).
- [#16736](https://gitlab.com/scilab/scilab/-/issues/16736): `xcosDiagramToScilab()` was deeply unstable and crashed Scilab.
- [#16753](https://gitlab.com/scilab/scilab/-/issues/16753): Xcos block `block.z` and `block.oz` variables could not be updated at simulation flag `2`.
- [#16759](https://gitlab.com/scilab/scilab/-/issues/16759): Scilab could not be build with HDF5 1.10.7 under Debian.
- [#16772](https://gitlab.com/scilab/scilab/-/issues/16772): Datatip failed when the related curve was on overlaping axes or child of a `frame` uicontrol.
- [#16857](https://gitlab.com/scilab/scilab/-/issues/16857): The colon operator in `start:step:stop` sometimes exceeded the stop limit.
- [#16894](https://gitlab.com/scilab/scilab/-/issues/16894): File Browser did not refresh after a `deletefile()` instruction.
- [#16931](https://gitlab.com/scilab/scilab/-/issues/16931): States were not accessible in Xcos blocks defined as Scilab functions.
- [#16935](https://gitlab.com/scilab/scilab/-/issues/16935): Variable was sometimes modified after a call to a graphics function.
- [#16938](https://gitlab.com/scilab/scilab/-/issues/16938): `slint()` is now applicable to any file extension.
- [#16940](https://gitlab.com/scilab/scilab/-/issues/16940): `string()` output was broken for structs, lists or cells.
- [#16947](https://gitlab.com/scilab/scilab/-/issues/16947): `NOR_Gate.zcos` Xcos demonstration failed to simulate.
- [#16950](https://gitlab.com/scilab/scilab/-/issues/16950): `tree_show()` now manages visualization of heterogenous object leaves.
- [#16973](https://gitlab.com/scilab/scilab/-/issues/16973): New `urlencode()` & `urldecode()` functions have been added.
- [#16974](https://gitlab.com/scilab/scilab/-/issues/16974): `scilab_macros.txt` and `scilab_primitives.txt` files contents is now sorted and files are no more part of Scilab source tree.
- [#17003](https://gitlab.com/scilab/scilab/-/issues/17003): `slint()` now focuses on code maintenance and actual errors by default (instead of on code style).
- [#17004](https://gitlab.com/scilab/scilab/-/issues/17004): `L = list(mode, lines), L(2)()` returned an error instead of running `lines()`.
- [#17009](https://gitlab.com/scilab/scilab/-/issues/17009): Legacy API help pages have been removed (these functions must no more be used).
- [#17040](https://gitlab.com/scilab/scilab/-/issues/17040): Scilab is now build and run using Java 17 on Windows.
- [#17043](https://gitlab.com/scilab/scilab/-/issues/17043): Stacktrace sometimes reported a `macro` as a `builtin` and failed to report the erroneous line.
- [#17044](https://gitlab.com/scilab/scilab/-/issues/17044): `test_run("ast", "bug_15701")` failed on new macOS build.
- [#17050](https://gitlab.com/scilab/scilab/-/issues/17050): Clang compilation on macOS was broken (due to removed C++11 `std::unary_function` and `std::binary_function`).
- [#17052](https://gitlab.com/scilab/scilab/-/issues/17052): Using JoGL 2.4.0, docking a figure shrank its axes to a tiny size in the lower left corner of the figure.
- [#17053](https://gitlab.com/scilab/scilab/-/issues/17053): `arl2()` documentation example did not work.
- [#17058](https://gitlab.com/scilab/scilab/-/issues/17058): Redirection of <https://help.scilab.org/docs/current/LANG/index.html> was not up-to-date.
- [#17061](https://gitlab.com/scilab/scilab/-/issues/17061): `cdfnor()` crashed Scilab macOS/arm64 build.
- [#17063](https://gitlab.com/scilab/scilab/-/issues/17063): The 16kB limit for the content of `if/for/while/select` was still documented but the limit no more existed since Scilab 6.0.0.
- [#17067](https://gitlab.com/scilab/scilab/-/issues/17067): `config.sub` was outdated.
- [#17068](https://gitlab.com/scilab/scilab/-/issues/17068): Under macOS, arm64 CPU architecture was wrongly detected during configuration of `ilib_build()`.
- [#17070](https://gitlab.com/scilab/scilab/-/issues/17070): The `xlabel()` web help page contained references to `zlabel()` in its title.
- [#17072](https://gitlab.com/scilab/scilab/-/issues/17072): `http_*()` functions now manage cookies.
- [#17074](https://gitlab.com/scilab/scilab/-/issues/17074): `write()` did not write text-content to the file.
- [#17075](https://gitlab.com/scilab/scilab/-/issues/17075): Scilab sometimes crashed when using complex matrices.
- [#17087](https://gitlab.com/scilab/scilab/-/issues/17087): `SCI/modules/sparse/src/c/lu.c` file did not compile when using recent versions of `clang`.
- [#17094](https://gitlab.com/scilab/scilab/-/issues/17094): `http_get()` was extremely slow when no filename argument was provided.
- [#17095](https://gitlab.com/scilab/scilab/-/issues/17095): Trying to change Scilab language using Preferences GUI did not reflect user selection in GUI.
- [#17100](https://gitlab.com/scilab/scilab/-/issues/17100): Scilab froze when displaying a variable under `pause` mode in ode.
- [#17102](https://gitlab.com/scilab/scilab/-/issues/17102): macOS configure cannot find `iconv` (dependency of `libarchive`.
- [#17106](https://gitlab.com/scilab/scilab/-/issues/17106): Under macOS, "Settings" item menu was not showing.
- [#17107](https://gitlab.com/scilab/scilab/-/issues/17107): C compiler detection failed with error under Windows when no compiler was installed.
- [#17110](https://gitlab.com/scilab/scilab/-/issues/17110): Under macOS, SciNotes save dialog selected parent of current directory as default.
- [#17120](https://gitlab.com/scilab/scilab/-/issues/17120): Display of cells was broken.
- [#17122](https://gitlab.com/scilab/scilab/-/issues/17122): Scilab crashed after `xsave()` on closing specific `bar()` figure.
- [#17127](https://gitlab.com/scilab/scilab/-/issues/17127): The "Acknowledgements" window (in Scilab About Box) was not readonly.
- [#17129](https://gitlab.com/scilab/scilab/-/issues/17129): `checkNamedArguments()` wrongly listed `varargout`.
- [#17130](https://gitlab.com/scilab/scilab/-/issues/17130): File Browser toolbar buttons generated spurious display in console.

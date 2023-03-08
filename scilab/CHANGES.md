Welcome to Scilab 2023.0.0
==========================

This file details the changes between Scilab 2023.0.0 (this version), and the previous 6.1.1 release.
For changelogs of earlier releases, please see [Scilab 6.1.1][1].

Summary:
- New features
- Obsolete functions & features
- Removed functions & features
- Installation, Compilation, Packaging, API/ABI changes
- Fixed bugs

Please report anything we could have missed, on the [mailing lists][2] or the [bug tracker][3].

[1]: https://help.scilab.org/docs/6.1.1/en_US/CHANGES.html
[2]: https://www.scilab.org/about/community/mailing-lists
[3]: https://gitlab.com/scilab/scilab/-/issues


Main new features
-----------------

For a high-level description of the main new features of this release, please consult the [embedded help][4]. It is also available as the "What's new" page of the help, by simply typing `help` in Scilab console.

[4]: modules/helptools/data/pages/homepage-en_US.html

In summary, the main new features and additions are:
* `axes.auto_stretch` property added.
* `http_get()` function now sets `accept-encoding` flag.
* Optional `verbose` parameter added to `http_get()`.
* `atomsInstall()` will now try to build a package (containing only Scilab code) locally from sources when no compatible binary version is found.
* Polynomial exponent display can either use ascii or unicode, and is configurable through preferences (See issue #16871).
* `toJSON(var, filename, indent)` implemented, after `toJSON(var, filename)`.
* `fromJSON` and `toJSON` processing of `tab` (`ascii(9)`) is changed.
* `for c = h,.., end` now accepts an hypermatrix `h` and iterates over its columns `matrix(h, size(h,1),-1)`.
* When an operation fails due to mismatching sizes of operands, the sizes are now displayed in the message.
* Displaying `covWrite("html", dir)` results is improved.
* `tbx_make(".", "localization")` can now update files of translated messages according to new gettext entries in the code.


Obsolete functions or features
------------------------------

All these functions and features will be removed in Scilab 2024.0.0 (October 2023):
* `dnaupd()`, `dneupd()`, `dsaupd()`, `dseupd()`, `znaupd()`, `zneupd()`: Please use `eigs()` instead.
* `plotframe()`: Please use `plot2d([], [], 0, "011", " ", [xmin ymin ymax ymax])` instead.
* `svd(X, 0)`: Please use `svd(X, "e")` instead.
* `xget('fpf')` and `xset('fpf')`: Please use `fpf` argument of `contour()`, `contourf()`, `contour2d()` instead.


Removed Functions
-----------------

The following functions have been removed:
* `%sn`, obsolete since 6.1.0, replaced by `ellipj`.
* `champ1`, obsolete since 6.1.0, replaced by `champ().colored='on'`.
* `closeEditvar`, obsolete since 6.1.0, replaced by `close editvar`.
* `datatipToggle`, obsolete since 6.0.2, replaced by `datatipManagerMode`.
* `dgettext`, obsolete since 6.0.1, replaced by `gettext(domain,..)`.
* `dirname`, obsolete since 6.0.2, replaced by `fileparts(..,'path')`.
* `fplot2d`, obsolete since 6.1.1, replaced by `plot(x, f)`.
* `get_figure_handle`, obsolete since 6.1.0, replaced by `findobj("figure_id", id)`.
* `hist3d`, obsolete since 6.1.0, replaced by `bar3d`.
* `noisegen`, obsolete since 6.1.0, replaced by `grand`.
* `ric_desc`, obsolete since 6.1.0, replaced by `riccati`.
* `saveafterncommands`, obsolete since 6.1.0.
* `scatter3`, obsolete since 6.1.0, replaced by `scatter3d`.
* `setPreferencesValue`, obsolete since 6.1.0, replaced by `xmlSetValues`.
* `soundsec`, obsolete since 6.1.1, replaced by `0 : 1/freq : t*(1-%eps)`.
* `sysdiag`, obsolete since 6.1.0, replaced by `blockdiag`.
* `xdel`, obsolete since 6.1.1, replaced by `close`.
* `xname`, obsolete since 6.1.1, replaced by `gcf().figure_name`.


Removed Features
----------------

The following features and usages have been removed or disabled:
* Datatip `"z_component"` property.
* `-costfunction` and `-outputcommandarg` options of `neldermead_configure()` function. Please use `-function` and `-outputcommand` options.
* `-myterminate` and `-myterminateflag` options of `neldermead_new()` function.
* `add_param()` usage with two input arguments.
* `sinc()` usage with two input arguments.
* `<-- JVM NOT MANDATORY -->` tag in tests. Please use `<-- CLI SHELL MODE -->` instead.
* Overloading functions for hypermatrices using `%hm` code.
* `0` value as `"linestyle"` property for polyline handles. Please use `1` instead.
* `"hidden_axis"` value as `"box"` property for axes handles. Please use `"hidden_axes"` instead.
* `m2sciassume` usage to annotate code for `mfile2sci()`. Please use `m2scideclare` instead.
* `qmr(A, Ap)` usage. Please use `qmr(A)` instead.
* `histc()` usage with `normalization` (boolean) as third argument.
* `ode()` usage with `"roots"` as solver (third argument). Please use `"root"` instead.
* `frexp` is now an internal function. Please use `[m,e]=log2(x)` instead.


Installation
------------

* macOS
   - Scilab now includes an embedded JRE and won't require a system installed JDK at run-time (See issue #13087).


Compilation
-----------

* GNU autotools have been updated to :
   - automake (GNU automake) 1.16.5
   - autoconf (GNU Autoconf) 2.71
   
* All builds require a C++17 compiler. Toolboxes might also want to use this standard by specifying `-std=c++17` as a `CFLAGS` under Linux and macOS.

* Migration to Microsoft Visual Studio 2022 and Intel® oneAPI HPC Toolkit 2022.3.

* macOS: Build environment has been migrated to conda and now relies on clang and libc++, hence (existing) toolboxes with binary gateways have to be (re)compiled using the same conda environment (see https://gitlab.com/scilab/scilab/-/wikis/Developers/setup-Scilab-repository-macOS)


Packaging & Supported Operating Systems
---------------------------------------

* Scilab embedded JVM is Java 8. To run or compile Scilab you need at least:
  - Windows:
     - Windows 10 (Desktop)
     - Windows 8 (Desktop)
     - Windows 7
     - Windows Vista SP2
     - Windows Server 2008 R2 SP1 (64-bit)
     - Windows Server 2012 (64-bit)
  - macOS:
     - Intel-based Mac running macOS 10.9+ (run) and 10.14+ (compile)
     - Support of macOS Monterey & Ventura added in Scilab 2023.0.0
  - Linux:
     - Red Hat Enterprise Linux 5.5+, 6.x (32-bit), 6.x (64-bit), 7.x (64-bit)
     - Oracle Linux 5.5+, 6.x (32-bit), 6.x (64-bit), 7.x (64-bit)
     - Ubuntu Linux 12.04 LTS, 13.x
     - Suse Linux Enterprise Server 10 SP2+, 11.x

    For more information, please consult: [What are the system requirements for Java?][5]

* [SSE2][6], Streaming SIMD Extensions 2 support is now mandatory to run Scilab on Linux i686.

[5]: http://java.com/en/download/help/sysreq.xml
[6]: https://en.wikipedia.org/wiki/SSE2


API/ABI modification
--------------------

* `analysis` module removed.
* `scilab_setVar` function added to API.


Bug Fixes
---------

### Bugs fixed in 2023.0.0:

* [#463](https://gitlab.com/scilab/scilab/-/issues/463): Invalid format led to crash for `write()` function.
* [#6094](https://gitlab.com/scilab/scilab/-/issues/6094): Error message in case of inconsistent operation was reporting wrong dimensions of operands.
* [#7196](https://gitlab.com/scilab/scilab/-/issues/7196): When using `try/catch`, returned value assigned in `catch` statement was not displayed.
* [#7475](https://gitlab.com/scilab/scilab/-/issues/7475): When running `fft()`, Scilab crashed.
* [#8076](https://gitlab.com/scilab/scilab/-/issues/8076): Xcos Superblock Create Mask UI did not have a default value setup.
* [#8353](https://gitlab.com/scilab/scilab/-/issues/8353): Just after launching Scilab, `log10(3)` made Scilab crash.
* [#8734](https://gitlab.com/scilab/scilab/-/issues/8734): `copyfile()` crashed Scilab while playing with locales.
* [#8760](https://gitlab.com/scilab/scilab/-/issues/8760): Masked superblock customization dialog was too complex.
* [#10383](https://gitlab.com/scilab/scilab/-/issues/10383): Xcos Superblock context and mask did not handle Scilab %inf.
* [#13087](https://gitlab.com/scilab/scilab/-/issues/13087): A symbolic link was missing in macOS version.
* [#13360](https://gitlab.com/scilab/scilab/-/issues/13360): `hilbert()` function made Scilab crash.
* [#13902](https://gitlab.com/scilab/scilab/-/issues/13902): `atomsSystemUpdate()` was slow.
* [#14138](https://gitlab.com/scilab/scilab/-/issues/14138): Reading some hdf5 file crashed Scilab.
* [#14155](https://gitlab.com/scilab/scilab/-/issues/14155): Defining and assigning Superblock mask variables was difficult.
* [#14216](https://gitlab.com/scilab/scilab/-/issues/14216): `readxls` could make Scilab crash without any error message.
* [#14372](https://gitlab.com/scilab/scilab/-/issues/14372): `a=L(2:3)` returned an error after `L=list(1,"a",%t)`.
* [#14451](https://gitlab.com/scilab/scilab/-/issues/14451): `fsolve()` was no longer reentrant.
* [#14512](https://gitlab.com/scilab/scilab/-/issues/14512): `isequalbitwise()` was made internal in Scilab 6.0.0 but was still documented.
* [#14585](https://gitlab.com/scilab/scilab/-/issues/14585): `closeEditvar()` had to be replaced by `close("editvar")`.
* [#14691](https://gitlab.com/scilab/scilab/-/issues/14691): Scilab crashed when code was halted then aborted.
* [#14917](https://gitlab.com/scilab/scilab/-/issues/14917): A first empty instruction `; a=1` returned an error.
* [#14998](https://gitlab.com/scilab/scilab/-/issues/14998): `mscanf()` introduced a leading newline (`\n`) and the prompt, before prompting the user for input.
* [#15071](https://gitlab.com/scilab/scilab/-/issues/15071): Extraction of mlist from another mlist behaved differently in Scilab 5 and 6.
* [#15103](https://gitlab.com/scilab/scilab/-/issues/15103): `xcorr()` led to immediate crash.
* [#15106](https://gitlab.com/scilab/scilab/-/issues/15106): `write` Fortran subroutine crashed Scilab in debug mode.
* [#15546](https://gitlab.com/scilab/scilab/-/issues/15546): Superblock mask variables could not be renamed.
* [#15602](https://gitlab.com/scilab/scilab/-/issues/15602): `gca()("thickness")` crashed Scilab.
* [#15657](https://gitlab.com/scilab/scilab/-/issues/15657): Empty categories corrupted the graphical output of `histplot()`.
* [#16029](https://gitlab.com/scilab/scilab/-/issues/16029): Tick marks were extending out of range for small scale plots.
* [#16049](https://gitlab.com/scilab/scilab/-/issues/16049): `struct("v", cell())` crashed Scilab.
* [#16127](https://gitlab.com/scilab/scilab/-/issues/16127): `c = {1:$}` crashed Scilab.
* [#16179](https://gitlab.com/scilab/scilab/-/issues/16179): `pause` inhibited error display when executed in try-catch block.
* [#16196](https://gitlab.com/scilab/scilab/-/issues/16196): `covStart()` did not report errors on invalid arguments.
* [#16278](https://gitlab.com/scilab/scilab/-/issues/16278): Recursive insertion on unknown function call crashed Scilab.
* [#16281](https://gitlab.com/scilab/scilab/-/issues/16281): `bezout(%inf, 1)` and `bezout(%nan, 1)` crashed Scilab.
* [#16336](https://gitlab.com/scilab/scilab/-/issues/16336): Xcos preferences final simulation time was not set on new diagrams.
* [#16408](https://gitlab.com/scilab/scilab/-/issues/16408): `toJSON` crashed in case of wrong parameters order.
* [#16541](https://gitlab.com/scilab/scilab/-/issues/16541): `load()/save()` did not handle the "layout" property correctly.
* [#16555](https://gitlab.com/scilab/scilab/-/issues/16555): Asking for `Details` of Xcos `CLOCK_c` block led to Scilab crash.
* [#16557](https://gitlab.com/scilab/scilab/-/issues/16557): `macr2tree` + `tree2code` translated `e={2}` into `"e=1"` and `e={2,"ab"}` into `"e=[2,"ab"]"`.
* [#16575](https://gitlab.com/scilab/scilab/-/issues/16575): `for m=rand(2,2,2), end` crashed Scilab.
* [#16576](https://gitlab.com/scilab/scilab/-/issues/16576): `macr2tree()` (and maybe `tree2code()`) killed recursive extractions made with indices (was OK with fields).
* [#16593](https://gitlab.com/scilab/scilab/-/issues/16593): `for o = L(3:$), o, end` after `L = list(1,2);` crashed Scilab.
* [#16640](https://gitlab.com/scilab/scilab/-/issues/16640): `glue()` crashed Scilab when called with 'Figure' handle as input.
* [#16653](https://gitlab.com/scilab/scilab/-/issues/16653): `fromJSON()` crashed with a non existing file.
* [#16670](https://gitlab.com/scilab/scilab/-/issues/16670): `c(1)(3).line_style = 8;` where `c` is a list of vectors of polyline handles crashed Scilab.
* [#16676](https://gitlab.com/scilab/scilab/-/issues/16676): `sfact([%s %s ; %s %s])` crashed Scilab after "sfact: Wrong value for input argument #1: singular or asymmetric problem." message.
* [#16704](https://gitlab.com/scilab/scilab/-/issues/16704): New Xcos schemas were not set to preferences-defined parameters.
* [#16713](https://gitlab.com/scilab/scilab/-/issues/16713): Automatic stretching of Axes box in 3d view was not configurable.
* [#16717](https://gitlab.com/scilab/scilab/-/issues/16717): An error occured in `findobj()` when no object existed.
* [#16732](https://gitlab.com/scilab/scilab/-/issues/16732): Information about file overwriting and Fortran formats was missing in `write()` help page.
* [#16734](https://gitlab.com/scilab/scilab/-/issues/16734): `findobj()` was slower than before.
* [#16748](https://gitlab.com/scilab/scilab/-/issues/16748): Build failed with OCaml 4.11 or newer build without unsafe-strings
* [#16750](https://gitlab.com/scilab/scilab/-/issues/16750): Xcos RELATIONALOP's icon became blank when editing the block.
* [#16755](https://gitlab.com/scilab/scilab/-/issues/16755): `plot3d` polygon facets rendering could be wrong when exactly in horizontal or vertical plane.
* [#16771](https://gitlab.com/scilab/scilab/-/issues/16771): `fullpath("existing_path/*.ext")` crashed Scilab under Windows.
* [#16785](https://gitlab.com/scilab/scilab/-/issues/16785): `xsave`/`save` of datatips produced double free in data model.
* [#16786](https://gitlab.com/scilab/scilab/-/issues/16786): `zoom_box` property was not correctly saved.
* [#16796](https://gitlab.com/scilab/scilab/-/issues/16796): `isreal(complex(1,%nan),0)` returned `%T` instead of `%F`.
* [#16797](https://gitlab.com/scilab/scilab/-/issues/16797): `atomsGui()` could produce some `field <module_name> unknown` error after running the `File / Update List of Packages` menu.
* [#16798](https://gitlab.com/scilab/scilab/-/issues/16798): `scinotes()` with option and non existing file crashed Scilab.
* [#16801](https://gitlab.com/scilab/scilab/-/issues/16801): Management of `covWrite("html")` results wrapping was wrong.
* [#16803](https://gitlab.com/scilab/scilab/-/issues/16803): `tbx_build_localization(…)` and `tbx_make(dir, "localization")` never updated existing .po files.
* [#16812](https://gitlab.com/scilab/scilab/-/issues/16812): While the help browser was open, `atomsLoad("linalg")` errored and broke the loading.
* [#16822](https://gitlab.com/scilab/scilab/-/issues/16822): `getrelativefilename()` returned incorrect value in case of same beginning of directory names.
* [#16823](https://gitlab.com/scilab/scilab/-/issues/16823): `Mtbxfun_db.txt` was missing the Scilab releases (`m2sci` module).
* [#16826](https://gitlab.com/scilab/scilab/-/issues/16826): `file()` or `file(fid)` could return outdated relative paths.
* [#16836](https://gitlab.com/scilab/scilab/-/issues/16836): `tbx_generate_pofile(…)` (and so `tbx_build_localization(…)`) silently failed for any module with too (but no so) many files to process.
* [#16841](https://gitlab.com/scilab/scilab/-/issues/16841): Zoom on multiaxes could desynchronize axes.
* [#16845](https://gitlab.com/scilab/scilab/-/issues/16845): Replot button or `replot(gcf())` failed for legends.
* [#16848](https://gitlab.com/scilab/scilab/-/issues/16848): For negative `mcolors` values, `scatter()` and `scatter3d()` did not map correctly the colormap.
* [#16849](https://gitlab.com/scilab/scilab/-/issues/16849): `toJSON("\\")` was on escaping "\\\\" properly.
* [#16853](https://gitlab.com/scilab/scilab/-/issues/16853): `plot(1:2, 'MarkerEdgeColor', [0.2 0.8 0.6])` returned an error.
* [#16861](https://gitlab.com/scilab/scilab/-/issues/16861): `repmat()` was broken for any sparse matrix input.
* [#16864](https://gitlab.com/scilab/scilab/-/issues/16864): `macr2tree()` interpreted `a=1:2, b=a(2)` as a funcall instead of as an extraction operation (Scilab 6.0 regression).
* [#16865](https://gitlab.com/scilab/scilab/-/issues/16865): Vector extraction with single hypermatrix index returned a vector.
* [#16867](https://gitlab.com/scilab/scilab/-/issues/16867): `macr2tree()` encoded `.'` (transpose) as `'` (conjugate transpose).
* [#16871](https://gitlab.com/scilab/scilab/-/issues/16871): Choosing the display of Polynomial exponents with either ascii or unicode characters was not possible through preferences.
* [#16879](https://gitlab.com/scilab/scilab/-/issues/16879): `members(N,H)` was very slow and crashed the computer for big `N` or/and `H` arrays of non-double data.
* [#16883](https://gitlab.com/scilab/scilab/-/issues/16883): `mprintf("%d %d\n", h);` called after `h=cat(3, [1 2], [3 4]);` crashed Scilab (same issue with `msprintf()`).
* [#16887](https://gitlab.com/scilab/scilab/-/issues/16887): French localization for `tbx_build_loader()` messages fixed.
* [#16893](https://gitlab.com/scilab/scilab/-/issues/16893): `exec()` instruction could make Scilab crash.
* [#16899](https://gitlab.com/scilab/scilab/-/issues/16899): configure script did not detect clang.
* [#16900](https://gitlab.com/scilab/scilab/-/issues/16900): no-gui build of Scilab raised an error at startup.
* [#16902](https://gitlab.com/scilab/scilab/-/issues/16902): `-lstdc++fs` flag broke link for recent C++17 compilers.
* [#16904](https://gitlab.com/scilab/scilab/-/issues/16904): `copy()` did not work for some handle types in Scilab 6.
* [#16905](https://gitlab.com/scilab/scilab/-/issues/16905): Unitary and non-regression tests using graphics did run although Scilab was compiled with `--without-gui` option.
* [#16907](https://gitlab.com/scilab/scilab/-/issues/16907): Logical OR operation on false sparse matrices could lead to Scilab crash.
* [#16908](https://gitlab.com/scilab/scilab/-/issues/16908): `macr2tree` crashed when members of an object were called as a function.
* [#16909](https://gitlab.com/scilab/scilab/-/issues/16909): `read()` might crash when building Scilab with gfortran >= 11.
* [#16911](https://gitlab.com/scilab/scilab/-/issues/16911): Wrong line number in callstack fixed.
* [#16912](https://gitlab.com/scilab/scilab/-/issues/16912): Some tools/functions still mentioned Scilab Enterprises and ESI Group as Scilab maintainer and/or Scilab trademark handler.
* [#16913](https://gitlab.com/scilab/scilab/-/issues/16913): InnoSetup files had not been updated after MKL upgrade.
* [#16914](https://gitlab.com/scilab/scilab/-/issues/16914): Wrong line number was returned in case of t/mlist extraction overload.
* [#16919](https://gitlab.com/scilab/scilab/-/issues/16919): MList overload extraction was not compatible with Scilab 5.5.2
* [#16920](https://gitlab.com/scilab/scilab/-/issues/16920): MatrixExp insertion in an empty matrix and using colon (such as `a =[]; a(:)=["a","a"];`) crashed Scilab.
* [#16921](https://gitlab.com/scilab/scilab/-/issues/16921): `var2vec()` documentation improved.
* [#16923](https://gitlab.com/scilab/scilab/-/issues/16923): `http_get(..., follow=%t)` could not be used without a filename argument.
* [#16924](https://gitlab.com/scilab/scilab/-/issues/16924): Xcos Superblock mask could not be used to add variables.
* [#16925](https://gitlab.com/scilab/scilab/-/issues/16925): Xcos modelica simulation failed when model name contained `-`.
* [#16932](https://gitlab.com/scilab/scilab/-/issues/16932): `toJSON()` did not escape TABs properly.
* [#16940](https://gitlab.com/scilab/scilab/-/issues/16940): `string` of cell, struct, list did not call overload.

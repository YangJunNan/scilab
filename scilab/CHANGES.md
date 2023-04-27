Welcome to Scilab 2023.1.0
==========================

This file details the changes between Scilab 2023.1.0 (this version), and the previous 2023.0.0 release.
For changelogs of earlier releases, please see [Scilab 2023.0.0][1].

Summary:
- New features
- Obsolete functions & features
- Installation, Compilation, Packaging, API/ABI changes
- Fixed bugs

Please report anything we could have missed, on the [mailing lists][2] or the [bug tracker][3].

[1]: https://help.scilab.org/docs/2023.0.0/en_US/CHANGES.html
[2]: https://www.scilab.org/about/community/mailing-lists
[3]: https://gitlab.com/scilab/scilab/-/issues


New features
------------

For a high-level description of the main new features of this release, please consult the [embedded help][4]. It is also available as the "What's new" page of the help, by simply typing `help` in Scilab console.

[4]: modules/helptools/data/pages/homepage-en_US.html

In summary, the main new features and additions are:
* <TODO>


Obsolete functions or features
------------------------------

All these functions and features will be removed in Scilab 2025.0.0 (October 2024):
* `getURL()`: Please use `http_get()` instead.
* <TODO>


Installation
------------

* <TODO>


Compilation
-----------

* Minimal version of JoGL (2.4.0) enforced.


Packaging & Supported Operating Systems
---------------------------------------

* To run or compile Scilab you need at least:
  - Linux with Docker images (amd64):
     - debian:11
     - ubuntu:18.04, 20.04, 22.04
     - fedora:37


Bug Fixes
---------
### Bugs fixed in 2023.1.0:

* [#3666](https://gitlab.com/scilab/scilab/-/issues/3666): `input()` badly reencoded UTF-8 input strings
* [#8666](https://gitlab.com/scilab/scilab/-/issues/8666): Linear algebra demonstration failed with xerbla error.
* [#8812](https://gitlab.com/scilab/scilab/-/issues/8812): Multi-selection in a listbox now works when `max - min` is greater than 1.
* [#8917](https://gitlab.com/scilab/scilab/-/issues/8917): `write(filename,..)` could not overwrite an existing file.
* [#12391](https://gitlab.com/scilab/scilab/-/issues/12391): `findobj("figure_id", num)` changed current figure (returned by `gcf()`).
* [#15075](https://gitlab.com/scilab/scilab/-/issues/15075): `read` was slow with dims == -1.
* [#15075](https://gitlab.com/scilab/scilab/-/issues/15075): `read` was slow when reading an unknown number of lines (dims == -1).
* [#13307](https://gitlab.com/scilab/scilab/-/issues/13307): Clicking on the same item from a listbox a second time did not trigger the callback.
* [#15709](https://gitlab.com/scilab/scilab/-/issues/15709): `tbx_make(.,"help")` needed a `languages` option to target building to some chosen languages.
* [#16685](https://gitlab.com/scilab/scilab/-/issues/16685): `asciimat()` now belongs to the `m2sci` module, where its code, pages and tests should be.
* [#16804](https://gitlab.com/scilab/scilab/-/issues/16804): `[s,m]=assert_checkequal(1,%z)` yielded an error instead of silently returning the error message in `m`.
* [#16859](https://gitlab.com/scilab/scilab/-/issues/16859): TKSCALE example had a flash duration. END_c and ENDBLK blocks were in the Sinks and/or Misc palettes instead of in Events.
* [#16868](https://gitlab.com/scilab/scilab/-/issues/16868): `justify(hypermat,..)` processed only the first page `hypermat(:,:,1)`.
* [#16872](https://gitlab.com/scilab/scilab/-/issues/16872): `cat()` did not apply `[,]` and `[;]` input transtyping rules.
* [#16877](https://gitlab.com/scilab/scilab/-/issues/16877): `cellstr()` & `iscellstr()` now belong to the `m2sci` module, where their code, pages and tests should be.
* [#16878](https://gitlab.com/scilab/scilab/-/issues/16878): `or(%i, dim)` and `and(%i, dim)` yielded an error.
* [#16906](https://gitlab.com/scilab/scilab/-/issues/16906): In the `param3d()` documentation, the descriptions of alpha and theta were inverted.
* [#16941](https://gitlab.com/scilab/scilab/-/issues/16941): `fplot3d(xr,yr,f,theta,..)` ignored theta.
* [#16951](https://gitlab.com/scilab/scilab/-/issues/16951): Javasci failed to load Scilab in nwni mode.
* [#16953](https://gitlab.com/scilab/scilab/-/issues/16953): `mgetl` did not trigger stream status end-of-file.
* [#16958](https://gitlab.com/scilab/scilab/-/issues/16958): preferences for polynomial display were ignored at startup.
* [#16960](https://gitlab.com/scilab/scilab/-/issues/16960): `write()` prints/writes an empty line in console/file when the input is an empty string.
* [#16962](https://gitlab.com/scilab/scilab/-/issues/16962): Tag `getURL` Obsolete.
* [#16966](https://gitlab.com/scilab/scilab/-/issues/16966): The warning message for removal of `xset/xget` did not tell which function displayed the message.
* [#16968](https://gitlab.com/scilab/scilab/-/issues/16968): `cov` generated a warning (xerbla) or maked Scilab crash (MKL generation issue).
* [#16969](https://gitlab.com/scilab/scilab/-/issues/16969): WSL default position was out of screen.
* [#16970](https://gitlab.com/scilab/scilab/-/issues/16970): Tests on `types::` in Webtools gateways fixed and http_upload example fixed.
* [#16980](https://gitlab.com/scilab/scilab/-/issues/16980): `contour` fpf = ' ' did not turn off labels.
* [#16982](https://gitlab.com/scilab/scilab/-/issues/16982): vcruntime140_1.dll was missing in Windows package.
* [#16983](https://gitlab.com/scilab/scilab/-/issues/16983): `input(msg)` no longer printed the message.
* [#16986](https://gitlab.com/scilab/scilab/-/issues/16986): MPI module must be active during build, build doc and packaging process.
* [#16987](https://gitlab.com/scilab/scilab/-/issues/16987): "Move object" icon was missing in figures menubar under Linux/MacOS.
* [#16988](https://gitlab.com/scilab/scilab/-/issues/16988): Scilab did not start in case of wrong encoding of `SCI/etc/modules.xml`.
* [#16989](https://gitlab.com/scilab/scilab/-/issues/16989): `atomsSystemUpdate()` could not more be run in NWNI mode.
* [#16991](https://gitlab.com/scilab/scilab/-/issues/16991): Scilab run without Java failed at startup if preferences file (XConfiguration.xml) did not exist.
* [#16995](https://gitlab.com/scilab/scilab/-/issues/16995): `hist3d` plotting feature no more worked in variable browser and variable editor.
* [#17001](https://gitlab.com/scilab/scilab/-/issues/17001): Improve AppStream metadata
* [#17008](https://gitlab.com/scilab/scilab/-/issues/17008): The C code displayed in the `API Scilab/API double functions` documentation page did not match the code used in the next runnable script, and was not compilable.
* [#17011](https://gitlab.com/scilab/scilab/-/issues/17011): `Matplot` crashed because of missing `rect` input argument.
* [#17014](https://gitlab.com/scilab/scilab/-/issues/17014): The tolerance required for the `rat` computation should verify `abs(N./D - X) <= tol * norm(X, 1)` (help page fixed).
* [#17022](https://gitlab.com/scilab/scilab/-/issues/17022): `kroneck()` returned wrong error message.
* __add your bug fix here and keep this line__

### Bugs fixed in 6.1.2:

* [#463](https://gitlab.com/scilab/scilab/-/issues/463): Invalid format leads to crash for write function.
* [#7196](https://gitlab.com/scilab/scilab/-/issues/7196): try/catch: returned value assigned in `catch` is not displayed.
* [#7475](https://gitlab.com/scilab/scilab/-/issues/7475): When running fft, the scilab program crashes.
* [#8353](https://gitlab.com/scilab/scilab/-/issues/8353): Just after launching scilab, `log10(3)` makes Scilab crash.
* [#8734](https://gitlab.com/scilab/scilab/-/issues/8734): copyfile crash Scilab while playing with locales.
* [#13360](https://gitlab.com/scilab/scilab/-/issues/13360): hilbert function make scilab crash.
* [#13902](https://gitlab.com/scilab/scilab/-/issues/13902): `atomsSystemUpdate()` was slow.
* [#14138](https://gitlab.com/scilab/scilab/-/issues/14138): reading some hdf5 file crashes scilab.
* [#14216](https://gitlab.com/scilab/scilab/-/issues/14216): readxls can make Scilab crash without any error message.
* [#14372](https://gitlab.com/scilab/scilab/-/issues/14372): after `L=list(1,"a",%t), a=L(2:3)` returned an error.
* [#14451](https://gitlab.com/scilab/scilab/-/issues/14451): fsolve is no longer reentrant, causes crash.
* [#14512](https://gitlab.com/scilab/scilab/-/issues/14512): `isequalbitwise()` was made internal in 6.0.0 but was still documented.
* [#14691](https://gitlab.com/scilab/scilab/-/issues/14691): scilab crashes when code is halted then aborted.
* [#14998](https://gitlab.com/scilab/scilab/-/issues/14998): `mscanf()` introduces a leading \n newline and the prompt before prompting the user for input
* [#15071](https://gitlab.com/scilab/scilab/-/issues/15071): Extraction of mlist from another mlist debhaves differently in Scilab 6.
* [#15602](https://gitlab.com/scilab/scilab/-/issues/15602): gca()("thickness") crashed Scilab.
* [#15657](https://gitlab.com/scilab/scilab/-/issues/15657): Empty categories corrupted the graphical output of  `histplot()`.
* [#15103](https://gitlab.com/scilab/scilab/-/issues/15103): xcorr leads to immediate crash.
* [#16029](https://gitlab.com/scilab/scilab/-/issues/16029): tick marks were extending out of range for small scale plots.
* [#16049](https://gitlab.com/scilab/scilab/-/issues/16049): `struct("v", cell())` crashes Scilab.
* [#16281](https://gitlab.com/scilab/scilab/-/issues/16281): `bezout(%inf, 1)` and `bezout(%nan, 1)` crashed Scilab
* [#16408](https://gitlab.com/scilab/scilab/-/issues/16408): `toJSON` crashed with wrong parameters order.
* [#16555](https://gitlab.com/scilab/scilab/-/issues/16555): Details of Xcos CLOCK_c block led to crash
* [#16557](https://gitlab.com/scilab/scilab/-/issues/16557): `macr2tree` + `tree2code` translated `e={2}` into `"e=1"` and `e={2,"ab"}` into `"e=[2,"ab"]"`.
* [#16575](https://gitlab.com/scilab/scilab/-/issues/16575): for m=rand(2,2,2), end crashes Scilab.
* [#16127](https://gitlab.com/scilab/scilab/-/issues/16127): c = {1:$} crashed Scilab.
* [#16179](https://gitlab.com/scilab/scilab/-/issues/16179): `pause` inhibits error display when executed in try-catch block.
* [#16653](https://gitlab.com/scilab/scilab/-/issues/16653): `fromJSON()` crashed with a non existing file.
* [#16713](https://gitlab.com/scilab/scilab/-/issues/16713): Automatic stretching of Axes box in 3d view was not configurable.
* [#16717](https://gitlab.com/scilab/scilab/-/issues/16717): An error occured in findobj when no objects existed.
* [#16732](https://gitlab.com/scilab/scilab/-/issues/16732): `write()` page: typo, missing information about file overwriting and Fortran formats.
* [#16734](https://gitlab.com/scilab/scilab/-/issues/16734): `findobj()` was slower than before.
* [#16748](https://gitlab.com/scilab/scilab/-/issues/16748): Build failed with OCaml 4.11 or newer build without unsafe-strings
* [#16786](https://gitlab.com/scilab/scilab/-/issues/16786): zoom_box property was not correctly saved.
* [#16796](https://gitlab.com/scilab/scilab/-/issues/16796): `isreal(complex(1,%nan),0)` returned `%T` instead of `%F`.
* [#16798](https://gitlab.com/scilab/scilab/-/issues/16798): `scinotes()` with option and non existing file crashed scilab.
* [#16801](https://gitlab.com/scilab/scilab/-/issues/16801): Management of `covWrite("html")` results wrapping was poor.
* [#16812](https://gitlab.com/scilab/scilab/-/issues/16812): `atomsLoad("linalg")` while the help browser is opened yielded an error breaking the loading.
* [#16822](https://gitlab.com/scilab/scilab/-/issues/16822): `getrelativefilename()` returned incorrect value in case of same beginning of directory names.
* [#16826](https://gitlab.com/scilab/scilab/-/issues/16826): `file()` or `file(fid)` could yield outdated relative paths.
* [#16841](https://gitlab.com/scilab/scilab/-/issues/16841): Zoom on multiaxes could desynchronize axes.
* [#16849](https://gitlab.com/scilab/scilab/-/issues/16849): toJSON("\\") must return "\\\\" instead of "\\\".
* [#16859](https://gitlab.com/scilab/scilab/-/issues/16859): TKSCALE example had a flash duration. END_c and ENDBLK blocks were in the Sinks and/or Misc palettes instead of in Events.
* [#16865](https://gitlab.com/scilab/scilab/-/issues/16865): Vector extraction with single hypermatrix index yielded a vector.
* [#16593](https://gitlab.com/scilab/scilab/-/issues/16593): After L = list(1,2); , for o = L(3:$), o, end crashes Scilab.
* [#16029](https://bugzilla.scilab.org/16029): tick marks were extending out of range for small scale plots 
* [#16278](https://gitlab.com/scilab/scilab/-/issues/16278): Recursive insertion on unknown function call crashes Scilab.
* [#16336](https://bugzilla.scilab.org/16336): Xcos preferences final simulation time was not set on new diagrams.
* [#16196](https://bugzilla.scilab.org/16196): covStart() did not report errors on invalid arguments.
* [#16653](https://bugzilla.scilab.org/16653): fromJSON() crashed with a non existing file.
* [#16670](https://gitlab.com/scilab/scilab/-/issues/16670): c(1)(3).line_style = 8; where c is a list of vectors of polyline handles crashes Scilab.
* [#16713](https://bugzilla.scilab.org/16713): Automatic stretching of Axes box in 3d view was not configurable.
* [#16704](https://bugzilla.scilab.org/16704): New Xcos schemas were not set to preferences-defined parameters.
* [#16717](https://bugzilla.scilab.org/16717): An error occured in findobj when no objects existed.
* [#16734](https://bugzilla.scilab.org/16734): `findobj()` was slower than before.
* [#16748](https://bugzilla.scilab.org/16748): Build failed with OCaml 4.11 or newer build without unsafe-strings
* [#16798](https://bugzilla.scilab.org/16798): `scinotes()` with option and non existing file crashed scilab.
* [#16826](https://bugzilla.scilab.org/16826): `file()` or `file(fid)` could yield outdated relative paths.
* [#16822](https://bugzilla.scilab.org/16822): `getrelativefilename()` returned incorrect value in case of same beginning of directory names.
* [#16755](https://bugzilla.scilab.org/16755): plot3d polygon facets rendering may be wrong when exactly in horizontal or vertical plane
* [#16771](https://gitlab.com/scilab/scilab/-/issues/16771): fullpath("existing_path/*.ext") crashed Scilab under Windows.
* [#16823](https://gitlab.com/scilab/scilab/-/issues/16823): `[m2sci]Mtbxfun_db.txt` was missing the Scilab releases.
* [#16841](https://bugzilla.scilab.org/16841): Zoom on multiaxes could desynchronize axes.
* [#16845](https://gitlab.com/scilab/scilab/-/issues/16845): Replot button or `replot(gcf())` failed for legends.
* [#16848](https://gitlab.com/scilab/scilab/-/issues/16848): For negative mcolors, `scatter()` and `scatter3d()` did not map correctly the colormap.
* [#16849](https://bugzilla.scilab.org/16849): toJSON("\\") must return "\\\\" instead of "\\\".
* [#16861](https://gitlab.com/scilab/scilab/-/issues/16861): `repmat()` was broken for any input sparse matrix.
* [#16864](https://gitlab.com/scilab/scilab/-/issues/16864): macr2tree(): after a=1:2, b=a(2) is pseudocoded as a funcall instead of as an extraction operation (Scilab 6.0 regression)
* [#16865](https://bugzilla.scilab.org/16865): Vector extraction with single hypermatrix index yielded a vector.
* [#16867](https://gitlab.com/scilab/scilab/-/issues/16867): macr2tree() encoded .' (transpose) as ' (conjugate transpose).
* [#16879](https://gitlab.com/scilab/scilab/-/issues/16879): `members(N,H)` was very slow and crashed the computer for big N or/and H arrays of non-Double data.
* [#16883](https://gitlab.com/scilab/scilab/-/issues/16883): After h=cat(3, [1 2], [3 4]), mprintf("%d %d\n", h); crashes Scilab (idem with msprintf()).
* [#16887](https://gitlab.com/scilab/scilab/-/issues/16887): French localization for `tbx_build_loader()` messages fixed.
* [#16893](https://gitlab.com/scilab/scilab/-/issues/16893): "exec" instruction crashes Scilab.
* [#16899](https://gitlab.com/scilab/scilab/-/issues/16899): configure script did not detect clang.
* [#16900](https://gitlab.com/scilab/scilab/-/issues/16900): no-gui build of Scilab raised an error at startup.
* [#16905](https://gitlab.com/scilab/scilab/-/issues/16905): Unitary and non-regression tests using graphics did run although scilab compiled `--without-gui`.
* [#16907](https://gitlab.com/scilab/scilab/-/issues/16907): Logical OR operation on false sparse matrices could lead to Scilab crash.
* [#16909](https://gitlab.com/scilab/scilab/-/issues/16909): `read()` may crash when building Scilab with gfortran >= 11.
* [#16911](https://gitlab.com/scilab/scilab/-/issues/16911): Wrong line number in callstack.
* [#16912](https://gitlab.com/scilab/scilab/-/issues/16912): Some tools/functions still mentioned Scilab Enterprises and ESI Group as Scilab maintainer and/or Scilab trademark handler.
* [#16913](https://gitlab.com/scilab/scilab/-/issues/16913): InnoSetup files was not updated after MKL upgrade.
* [#16914](https://gitlab.com/scilab/scilab/-/issues/16914): Wrong line number with t/mlist extraction overload.
* [#16919](https://gitlab.com/scilab/scilab/-/issues/16919): MList overload extraction compatibility with scilab 5.5.2
* [#16923](https://gitlab.com/scilab/scilab/-/issues/16923): unable to use `http_get(..., follow=%t)` without a filename argument.
* [#16920](https://gitlab.com/scilab/scilab/-/issues/16920): MatrixExp insertion in an empty matrix and using colon crashes Scilab.
* [#16932](https://gitlab.com/scilab/scilab/-/issues/16932): toJSON() did not escape TABs properly.


### Bugs fixed in 6.1.1:
* [#3188](https://bugzilla.scilab.org/3188): `part()` was slower than in Scilab 4.1.2.
* [#4648](https://bugzilla.scilab.org/4648): Scilab missed more secure hashing functions (md5 is now broken)
* [#5511](https://bugzilla.scilab.org/5511): `printf_conversion` help page was poorly presented and had many issues: The described types of accepted value and the printed result were often switched; nothing was told about the processing of complex numbers; special escaped sequences \n \r \t \\ was not described; possible numbering of placeholders was not described; in the pt_BR version, the itemized lists were wrongly unnested and characters typing placeholders (d,u,o,x,f,e,g..) were missing.
* [#7202](https://bugzilla.scilab.org/7202): It was not possible to send string parameters via the opar structure of an xcos block to a block of type 4.
* [#8059](https://bugzilla.scilab.org/8059): A local `.wgetrc` config file could make troubles in `atomsDownload`.
* [#8100](https://bugzilla.scilab.org/8100): `cumsum()` on sparse documented.
* [#8378](https://bugzilla.scilab.org/8378): Datatip `ContextMenu => Delete last datatip` was useless.
* [#8761](https://bugzilla.scilab.org/8761): Xcos masked superblocks had invalid names.
* [#9221](https://bugzilla.scilab.org/9221): There was no way in Scilab to easily access to sets of Unicode symbols like Greek letters, etc.
* [#9909](https://bugzilla.scilab.org/9909): In the help browser, add a way to open the online version of the current page.
* [#10046](https://bugzilla.scilab.org/10046): By default, the `MAXMIN` block did not propose 2 input ports to work in an element-wise way (unlike MIN_f and MAX_f).
* [#10465](https://bugzilla.scilab.org/10465): At Scilab exit, the help browser is not saved nor restored.
* [#10476](https://bugzilla.scilab.org/10476): From `browsevar`, displaying the content of lists, structures, cells, or other custom tlists or mlists was not possible.
* [#10490](https://bugzilla.scilab.org/10490): The `mapsound` page was poor with a single interesting example.
* [#10964](https://bugzilla.scilab.org/10964): Scinotes could not execute the current file in NW mode.
* [#11600](https://bugzilla.scilab.org/11600): `rand()` was parsing its inputs incorrectly.
* [#11677](https://bugzilla.scilab.org/11677): The original Arnoldi functions were obsolete.
* [#11888](https://bugzilla.scilab.org/11888): The `struct` page did not document how to build an array of structures.
* [#12418](https://bugzilla.scilab.org/12418): Using bvode() with "continuation", i.e. `ipar(9) > 1` led to an error.
* [#12516](https://bugzilla.scilab.org/12516): From `browsevar`, clicking on any graphical handle did not edit its figure with `ged`.
* [#12532](https://bugzilla.scilab.org/12532): From `browsevar`, clicking on any function did not edit it with `edit`. The content of libraries could not be displayed either.
* [#12719](https://bugzilla.scilab.org/12719): `A(%s)` gave the same result as `A($)`.
* [#12889](https://bugzilla.scilab.org/12889): In the help browser, add a menu allowing you to select the language of help pages, regardless of the language of the session.
* [#13303](https://bugzilla.scilab.org/13303): `mprintf`, `msprintf` and `mfprintf` could not print input booleans.
* [#13417](https://bugzilla.scilab.org/13417): `csvRead` page did not document the way to use the `range` up to the last row/column.
* [#13593](https://bugzilla.scilab.org/13593): `csvRead()` did not take the `range` into account when `header` is provided. `[]` could not be used as the default `range`.
* [#13762](https://bugzilla.scilab.org/13762): On the `fft` page, the formula for the inverse FFT missed the 1/n normalization factor.
* [#13855](https://bugzilla.scilab.org/13855): The documentation of `pause` was not up-to-date and could be improved.
* [#13985](https://bugzilla.scilab.org/13985): The display of lists was very loose and poor.
* [#14033](https://bugzilla.scilab.org/14033): `x_matrix` could not edit matrices of booleans, encoded integers, or text. Matrices of real or complex numbers were poorly displayed.
* [#14098](https://bugzilla.scilab.org/14098): The `genlib` and `library` help pages were outdated concerning Scilab 6.
* [#14297](https://bugzilla.scilab.org/14297): Documentation of `cumsum()` improved.
* [#14435](https://bugzilla.scilab.org/14435): Errors were not well handled in overloaded functions.
* [#14477](https://bugzilla.scilab.org/14477): `mtlb_sparse()` removed from the documentation.
* [#14488](https://bugzilla.scilab.org/14488): The `frameflag=9` and `strf=".9."` values of these `plot2d` options were no longer accepted. Their documentation was ambiguous.
* [#14567](https://bugzilla.scilab.org/14567): In Scinotes, the `TODO` keyword was no longer highlighted.
* [#14718](https://bugzilla.scilab.org/14718): `user` is removed for a while but was still documented.
* [#14873](https://bugzilla.scilab.org/14873): `setfield` page: The output and the 6.0 history were documented only on the en_US version. The input was wrongly restricted to matrices, while any Scilab object is acceptable. The specific role of `setfield` for mlists was not really described nor illustrated. The example did not include any call to setfield.
* [#15012](https://bugzilla.scilab.org/15012): `covStart(["isempty" ; "isscalar"])` crashed Scilab.
* [#15163](https://bugzilla.scilab.org/15163): `getdate` page: The time referential was obscure: a) UTC for Unix Time Convention vs Coordinated Universal Time. b) unclear influence of the time zone.
* [#15226](https://bugzilla.scilab.org/15226): The `get` page needed to be overhauled: `get(0)`, `get(0,prop)`, `get(tag)`, `get(tag,prop)` and other features were not documented.
* [#15280](https://bugzilla.scilab.org/15280): `gsort` was unable to sort any hypermatrix along dimensions > "r"|"c".
* [#15293](https://bugzilla.scilab.org/15293): scilab had troubles when comparing 2 lists L==L with void components.
* [#15330](https://bugzilla.scilab.org/15330): spec.tst was crashing on Linux.
* [#15839](https://bugzilla.scilab.org/15839): `gsort`: the only sparse possible input were real or complex vectors, and only with the `g` method.
* [#15841](https://bugzilla.scilab.org/15841): `intersect` supported neither sparse boolean nor sparse numeric inputs.
* [#15842](https://bugzilla.scilab.org/15842): `unique` could not process 2D sparse matrices.
* [#15868](https://bugzilla.scilab.org/15868): `setdiff(s,s2)` yielded an error when `s` or/and `s2` is sparse encoded.
* [#15954](https://bugzilla.scilab.org/15954): `mfile2sci` abusively added a 6 lines `mode(0); ieee(1)` header to every converted file.
* [#16069](https://bugzilla.scilab.org/16069): `[].figure_name` crashes Scilab.
* [#16106](https://bugzilla.scilab.org/16106): Xcos sciblk4 user-defined blocks did not handle opar and odstate/oz correctly.
* [#16122](https://bugzilla.scilab.org/16122): Concatenate polynomials with different variables did not raise an error.
* [#16141](https://bugzilla.scilab.org/16141): Recursive extraction `(m:n)($)` crashed Scilab
* [#16151](https://bugzilla.scilab.org/16151): `isequal(1:$, 2:$)` returned `%T`.
* [#16193](https://bugzilla.scilab.org/16193): `covStart()` clear previous coverage information. `profileEnable()` could be used to append a macro later on.
* [#16196](https://bugzilla.scilab.org/16196): `covStart()` help page was incomplete about the API usage.
* [#16274](https://bugzilla.scilab.org/16274): `assert_checkequal()` did not considered equal matching Nan or void elements in (nested) containers.
* [#16284](https://bugzilla.scilab.org/16284): `typename()` still considered removed uncompiled macros (11, "m"), and "mc" overloading code instead of "function".
* [#16288](https://bugzilla.scilab.org/16288): An error message from `wavread` was wrong.
* [#16297](https://bugzilla.scilab.org/16297): After function test(), e={}, endfunction; macr2tree(test)  crashes Scilab.
* [#16305](https://bugzilla.scilab.org/16305): `unwrap()` failed unfolding curves with straight segments.
* [#16337](https://bugzilla.scilab.org/16337): The 3rd output of `[U,km,ku] = unique(..)` was not implemented.
* [#16340](https://bugzilla.scilab.org/16340): `setdiff("","")` produced `""` instead of `[]`. The `"c"` and `"r"` options yielded an error for string inputs. Input arguments were poorly checked.
* [#16342](https://bugzilla.scilab.org/16342): `strcat()` was much slower in Scilab 6.0.2.
* [#16350](https://bugzilla.scilab.org/16350): In if/while conditions, the empty sparse boolean was considered as TRUE.
* [#16358](https://bugzilla.scilab.org/16358): `isdef([],..)` yielded an error instead of returning [].
* [#16357](https://bugzilla.scilab.org/16357): `script2var` did get variables generated by `exec()`.
* [#16362](https://bugzilla.scilab.org/16362): Sparse empty matrix could no be concatenated.
* [#16365](https://bugzilla.scilab.org/16365): `median(m,"r")` and `median(m,"c")` yielded wrong results (6.1.0 regression)
* [#16366](https://bugzilla.scilab.org/16366): `plot([0 1], ":")` plotted a dash-dotted curve instead of a dotted one.
* [#16369](https://bugzilla.scilab.org/16369): Right divisions / involving one or two sparse numerical matrices were no longer supported.
* [#16370](https://bugzilla.scilab.org/16370): `msprintf()` did not handle LaTeX dollars anymore.
* [#16374](https://bugzilla.scilab.org/16374): Any plot with datatips saved in Scilab 5.5 could not be loaded in Scilab 6.
* [#16385](https://bugzilla.scilab.org/16385): In Xcos without any diagram, the menu `Simulation => Modelica initialize` displayed "Undefined variable: flag" in the console.
* [#16391](https://bugzilla.scilab.org/16391): `csvRead()` was crashing with CSV files containing empty lines.
* [#16396](https://bugzilla.scilab.org/16396): Recursive extraction `(m:n)(:)` crashed Scilab
* [#16397](https://bugzilla.scilab.org/16397): The display of long (real) column vectors was slow (regression).
* [#16399](https://bugzilla.scilab.org/16399): `mtlb_zeros([])` was crashing Scilab.
* [#16401](https://bugzilla.scilab.org/16401): Global `external_object_java` class was crashing Scilab.
* [#16403](https://bugzilla.scilab.org/16403): 1D extraction of a matrix with an implicit index had wrong dimensions.
* [#16406](https://bugzilla.scilab.org/16406): `edit_curv` yielded an error when reading data.
* [#16407](https://bugzilla.scilab.org/16407): Fec rendering was incorrect
* [#16408](https://bugzilla.scilab.org/16408): `toJSON(var, indent, filename)` is the right call sequence. Documentation has been updated.
* [#16438](https://bugzilla.scilab.org/16438): `asciimat(text)` did not accept strings of different lengths or including some extended UTF-8 characters.
* [#16445](https://bugzilla.scilab.org/16445): `colorbar(..)` ignored how to guess `umin` and `umax` for a Champ object (with .colored="on").
* [#16449](https://bugzilla.scilab.org/16449): Insertion of implicit vector in Cell was crashing Scilab
* [#16450](https://bugzilla.scilab.org/16450): Concatenating encoded integers with decimal or complex numbers was not possible.
* [#16451](https://bugzilla.scilab.org/16451): `setdiff(a,b,"r"|"c")` with a and b boolean yielded an error.
* [#16452](https://bugzilla.scilab.org/16452): `setdiff(sparse([1 3 0 2]), sparse([3 7]))` missed returning 0, and wrongly returned 3.
* [#16454](https://bugzilla.scilab.org/16454): `gsort` yielded an error when sorting any sparse vector including some NaN.
* [#16458](https://bugzilla.scilab.org/16458): `mean()` did not handle sparse numerical matrices.
* [#16465](https://bugzilla.scilab.org/16465): Scinotes OpenRecent menu was not updated when it should.
* [#16473](https://bugzilla.scilab.org/16473): Deleting rows in a sparse squared matrix with padding zeros crashed (Scilab 6 regression).
* [#16474](https://bugzilla.scilab.org/16474): `imult(%z)` crashed Scilab.
* [#16476](https://bugzilla.scilab.org/16476): `issquare` was not overloaded.
* [#16488](https://bugzilla.scilab.org/16488): Concatenations mixing boolean and double with at least one operand being sparse were not supported.
* [#16496](https://bugzilla.scilab.org/16496): The `getdate` page should be rewritten: a) `getdate("s")` does NOT take leap seconds into account. b) `D=getdate(X)` is vectorized, accepts fractional seconds and returns them in `[0,1)` in D(10) instead of milliseconds. Moreover, the time referential of the result was unclear (time zone, daylight saving offset).
* [#16504](https://bugzilla.scilab.org/16504): `clock` returned none of the milliseconds, time zone, and daylight saving time.
* [#16508](https://bugzilla.scilab.org/16508): `csvTextScan()` and `csvRead()` did not handle well complex data.
* [#16512](https://bugzilla.scilab.org/16512): `1 ./ uint8(0)` crashes Scilab (idem with int8, uint16, int16, uint32, int32, uint64, int64).
* [#16517](https://bugzilla.scilab.org/16517): `getdate("s")` truncated the actual time to integer seconds. `getdate(u)(10)` returned fractional seconds instead of milliseconds as `getdate()`.
* [#16522](https://bugzilla.scilab.org/16522): `bitget(x,pos)` and `bitset(x,pos)` results could be wrong when `pos` is an encoded integer.
* [#16525](https://bugzilla.scilab.org/16525): `soundsec(t,freq)` has the trivial equivalence `0 : 1/freq : t*(1-%eps)` and should be removed.
* [#16529](https://bugzilla.scilab.org/16529): `deff` could not return the created function as output argument, preventing to create and use anonymous functions. The function's headline and body had to be provided separately. For Simple functions, a one-string input (possibly console-oriented) definition was not supported.
* [#16530](https://bugzilla.scilab.org/16530): `mapsound` needed to be reforged.
* [#16539](https://bugzilla.scilab.org/16539): `fplot2d` is weaker than `plot` and useless. It should be removed.
* [#16540](https://bugzilla.scilab.org/16540): Uicontrol spinner did not "snaptoticks"
* [#16549](https://bugzilla.scilab.org/16549): Simple script crashed Scilab in GUI mode.
* [#16551](https://bugzilla.scilab.org/16551): `num2cell` returned {} for any input array of empty strings.
* [#16552](https://bugzilla.scilab.org/16552): `mfile2sci` conversion of `ispc` and `isunix` still used `MSDOS` removed far ago. Conversion of `ismac` was missing. Conversion of `exist` missed using `mtlb_exist`. Conversion of `dos` yielded some "operation +" warnings. Unit tests for the conversion of `cd`, `dir`, and `ferror` overwrote some Scilab reserved keywords. Conversion of `return` yielded `mtlb(resume)`.
* [#16553](https://bugzilla.scilab.org/16553): `unique(["" ""])` returned `["" ""]`.
* [#16557](https://bugzilla.scilab.org/16557): `macr2tree` + `tree2code` translated `e={2}` into `"e=1"` and `e={2,"ab"}` into `"e=[2,"ab"]"`.
* [#16559](https://bugzilla.scilab.org/16553): `isempty(A)` was true for a sparse matrix of dimension 2^16 or larger.
* [#16561](https://bugzilla.scilab.org/16561): `histplot(-10:0.2:10, 2)` yielded a warning from `histc` and an error.
* [#16565](https://bugzilla.scilab.org/16565): `edit(user_defined_function)` corrupted the original code.
* [#16567](https://bugzilla.scilab.org/16567): `mfile2sci` did not support Matlab block-comments %{ ..%}.
* [#16568](https://bugzilla.scilab.org/16568): The operator `**` was undocumented.
* [#16571](https://bugzilla.scilab.org/16571): `mfile2sci` had several issues when converting the NOT `~` operator: 1) `~(1-1)` was converted into `~1-1` instead of `~(1-1)`  2) `~` applied to an integer expression yielded an error from `convert2double`  3) `~i` was converted into `~%i` instead of `~abs(%i)`.
* [#16573](https://bugzilla.scilab.org/16573): `mfile2sci`: Some `axis` conversions were wrong or not reliable.
* [#16576](https://bugzilla.scilab.org/16576): macr2tree() (and maybe tree2code) kills recursive extractions made with indices (it's OK with fields)
* [#16586](https://bugzilla.scilab.org/16586): `mfile2sci`: The `prettyprintoutput` flag badly managed appended comments.
* [#16592](https://bugzilla.scilab.org/16592): `%i|[]`, `[]|%i`, `%i&[]`, and `[]&%i` were wrong. `%t|%i`, `%t&%i`, and `%i&%t` were not defined.
* [#16596](https://bugzilla.scilab.org/16596): Concatenating encoded integers with sparse numeric data was not possible.
* [#16601](https://bugzilla.scilab.org/16601): `libmatio >= 1.5.18` was not supported.
* [#16608](https://bugzilla.scilab.org/16608): `union` did not support input boolean, sparse boolean, nor sparse numerical matrices. The result of `union(complexA, complexB)` was wrongly conjugate.
* [#16609](https://bugzilla.scilab.org/16609): `bitcmp` needed to be upgraded for Scilab 6.
* [#16612](https://bugzilla.scilab.org/16612): Unlike the `.*.` operator, `kron()` was not defined for sparse numeric matrices.
* [#16613](https://bugzilla.scilab.org/16613): Neither `.*.` nor `kron()` worked with boolean or sparse boolean matrices.
* [#16614](https://bugzilla.scilab.org/16614): Out of gcf(), a figure with some xstring content could be not properly reframed to contents.
* [#16617](https://bugzilla.scilab.org/16617): `gamma` did not support incomplete gamma integrals.
* [#16618](https://bugzilla.scilab.org/16618): `close` could not close the help browser, xcos, nor the variable editor or browser.
* [#16620](https://bugzilla.scilab.org/16620): `derivat` had no reciprocal `polyint` polynomial integration function.
* [#16622](https://bugzilla.scilab.org/16622): `inv` could no longer be overloaded for hypermatrices of decimal or complex numbers.
* [#16623](https://bugzilla.scilab.org/16623): `rand(2,2,2)^2` yielded a wrong result instead of trying to call the `%s_p_s` overload for input hypermatrices.
* [#16624](https://bugzilla.scilab.org/16624): `fullfile` badly handled any forced final file separator when building a directory's path.
* [#16626](https://bugzilla.scilab.org/16626): `==` and `<>` between libraries were no longer defined.
* [#16627](https://bugzilla.scilab.org/16627): `importgui` function's name was not explicit enough. `importgui` is renamed `uiSpreadsheet`. `importgui` internals was public.
* [#16629](https://bugzilla.scilab.org/16629): `interp1`'s documentation did not tell the spline edges conditions; extrapolation modes were poorly explained; the description of the result's size was completely wrong; x as an option was not documented. `periodic` and `edgevalue` extrapolation modes were not available. `linear` extrapolation was not available for splines. When `xp` is an hypermatrix with `size(xp,1)==1`, the size of the result was irregular/wrong.
* [#16631](https://bugzilla.scilab.org/16631): Read-only handle properties were reported as unknown when trying to set them.
* [#16632](https://bugzilla.scilab.org/16632): Scilab did not start with an unsupported locale on macOS.
* [#16636](https://bugzilla.scilab.org/16636): `det(sparse)` most often yielded `Nan`. `[e,m]=det(sparse)` was not actually implemented.
* [#16638](https://bugzilla.scilab.org/16638): `getcolor` had a bunch of issues.
* [#16639](https://bugzilla.scilab.org/16639): `atomsInstall` and `atomsRemove` did not update the Toolboxes menu.
* [#16644](https://bugzilla.scilab.org/16644): `input("message:")` yielded a wrong error message about `mprintf` in case of non-interpretable input.
* [#16654](https://bugzilla.scilab.org/16654): `interp` was leaking memory.
* [#16661](https://bugzilla.scilab.org/16661): `x=spzeros(1e10,1e10)` yielded an incorrect error message.
* [#16664](https://bugzilla.scilab.org/16664): `diag(spzeros(2,2))` yielded an `Operation -[]` warning.
* [#16665](https://bugzilla.scilab.org/16665): `help echo` could not redirect to `help mode` when preferred, for new users coming from Octave.
* [#16677](https://bugzilla.scilab.org/16677): In offline mode, `atomsInstall` was flashing many times on the console.
* [#16679](https://bugzilla.scilab.org/16679): `get_function_path("acosh")` yielded an error (regression from Scilab 6.0.0).
* [#16683](https://bugzilla.scilab.org/16683): The `m2sci` code converter needed a set of fix and improvements.
* [#16685](https://bugzilla.scilab.org/16685): `asciimat("A";"";"B")` yielded a transposed matrix of codes. When processing an hypermatrix of codes, the dim#2 of the result was squeezed (unlike Matlab/Octave's behavior).
* [#16686](https://bugzilla.scilab.org/16686): `strsplit('a','a')`, `strsplit('ab','ab')`,  and `strsplit("abcd","cd")` yielded wrong results.
* [#16687](https://bugzilla.scilab.org/16687): `spec` documentation used messy concurrent notations. It still refered to the Arnoldi module instead of `eigs`. The fr_FR version was incomplete.
* [#16708](https://bugzilla.scilab.org/16708): `mgetl` could not read from stdin.
* [#16711](https://bugzilla.scilab.org/16711): `prettyprint` export to html failed under Linux and macOS.
* [#16714](https://bugzilla.scilab.org/16714): `fullpath` failed to resolve the path depending on pwd.

### Bugs fixed in 6.1.1:
* [#3188](https://gitlab.com/scilab/scilab/-/issues/3188): `part()` was slower than in Scilab 4.1.2.
* [#4648](https://gitlab.com/scilab/scilab/-/issues/4648): Scilab missed more secure hashing functions (md5 is now broken)
* [#5511](https://gitlab.com/scilab/scilab/-/issues/5511): `printf_conversion` help page was poorly presented and had many issues: The described types of accepted value and the printed result were often switched; nothing was told about the processing of complex numbers; special escaped sequences \n \r \t \\ was not described; possible numbering of placeholders was not described; in the pt_BR version, the itemized lists were wrongly unnested and characters typing placeholders (d,u,o,x,f,e,g..) were missing.
* [#7202](https://gitlab.com/scilab/scilab/-/issues/7202): It was not possible to send string parameters via the opar structure of an xcos block to a block of type 4.
* [#8059](https://gitlab.com/scilab/scilab/-/issues/8059): A local `.wgetrc` config file could make troubles in `atomsDownload`.
* [#8100](https://gitlab.com/scilab/scilab/-/issues/8100): `cumsum()` on sparse documented.
* [#8378](https://gitlab.com/scilab/scilab/-/issues/8378): Datatip `ContextMenu => Delete last datatip` was useless.
* [#8761](https://gitlab.com/scilab/scilab/-/issues/8761): Xcos masked superblocks had invalid names.
* [#9221](https://gitlab.com/scilab/scilab/-/issues/9221): There was no way in Scilab to easily access to sets of Unicode symbols like Greek letters, etc.
* [#9909](https://gitlab.com/scilab/scilab/-/issues/9909): In the help browser, add a way to open the online version of the current page.
* [#10046](https://gitlab.com/scilab/scilab/-/issues/10046): By default, the `MAXMIN` block did not propose 2 input ports to work in an element-wise way (unlike MIN_f and MAX_f).
* [#10465](https://gitlab.com/scilab/scilab/-/issues/10465): At Scilab exit, the help browser is not saved nor restored.
* [#10476](https://gitlab.com/scilab/scilab/-/issues/10476): From `browsevar`, displaying the content of lists, structures, cells, or other custom tlists or mlists was not possible.
* [#10490](https://gitlab.com/scilab/scilab/-/issues/10490): The `mapsound` page was poor with a single interesting example.
* [#10964](https://gitlab.com/scilab/scilab/-/issues/10964): Scinotes could not execute the current file in NW mode.
* [#11600](https://gitlab.com/scilab/scilab/-/issues/11600): `rand()` was parsing its inputs incorrectly.
* [#11677](https://gitlab.com/scilab/scilab/-/issues/11677): The original Arnoldi functions were obsolete.
* [#11888](https://gitlab.com/scilab/scilab/-/issues/11888): The `struct` page did not document how to build an array of structures.
* [#12418](https://gitlab.com/scilab/scilab/-/issues/12418): Using bvode() with "continuation", i.e. `ipar(9) > 1` led to an error.
* [#12516](https://gitlab.com/scilab/scilab/-/issues/12516): From `browsevar`, clicking on any graphical handle did not edit its figure with `ged`.
* [#12532](https://gitlab.com/scilab/scilab/-/issues/12532): From `browsevar`, clicking on any function did not edit it with `edit`. The content of libraries could not be displayed either.
* [#12719](https://gitlab.com/scilab/scilab/-/issues/12719): `A(%s)` gave the same result as `A($)`.
* [#12889](https://gitlab.com/scilab/scilab/-/issues/12889): In the help browser, add a menu allowing you to select the language of help pages, regardless of the language of the session.
* [#13303](https://gitlab.com/scilab/scilab/-/issues/13303): `mprintf`, `msprintf` and `mfprintf` could not print input booleans.
* [#13417](https://gitlab.com/scilab/scilab/-/issues/13417): `csvRead` page did not document the way to use the `range` up to the last row/column.
* [#13593](https://gitlab.com/scilab/scilab/-/issues/13593): `csvRead()` did not take the `range` into account when `header` is provided. `[]` could not be used as the default `range`.
* [#13762](https://gitlab.com/scilab/scilab/-/issues/13762): On the `fft` page, the formula for the inverse FFT missed the 1/n normalization factor.
* [#13855](https://gitlab.com/scilab/scilab/-/issues/13855): The documentation of `pause` was not up-to-date and could be improved.
* [#13985](https://gitlab.com/scilab/scilab/-/issues/13985): The display of lists was very loose and poor.
* [#14033](https://gitlab.com/scilab/scilab/-/issues/14033): `x_matrix` could not edit matrices of booleans, encoded integers, or text. Matrices of real or complex numbers were poorly displayed.
* [#14098](https://gitlab.com/scilab/scilab/-/issues/14098): The `genlib` and `library` help pages were outdated concerning Scilab 6.
* [#14297](https://gitlab.com/scilab/scilab/-/issues/14297): Documentation of `cumsum()` improved.
* [#14435](https://gitlab.com/scilab/scilab/-/issues/14435): Errors were not well handled in overloaded functions.
* [#14477](https://gitlab.com/scilab/scilab/-/issues/14477): `mtlb_sparse()` removed from the documentation.
* [#14488](https://gitlab.com/scilab/scilab/-/issues/14488): The `frameflag=9` and `strf=".9."` values of these `plot2d` options were no longer accepted. Their documentation was ambiguous.
* [#14567](https://gitlab.com/scilab/scilab/-/issues/14567): In Scinotes, the `TODO` keyword was no longer highlighted.
* [#14585](https://gitlab.com/scilab/scilab/-/issues/14585): `closeEditvar()` had to be replaced with `close("editvar")`.
* [#14718](https://gitlab.com/scilab/scilab/-/issues/14718): `user` is removed for a while but was still documented.
* [#14873](https://gitlab.com/scilab/scilab/-/issues/14873): `setfield` page: The output and the 6.0 history were documented only on the en_US version. The input was wrongly restricted to matrices, while any Scilab object is acceptable. The specific role of `setfield` for mlists was not really described nor illustrated. The example did not include any call to setfield.
* [#15012](https://gitlab.com/scilab/scilab/-/issues/15012): `covStart(["isempty" ; "isscalar"])` crashed Scilab.
* [#15163](https://gitlab.com/scilab/scilab/-/issues/15163): `getdate` page: The time referential was obscure: a) UTC for Unix Time Convention vs Coordinated Universal Time. b) unclear influence of the time zone.
* [#15226](https://gitlab.com/scilab/scilab/-/issues/15226): The `get` page needed to be overhauled: `get(0)`, `get(0,prop)`, `get(tag)`, `get(tag,prop)` and other features were not documented.
* [#15280](https://gitlab.com/scilab/scilab/-/issues/15280): `gsort` was unable to sort any hypermatrix along dimensions > "r"|"c".
* [#15293](https://gitlab.com/scilab/scilab/-/issues/15293): scilab had troubles when comparing 2 lists L==L with void components.
* [#15330](https://gitlab.com/scilab/scilab/-/issues/15330): spec.tst was crashing on Linux.
* [#15839](https://gitlab.com/scilab/scilab/-/issues/15839): `gsort`: the only sparse possible input were real or complex vectors, and only with the `g` method.
* [#15841](https://gitlab.com/scilab/scilab/-/issues/15841): `intersect` supported neither sparse boolean nor sparse numeric inputs.
* [#15842](https://gitlab.com/scilab/scilab/-/issues/15842): `unique` could not process 2D sparse matrices.
* [#15868](https://gitlab.com/scilab/scilab/-/issues/15868): `setdiff(s,s2)` yielded an error when `s` or/and `s2` is sparse encoded.
* [#15954](https://gitlab.com/scilab/scilab/-/issues/15954): `mfile2sci` abusively added a 6 lines `mode(0); ieee(1)` header to every converted file.
* [#16069](https://gitlab.com/scilab/scilab/-/issues/16069): `[].figure_name` crashes Scilab.
* [#16106](https://gitlab.com/scilab/scilab/-/issues/16106): Xcos sciblk4 user-defined blocks did not handle opar and odstate/oz correctly.
* [#16122](https://gitlab.com/scilab/scilab/-/issues/16122): Concatenate polynomials with different variables did not raise an error.
* [#16141](https://gitlab.com/scilab/scilab/-/issues/16141): Recursive extraction `(m:n)($)` crashed Scilab
* [#16151](https://gitlab.com/scilab/scilab/-/issues/16151): `isequal(1:$, 2:$)` returned `%T`.
* [#16193](https://gitlab.com/scilab/scilab/-/issues/16193): `covStart()` clear previous coverage information. `profileEnable()` could be used to append a macro later on.
* [#16196](https://gitlab.com/scilab/scilab/-/issues/16196): `covStart()` help page was incomplete about the API usage.
* [#16274](https://gitlab.com/scilab/scilab/-/issues/16274): `assert_checkequal()` did not considered equal matching Nan or void elements in (nested) containers.
* [#16284](https://gitlab.com/scilab/scilab/-/issues/16284): `typename()` still considered removed uncompiled macros (11, "m"), and "mc" overloading code instead of "function".
* [#16288](https://gitlab.com/scilab/scilab/-/issues/16288): An error message from `wavread` was wrong.
* [#16297](https://gitlab.com/scilab/scilab/-/issues/16297): After function test(), e={}, endfunction; macr2tree(test)  crashes Scilab.
* [#16305](https://gitlab.com/scilab/scilab/-/issues/16305): `unwrap()` failed unfolding curves with straight segments.
* [#16337](https://gitlab.com/scilab/scilab/-/issues/16337): The 3rd output of `[U,km,ku] = unique(..)` was not implemented.
* [#16340](https://gitlab.com/scilab/scilab/-/issues/16340): `setdiff("","")` produced `""` instead of `[]`. The `"c"` and `"r"` options yielded an error for string inputs. Input arguments were poorly checked.
* [#16342](https://gitlab.com/scilab/scilab/-/issues/16342): `strcat()` was much slower in Scilab 6.0.2.
* [#16350](https://gitlab.com/scilab/scilab/-/issues/16350): In if/while conditions, the empty sparse boolean was considered as TRUE.
* [#16358](https://gitlab.com/scilab/scilab/-/issues/16358): `isdef([],..)` yielded an error instead of returning [].
* [#16357](https://gitlab.com/scilab/scilab/-/issues/16357): `script2var` did get variables generated by `exec()`.
* [#16362](https://gitlab.com/scilab/scilab/-/issues/16362): Sparse empty matrix could no be concatenated.
* [#16365](https://gitlab.com/scilab/scilab/-/issues/16365): `median(m,"r")` and `median(m,"c")` yielded wrong results (6.1.0 regression)
* [#16366](https://gitlab.com/scilab/scilab/-/issues/16366): `plot([0 1], ":")` plotted a dash-dotted curve instead of a dotted one.
* [#16369](https://gitlab.com/scilab/scilab/-/issues/16369): Right divisions / involving one or two sparse numerical matrices were no longer supported.
* [#16370](https://gitlab.com/scilab/scilab/-/issues/16370): `msprintf()` did not handle LaTeX dollars anymore.
* [#16374](https://gitlab.com/scilab/scilab/-/issues/16374): Any plot with datatips saved in Scilab 5.5 could not be loaded in Scilab 6.
* [#16385](https://gitlab.com/scilab/scilab/-/issues/16385): In Xcos without any diagram, the menu `Simulation => Modelica initialize` displayed "Undefined variable: flag" in the console.
* [#16391](https://gitlab.com/scilab/scilab/-/issues/16391): `csvRead()` was crashing with CSV files containing empty lines.
* [#16396](https://gitlab.com/scilab/scilab/-/issues/16396): Recursive extraction `(m:n)(:)` crashed Scilab
* [#16397](https://gitlab.com/scilab/scilab/-/issues/16397): The display of long (real) column vectors was slow (regression).
* [#16399](https://gitlab.com/scilab/scilab/-/issues/16399): `mtlb_zeros([])` was crashing Scilab.
* [#16401](https://gitlab.com/scilab/scilab/-/issues/16401): Global `external_object_java` class was crashing Scilab.
* [#16403](https://gitlab.com/scilab/scilab/-/issues/16403): 1D extraction of a matrix with an implicit index had wrong dimensions.
* [#16406](https://gitlab.com/scilab/scilab/-/issues/16406): `edit_curv` yielded an error when reading data.
* [#16407](https://gitlab.com/scilab/scilab/-/issues/16407): Fec rendering was incorrect
* [#16408](https://gitlab.com/scilab/scilab/-/issues/16408): `toJSON(var, indent, filename)` is the right call sequence. Documentation has been updated.
* [#16438](https://gitlab.com/scilab/scilab/-/issues/16438): `asciimat(text)` did not accept strings of different lengths or including some extended UTF-8 characters.
* [#16445](https://gitlab.com/scilab/scilab/-/issues/16445): `colorbar(..)` ignored how to guess `umin` and `umax` for a Champ object (with .colored="on").
* [#16449](https://gitlab.com/scilab/scilab/-/issues/16449): Insertion of implicit vector in Cell was crashing Scilab
* [#16450](https://gitlab.com/scilab/scilab/-/issues/16450): Concatenating encoded integers with decimal or complex numbers was not possible.
* [#16451](https://gitlab.com/scilab/scilab/-/issues/16451): `setdiff(a,b,"r"|"c")` with a and b boolean yielded an error.
* [#16452](https://gitlab.com/scilab/scilab/-/issues/16452): `setdiff(sparse([1 3 0 2]), sparse([3 7]))` missed returning 0, and wrongly returned 3.
* [#16454](https://gitlab.com/scilab/scilab/-/issues/16454): `gsort` yielded an error when sorting any sparse vector including some NaN.
* [#16458](https://gitlab.com/scilab/scilab/-/issues/16458): `mean()` did not handle sparse numerical matrices.
* [#16465](https://gitlab.com/scilab/scilab/-/issues/16465): Scinotes OpenRecent menu was not updated when it should.
* [#16473](https://gitlab.com/scilab/scilab/-/issues/16473): Deleting rows in a sparse squared matrix with padding zeros crashed (Scilab 6 regression).
* [#16474](https://gitlab.com/scilab/scilab/-/issues/16474): `imult(%z)` crashed Scilab.
* [#16476](https://gitlab.com/scilab/scilab/-/issues/16476): `issquare` was not overloaded.
* [#16488](https://gitlab.com/scilab/scilab/-/issues/16488): Concatenations mixing boolean and double with at least one operand being sparse were not supported.
* [#16496](https://gitlab.com/scilab/scilab/-/issues/16496): The `getdate` page should be rewritten: a) `getdate("s")` does NOT take leap seconds into account. b) `D=getdate(X)` is vectorized, accepts fractional seconds and returns them in `[0,1)` in D(10) instead of milliseconds. Moreover, the time referential of the result was unclear (time zone, daylight saving offset).
* [#16504](https://gitlab.com/scilab/scilab/-/issues/16504): `clock` returned none of the milliseconds, time zone, and daylight saving time.
* [#16508](https://gitlab.com/scilab/scilab/-/issues/16508): `csvTextScan()` and `csvRead()` did not handle well complex data.
* [#16512](https://gitlab.com/scilab/scilab/-/issues/16512): `1 ./ uint8(0)` crashes Scilab (idem with int8, uint16, int16, uint32, int32, uint64, int64).
* [#16517](https://gitlab.com/scilab/scilab/-/issues/16517): `getdate("s")` truncated the actual time to integer seconds. `getdate(u)(10)` returned fractional seconds instead of milliseconds as `getdate()`.
* [#16522](https://gitlab.com/scilab/scilab/-/issues/16522): `bitget(x,pos)` and `bitset(x,pos)` results could be wrong when `pos` is an encoded integer.
* [#16525](https://gitlab.com/scilab/scilab/-/issues/16525): `soundsec(t,freq)` has the trivial equivalence `0 : 1/freq : t*(1-%eps)` and should be removed.
* [#16529](https://gitlab.com/scilab/scilab/-/issues/16529): `deff` could not return the created function as output argument, preventing to create and use anonymous functions. The function's headline and body had to be provided separately. For Simple functions, a one-string input (possibly console-oriented) definition was not supported.
* [#16530](https://gitlab.com/scilab/scilab/-/issues/16530): `mapsound` needed to be reforged.
* [#16539](https://gitlab.com/scilab/scilab/-/issues/16539): `fplot2d` is weaker than `plot` and useless. It should be removed.
* [#16540](https://gitlab.com/scilab/scilab/-/issues/16540): Uicontrol spinner did not "snaptoticks"
* [#16549](https://gitlab.com/scilab/scilab/-/issues/16549): Simple script crashed Scilab in GUI mode.
* [#16551](https://gitlab.com/scilab/scilab/-/issues/16551): `num2cell` returned {} for any input array of empty strings.
* [#16552](https://gitlab.com/scilab/scilab/-/issues/16552): `mfile2sci` conversion of `ispc` and `isunix` still used `MSDOS` removed far ago. Conversion of `ismac` was missing. Conversion of `exist` missed using `mtlb_exist`. Conversion of `dos` yielded some "operation +" warnings. Unit tests for the conversion of `cd`, `dir`, and `ferror` overwrote some Scilab reserved keywords. Conversion of `return` yielded `mtlb(resume)`.
* [#16553](https://gitlab.com/scilab/scilab/-/issues/16553): `unique(["" ""])` returned `["" ""]`.
* [#16557](https://gitlab.com/scilab/scilab/-/issues/16557): `macr2tree` + `tree2code` translated `e={2}` into `"e=1"` and `e={2,"ab"}` into `"e=[2,"ab"]"`.
* [#16559](https://gitlab.com/scilab/scilab/-/issues/16553): `isempty(A)` was true for a sparse matrix of dimension 2^16 or larger.
* [#16561](https://gitlab.com/scilab/scilab/-/issues/16561): `histplot(-10:0.2:10, 2)` yielded a warning from `histc` and an error.
* [#16565](https://gitlab.com/scilab/scilab/-/issues/16565): `edit(user_defined_function)` corrupted the original code.
* [#16567](https://gitlab.com/scilab/scilab/-/issues/16567): `mfile2sci` did not support Matlab block-comments %{ ..%}.
* [#16568](https://gitlab.com/scilab/scilab/-/issues/16568): The operator `**` was undocumented.
* [#16571](https://gitlab.com/scilab/scilab/-/issues/16571): `mfile2sci` had several issues when converting the NOT `~` operator: 1) `~(1-1)` was converted into `~1-1` instead of `~(1-1)`  2) `~` applied to an integer expression yielded an error from `convert2double`  3) `~i` was converted into `~%i` instead of `~abs(%i)`.
* [#16573](https://gitlab.com/scilab/scilab/-/issues/16573): `mfile2sci`: Some `axis` conversions were wrong or not reliable.
* [#16586](https://gitlab.com/scilab/scilab/-/issues/16586): `mfile2sci`: The `prettyprintoutput` flag badly managed appended comments.
* [#16592](https://gitlab.com/scilab/scilab/-/issues/16592): `%i|[]`, `[]|%i`, `%i&[]`, and `[]&%i` were wrong. `%t|%i`, `%t&%i`, and `%i&%t` were not defined.
* [#16596](https://gitlab.com/scilab/scilab/-/issues/16596): Concatenating encoded integers with sparse numeric data was not possible.
* [#16601](https://gitlab.com/scilab/scilab/-/issues/16601): `libmatio >= 1.5.18` was not supported.
* [#16608](https://gitlab.com/scilab/scilab/-/issues/16608): `union` did not support input boolean, sparse boolean, nor sparse numerical matrices. The result of `union(complexA, complexB)` was wrongly conjugate.
* [#16609](https://gitlab.com/scilab/scilab/-/issues/16609): `bitcmp` needed to be upgraded for Scilab 6.
* [#16612](https://gitlab.com/scilab/scilab/-/issues/16612): Unlike the `.*.` operator, `kron()` was not defined for sparse numeric matrices.
* [#16613](https://gitlab.com/scilab/scilab/-/issues/16613): Neither `.*.` nor `kron()` worked with boolean or sparse boolean matrices.
* [#16614](https://gitlab.com/scilab/scilab/-/issues/16614): Out of gcf(), a figure with some xstring content could be not properly reframed to contents.
* [#16617](https://gitlab.com/scilab/scilab/-/issues/16617): `gamma` did not support incomplete gamma integrals.
* [#16618](https://gitlab.com/scilab/scilab/-/issues/16618): `close` could not close the help browser, xcos, nor the variable editor or browser.
* [#16620](https://gitlab.com/scilab/scilab/-/issues/16620): `derivat` had no reciprocal `polyint` polynomial integration function.
* [#16622](https://gitlab.com/scilab/scilab/-/issues/16622): `inv` could no longer be overloaded for hypermatrices of decimal or complex numbers.
* [#16623](https://gitlab.com/scilab/scilab/-/issues/16623): `rand(2,2,2)^2` yielded a wrong result instead of trying to call the `%s_p_s` overload for input hypermatrices.
* [#16624](https://gitlab.com/scilab/scilab/-/issues/16624): `fullfile` badly handled any forced final file separator when building a directory's path.
* [#16626](https://gitlab.com/scilab/scilab/-/issues/16626): `==` and `<>` between libraries were no longer defined.
* [#16627](https://gitlab.com/scilab/scilab/-/issues/16627): `importgui` function's name was not explicit enough. `importgui` is renamed `uiSpreadsheet`. `importgui` internals was public.
* [#16629](https://gitlab.com/scilab/scilab/-/issues/16629): `interp1`'s documentation did not tell the spline edges conditions; extrapolation modes were poorly explained; the description of the result's size was completely wrong; x as an option was not documented. `periodic` and `edgevalue` extrapolation modes were not available. `linear` extrapolation was not available for splines. When `xp` is an hypermatrix with `size(xp,1)==1`, the size of the result was irregular/wrong.
* [#16631](https://gitlab.com/scilab/scilab/-/issues/16631): Read-only handle properties were reported as unknown when trying to set them.
* [#16632](https://gitlab.com/scilab/scilab/-/issues/16632): Scilab did not start with an unsupported locale on macOS.
* [#16636](https://gitlab.com/scilab/scilab/-/issues/16636): `det(sparse)` most often yielded `Nan`. `[e,m]=det(sparse)` was not actually implemented.
* [#16638](https://gitlab.com/scilab/scilab/-/issues/16638): `getcolor` had a bunch of issues.
* [#16639](https://gitlab.com/scilab/scilab/-/issues/16639): `atomsInstall` and `atomsRemove` did not update the Toolboxes menu.
* [#16644](https://gitlab.com/scilab/scilab/-/issues/16644): `input("message:")` yielded a wrong error message about `mprintf` in case of non-interpretable input.
* [#16654](https://gitlab.com/scilab/scilab/-/issues/16654): `interp` was leaking memory.
* [#16661](https://gitlab.com/scilab/scilab/-/issues/16661): `x=spzeros(1e10,1e10)` yielded an incorrect error message.
* [#16664](https://gitlab.com/scilab/scilab/-/issues/16664): `diag(spzeros(2,2))` yielded an `Operation -[]` warning.
* [#16665](https://gitlab.com/scilab/scilab/-/issues/16665): `help echo` could not redirect to `help mode` when preferred, for new users coming from Octave.
* [#16677](https://gitlab.com/scilab/scilab/-/issues/16677): In offline mode, `atomsInstall` was flashing many times on the console.
* [#16679](https://gitlab.com/scilab/scilab/-/issues/16679): `get_function_path("acosh")` yielded an error (regression from Scilab 6.0.0).
* [#16683](https://gitlab.com/scilab/scilab/-/issues/16683): The `m2sci` code converter needed a set of fix and improvements.
* [#16685](https://gitlab.com/scilab/scilab/-/issues/16685): `asciimat("A";"";"B")` yielded a transposed matrix of codes. When processing an hypermatrix of codes, the dim#2 of the result was squeezed (unlike Matlab/Octave's behavior).
* [#16686](https://gitlab.com/scilab/scilab/-/issues/16686): `strsplit('a','a')`, `strsplit('ab','ab')`,  and `strsplit("abcd","cd")` yielded wrong results.
* [#16687](https://gitlab.com/scilab/scilab/-/issues/16687): `spec` documentation used messy concurrent notations. It still refered to the Arnoldi module instead of `eigs`. The fr_FR version was incomplete.
* [#16708](https://gitlab.com/scilab/scilab/-/issues/16708): `mgetl` could not read from stdin.
* [#16711](https://gitlab.com/scilab/scilab/-/issues/16711): `prettyprint` export to html failed under Linux and macOS.
* [#16714](https://gitlab.com/scilab/scilab/-/issues/16714): `fullpath` failed to resolve the path depending on pwd.
* [#16908](https://gitlab.com/scilab/scilab/-/issues/16908): Segmentation fault in macr2tree when members of an object are called as a function.

### Bugs fixed in 6.1.0:
* [#2694](https://gitlab.com/scilab/scilab/-/issues/2694): `bitget` did not accept positive integers of types int8, int16 or int32.
* [#5824](https://gitlab.com/scilab/scilab/-/issues/5824): The `datafit` algorithm was not documented.
* [#6070](https://gitlab.com/scilab/scilab/-/issues/6070): How to make multiscaled plots was not documented.
* [#7293](https://gitlab.com/scilab/scilab/-/issues/7293): There was no function to circularly shift components, rows, columns, or subarrays of an array. `circshift` introduced.
* [#7562](https://gitlab.com/scilab/scilab/-/issues/7562): `factorial` could use a huge memory amount even for a scalar argument.
* [#7589](https://gitlab.com/scilab/scilab/-/issues/7589): There was no function computing the binomial coefficients.
* [#7657](https://gitlab.com/scilab/scilab/-/issues/7657): `lstsize` was a duplicate of `size` and should be removed.
* [#7724](https://gitlab.com/scilab/scilab/-/issues/7724): When a figure is created in .auto_resize="on" mode, its .axes_size sets its .figure_size accordingly, not the reverse. But this was not documented.
* [#7732](https://gitlab.com/scilab/scilab/-/issues/7732): The `datafit` help page needed to be fixed and overhauled.
* [#7765](https://gitlab.com/scilab/scilab/-/issues/7765): `champ1` is useless. `champ().colored` is available for a long time.
* [#7777](https://gitlab.com/scilab/scilab/-/issues/7777): `ged` did not allow moving several objects.
* [#7948](https://gitlab.com/scilab/scilab/-/issues/7948): `gsort` could not perform multilevel sorting, and could not sort complex numbers completely.
* [#7967](https://gitlab.com/scilab/scilab/-/issues/7967): The tricky size `[ny,nx]` of `meshgrid(x,y)` results and usages with graphics was not enough documented.
* [#8301](https://gitlab.com/scilab/scilab/-/issues/8301): `definedfields` wrongly considered as defined void elements in lists, tlists, and mlists.
* [#8307](https://gitlab.com/scilab/scilab/-/issues/8307): `list2vec` and `vec2list` were located in the optimization module instead of in data_structures, and were missing in the `See also` section of `list`.
* [#8328](https://gitlab.com/scilab/scilab/-/issues/8328): Tabs of the Xcos block Format => Edit dialog were unclear.
* [#8393](https://gitlab.com/scilab/scilab/-/issues/8393): `isdef` and `definedfields` had mismatching answers for void elements in lists, mlists, or tlists.
* [#8418](https://gitlab.com/scilab/scilab/-/issues/8418): `unique` was not able to return the number of occurrences of returned distinct entities.
* [#8784](https://gitlab.com/scilab/scilab/-/issues/8784): Automatic self-adjusting blocks `SCALE_CSCOPE` & `SCALE_CMSCOPE` in Xcos.
* [#5512](https://gitlab.com/scilab/scilab/-/issues/5512): `disp` puzzlingly displayed arguments in reverse order.
* [#9007](https://gitlab.com/scilab/scilab/-/issues/9007): On Linux, `sciargs()` included twice `-nw` when `-nw` is used.
* [#9130](https://gitlab.com/scilab/scilab/-/issues/9130): On the SigBuilder Xcos page, the parameters of the block were not described. The page referred to the CURVE_c block removed from Scilab 5.0.0.
* [#9529](https://gitlab.com/scilab/scilab/-/issues/9529): `assert_checkequal(list(1,,3), list(1,,3))` yielded an error.
* [#9673](https://gitlab.com/scilab/scilab/-/issues/9673): Priority of colon `:` operator was too low
* [#10014](https://gitlab.com/scilab/scilab/-/issues/10014): `DominationRank` could be made private in `optim_nsga2`.
* [#10078](https://gitlab.com/scilab/scilab/-/issues/10078): `isinf` was not reliable for polynomials.
* [#10092](https://gitlab.com/scilab/scilab/-/issues/10092): The left and right Kronecker divisions were not implemented nor documented.
* [#10353](https://gitlab.com/scilab/scilab/-/issues/10353): Documentation: The referential for the uicontrol.position property was not provided. Moreover, `gca().axes_bounds` refered to `fig.figure_size` instead of `fig.axes_size`.
* [#10553](https://gitlab.com/scilab/scilab/-/issues/10553): After calling `colorbar`, retrieving the handle of the new color bar was not trivial.
* [#10702](https://gitlab.com/scilab/scilab/-/issues/10702): The icon of the FROMWSB xcos block did not show the name of the source variable.
* [#10723](https://gitlab.com/scilab/scilab/-/issues/10723): `subplot`'s action was unclearly described on its help page. Page improved.
* [#11852](https://gitlab.com/scilab/scilab/-/issues/11852): File browser didn't update after file creation or removal.
* [#11363](https://gitlab.com/scilab/scilab/-/issues/11363): `show_window()` did not raise the current graphics window.
* [#12013](https://gitlab.com/scilab/scilab/-/issues/12013): `bitset` did not work for numbers greater than 2^32-1.
* [#12302](https://gitlab.com/scilab/scilab/-/issues/12302): Blocks of legends could not be moved interactively.
* [#12428](https://gitlab.com/scilab/scilab/-/issues/12428): A part of an error message from `toprint` was not translated.
* [#12520](https://gitlab.com/scilab/scilab/-/issues/12520): Variable browser did not display the size of the variables.
* [#12534](https://gitlab.com/scilab/scilab/-/issues/12534): Variable browser did not display the size of the variables.
* [#12837](https://gitlab.com/scilab/scilab/-/issues/12837): `strcmpi` was an obsolete duplicate of `strcmp(,'i')`. It is removed.
* [#13603](https://gitlab.com/scilab/scilab/-/issues/13603): `plot(1:3, 10)` failed.
* [#13683](https://gitlab.com/scilab/scilab/-/issues/13683): `unsetmenu()` for a `dockable="off"` figure crashed Scilab.
* [#13738](https://gitlab.com/scilab/scilab/-/issues/13738): `get_figure_handle` was a specific duplicate of the more powerful `findobj('figure_id',n)` feature. It is now obsolete.
* [#13766](https://gitlab.com/scilab/scilab/-/issues/13766): Minimal values for `.figure_size` were not documented.
* [#14015](https://gitlab.com/scilab/scilab/-/issues/14015): Nan terms added to a polynomial were ignored.
* [#14191](https://gitlab.com/scilab/scilab/-/issues/14191): Unlike `plot2d()`, `plot()` did not accept logflags among input arguments.
* [#14397](https://gitlab.com/scilab/scilab/-/issues/14397): `mgeti` wrongly handled `int64` or `uint64` integers bigger than 2^52. The `mget`/`mgeti` help page was unclear.
* [#14422](https://gitlab.com/scilab/scilab/-/issues/14422): `clc(0)` did nothing, now clears last console entry. Remove leading blank after a `clc()`.
* [#14498](https://gitlab.com/scilab/scilab/-/issues/14498): `size([],3)` returned 1 instead of 0.
* [#14501](https://gitlab.com/scilab/scilab/-/issues/14501): `strsubst` crashed on consecutive occurrences.
* [#14557](https://gitlab.com/scilab/scilab/-/issues/14557): `csim` failed when the system has no state.
* [#14498](https://gitlab.com/scilab/scilab/-/issues/14498): `size([],3)` returned 1 instead of 0.
* [#14487](https://gitlab.com/scilab/scilab/-/issues/14487): Matrix indexing was not coherent with MATLAB.
* [#14502](https://gitlab.com/scilab/scilab/-/issues/14502): `Demo > GUI > Uicontrols 2` could not be exported to a file.
* [#14585](https://gitlab.com/scilab/scilab/-/issues/14585): `closeEditvar()` had to be replaced with `editvar("close")`.
* [#14604](https://gitlab.com/scilab/scilab/-/issues/14604): `emptystr` is 40x slower with 6.0.0 wrt 5.5.2
* [#14605](https://gitlab.com/scilab/scilab/-/issues/14605): fixed - `bench_run` was too strict about the specification of tests names.
* [#14606](https://gitlab.com/scilab/scilab/-/issues/14606): Memory used by variables returned by `[names,mem]=who()` was always zero.
* [#14610](https://gitlab.com/scilab/scilab/-/issues/14610): `x = ric_desc(H,E)` always yielded an error. [x1,x2,residual] = ric_desc(..) returned a wrong `residual` value.
* [#14642](https://gitlab.com/scilab/scilab/-/issues/14642): No more "\r" carriage return with printf.
* [#14655](https://gitlab.com/scilab/scilab/-/issues/14655): `bitset` worked only element-wise, without accepting mixed scalar and array inputs.
* [#14660](https://gitlab.com/scilab/scilab/-/issues/14660): `dec2base` was 53-bit limited by double and not uint64 ready
* [#14734](https://gitlab.com/scilab/scilab/-/issues/14734): The `simulated_annealing` module was out of the `optimization` one.
* [#14735](https://gitlab.com/scilab/scilab/-/issues/14735): The `genetic_algorithms` module was out of the `optimization` one.
* [#14738](https://gitlab.com/scilab/scilab/-/issues/14738): `hist3d` was not an histogram function. It is renamed `bar3d`.
* [#14741](https://gitlab.com/scilab/scilab/-/issues/14741): The syntax `[m,e]=log2(x)` was not documented. As public function `frexp` was in duplicate with `[m,e]=log2(x)`.
* [#14742](https://gitlab.com/scilab/scilab/-/issues/14742): `mprintf`, `msprintf` a non-finite number displayed nothing.
* [#14746](https://gitlab.com/scilab/scilab/-/issues/14746): Tiny numbers were sometimes displayed as 0.
* [#14791](https://gitlab.com/scilab/scilab/-/issues/14791): `sleep 1` crashed Scilab.
* [#14812](https://gitlab.com/scilab/scilab/-/issues/14812): Minor typos in messages.
* [#14836](https://gitlab.com/scilab/scilab/-/issues/14836): Calling `exportUI` on a non dockable figure crashed Scilab.
* [#14863](https://gitlab.com/scilab/scilab/-/issues/14863): In Xcos, the default ending time was unhandily high (100000), reduced to 30.
* [#14900](https://gitlab.com/scilab/scilab/-/issues/14900): In Scilab 6.0, the new overloading code `function` replacing `mc` for functions in the Scilab language was not documented.
* [#14982](https://gitlab.com/scilab/scilab/-/issues/14982): `msprintf` segmentation fault was caught due to a wrong size
* [#14985](https://gitlab.com/scilab/scilab/-/issues/14985): Scilab crashed if a .bin file was not found.
* [#15067](https://gitlab.com/scilab/scilab/-/issues/15067): `.xmi` files saved from Xcos could not be opened by drag & dropping them into the console.
* [#15068](https://gitlab.com/scilab/scilab/-/issues/15068): `size(sum(ones(2,3,4,5),4))` was [4 2 3] instead of [2 3 4].
* [#15087](https://gitlab.com/scilab/scilab/-/issues/15087): Deleting rows or columns from a matrix is slow (regression)
* [#15200](https://gitlab.com/scilab/scilab/-/issues/15200): `weekday` yielded an error for some row of input dates.
* [#15248](https://gitlab.com/scilab/scilab/-/issues/15248): `lsq`was leaking memory.
* [#15260](https://gitlab.com/scilab/scilab/-/issues/15260): `sci2exp` was no longer able to convert non-scalar structures.
* [#15269](https://gitlab.com/scilab/scilab/-/issues/15269): `xgetech` was poor and stiff compared to any combination of `gca()` properties `.axes_bounds`, `.data_bounds`, `.log_flags`, and `.margins`. It is removed.
* [#15271](https://gitlab.com/scilab/scilab/-/issues/15271): `bitget` needed to be upgraded.
* [#15309](https://gitlab.com/scilab/scilab/-/issues/15309): `eval` was a weak duplicate of `evstr`. It should be removed.
* [#15321](https://gitlab.com/scilab/scilab/-/issues/15321): `lu` was leaking memory.
* [#15350](https://gitlab.com/scilab/scilab/-/issues/15350): `ric_desc` should be merged into `riccati`.
* [#15357](https://gitlab.com/scilab/scilab/-/issues/15357): `atomsGetInstalledPath` returned "" if the provided technical name differs only by the case, or is a fragment, or failed when the version is not provided.
* [#15359](https://gitlab.com/scilab/scilab/-/issues/15359): `twinkle` was not able to blink several independent objects.
* [#15360](https://gitlab.com/scilab/scilab/-/issues/15360): `numer` and `denom` were poor and duplicates of the `.num` and `.den` fields of rationals. They are removed.
* [#15368](https://gitlab.com/scilab/scilab/-/issues/15368): `freson` silently returned frequencies not corresponding to a maximum, or returned [] instead of some still computable maxima frequencies.
* [#15374](https://gitlab.com/scilab/scilab/-/issues/15374):  Trivial infinite loop could not be interrupted.
* [#15392](https://gitlab.com/scilab/scilab/-/issues/15392): `comet` and `comet3d` did not allow specifying colors with colors names.
* [#15393](https://gitlab.com/scilab/scilab/-/issues/15393): In a new figure, `nicholschart` plotted nothing. The default frame color was a flashy cyan. The position of gain labels could be puzzling. It was not possible to specify colors by their names. Postprocessing the frames and the set of labels was not easy.
* [#15421](https://gitlab.com/scilab/scilab/-/issues/15421): A new smarter default grid_style was required since smart lines styles #7-10 are available.
* [#15425](https://gitlab.com/scilab/scilab/-/issues/15425): The Kronecker product `a .*. b` failed when `a` or `b` or both are hypermatrices, with one or both being polynomials or rationals.
* [#15428](https://gitlab.com/scilab/scilab/-/issues/15428): `repmat` was slow. Its code did not use `kron` and was complex.
* [#15431](https://gitlab.com/scilab/scilab/-/issues/15431): The empty matrix `[]` and its non-convertibility were poorly documented.
* [#15451](https://gitlab.com/scilab/scilab/-/issues/15451): The code was not adapted to use `lucene 4.10` in Debian.
* [#15481](https://gitlab.com/scilab/scilab/-/issues/15481): `scatter` and `scatter3d` failed when specifying a single data point.
* [#15514](https://gitlab.com/scilab/scilab/-/issues/15514): The `set` documentation page needed to be overhauled.
* [#15517](https://gitlab.com/scilab/scilab/-/issues/15517): `factorial` could be used up to only `n=170`.
* [#15522](https://gitlab.com/scilab/scilab/-/issues/15522): `unique` was not able to consider all Nan values as the same value. A `uniqueNan` option now allows it.
* [#15523](https://gitlab.com/scilab/scilab/-/issues/15523): `%ODEOPTIONS(1)=2` didn't work with solvers 'rk' and 'rkf'
* [#15534](https://gitlab.com/scilab/scilab/-/issues/15534): Booleans and encoded integers could not be concatenated together.
* [#15577](https://gitlab.com/scilab/scilab/-/issues/15577): `edit` did not accept a line number as text, as with `edit linspace 21`.
* [#15580](https://gitlab.com/scilab/scilab/-/issues/15580): `det(sparse([],[]))` yielded an error.
* [#15581](https://gitlab.com/scilab/scilab/-/issues/15581): The display of complex matrix was ugly.
* [#15595](https://gitlab.com/scilab/scilab/-/issues/15595): `unique` was not able to return distinct values in their original order, without sorting them. A `keepOrder` option now allows it.
* [#15628](https://gitlab.com/scilab/scilab/-/issues/15628): `with_tk` was a duplicate of `with_module('tclsci')`. It is removed.
* [#15643](https://gitlab.com/scilab/scilab/-/issues/15643): Features with the signed zero -0 were not documented.
* [#15668](https://gitlab.com/scilab/scilab/-/issues/15668): `save(filename)` saved all predefined Scilab constants %e %pi etc.. (regression)
* [#15680](https://gitlab.com/scilab/scilab/-/issues/15680): `loadmatfile` could not return variables in a structure instead of into the calling environment.
* [#15701](https://gitlab.com/scilab/scilab/-/issues/15701): `A\B` was not faster when `A` is square and triangular.
* [#15715](https://gitlab.com/scilab/scilab/-/issues/15715): `%nan` indices crashed Scilab.
* [#15734](https://gitlab.com/scilab/scilab/-/issues/15734): `intersect` did not support complex numbers.
* [#15737](https://gitlab.com/scilab/scilab/-/issues/15737): `setdiff` was wrong with complex numbers.
* [#15742](https://gitlab.com/scilab/scilab/-/issues/15742): The `compatibility_functions` module should be merged in the `m2sci` one.
* [#15744](https://gitlab.com/scilab/scilab/-/issues/15744): `sylm(a,b)` yielded an error when degree(a)==0 or degree(b)==0.
* [#15745](https://gitlab.com/scilab/scilab/-/issues/15745): `diophant(0,0,m)`, `diophant([p 0],q)`, `diophant([0 p],q)` with m<>0 and p>q were wrong. There was no flag for cases with an infinite number of solutions. When there is no solution, some values were returned anyway, instead of []. In this case, the documented definition of the err value was dubious. Decimal numbers and integers were accepted, but not encoded integers. Inf and NaN input coefficients were not rejected.
* [#15812](https://gitlab.com/scilab/scilab/-/issues/15812): While assigning variables the source variable may become corrupted.
* [#15821](https://gitlab.com/scilab/scilab/-/issues/15821): `fac3d` and `fac3d1` were still in Scilab 6.0 despite they were tagged obsolete 14 years ago in Scilab 4.1
* [#15825](https://gitlab.com/scilab/scilab/-/issues/15825): `gsort` could not sort completely dense matrices of complex numbers.
* [#15840](https://gitlab.com/scilab/scilab/-/issues/15840): `grand(1,"prm",m)` yielded an unsqueezed size([size(m) 1]) hypermatrix
* [#15861](https://gitlab.com/scilab/scilab/-/issues/15861): The `overloadname` internal macro defined in CACSD was a duplicate of `typeof(,"overload")`. It is removed.
* [#15874](https://gitlab.com/scilab/scilab/-/issues/15874): The `scatter3` function name was an unfounded naming exception. It had to be renamed `scatter3d`.
* [#15921](https://gitlab.com/scilab/scilab/-/issues/15921): Xcos user's function `scifunc_block_m` block: any `<` in the expression was not displayed on the block's icon.
* [#15934](https://gitlab.com/scilab/scilab/-/issues/15934): The `^ hat` page wrongly indicated that `^` applied to a rectangular matrix not being a vector is done element-wise.
* [#15948](https://gitlab.com/scilab/scilab/-/issues/15948): `xlabel`, `ylabel`, `zlabel`, and `title` needed to be upgraded.
* [#15963](https://gitlab.com/scilab/scilab/-/issues/15963): The `EXPRESSION` block was more expected in the Mathematical palette.
* [#15964](https://gitlab.com/scilab/scilab/-/issues/15954): A complex empty sparse matrix could be obtained after insertion.
* [#15965](https://gitlab.com/scilab/scilab/-/issues/15965): `plot(x,y)` did not accept y as encoded integers.
* [#15967](https://gitlab.com/scilab/scilab/-/issues/15967): `setdiff(1,[])` was [] instead of `1`. `setdiff(a,[],..)` was not enough tested.
* [#15969](https://gitlab.com/scilab/scilab/-/issues/15969): Fix spelling
* [#15974](https://gitlab.com/scilab/scilab/-/issues/15974): `msprintf("%d", %nan)` did not return Nan
* [#15977](https://gitlab.com/scilab/scilab/-/issues/15977): The documentation for `wavread(..,'info')` had a mistake. The `wavread` page deserved some improvements.
* [#15978](https://gitlab.com/scilab/scilab/-/issues/15978): The `writewav` page in English said that input data are one column per channel, instead of one row per channel. In addition, in case of writing error, `savewave` kept the output file open and locked.
* [#15979](https://gitlab.com/scilab/scilab/-/issues/15979): `EXPRESSION`, `CLR` and `DLR` Xcos blocks did not (always) correctly display multicharacter exponents in expressions displayed in their icons.
* [#15981](https://gitlab.com/scilab/scilab/-/issues/15981): `wavread` kept the wav file open and locked when returning on errors. It weakly managed the input file name. It claimed for invalid data formats instead of unsupported ones, with poor information about the current format vs the supported ones. Several error messages referred to a wrong function.
* [#15983](https://gitlab.com/scilab/scilab/-/issues/15983): `group` regressed in 5.5.2 due to a too intrusive fix.
* [#15984](https://gitlab.com/scilab/scilab/-/issues/15984): Display scale was wrong with Retina displays on OSX..
* [#15995](https://gitlab.com/scilab/scilab/-/issues/15995): Patch was missing in the surface plot (regression)
* [#15998](https://gitlab.com/scilab/scilab/-/issues/15998): `mfile2sci` yielded an unsuitable warning when converting `atan`.
* [#16000](https://gitlab.com/scilab/scilab/-/issues/16000): `mfile2sci` converted `acoth` using `atanh` and yielding a wrong warning message.
* [#16003](https://gitlab.com/scilab/scilab/-/issues/16003): Zoom with mouse scroll wheel was broken on simple surfaces.
* [#16005](https://gitlab.com/scilab/scilab/-/issues/16005): The `intdec` example was biased and not robust when changing sampling frequencies.
* [#16007](https://gitlab.com/scilab/scilab/-/issues/16007): Non-integer index in sparse makes Scilab crash.
* [#16008](https://gitlab.com/scilab/scilab/-/issues/16008): Uimenu .callback_type, .children, .handle_visible, .user_data properties, and using HTML styling in .label were not documented.
* [#16011](https://gitlab.com/scilab/scilab/-/issues/16011): `colorbar(umin, umax)` did not work after `plot3d2`.
* [#16012](https://gitlab.com/scilab/scilab/-/issues/16012): `[struct() struct()]` crashed Scilab.
* [#16013](https://gitlab.com/scilab/scilab/-/issues/16013): Load previously saved environment with "File/Load environment" menu failed.
* [#16014](https://gitlab.com/scilab/scilab/-/issues/16014): after `x.a=1; x(:)=[]` x.a was an empty list.
* [#16015](https://gitlab.com/scilab/scilab/-/issues/16015): `intg(a,b,f)` called f(x) with x outside [a,b].
* [#16019](https://gitlab.com/scilab/scilab/-/issues/16019): `polarplot(x,Z)` yielded an error when x is a vector and Z a matrix.
* [#16021](https://gitlab.com/scilab/scilab/-/issues/16021): `tand([-90 90])` answered [Nan Nan] instead of [-Inf, Inf]. `cotd([-90 90])` answered [Nan Nan] instead of [0 0]. `1 ./cosd([-90 90])` answered [Inf -Inf] instead of [Inf Inf].
* [#16026](https://gitlab.com/scilab/scilab/-/issues/16026): For `atanh`, neither the documentation pages nor the `m2sci` converter was up to date.
* [#16028](https://gitlab.com/scilab/scilab/-/issues/16028): The length of `intdec(intdec(x, r), 1/r)` was most often different from length(x).
* [#16046](https://gitlab.com/scilab/scilab/-/issues/16046): After `w=ssrand(2,3,4)`, `[]+w`, `[]-w`, `w+[]` and `w-[]` yielded an "operation +/- []" warning.
* [#16051](https://gitlab.com/scilab/scilab/-/issues/16051): Undefined list elements could be of 2 distinct typeof "void" or "listundefined" according to the way they are created.
* [#16053](https://gitlab.com/scilab/scilab/-/issues/16053): `plot(,"color",c)` no longer supported standard abbreviated color names c like "k" for black.
* [#16062](https://gitlab.com/scilab/scilab/-/issues/16062): `tbx_make` did not allow easily to force building all toolbox sections without the toolbox builder (if any). `tbx_make(Dir,"*")` now does it.
* [#16064](https://gitlab.com/scilab/scilab/-/issues/16064): `tbx_make(Dir,'localization')` did not update `.mo` files from `.po`.
* [#16065](https://gitlab.com/scilab/scilab/-/issues/16065): Building help pages including some <scilab:image> tags used and finally deleted the current on-screen figures (if any)!
* [#16067](https://gitlab.com/scilab/scilab/-/issues/16067): The display of matrices of signed integers was misaligned (regression of 6.0.0 vs 5.5.2)
* [#16071](https://gitlab.com/scilab/scilab/-/issues/16071): `prettyprint(complex(1,%nan))` omitted the "+" in `1 + Nani`. Documentation was also improved.
* [#16072](https://gitlab.com/scilab/scilab/-/issues/16072): `prettyprint` did not support input encoded integers.
* [#16075](https://gitlab.com/scilab/scilab/-/issues/16075): `prettyprint` was broken for cells.
* [#16079](https://gitlab.com/scilab/scilab/-/issues/16079): `part("",$)` and `part("",$-1:$+2)` yielded an error instead of returning "" and "  ".
* [#16081](https://gitlab.com/scilab/scilab/-/issues/16081): `prettyprint` did not allow to export of objects into HTML.
* [#16085](https://gitlab.com/scilab/scilab/-/issues/16085): Insertion in an empty struct was broken.
* [#16087](https://gitlab.com/scilab/scilab/-/issues/16087): Insertion of struct in a non-empty struct crashed Scilab.
* [#16089](https://gitlab.com/scilab/scilab/-/issues/16089): `x=1:1e10` freezed Scilab.
* [#16090](https://gitlab.com/scilab/scilab/-/issues/16090): The documentation of `prbs_a` was poor and unclear.
* [#16095](https://gitlab.com/scilab/scilab/-/issues/16095): For a matrix of graphic handles of the same types, it was no longer possible to clear a property by assigning `[]`.
* [#16097](https://gitlab.com/scilab/scilab/-/issues/16097): `coth` was more than twice slower than `1./tanh()`. `tanh` and `coth` did not accept sparse-encoded input.
* [#16102](https://gitlab.com/scilab/scilab/-/issues/16102): `lstcat` could not concatenate input lists with mixed objects of types>10 like 1:$, sin, sind, struct, cells, tlists or mlists. In addition, it was slow for very long inputs lists.
* [#16104](https://gitlab.com/scilab/scilab/-/issues/16104): `assert_checkequal` did not support properly or at all Nan and void in lists, Nan in sparse, implicit lists, macros, libraries, built-in functions, graphical handles. For input arrays or lists of matching typeof and sizes, the failure message displayed neither the index nor the values of the first mismatching elements.
* [#16108](https://gitlab.com/scilab/scilab/-/issues/16108): For the CSCOPE and CMSCOPE blocks, the Label&id parameter entered in their interface were not displayed below the block's icon.
* [#16111](https://gitlab.com/scilab/scilab/-/issues/16111): `isglobal` was not supporting a non-scalar array of strings as input.
* [#16118](https://gitlab.com/scilab/scilab/-/issues/16118): `%s <> (1+%s)` returned %F.
* [#16120](https://gitlab.com/scilab/scilab/-/issues/16120): `tree_show` was broken cells within containers.
* [#16121](https://gitlab.com/scilab/scilab/-/issues/16121): `tree_show` void components were displayed as non-empty.
* [#16124](https://gitlab.com/scilab/scilab/-/issues/16124): `sci2exp({})` result could not be executed.
* [#16128](https://gitlab.com/scilab/scilab/-/issues/16128): `tree_show` needs improvements.
* [#16129](https://gitlab.com/scilab/scilab/-/issues/16129): `uiDumpTree()` interpreted "\n" "\r" "\t" sequences in contents as special ones.
* [#16135](https://gitlab.com/scilab/scilab/-/issues/16135): `base2dec()` did not detect invalid numbers.
* [#16137](https://gitlab.com/scilab/scilab/-/issues/16137): After running `playsnd` on Windows for a long sound, it was not possible to stop it.
* [#16138](https://gitlab.com/scilab/scilab/-/issues/16138): `playsnd` could not be run in a non-modal (asynchronous) way on Linux and MacOS.
* [#16139](https://gitlab.com/scilab/scilab/-/issues/16139): `auread` and `auwrite` kept the sound file open and locked when returning on errors. They poorly handled the default .au sound file extension.
* [#16140](https://gitlab.com/scilab/scilab/-/issues/16140): `playsnd` could not directly accept an audio file and could not repeat the input sound.
* [#16143](https://gitlab.com/scilab/scilab/-/issues/16143): `clc(n)` cleared n+1 lines instead of n>0. Thus, it was not possible to clear only one line.
* [#16144](https://gitlab.com/scilab/scilab/-/issues/16144): The addition of sparse matrices gave incorrect results.
* [#16145](https://gitlab.com/scilab/scilab/-/issues/16145): `integrate` and `intg` default absolute tolerances atol was no longer the same. `integrate`'s default relative tolerance rtol was not the same in the case of 3 or 4 input arguments.
* [#16148](https://gitlab.com/scilab/scilab/-/issues/16148): `setPreferencesValue` is a general usage function and deserved to be renamed `xmlSetValues`.
* [#16149](https://gitlab.com/scilab/scilab/-/issues/16149): `fullpath` did not support symbolic links in paths
* [#16152](https://gitlab.com/scilab/scilab/-/issues/16152): For sparse or boolean sparse matrix `s`, `s([])` returned `[]` instead of `sparse([])`.
* [#16155](https://gitlab.com/scilab/scilab/-/issues/16155): `flipdim(hypermat,dim,sb)` yielded wrong results for dim<3 and sb>1, and yielded an error for dim>2.
* [#16158](https://gitlab.com/scilab/scilab/-/issues/16158): When a multicolumn array of rationals was displayed wide column per column, columns #2:$ were replaced with its column #2.
* [#16160](https://gitlab.com/scilab/scilab/-/issues/16160): `ppol` changed values of the third input variable.
* [#16162](https://gitlab.com/scilab/scilab/-/issues/16162): `noisegen()` and `prbs_a()` deserved to be moved to the elementary_functions module, gathered with `rand()` and `grand()` in a new `elementarymatrices/random` help subsection.
* [#16163](https://gitlab.com/scilab/scilab/-/issues/16163): `prbs_a()` did not comply with the requested number of switches. The biased number of actual switches was unpredictable, preventing to manage its statistical distribution. The probability of the initial state was biased. For instance, prbs_a(n,0) always returned ones(1,n).
* [#16164](https://gitlab.com/scilab/scilab/-/issues/16164): Help pages in elementary_functions/signal_processing were mislocated.
* [#16166](https://gitlab.com/scilab/scilab/-/issues/16166): `noisegen` is very poor. It is tagged as obsolete and will be removed from Scilab 6.1.x.
* [#16167](https://gitlab.com/scilab/scilab/-/issues/16167): When get(0).showHiddenHandles is "on", clf('reset') unexpectedly removed native menus.
* [#16168](https://gitlab.com/scilab/scilab/-/issues/16168): On some Linux installations, `test_run` always failed.
* [#16174](https://gitlab.com/scilab/scilab/-/issues/16174): `libraryinfo` yielded 0x0 matrix of strings for libs without any macro.
* [#16177](https://gitlab.com/scilab/scilab/-/issues/16177): In the uicontrol help page, the first example was bugged.
* [#16178](https://gitlab.com/scilab/scilab/-/issues/16178): `sci2exp` yielded an error for any input macro without output argument.
* [#16181](https://gitlab.com/scilab/scilab/-/issues/16181): `mfile2sci` yielded an error on `a(end)` standing for `a($)` (Scilab 6 regression).
* [#16190](https://gitlab.com/scilab/scilab/-/issues/16190): Console width was fixed at 75 in nw and nwni mode regardless of terminal width.
* [#16197](https://gitlab.com/scilab/scilab/-/issues/16197): The result of extraction was not decomplexified when applicable.
* [#16199](https://gitlab.com/scilab/scilab/-/issues/16199): In the documentation, `zpk2tf` and `zpk2ss` examples yielded an error.
* [#16200](https://gitlab.com/scilab/scilab/-/issues/16200): Concatenation of transposed cells crashed Scilab.
* [#16204](https://gitlab.com/scilab/scilab/-/issues/16204): `for i=1:$, end` crashed Scilab.
* [#16208](https://gitlab.com/scilab/scilab/-/issues/16208): Using 3D string matrix with old C-api gateways may crash Scilab.
* [#16209](https://gitlab.com/scilab/scilab/-/issues/16209): `grand` causes a freeze after several consecutive calls when using the default base generator.
* [#16210](https://gitlab.com/scilab/scilab/-/issues/16210): The `uicontrol.units = "normalized"` property was not described.
* [#16215](https://gitlab.com/scilab/scilab/-/issues/16215): `mfile2sci` badly converted the colon `:` into `mtlb(:)`
* [#16223](https://gitlab.com/scilab/scilab/-/issues/16223): `EXPRESSION`, `CLR`, and `DLR` Xcos blocks sometimes displayed multiplied terms ambiguously in their icons.
* [#16227](https://gitlab.com/scilab/scilab/-/issues/16227): `WSCI` was not defined as an environment variable and could not be used as `%WSCI%` in commands sent with `host` or `unix_*`.
* [#16228](https://gitlab.com/scilab/scilab/-/issues/16228): `bode` and `nyquist` inline demos did not clear and reset the current axes where to draw, which could yield an error.
* [#16229](https://gitlab.com/scilab/scilab/-/issues/16229): Some outdated parts of the `help scilab` page were misleading.
* [#16230](https://gitlab.com/scilab/scilab/-/issues/16230): `MSWin>scilab --help` missed displaying some options like `-args..`, `-noatomsautoload`, etc.
* [#16232](https://gitlab.com/scilab/scilab/-/issues/16232): `colorbar` did not support `$` in `colminmax`, standing for the number of colors in the current colormap.
* [#16234](https://gitlab.com/scilab/scilab/-/issues/16234): Airy functions were not available.
* [#16242](https://gitlab.com/scilab/scilab/-/issues/16242): `loadmatfile` could not read Octave native text data files.
* [#16244](https://gitlab.com/scilab/scilab/-/issues/16244): `perms` could freeze the whole computer. It could not ignore duplicate permutations.
* [#16245](https://gitlab.com/scilab/scilab/-/issues/16245): `gsort` could not sort booleans.
* [#16246](https://gitlab.com/scilab/scilab/-/issues/16246): `isvector` was broken for sparse matrices.
* [#16257](https://gitlab.com/scilab/scilab/-/issues/16257): `blockdiag` implemented to replace `sysdiag`, improved and extended to strings.
* [#16259](https://gitlab.com/scilab/scilab/-/issues/16259): `*` and `.*` multiplications involving a sparse boolean and a double, or involving 2 booleans, were not implemented.
* [#16260](https://gitlab.com/scilab/scilab/-/issues/16260): Overloading `nnz` was not possible (regression).
* [#16263](https://gitlab.com/scilab/scilab/-/issues/16263): Polynomial insertion was broken for complex cases.
* [#16264](https://gitlab.com/scilab/scilab/-/issues/16264): After empty for loop iterator was left uninitialized.
* [#16265](https://gitlab.com/scilab/scilab/-/issues/16265): The translated pages of the `warning` documentation were not up-to-date.
* [#16269](https://gitlab.com/scilab/scilab/-/issues/16269): Scalar structures were poorly displayed.
* [#16271](https://gitlab.com/scilab/scilab/-/issues/16271): `loadmatfile` was never able to automatically detect the input data format.
* [#16272](https://gitlab.com/scilab/scilab/-/issues/16272): `spzeros(0,n)` and `spzeros(n,0)` were different from `sparse(0,0)`.
* [#16273](https://gitlab.com/scilab/scilab/-/issues/16273): `calendar` had no formatted display mode.
* [#16275](https://gitlab.com/scilab/scilab/-/issues/16275): `fsolve(x0, fun, tol)` no longer took `tol` into account.
* [#16290](https://gitlab.com/scilab/scilab/-/issues/16290): The `cn`, `dn`, `ns`, `nc` and `nd` Jacobi elliptic functions were not available.
* [#16292](https://gitlab.com/scilab/scilab/-/issues/16292): `hallchart` had bugs and a poor rendering.
* [#16293](https://gitlab.com/scilab/scilab/-/issues/16293): Some demos run in step-by-step console mode(4) did not focus the user's attention on the console to proceed.
* [#16299](https://gitlab.com/scilab/scilab/-/issues/16299): After `graypolarplot`, `colorbar` displayed an empty ungraduated color bar.
* [#16303](https://gitlab.com/scilab/scilab/-/issues/16303): `log10(x)` had wrong dimensions when `x` is a hypermatrix.
* [#16307](https://gitlab.com/scilab/scilab/-/issues/16307): `dockable="off"` and `closerequestfcn` on figures crached Scilab.
* [#16320](https://gitlab.com/scilab/scilab/-/issues/16320): There were unsupported UTF-8 characters in some gettext id messages.
* [#16321](https://gitlab.com/scilab/scilab/-/issues/16321): There were typo errors in the documentation.
* [#16323](https://gitlab.com/scilab/scilab/-/issues/16323): `conj(sparse(x))` was complex when x is real.
* [#16325](https://gitlab.com/scilab/scilab/-/issues/16325): `mgetl` could not read single line data which is greater than ~260,000 characters.
* [#16333](https://gitlab.com/scilab/scilab/-/issues/16333): `tree_show` crashed for an input Xcos block.
* [#16373](https://gitlab.com/scilab/scilab/-/issues/16373): Scilab crashed or showed the wrong output when running on Arm processor
* [#16459](https://gitlab.com/scilab/scilab/-/issues/16459): The display of one column hypermatrix was wrong.
* [#16463](https://gitlab.com/scilab/scilab/-/issues/16463): `matrix(sparse([]),[0 0])` yielded `[]` instead of `sparse([])`.
* [#16483](https://gitlab.com/scilab/scilab/-/issues/16483): Substraction of complex polynomial matrices was broken (Scilab 6 regression).
* [#16498](https://gitlab.com/scilab/scilab/-/issues/16498): After `esb=sparse([%t %f]); esb(1,:)=[];` , `size(esb)` answered `[0 2]` instead of `[0 0]` .

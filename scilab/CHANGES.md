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
* `color_input()` checks entries against chosen color formats: indices, [r g b] triplets, color names, or "#RRGGBB" identifiers.
* <TODO>

For a high-level description of the main new features of this release, please consult the [embedded help][4]. It is also available as the "What's new" page of the help, by simply typing `help` in Scilab console.

[4]: modules/helptools/data/pages/homepage-en_US.html

In summary, the main new features and additions are:
* `edit_curv()` is upgraded. New implemented features:
  - Undo / Redo actions.
  - Deletion of points.
  - Editing a curve of given (customized) handle.
  - Editing a curve of given handle.
  - Editing in a given axes, persistent when leaving.
* Use `curl` as default on `atomsDownload` for all OS to handle local file repositories
* <TODO>

Obsolete functions or features
------------------------------

All these functions and features will be removed in Scilab 2025.0.0 (October 2024):
* `getURL()`: Please use `http_get()` instead.
* `splitURL()`: Please use `url_split()` instead.
* `sound()`: Please use `playsnd()` instead.
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

* __add your bug fix here and keep this line__
* [#3666](https://gitlab.com/scilab/scilab/-/issues/3666): `input()` badly reencoded UTF-8 input strings
* [#8666](https://gitlab.com/scilab/scilab/-/issues/8666): Linear algebra demonstration failed with xerbla error.
* [#8812](https://gitlab.com/scilab/scilab/-/issues/8812): Multi-selection in a listbox now works when `max - min` is greater than 1.
* [#8917](https://gitlab.com/scilab/scilab/-/issues/8917): `write(filename,..)` could not overwrite an existing file.
* [#12391](https://gitlab.com/scilab/scilab/-/issues/12391): `findobj("figure_id", num)` changed current figure (returned by `gcf()`).
* [#13307](https://gitlab.com/scilab/scilab/-/issues/13307): Clicking on the same item from a listbox a second time did not trigger the callback.
* [#14069](https://gitlab.com/scilab/scilab/-/issues/14069): Autosave in SciNotes did not work as intended for the "source file directory" option.
* [#14358](https://gitlab.com/scilab/scilab/-/issues/14358): Black Hole demo produced an error java, clicking on "Clear" button.
* [#15075](https://gitlab.com/scilab/scilab/-/issues/15075): `read` was slow when reading an unknown number of lines (dims == -1).
* [#13392](https://gitlab.com/scilab/scilab/-/issues/13392): `edit_curv()`: `Undo` could cancel only the very last action. There was no `Redo` action.
* [#13913](https://gitlab.com/scilab/scilab/-/issues/13913): The second output argument of `xgetmouse` always returned 0.
* [#15709](https://gitlab.com/scilab/scilab/-/issues/15709): `tbx_make(.,"help")` needed a `languages` option to target building to some chosen languages.
* [#16136](https://gitlab.com/scilab/scilab/-/issues/16136): `sound()` is a useless wrapper of `playsnd()`. It needed to be declared obsolete before forthcoming removal.
* [#16442](https://gitlab.com/scilab/scilab/-/issues/16442): `splitURL` moved to webtools module and renamed to `url_split`.
* [#16685](https://gitlab.com/scilab/scilab/-/issues/16685): `asciimat()` now belongs to the `m2sci` module, where its code, pages and tests should be.
* [#16804](https://gitlab.com/scilab/scilab/-/issues/16804): `[s,m]=assert_checkequal(1,%z)` yielded an error instead of silently returning the error message in `m`.
* [#16838](https://gitlab.com/scilab/scilab/-/issues/16838): Xcos window were not restore properly from `windowsConfiguration.xml`. 
* [#16810](https://gitlab.com/scilab/scilab/-/issues/16810): `edit_curv()` needed to be fixed and upgraded.
* [#16868](https://gitlab.com/scilab/scilab/-/issues/16868): `justify(hypermat,..)` processed only the first page `hypermat(:,:,1)`.
* [#16872](https://gitlab.com/scilab/scilab/-/issues/16872): `cat()` did not apply `[,]` and `[;]` input transtyping rules.
* [#16877](https://gitlab.com/scilab/scilab/-/issues/16877): `cellstr()` & `iscellstr()` now belong to the `m2sci` module, where their code, pages and tests should be.
* [#16878](https://gitlab.com/scilab/scilab/-/issues/16878): `or(%i, dim)` and `and(%i, dim)` yielded an error.
* [#16939](https://gitlab.com/scilab/scilab/-/issues/16993): `getversion()` did not detect that Scilab was built using `clang`.
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
* [#17002](https://gitlab.com/scilab/scilab/-/issues/17002): `Slint` default configuration file copied into SCIHOME and used instead of the original one.
* [#17008](https://gitlab.com/scilab/scilab/-/issues/17008): The C code displayed in the `API Scilab/API double functions` documentation page did not match the code used in the next runnable script, and was not compilable.
* [#17011](https://gitlab.com/scilab/scilab/-/issues/17011): `Matplot` crashed because of missing `rect` input argument.
* [#17014](https://gitlab.com/scilab/scilab/-/issues/17014): The tolerance required for the `rat` computation should verify `abs(N./D - X) <= tol * norm(X, 1)` (help page fixed).
* [#17022](https://gitlab.com/scilab/scilab/-/issues/17022): `kroneck()` returned wrong error message.
* [#17018](https://gitlab.com/scilab/scilab/-/issues/17018): The documentation for `x=input(…)` had error (x type), and was poor (description, examples). The only example was canceled with commenting.
* [#17010](https://gitlab.com/scilab/scilab/-/issues/17010): `slint` was overwriting the config file.
* [#17011](https://gitlab.com/scilab/scilab/-/issues/17011): `Matplot` crashed because of missing `rect` input argument.
* [#17041](https://gitlab.com/scilab/scilab/-/issues/17041): Wrong error message when calling `mopen` in read mode for a new file.
* [#13392](https://gitlab.com/scilab/scilab/-/issues/13392): `edit_curv()`: `Undo` could cancel only the very last action. There was no `Redo` action.
* [#16810](https://gitlab.com/scilab/scilab/-/issues/16810): `edit_curv()` needed to be fixed and upgraded.

* [#17012](https://gitlab.com/scilab/scilab/-/issues/17012): The internal function `iscolor` deserved being renamed and made public and documented.
* __add your bug fix here and keep this line__

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
* `demo_run()` is upgraded:
  * former `demo_begin()`and `demo_end()` features are actually implemented, included, and extended.
  * option `"needCompiler"` added. It replaces `demo_compiler()`

For a high-level description of the main new features of this release, please consult the [embedded help][4]. It is also available as the "What's new" page of the help, by simply typing `help` in Scilab console.

[4]: modules/helptools/data/pages/homepage-en_US.html

In summary, the main new features and additions are:
* <TODO>


Obsolete functions or features
------------------------------
* `demo_begin`, `demo_end` and `demo_compiler`

All these functions and features will be removed in Scilab 2025.0.0 (October 2024):
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
     - redhat/ubi8:8, ubi9:9.1 


Bug Fixes
---------

### Bugs fixed in 2023.1.0:

* [#7113](https://gitlab.com/scilab/scilab/-/issues/7113): In case of missing C compiler, `demo_compiler()` warns the user but was unable to abort the demonstration. Its added value w.r.t. `haveacompiler()` was poor.
* [#8212](https://gitlab.com/scilab/scilab/-/issues/8212): `demo_begin()` and `demo_end()` were not able to clean variables defined by a demonstration.
* [#8666](https://gitlab.com/scilab/scilab/-/issues/8666): Linear algebra demonstration failed with xerbla error.
* [#8812](https://gitlab.com/scilab/scilab/-/issues/8812): Multi-selection in a listbox now works when `max - min` is greater than 1.
* [#16685](https://gitlab.com/scilab/scilab/-/issues/16685): `asciimat()` now belongs to the `m2sci` module, where its code, pages and tests should be.
* [#16804](https://gitlab.com/scilab/scilab/-/issues/16804): `[s,m]=assert_checkequal(1,%z)` yielded an error instead of silently returning the error message in `m`.
* [#16877](https://gitlab.com/scilab/scilab/-/issues/16877): `cellstr()` & `iscellstr()` now belong to the `m2sci` module, where their code, pages and tests should be.
* [#16966](https://gitlab.com/scilab/scilab/-/issues/16966): The warning message for removal of `xset/xget` did not tell which function displayed the message.
* [#16995](https://gitlab.com/scilab/scilab/-/issues/16995): `hist3d` plotting feature no more worked in variable browser and variable editor.

* __add your bug fix here and keep this line__


### Bugs fixed in 2023.0.0:


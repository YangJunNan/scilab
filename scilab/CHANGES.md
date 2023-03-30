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

* [#8812](https://gitlab.com/scilab/scilab/-/issues/8812): Multi-selection in a listbox now works when `max - min` is greater than 1.
* [#16966](https://gitlab.com/scilab/scilab/-/issues/16966): The warning message for removal of `xset/xget` did not tell which function displayed the message.
* [#16995](https://gitlab.com/scilab/scilab/-/issues/16995): `hist3d` plotting feature no more worked in variable browser and variable editor.


### Bugs fixed in 2023.0.0:


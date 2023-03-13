Welcome to Scilab 2024.0.0
==========================

This file details the changes between Scilab 2024.0.0 (this version), and the previous 2023.0.0 release.
For changelogs of earlier releases, please see [Scilab 2023.0.0][1].

Summary:
- New features
- Obsolete functions & features
- Removed functions & features
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
* __add your features here and keep this line__


Obsolete functions or features
------------------------------

All these functions and features will be removed in Scilab 2025.0.0 (October 2024):
* __add your obsolete features here and keep this line__


Removed Functions
-----------------

The following functions have been removed:
* __add your removed functions here and keep this line__


Removed Features
----------------

The following features and usages have been removed or disabled:
* __add your removed features here and keep this line__


Installation
------------

* __add your installation notes here and keep this line__


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

* Scilab embedded JVM is Java 8. 

* To run or compile Scilab you need at least:
  - Windows (64-bit):
     - Windows 11 (Desktop)
     - Windows 10 (Desktop)
     - Windows 8 (Desktop)
  - macOS (64-bit):
     - Intel-based Mac running macOS 10.9+ (run) and 10.14+ (compile)
     - Support of macOS Monterey & Ventura added in Scilab 2023.0.0
  - Linux (64-bit):
     - Red Hat Enterprise Linux 6.x, 7.x
     - Ubuntu Linux 18.04 LTS, 22.04 LTS
     - Suse Linux Enterprise Server 10 SP2+, 11.x


API/ABI modification
--------------------

* __add your API modification here and keep this line__


Bug Fixes
---------

### Bugs fixed in 2024.0.0:


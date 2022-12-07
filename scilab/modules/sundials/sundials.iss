;
; Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
; Copyright (C) INRIA - Allan CORNET
; Copyright (C) DIGITEO - 2010 - Allan CORNET
;
; Copyright (C) 2012 - 2016 - Scilab Enterprises
;
; This file is hereby licensed under the terms of the GNU GPL v2.0,
; pursuant to article 5.3.4 of the CeCILL v.2.1.
; This file was originally licensed under the terms of the CeCILL v2.1,
; and continues to be available under such terms.
; For more information, see the COPYING file which you should have received
; along with this program.
;
;--------------------------------------------------------------------------------------------------------------
; Inno Setup Script (5.3 and more) for Scilab (UNICODE version required)
;
;--------------------------------------------------------------------------------------------------------------
; sundials module
;--------------------------------------------------------------------------------------------------------------
;
#define SUNDIALS "sundials"
;
Source: bin\{#SUNDIALS}.dll; DestDir: {app}\bin; Components: {#COMPN_SCILAB}
Source: bin\{#SUNDIALS}_gw.dll; DestDir: {app}\bin; Components: {#COMPN_SCILAB}
;
Source: modules\{#SUNDIALS}\src\patched_sundials\include\*; DestDir: {app}\modules\{#SUNDIALS}\includes; Flags: recursesubdirs; Components: {#COMPN_SCILAB}
;
Source: modules\{#SUNDIALS}\license.txt; DestDir: {app}\modules\{#SUNDIALS}; Components: {#COMPN_SCILAB}
;
Source: modules\{#SUNDIALS}\sci_gateway\{#SUNDIALS}_gateway.xml; DestDir: {app}\modules\{#SUNDIALS}\sci_gateway; Components: {#COMPN_SCILAB}
;
Source: modules\{#SUNDIALS}\etc\{#SUNDIALS}.quit; DestDir: {app}\modules\{#SUNDIALS}\etc; Components: {#COMPN_SCILAB}
Source: modules\{#SUNDIALS}\etc\{#SUNDIALS}.start; DestDir: {app}\modules\{#SUNDIALS}\etc; Components: {#COMPN_SCILAB}
;
Source: modules\{#SUNDIALS}\macros\lib; DestDir: {app}\modules\{#SUNDIALS}\macros; Flags: recursesubdirs; Components: {#COMPN_SCILAB}
Source: modules\{#SUNDIALS}\macros\*.sci; DestDir: {app}\modules\{#SUNDIALS}\macros; Flags: recursesubdirs; Components: {#COMPN_SCILAB}
Source: modules\{#SUNDIALS}\macros\*.bin; DestDir: {app}\modules\{#SUNDIALS}\macros; Flags: recursesubdirs; Components: {#COMPN_SCILAB}
Source: modules\{#SUNDIALS}\macros\buildmacros.sce; DestDir: {app}\modules\{#SUNDIALS}\macros; Flags: recursesubdirs; Components: {#COMPN_SCILAB}
Source: modules\{#SUNDIALS}\macros\buildmacros.bat; DestDir: {app}\modules\{#SUNDIALS}\macros; Flags: recursesubdirs; Components: {#COMPN_SCILAB}
Source: modules\{#SUNDIALS}\macros\cleanmacros.bat; DestDir: {app}\modules\{#SUNDIALS}\macros; Flags: recursesubdirs; Components: {#COMPN_SCILAB}
;
Source: modules\{#SUNDIALS}\demos\*.*; DestDir: {app}\modules\{#SUNDIALS}\demos; Flags: recursesubdirs; Components: {#COMPN_SCILAB}
;
Source: modules\{#SUNDIALS}\tests\*.*; DestDir: {app}\modules\{#SUNDIALS}\tests; Flags: recursesubdirs; Components: {#COMPN_SCILAB} and {#COMPN_TESTS}
;--------------------------------------------------------------------------------------------------------------

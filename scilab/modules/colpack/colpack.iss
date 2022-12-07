;
; Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
; Copyright (C) 3DS - 2022 - Antoine ELIAS
;
;--------------------------------------------------------------------------------------------------------------
; Inno Setup Script (5.3 and more) for Scilab (UNICODE version required)
;--------------------------------------------------------------------------------------------------------------
; string module
;--------------------------------------------------------------------------------------------------------------

#define COLPACK "colpack"

Source: bin\{#COLPACK}.dll; DestDir: {app}\bin; Components: {#COMPN_SCILAB}
Source: bin\{#COLPACK}.lib; DestDir: {app}\bin; Components: {#COMPN_SCILAB}
Source: bin\{#COLPACK}_gw.dll; DestDir: {app}\bin; Components: {#COMPN_SCILAB}

Source: modules\{#COLPACK}\license.txt; DestDir: {app}\modules\{#COLPACK}; Components: {#COMPN_SCILAB}

Source: modules\{#COLPACK}\etc\{#COLPACK}.quit; DestDir: {app}\modules\{#COLPACK}\etc; Flags: recursesubdirs; Components: {#COMPN_SCILAB}
Source: modules\{#COLPACK}\etc\{#COLPACK}.start; DestDir: {app}\modules\{#COLPACK}\etc; Flags: recursesubdirs; Components: {#COMPN_SCILAB}

Source: modules\{#COLPACK}\includes\*.h; DestDir: {app}\modules\{#COLPACK}\includes; Components: {#COMPN_SCILAB}

Source: modules\{#COLPACK}\macros\buildmacros.sce; DestDir: {app}\modules\{#COLPACK}\macros; Components: {#COMPN_SCILAB}
Source: modules\{#COLPACK}\macros\buildmacros.bat; DestDir: {app}\modules\{#COLPACK}\macros; Components: {#COMPN_SCILAB}
Source: modules\{#COLPACK}\macros\cleanmacros.bat; DestDir: {app}\modules\{#COLPACK}\macros; Components: {#COMPN_SCILAB}
Source: modules\{#COLPACK}\macros\lib; DestDir: {app}\modules\{#COLPACK}\macros; Components: {#COMPN_SCILAB}
Source: modules\{#COLPACK}\macros\*.sci; DestDir: {app}\modules\{#COLPACK}\macros; Components: {#COMPN_SCILAB}
Source: modules\{#COLPACK}\macros\*.bin; DestDir: {app}\modules\{#COLPACK}\macros; Components: {#COMPN_SCILAB}

Source: modules\{#COLPACK}\demos\*.*; DestDir: {app}\modules\{#COLPACK}\demos; Flags: recursesubdirs;  Components: {#COMPN_SCILAB}

Source: modules\{#COLPACK}\tests\*.*; DestDir: {app}\modules\{#COLPACK}\tests; Flags: recursesubdirs;  Components: {#COMPN_SCILAB}



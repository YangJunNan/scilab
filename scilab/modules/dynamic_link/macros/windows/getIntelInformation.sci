function FComplier = getIntelInformation()
    FComplier = getenv("IFORT_COMPILER22", "");
    if FComplier <> "" then
        FComplier = fullpath(FComplier + "../../..");
    end
endfunction
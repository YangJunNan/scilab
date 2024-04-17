// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2024 - UTC - Stephane MOTTELET
//

data.x = 1;
data.X = rand(5, 5);
data.b = %t;
data.B = [%t %f;%f %t];
data.s = "outline";
data.S = ["outline" "outline";"outline", "outline"];
data.i8 = int8(1);
data.I8 = int8([1 2 3 4]);
data.i16 = int16(1);
data.I16 = int16([1 2 3 4]);
data.i32 = int32(1);
data.I32 = int32([1 2 3 4]);
data.i64 = int64(1);
data.I64 = int64([1 2 3 4]);
data.l = list();
data.L = list(1, 2, 3);
data.ce = {[1 2 3 4], ["outline"]};
data.p = %s;
data.P = [%s %s;%s %s];
data.sp = sparse([1 2 3]);
data.spb = sparse([1 2 3] > 1);
data.st = struct("a", [1 2 3]);
data.ST = [struct("a", [1 2 3]) struct("a", [1 2 3]) struct("a", [1 2 3])];
data.h = gcf();
data.H = [gcf() gcf()];

//mode cannot be check in test, test_run remove empty lines in dia.ref
for i = fieldnames(data)'
	data(i)
end

/*
 *  Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
 *  Copyright (C) 2015 - Scilab Enterprises - Calixte DENIZET
 *
 *  This file must be used under the terms of the CeCILL.
 *  This source file is licensed as described in the file COPYING, which
 *  you should have received as part of this distribution.  The terms
 *  are also available at
 *  http://www.cecill.info/licences/Licence_CeCILL_V2-en.txt
 *
 */

#ifndef __JIT_SQRT_HXX__
#define __JIT_SQRT_HXX__

#include "JITOptimizedCall1.hxx"

namespace jit
{
    
    class JITSqrt : public JITOptimizedCall1
    {
    public:

        JITSqrt() : JITOptimizedCall1("sqrt", {{ analysis::TIType::COMPLEX, "csqrt"}}, llvm::Intrinsic::sqrt) { }
	
	virtual ~JITSqrt() { }

	virtual void S(const analysis::TIType & argType, JITScilabPtr & arg, const analysis::TIType & OType, JITScilabPtr & out, JITVisitor & jit);

	void S_d(const analysis::TIType & argType, JITScilabPtr & arg, const analysis::TIType & OType, JITScilabPtr & out, JITVisitor & jit);
    };

} // namespace jit

#endif // __JIT_SQRT_HXX__
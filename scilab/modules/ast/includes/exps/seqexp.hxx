/*
 *  Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
 *  Copyright (C) 2008-2008 - DIGITEO - Bruno JOFRET
 *
 *  This file must be used under the terms of the CeCILL.
 *  This source file is licensed as described in the file COPYING, which
 *  you should have received as part of this distribution.  The terms
 *  are also available at
 *  http://www.cecill.info/licences/Licence_CeCILL_V2-en.txt
 *
 */

/**
 ** \file seqexp.hxx
 ** Define the Sequence Expression class.
 */

#ifndef __AST_SEQEXP_HXX__
#define __AST_SEQEXP_HXX__

#include "exp.hxx"

namespace ast
{

/** \brief Abstract a Sequence Expression node.
**
** \b Example: (print_int(2097); print("WipeOut")) */
class SeqExp : public Exp
{
    /** \name Ctor & dtor.
    ** \{ */
public:
    /** \brief Construct a Sequence Expression node.
    ** \param location scanner position informations
    ** \param body EXP LIST intruction
    */
    SeqExp (const Location& location,
            exps_t& body)
        : Exp (location)
    {
        for (auto it : body)
        {
            it->setParent(this);
            _exps.push_back(it);
        }

        delete &body;
    }

    virtual ~SeqExp ()
    {
    }

    virtual SeqExp* clone()
    {
        exps_t* exp = new exps_t;
        for (auto it : _exps)
        {
            exp->push_back(it->clone());
        }

        SeqExp* cloned = new SeqExp(getLocation(), *exp);
        cloned->setVerbose(isVerbose());
        return cloned;
    }
    /** \name Visitors entry point.
    ** \{ */
public:
    /** \brief Accept a const visitor \a v. */
    virtual void accept (Visitor& v)
    {
        v.visit (*this);
    }
    /** \brief Accept a non-const visitor \a v. */
    virtual void accept (ConstVisitor& v) const
    {
        v.visit (*this);
    }
    /** \} */


    /** \name Accessors.
    ** \{ */
public:

    void clearExps()
    {
        //no delete ?
        _exps.clear();
    }
    /** \} */


    virtual ExpType getType() const
    {
        return SEQEXP;
    }
    inline bool isSeqExp() const
    {
        return true;
    }

    //forward continuable information to children
    virtual inline void setContinuable(void)
    {
        Exp::setContinuable();
        for (auto exp : _exps)
        {
            exp->setContinuable();
        }
    }

    //forward returnable information to children
    virtual inline void setReturnable(void)
    {
        Exp::setReturnable();
        for (auto exp : _exps)
        {
            exp->setReturnable();
        }
    }

    //forward breakable information to children
    virtual inline void setBreakable(void)
    {
        Exp::setBreakable();
        for (auto exp : _exps)
        {
            exp->setBreakable();
        }
    }
};

} // namespace ast

#endif // __AST_SEQEXP_HXX__
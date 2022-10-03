//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "OdeManager.hxx"
#include "complexHelpers.hxx"

void OdeManager::init()
{
    char errorMsg[256];

    if (std::isnan(m_dblOptT0))
    {
        if (m_pDblTSpan->getSize() > 1)
        {
            m_dblT0 = m_pDblTSpan->get(0);
        }
        else
        {
            sprintf(errorMsg, _("%ls: parameter \"%ls\" must be defined by user.\n"), m_wstrCaller.c_str(), L"t0");
            throw ast::InternalError(errorMsg);
        }
     }
    else
    {
        m_dblT0 = m_dblOptT0;
    }

    // Complex ode is handled by using [real(y); imag(y)] as state,
    // hence the number of *real* equations is twice the number of complex equatioms
    m_iNbRealEq = m_odeIsComplex ? 2*m_iNbEq : m_iNbEq;

    m_N_VectorY = N_VNew_Serial(m_iNbRealEq, m_sunctx);
    m_N_VectorYTemp = N_VClone(m_N_VectorY);

    // Load Y0 into N_Serial vector
    // When ODE is complex m_N_VectorY has interlaced real and imaginary part of user Y (equivalent to std::complex)
  
    copyRealImgToComplexVector(m_pDblY0->get(), m_pDblY0->getImg(), N_VGetArrayPointer(m_N_VectorY), m_iNbEq, m_odeIsComplex);

    if (create())
    {
        sprintf(errorMsg,"Solver create error\n");
        throw ast::InternalError(errorMsg);
    }

    if (setUserData(m_prob_mem, (void *)this) < 0)
    {
        sprintf(errorMsg,"setUserData error\n");
        throw ast::InternalError(errorMsg);
    }

    // Eventual initial values of additionnal states are set in initialize() specific solver method
    if (initialize(errorMsg))
    {
        throw ast::InternalError(errorMsg);
    }

    // constraints on solution
    if (m_iVecPositive.size() > 0    ||
        m_iVecNonPositive.size() > 0 ||
        m_iVecNegative.size() > 0    ||
        m_iVecNonNegative.size() > 0)
    {
        N_Vector NVConstr = N_VClone(m_N_VectorY);
        double *pdblConstr = N_VGetArrayPointer(NVConstr);
        for (const auto &it : m_iVecPositive)
        {
           pdblConstr[it-1] = 2;
        }
        for (const auto &it : m_iVecNonNegative)
        {
            pdblConstr[it-1] = 1;
        }
        for (const auto &it : m_iVecNonPositive)
        {
            pdblConstr[it-1] = -1;
        }
        for (const auto &it : m_iVecNegative)
        {
            pdblConstr[it-1] = -2;
        }
        if (setConstraints(m_prob_mem, NVConstr) < 0)
        {
            sprintf(errorMsg, "setConstraints error");
            throw ast::InternalError(errorMsg);
        }
    }

    if (m_iMaxNumSteps > 0 && setMaxNumSteps(m_prob_mem, m_iMaxNumSteps))
    {
        sprintf(errorMsg,"setMaxNumSteps error\n");
        throw ast::InternalError(errorMsg);
    }

    if (m_dblInitialStep > 0 && setInitStep(m_prob_mem, m_dblInitialStep) < 0)
    {
        sprintf(errorMsg,"setInitStep error\n");
        throw ast::InternalError(errorMsg);
    }

    if (m_dblMaxStep > 0 && setMaxStep(m_prob_mem, m_dblMaxStep) < 0)
    {
        sprintf(errorMsg,"setMaxStep error\n");
        throw ast::InternalError(errorMsg);
    }

    if (m_dblMinStep > 0 && setMinStep(m_prob_mem, m_dblMinStep) < 0)
    {
        sprintf(errorMsg,"setMinStep error\n");
        throw ast::InternalError(errorMsg);
    }

    // Events
    if (m_iNbEvents > 0 && setEventFunction())
    {
        sprintf(errorMsg,"setEventFunction error\n");
        throw ast::InternalError(errorMsg);
    }
    // absolute (a vector) and relative tolerance
    m_N_VectorAtol = N_VClone(m_N_VectorY);
    if (m_odeIsComplex)
    {
        m_dblVecAtol.resize(m_iNbRealEq);
        for (int i=0; i<m_iNbEq; i++)
        {
            m_dblVecAtol[i+m_iNbEq] = m_dblVecAtol[i];
        }
    }
    std::copy(m_dblVecAtol.begin(), m_dblVecAtol.end(), N_VGetArrayPointer(m_N_VectorAtol));

    if (setVTolerances(m_prob_mem, m_dblRtol, m_N_VectorAtol) < 0)
    {
        sprintf(errorMsg,"setTolerances error\n");
        throw ast::InternalError(errorMsg);
    }

    if (setMaxOrd(m_prob_mem, m_iMaxOrder) < 0)
    {
        sprintf(errorMsg,"setMaxOrder error\n");
        throw ast::InternalError(errorMsg);
    }
    //
    // Set linear solver (if applicable) according to Jacobian type (Dense, band or Sparse)
    //
    if (m_wstrNonLinSolver == L"Newton")
    {
        m_wstrLinSolver = setLinearSolver(isDAE() ? JACYYP : JACY, m_N_VectorY, m_A, m_LS);
    }

    if (setSolverAndJacobian(errorMsg))
    {
        throw ast::InternalError(errorMsg);
    }

    if (computeIC(errorMsg))
    {
     throw ast::InternalError(errorMsg);
    }

    if (setErrHandlerFn(m_prob_mem, SUNDIALSErrHandler, (void *)this) < 0)
    {
        sprintf(errorMsg,"setHandlerFunction error\n");
        throw ast::InternalError(errorMsg);
    }
}



//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#ifndef _KINSOLMANAGER_HXX_
#define _KINSOLMANAGER_HXX_

#include "SUNDIALSManager.hxx"
#include "complexHelpers.hxx"
#include <kinsol/kinsol_impl.h>
#include <kinsol/kinsol_ls_impl.h>
#include <kinsol/kinsol.h>  /* prototypes for KINSOL fcts. and consts. */

typedef void(*dynlibFunPtr)();

class SUNDIALS_EXPORT KINSOLManager final : public SUNDIALSManager
{
public :

    KINSOLManager(const std::wstring& callerName, const std::wstring& solverName) : SUNDIALSManager(callerName, solverName)
    {
        LsATimes = kinLsATimes;
    }

    ~KINSOLManager()
    {
        if (m_prob_mem != NULL)
        {
            KINFree(&m_prob_mem);
        }
        m_prob_mem = NULL;
    };

    void* getmem()
    {
        return m_prob_mem;
    }

    KINMem getMem()
    {
        return (KINMem)m_prob_mem;
    }

    bool isEQSYS()
    {
        return true;
    }

    N_Vector getY()
    {
        return m_N_VectorY;
    }

    types::Double *getYOut()
    {
        types::Double *pDblYOut = m_pDblY0->clone();
        copyComplexVectorToDouble(NV_DATA_S(m_N_VectorY), pDblYOut->get(), pDblYOut->getImg(), m_iNbEq, m_odeIsComplex);
        return pDblYOut;
    }

    types::Double *getFOut()
    {
        types::Double *pDblFOut = m_pDblY0->clone();
        copyComplexVectorToDouble(NV_DATA_S(getMem()->kin_fval), pDblFOut->get(), pDblFOut->getImg(), m_iNbEq, m_odeIsComplex);
        return pDblFOut;
    }

    types::Double *getExitCode()
    {
        return (new types::Double((double)(m_bUserStop ? -99 : m_liExitCode)));
    }

    std::wstring getState()
    {
        return m_wstrState;
    }

    std::wstring getDisplay()
    {
        return m_wstrDisplay;
    }

    void setUserStop(bool b)
    {
        m_bUserStop = b;
    }

    bool getUserStop()
    {
        return m_bUserStop;
    }

    int DQJtimes(realtype tt, N_Vector yy, N_Vector yp, N_Vector rr,
                  N_Vector v, N_Vector Jv, realtype c_j,
                  N_Vector work1, N_Vector work2);
    void parseMatrices(types::typed_list &in);
    void parseFunctionFromOption(types::optional_list &opt, const wchar_t * _pwstLabel, functionKind what);
    void parseOptions(types::optional_list &opt);
    bool create();
    void init();
    void solve();
    types::Struct *getStats();
    void createSolutionOutput(types::typed_list &out);

    std::wstring getDefaultNonLinSolver()
    {
        return getAvailableNonLinSolvers()[0];
    }

    std::vector<std::wstring> getAvailableNonLinSolvers()
    {
        std::vector<std::wstring> availableSolvers = {L"Newton", L"lineSearch", L"Picard"};
        if (hasJacobian() == false)
        {
            availableSolvers.push_back(L"fixedPoint")  ;
        }
        return availableSolvers;
    }

    std::vector<std::wstring> getAvailablePrecondType()
    {
        std::vector<std::wstring> available = {L"NONE",L"RIGHT"};
        return available;
    }

    std::map<std::wstring, int> strategy = {
        {L"Newton", KIN_NONE},
        {L"lineSearch", KIN_LINESEARCH},
        {L"Picard", KIN_PICARD},
        {L"fixedPoint", KIN_FP}};

private :

    bool m_bUserStop = false;

    long int m_liExitCode;

    int m_iJacUpdateFreq;
    int m_iResMonFreq;
    
    double m_dblTol;
    double m_dblStepTol;
    double m_dblMaxStep;
    double m_dblNonLinSolDamping;
    
    std::wstring m_wstrState;
    std::wstring m_wstrDisplay;

    N_Vector m_N_VectorTypicalX = NULL;
    N_Vector m_N_VectorTypicalF = NULL;

    std::vector<double> m_dblVecTypicalX;
    std::vector<double> m_dblVecTypicalF;

    long int m_incStat[9] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
};

#endif

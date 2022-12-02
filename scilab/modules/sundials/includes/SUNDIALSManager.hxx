//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#ifndef _SUNDIALSMANAGER_HXX_
#define _SUNDIALSMANAGER_HXX_

#include "callable.hxx"
#include "cell.hxx"
#include "context.hxx"
#include "double.hxx"
#include "function.hxx"
#include "list.hxx"
#include "mlist.hxx"
#include "pointer.hxx"
#include "runvisitor.hxx"
#include "sparse.hxx"
#include "string.hxx"
#include "struct.hxx"
#include "spCompJacobian.hxx"
#include <Eigen/Sparse>
#include <array>
#include <chrono>

extern "C"
{
#include "Scierror.h"
#include "localization.h"
#include "sciprint.h"
}

/* Sundials includes */
#include <nvector/nvector_serial.h>   /* serial N_Vector types, fcts., and macros */
#ifdef _OPENMP
#include <nvector/nvector_openmp.h>   /* OpenMP N_Vector types, fcts., and macros */
#endif
#include <sundials/sundials_context.h>  /* prototypes for SUNDIALS context (since 6.0) */
#include <sundials/sundials_dense.h>  /* prototypes for various DlsMat operations */
#include <sundials/sundials_direct.h> /* definitions of DlsMat and DENSE_ELEM */
#include <sundials/sundials_math.h>
#include <sundials/sundials_types.h>              /* definition of type realtype */
#include <sunlinsol/sunlinsol_band.h>             /* access to band SUNLinearSolver */
#include <sunlinsol/sunlinsol_dense.h>            /* access to dense SUNLinearSolver */
#include <sunlinsol/sunlinsol_klu.h>              /* access to band SUNLinearSolver */
#include <sunlinsol/sunlinsol_lapackband.h>       /* access to Lapack band SUNLinearSolver */
#include <sunlinsol/sunlinsol_lapackdense.h>      /* access to Lapack dense SUNLinearSolver */
#include <sunlinsol/sunlinsol_pcg.h>
#include <sunlinsol/sunlinsol_spbcgs.h>
#include <sunlinsol/sunlinsol_spgmr.h>
#include <sunlinsol/sunlinsol_spfgmr.h>   
#include <sunlinsol/sunlinsol_sptfqmr.h>
#include <sunmatrix/sunmatrix_band.h>             /* access to band SUNmatrix       */
#include <sunmatrix/sunmatrix_dense.h>            /* access to dense SUNmatrix       */
#include <sunnonlinsol/sunnonlinsol_fixedpoint.h> /* access to dense SUNLinearSolver */
#include <sunnonlinsol/sunnonlinsol_newton.h>     /* access to dense SUNLinearSolver */

typedef void (*dynlibFunPtr)();

#define SUNDIALSMANAGER_KILLME(p) \
    if (p != NULL)                \
        p->killMe();              \
    p = NULL;

class SUNDIALS_EXPORT SUNDIALSManager
{
  public:
    SUNDIALSManager(const std::wstring& callerName, const std::wstring& solverName)
    {
        m_wstrCaller = callerName;
        m_wstrSolver = solverName;
        m_dblElapsedTime = 0;
        m_iSizeOfInput[EVENTS] = -1;
        m_pCallFunction.fill(NULL);
        m_pCallFunctionName.fill(NULL);
        m_pIConstFunction.fill(NULL);
        m_typeOfOutput.fill(types::InternalType::ScilabNull);
        m_pIPattern.fill(NULL);
        m_iNonZeros.fill(-1);
        m_wstrSparseFormat.fill(L"");
        m_iVecBand.fill({});
        m_pEntryPointFunction.fill(NULL);
        m_functionAPI.fill(NONE);
        m_bHas.fill(false);
        SUNContext_Create(NULL, &m_sunctx); /* Create the SUNDIALS context */
    }

    virtual ~SUNDIALSManager()
    {
        if (m_N_VectorY != NULL)
            N_VDestroy(m_N_VectorY);
        if (m_N_VectorAtol != NULL)
            N_VDestroy(m_N_VectorAtol);
        if (m_N_VectorRAtol != NULL)
            N_VDestroy(m_N_VectorRAtol);
        if (m_A != NULL)
            SUNMatDestroy(m_A);
        if (m_SUNMat_pattern != NULL)
            SUNMatDestroy(m_SUNMat_pattern);
        if (m_N_Vector_seeds != NULL)
        {
            N_VDestroyVectorArray(m_N_Vector_seeds, m_spJacEngine->getNbSeeds());
        }
        if (m_LS != NULL)
            SUNLinSolFree(m_LS);
        if (m_NLS != NULL)
            SUNNonlinSolFree(m_NLS);
        for (auto pDbl : m_pIConstFunction)
        {
            SUNDIALSMANAGER_KILLME(pDbl);
        }
        if (m_spJacEngine != NULL)
        {
            delete m_spJacEngine;
        }
        SUNContext_Free(&m_sunctx);  /* Free the SUNDIALS context */
    };

    enum functionKind
    {
        RHS = 0,
        SRHS,
        FRHS,
        SENSRHS,
        JACY,
        JACYTIMES,
        RES,
        JACYYP,
        JACYYPTIMES,
        MASS,
        MASSTIMES,
        EVENTS,
        INTCB,
        PROJ,
        PRECL,
        PRECR,
        NBKIND
    };
    enum functionAPI
    {
        NONE = 0,
        CONSTANT,
        SCILAB_CALLABLE,
        SUNDIALS_DLL,
        NBAPI
    };

    char pstrArgName[NBKIND][16] = {"\"f\"", "\"stiffRhs\"", "\"fastRhs\"", "\"sensRhs\"", "\"jacobian\"", "\"jacTimes\"", "\"residual\"",
                                    "\"jacobian\"", "\"jacTimes\"", "\"mass\"", "\"massTimes\"", "\"events\"", "\"callback\"", "\"projection\""};

    std::map<std::wstring, dynlibFunPtr> m_staticFunctionMap;

    SUNContext getContext()
    {
        return m_sunctx;
    }
    std::wstring getCallerName()
    {
        return m_wstrCaller;
    }
    std::wstring getSolverName()
    {
        return m_wstrSolver;
    }
    std::wstring getNonLinSol()
    {
        return m_wstrNonLinSolver;
    }
    SUNMatrix getSUNMATPattern()
    {
        return m_SUNMat_pattern;
    }
    bool isComplex()
    {
        return m_odeIsComplex;
    }
    void setIsComplex(bool b)
    {
        m_odeIsComplex = b;
    }

    bool hasJacobian()
    {
        functionKind whatJAC = isDAE() ? JACYYP : JACY;
        return m_bHas[whatJAC] || m_iVecBand[whatJAC].size() > 0 || m_pIPattern[whatJAC] != NULL;
    }

    types::Double* getATol()
    {
        types::Double* pDblATol = new types::Double(1, m_dblVecAtol.size());
        std::copy(m_dblVecAtol.begin(), m_dblVecAtol.end(), pDblATol->get());
        return pDblATol;
    }

    types::Double* getY0()
    {
        return m_pDblY0;
    }

    void setIretCount(int iRetCount)
    {
        m_iRetCount = iRetCount;
    }

    int getNEq()
    {
        return m_iNbEq;
    }

    int getNRealEq()
    {
        return m_iNbRealEq;
    }

    int getSizeOfInput(functionKind what)
    {
        return m_iSizeOfInput[what];
    }

    dynlibFunPtr getEntryPointFunction(functionKind what)
    {
        return m_pEntryPointFunction[what];
    }

    int getNbParameters(functionKind what)
    {
        return m_pParameters[what].size();
    }

    types::typed_list getParameters(functionKind what)
    {
        return m_pParameters[what];
    }

    double* getPdblSinglePar(functionKind what)
    {
        if (getNbParameters(what) > 0)
        {
            // only first (Double) parameter is considered (tested in OdeManager::parseFunction)
            return getParameters(what)[0]->getAs<types::Double>()->get();
        }
        return NULL;
    }

    functionAPI getFunctionAPI(functionKind what)
    {
        return m_functionAPI[what];
    }

    char* getFunctionName(functionKind what)
    {
        return m_pCallFunctionName[what];
    }

    types::InternalType* getConstantFunction(functionKind what)
    {
        return m_pIConstFunction[what];
    }

    void freeConstantFunction(functionKind what)
    {
        m_pIConstFunction[what]->DecreaseRef();
        m_pIConstFunction[what]->killMe();
        m_pIConstFunction[what] = NULL;
    }

    void *getSUNProbMem()
    {
        return m_prob_mem;
    }

    int (*LsATimes)(void *, N_Vector, N_Vector);

    spCompJacobian *getColPackEngine()
    {
        return m_spJacEngine;
    }
    
    N_Vector *getNVectorSeeds()
    {
        return m_N_Vector_seeds;
    }
    
    std::wstring getDefaultLinSolver()
    {
        return getAvailableLinSolvers()[0];
    }

    std::vector<std::wstring> getAvailableLinSolvers()
    {
        std::vector<std::wstring> availableSolvers = {};
        functionKind whatJAC = isDAE() ? JACYYP : JACY;
        if (m_pIPattern[whatJAC] != NULL || m_iNonZeros[whatJAC] > 0)
        {
            availableSolvers.push_back(L"KLU");
        }
        else if (m_iVecBand[whatJAC].size() > 0)
        {
            availableSolvers.push_back(L"BAND");            
        }
        else if (m_bHas[whatJAC])
        {
            availableSolvers.push_back(L"DENSE");                        
        }
        else if (m_wstrNonLinSolver == L"fixedPoint")
        {
            availableSolvers.push_back(L"NONE");
        }
        else
        {
            availableSolvers.push_back(L"DENSE");
            availableSolvers.push_back(L"CG");
            availableSolvers.push_back(L"BCGS");
            availableSolvers.push_back(L"FGMR");
            availableSolvers.push_back(L"GMR");                      
            availableSolvers.push_back(L"TFQMR");
        }
        return availableSolvers;
    }

    void parseFunction(types::InternalType* pIn, functionKind what);
    void parseMatrixPattern(types::optional_list &opt, const wchar_t * _pwstLabel, functionKind what);
    void callOpening(functionKind what, types::typed_list& in, double* pdblY = NULL);
    void callClosing(functionKind what, types::typed_list& in, std::vector<int> iRetCount, types::typed_list& out);
    void computeFunction(types::typed_list& in, functionKind what, double* pdblOut = NULL, double* pdblOutExtra = NULL);
    void computeMatrix(types::typed_list& in, functionKind what, SUNMatrix SUNMat_J = NULL);
    std::wstring setLinearSolver(functionKind what, N_Vector NV_work, SUNMatrix& SUN_A, SUNLinearSolver& SUN_LS);

    // virtual OdeManager methods (later overriden by CVODE, IDA, ARKODE, ...)
    virtual bool isDAE()
    {
        return false;
    }
    virtual bool isODE()
    {
        return false;
    }
    virtual bool isEQSYS()
    {
        return false;
    }
    // virtual void errHandler(int error_code, const char *module, const char *function, char *msg) {}

    virtual std::vector<std::wstring> getAvailablePrecondType()
    {
        std::vector<std::wstring> available = {L"NONE",L"LEFT",L"RIGHT",L"BOTH"};
        return available;
    }

    virtual std::wstring getDefaultPrecondType()
    {
        if  (m_iPrecBand.size() > 0)
        {
            return L"RIGHT";
        }
        else
        {
            return L"NONE";            
        }
    }
    
    virtual bool hasBandPrec()
    {
        return false;
    }

    virtual int DQJtimes(realtype tt, N_Vector yy, N_Vector yp, N_Vector rr,
                  N_Vector v, N_Vector Jv, realtype c_j,
                  N_Vector work1, N_Vector work2) = 0;
    virtual void parseMatrices(types::typed_list& in) = 0;
    virtual void parseOptions(types::optional_list& opt) = 0;
    virtual bool create() = 0;
    virtual void init() = 0;
    virtual void solve() = 0;
    virtual std::vector<std::wstring> getAvailableNonLinSolvers() = 0;
    virtual std::wstring getDefaultNonLinSolver() = 0;
    virtual types::Struct* getStats() = 0;

  protected:
    std::wstring m_wstrCaller;
    std::wstring m_wstrSolver;
    std::wstring m_wstrNonLinSolver;
    std::wstring m_wstrLinSolver;
    std::wstring m_wstrPrecondType;

    std::array<functionAPI, NBKIND> m_functionAPI;
    std::array<dynlibFunPtr, NBKIND> m_pEntryPointFunction;
    std::array<dynlibFunPtr, NBKIND> m_pEntryPointFunctionWithPar;
    std::array<int, NBKIND> m_iNonZeros;
    std::array<std::wstring, NBKIND> m_wstrSparseFormat;
    std::array<std::vector<int>, NBKIND> m_iVecBand;
    std::array<char*, NBKIND> m_pCallFunctionName;
    std::array<int, NBKIND> m_iSizeOfInput;
    std::array<bool, NBKIND> m_bHas;
    std::array<types::typed_list, NBKIND> m_pParameters;

    // Arrays of Scilab type objects
    std::array<types::Callable*, NBKIND> m_pCallFunction;
    std::array<types::InternalType*, NBKIND> m_pIConstFunction;
    std::array<types::InternalType::ScilabType, NBKIND> m_typeOfOutput;
    std::array<types::InternalType*, NBKIND> m_pIPattern;

    // Colpack Jacobian engine
    spCompJacobian *m_spJacEngine = NULL;

    // Preconditioning
    std::map<std::wstring, int> m_iPrecondType { {L"NONE", 0}, {L"LEFT", 1}, {L"RIGHT", 2}, {L"BOTH", 2}};

    SUNContext m_sunctx;
    N_Vector m_N_VectorY = NULL;
    N_Vector m_N_VectorAtol = NULL;
    N_Vector m_N_VectorRAtol = NULL;
    N_Vector* m_N_Vector_seeds = NULL;

    SUNMatrix m_A = NULL;
    SUNMatrix m_SUNMat_pattern = NULL;
    SUNLinearSolver m_LS = NULL;
    SUNNonlinearSolver m_NLS = NULL;

    types::Double* m_pDblY0 = NULL;
    types::Double* m_pDblYOut = NULL;

    std::vector<double> m_dblVecAtol;
    std::vector<double> m_dblVecRAtol;
    std::vector<double> m_dblVecTOut;
    std::vector<int> m_iVecPositive;
    std::vector<int> m_iVecNonPositive;
    std::vector<int> m_iVecNegative;
    std::vector<int> m_iVecNonNegative;
    std::vector<int> m_iPrecBand;

    bool m_odeIsComplex = false;

    double m_dblDefaultRtol = 1e-4;
    double m_dblDefaultAtol = 1e-6;
    double m_dblRtol;
    double m_dblElapsedTime;

    int m_iRetCount;
    int m_iNbEq;
    int m_iNbRealEq;
    int m_iNonLinSolAccel;
    int m_iLinSolMaxIters;
    int m_iNonLinSolMaxIters;
    int m_iNbThreads;

    void* m_prob_mem = NULL;
};

#endif

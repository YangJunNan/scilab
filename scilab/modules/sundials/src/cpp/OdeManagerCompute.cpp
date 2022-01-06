//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "OdeManager.hxx"
#include "SUNDIALSBridge.hxx"
#include "odeparameters.hxx"
#include "complexHelpers.hxx"

void OdeManager::setupEvents(types::optional_list &opt)
{
    types::typed_list in;
    types::typed_list out;
    std::vector<int> emptyVect = {};
    char errorMsg[256] = "";
    OdeManager *prevManager = getPreviousManager();

    if (getFunctionAPI(EVENTS) == SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = m_pEntryPointFunction[EVENTS];
        
        getIntInPlist(m_wstrCaller.c_str(), opt, L"nbEvents", &m_iNbEvents,
            m_odeIsExtension ? prevManager->m_iNbEvents : -1, {0, INT_MAX});
        if (m_iNbEvents >= 0)
        {
            getIntVectorInPlist(m_wstrCaller.c_str(), opt, L"evDir", m_iVecEventDirection,
                m_odeIsExtension ? prevManager->m_iVecEventDirection : emptyVect, {-1,1}, {m_iNbEvents});
            getIntVectorInPlist(m_wstrCaller.c_str(), opt, L"evTerm", m_iVecEventIsTerminal,
                m_odeIsExtension ? prevManager->m_iVecEventIsTerminal : emptyVect, {0,1}, {m_iNbEvents});        
        }
        else
        {
            sprintf(errorMsg, _("%ls: option \"nbEvents\" is missing.\n"), m_wstrCaller.c_str());
            throw ast::InternalError(errorMsg);            
        }
    }
    else if (getFunctionAPI(EVENTS) == SCILAB_CALLABLE)
    {
        callOpening(EVENTS, in, m_dblT0, NULL, NULL);
        callClosing(EVENTS, in, {1,3}, out);

        for (int i=0; i < out.size(); i++)
        {
            if (out[i]->isDouble() && out[i]->getAs<types::Double>()->isComplex() == false)
            {
                types::Double *pDbl = out[i]->getAs<types::Double>();
                m_iNbEvents = (i == 0) ? pDbl->getSize() : m_iNbEvents;
                if (pDbl->getSize() != m_iNbEvents)
                {
                    sprintf(errorMsg, _("%s: Wrong size for output argument #%d: expecting %d.\n"), m_pCallFunctionName[EVENTS], i+1, m_iNbEvents);
                    throw ast::InternalError(errorMsg);
                }
                if (i == 1)
                {
                    for (int k = 0; k<m_iNbEvents; k++)
                    {
                        m_iVecEventIsTerminal.push_back(pDbl->get(k));
                    }
                }
                else if (i == 2)
                {
                    for (int k = 0; k<m_iNbEvents; k++)
                    {
                        m_iVecEventDirection.push_back(pDbl->get(k));
                    }
                }
            }
            else
            {
                sprintf(errorMsg, _("%s: Wrong type for output argument #%d: A real matrix expected.\n"), m_pCallFunctionName[EVENTS], i+1);
                throw ast::InternalError(errorMsg);
            }
            m_iSizeOfInput[EVENTS] = m_iNbEvents;
            out[i]->killMe();
        }        
    }
}

void OdeManager::callOpening(functionKind what, types::typed_list &in, double t, double *pdblY, double *pdblYp)
{
    types::Double* pDblY = NULL;
    types::Double* pDblYp = NULL;
    char errorMsg[256] = "";

    in.push_back(new types::Double(t));        

    // keep native dimensions of Y0

    pDblY = m_pDblY0->clone();
    if (pdblY != NULL)
    {
        copyComplexVectorToDouble(pdblY, pDblY->get(), pDblY->getImg(), m_iNbEq, m_odeIsComplex);
    }
    in.push_back(pDblY);
    if (pdblYp != NULL || isDAE())
    {
        pDblYp = m_pDblY0->clone();
        if (pdblYp != NULL)
        {
            copyComplexVectorToDouble(pdblYp, pDblYp->get(), pDblYp->getImg(), m_iNbEq, m_odeIsComplex);            
        }
        in.push_back(pDblYp);
    }
}


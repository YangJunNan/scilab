//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "OdeManager.hxx"
#include "complexHelpers.hxx"

types::Double *OdeManager::createYOut(types::Double *m_pDblYtempl, int iNbOut, int iSizeTSpan, bool bFlat)
{
    types::Double *pDblYOut;
    int iDimsYtempl = m_pDblYtempl->getDims();

    if (bFlat == false && m_pDblYtempl->isVector()==false)
    {
        int *piDimsArrayYtempl = m_pDblYtempl->getDimsArray();
        int *piDimsArrayYOut = new int(iDimsYtempl+1);
        for (int i=0; i<iDimsYtempl; i++)
        {
            piDimsArrayYOut[i] = piDimsArrayYtempl[i];
        }
        piDimsArrayYOut[iDimsYtempl] = iSizeTSpan;
        pDblYOut = new types::Double(iDimsYtempl+1, piDimsArrayYOut, m_odeIsComplex);
    }
    else if (m_pDblYtempl->isVector() && bFlat == false)
    {
        pDblYOut = new types::Double(m_pDblYtempl->getSize(), iSizeTSpan, m_odeIsComplex);        
    }
    else
    {
        pDblYOut = new types::Double(iNbOut, iSizeTSpan, m_odeIsComplex);
    }
    return pDblYOut;
}

void OdeManager::createSolutionOutput(types::typed_list &out)
{
    // return a MList of "_odeSolution" type with method solution at internal steps
    // and a pointer to the OdeManager object. Extraction on this MList calls %_odeSolution_e and allows
    // to compute solution at arbitrary value of time by using method dense interpolant.

    auto addFields = getAdditionalFields();
    auto addEventFields = getAdditionalEventFields();
    int iNbEventFields = m_iNbEvents > 0 ? 3+addEventFields.size() : 0; 
    int iNbFields = 9 + (m_iRetCount == 1 ? 3+addFields.size() + iNbEventFields : 0);
    int k = 0;

    types::MList *pObj = new types::MList();
    types::String *pStr = new types::String(1,iNbFields);
    
    pStr->set(k++,L"_odeSolution");
    pStr->set(k++,L"solver");
    pStr->set(k++,L"method");
    pStr->set(k++,L"interpolation");
    pStr->set(k++,L"linearSolver");
    pStr->set(k++,L"nonLinearSolver");
    pStr->set(k++,L"rtol");
    pStr->set(k++,L"atol");

    if (m_iRetCount == 1)
    {
        pStr->set(k++,L"t");
        pStr->set(k++,L"y");
        for (auto it : addFields)
        {
            pStr->set(k++,it.first.c_str());            
        }
        if (m_iNbEvents > 0)
        {
            pStr->set(k++,L"te");
            pStr->set(k++,L"ye");
            for (auto it : addEventFields)
            {
                pStr->set(k++,it.first.c_str());            
            }
            pStr->set(k++,L"ie");
        }
        pStr->set(k++,L"manager");
    }
    pStr->set(k++,L"stats");

    k = 0;
    pObj->set(k++,pStr);
    pObj->set(k++,new types::String(m_wstrSolver.c_str()));
    pObj->set(k++,new types::String(getMethodName().c_str()));
    pObj->set(k++,new types::String(getInterpolationMethod().c_str()));
    pObj->set(k++,new types::String(m_wstrLinSolver.c_str()));
    pObj->set(k++,new types::String(m_wstrNonLinSolver.c_str()));
    pObj->set(k++,new types::Double(m_dblRtol));
    pObj->set(k++,getATol());
    
    if (m_iRetCount == 1)
    {
        pObj->set(k++,getTOut());
        pObj->set(k++,getYOut());
        for (auto it : addFields)
        {
            pObj->set(k++,it.second);            
        }
        if (m_iNbEvents > 0)
        {
            pObj->set(k++, getTEvent());
            pObj->set(k++, getYEvent());
            for (auto it : addEventFields)
            {
                pObj->set(k++,it.second);            
            }
            pObj->set(k++, getIndexEvent());
        }
        pObj->set(k++,new types::Pointer((void *)this));
    }

    pObj->set(k++, getStats());

    out.push_back(pObj);
}

types::Double *OdeManager::getArrayFromVectors(types::Double *m_pDblYtempl, std::vector<std::vector<double>> &m_vecY, int iTSpanSize)
{
    types::Double *pDblY = createYOut(m_pDblYtempl, m_iNbEq, iTSpanSize);
    for (int i = 0; i < m_vecY.size(); i++)
    {
        copyComplexVectorToRealImg(m_vecY[i].data(), pDblY, i, m_iNbEq, m_odeIsComplex);
    }
    return pDblY;
}

int OdeManager::getBasisDimensionAtIndex(int iIndex)
{
    return m_indexInterpBasis[iIndex] -  m_indexInterpBasis[iIndex - 1];        
}

double *OdeManager::getBasisAtIndex(int iIndex)
{
    return m_pDblInterpBasisVectors->get() + m_indexInterpBasis[iIndex-1]*m_pDblInterpBasisVectors->getRows();
}





















/**
 * Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
 * Copyright (C) 2014 - Scilab Enterprises
 *
 * This file must be used under the terms of the CeCILL.
 * This source file is licensed as described in the file COPYING, which
 * you should have received as part of this distribution.  The terms
 * are also available at
 * http://www.cecill.info/licences/Licence_CeCILL_V2.1-en.txt
 *
 */
package org.scilab.modules.xcos.modeling.system.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.scilab.modules.xcos.modeling.system.Block;
import org.scilab.modules.xcos.modeling.system.Diagram;
import org.scilab.modules.xcos.modeling.system.Graphics;
import org.scilab.modules.xcos.modeling.system.Link;
import org.scilab.modules.xcos.modeling.system.Model;
import org.scilab.modules.xcos.modeling.system.Params;
import org.scilab.modules.xcos.modeling.system.Scsopt;
import org.scilab.modules.xcos.modeling.system.SystemFactory;
import org.scilab.modules.xcos.modeling.system.SystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemPackageImpl extends EPackageImpl implements SystemPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass diagramEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass paramsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scsoptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass blockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass graphicsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass linkEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType scilabTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType scilabDoubleEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType scilabIntegerEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType scilabBooleanEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType scilabStringEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SystemPackageImpl() {
        super(eNS_URI, SystemFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>This method is used to initialize {@link SystemPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SystemPackage init() {
        if (isInited) {
            return (SystemPackage)EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
        }

        // Obtain or create and register package
        SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SystemPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theSystemPackage.createPackageContents();

        // Initialize created meta-data
        theSystemPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSystemPackage.freeze();


        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SystemPackage.eNS_URI, theSystemPackage);
        return theSystemPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDiagram() {
        return diagramEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagram_Version() {
        return (EAttribute)diagramEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagram_Props() {
        return (EReference)diagramEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getParams() {
        return paramsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParams_Wpar() {
        return (EAttribute)paramsEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParams_Title() {
        return (EAttribute)paramsEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParams_Tol() {
        return (EAttribute)paramsEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParams_Tf() {
        return (EAttribute)paramsEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParams_Context() {
        return (EAttribute)paramsEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParams_Void1() {
        return (EAttribute)paramsEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getParams_Options() {
        return (EReference)paramsEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParams_Void2() {
        return (EAttribute)paramsEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParams_Void3() {
        return (EAttribute)paramsEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParams_Doc() {
        return (EAttribute)paramsEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScsopt() {
        return scsoptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScsopt__3D() {
        return (EAttribute)scsoptEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScsopt_Background() {
        return (EAttribute)scsoptEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScsopt_Link() {
        return (EAttribute)scsoptEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScsopt_ID() {
        return (EAttribute)scsoptEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScsopt_CMap() {
        return (EAttribute)scsoptEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBlock() {
        return blockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBlock_Gui() {
        return (EAttribute)blockEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_Graphics() {
        return (EReference)blockEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBlock_Model() {
        return (EReference)blockEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBlock_Doc() {
        return (EAttribute)blockEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGraphics() {
        return graphicsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Orig() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Sz() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Flip() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Theta() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Exprs() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Pin() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Pout() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Pein() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Peout() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Gr_i() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Id() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_In_implicit() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphics_Out_implicit() {
        return (EAttribute)graphicsEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModel() {
        return modelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Sim() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_In() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_In2() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Intyp() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Out() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Out2() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Outtyp() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Evtin() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Evtout() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_State() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Dstate() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Odstate() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Rpar() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Ipar() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Opar() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Blocktype() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Firing() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Dep_ut() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Label() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Nzcross() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Nmode() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModel_Equation() {
        return (EAttribute)modelEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLink() {
        return linkEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLink_Xx() {
        return (EAttribute)linkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLink_Yy() {
        return (EAttribute)linkEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLink_Id() {
        return (EAttribute)linkEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLink_Tick() {
        return (EAttribute)linkEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLink_Ct() {
        return (EAttribute)linkEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLink_From() {
        return (EAttribute)linkEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLink_To() {
        return (EAttribute)linkEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getScilabType() {
        return scilabTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getScilabDouble() {
        return scilabDoubleEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getScilabInteger() {
        return scilabIntegerEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getScilabBoolean() {
        return scilabBooleanEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getScilabString() {
        return scilabStringEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemFactory getSystemFactory() {
        return (SystemFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) {
            return;
        }
        isCreated = true;

        // Create classes and their features
        diagramEClass = createEClass(DIAGRAM);
        createEAttribute(diagramEClass, DIAGRAM__VERSION);
        createEReference(diagramEClass, DIAGRAM__PROPS);

        paramsEClass = createEClass(PARAMS);
        createEAttribute(paramsEClass, PARAMS__WPAR);
        createEAttribute(paramsEClass, PARAMS__TITLE);
        createEAttribute(paramsEClass, PARAMS__TOL);
        createEAttribute(paramsEClass, PARAMS__TF);
        createEAttribute(paramsEClass, PARAMS__CONTEXT);
        createEAttribute(paramsEClass, PARAMS__VOID1);
        createEReference(paramsEClass, PARAMS__OPTIONS);
        createEAttribute(paramsEClass, PARAMS__VOID2);
        createEAttribute(paramsEClass, PARAMS__VOID3);
        createEAttribute(paramsEClass, PARAMS__DOC);

        scsoptEClass = createEClass(SCSOPT);
        createEAttribute(scsoptEClass, SCSOPT__3D);
        createEAttribute(scsoptEClass, SCSOPT__BACKGROUND);
        createEAttribute(scsoptEClass, SCSOPT__LINK);
        createEAttribute(scsoptEClass, SCSOPT__ID);
        createEAttribute(scsoptEClass, SCSOPT__CMAP);

        blockEClass = createEClass(BLOCK);
        createEAttribute(blockEClass, BLOCK__GUI);
        createEReference(blockEClass, BLOCK__GRAPHICS);
        createEReference(blockEClass, BLOCK__MODEL);
        createEAttribute(blockEClass, BLOCK__DOC);

        graphicsEClass = createEClass(GRAPHICS);
        createEAttribute(graphicsEClass, GRAPHICS__ORIG);
        createEAttribute(graphicsEClass, GRAPHICS__SZ);
        createEAttribute(graphicsEClass, GRAPHICS__FLIP);
        createEAttribute(graphicsEClass, GRAPHICS__THETA);
        createEAttribute(graphicsEClass, GRAPHICS__EXPRS);
        createEAttribute(graphicsEClass, GRAPHICS__PIN);
        createEAttribute(graphicsEClass, GRAPHICS__POUT);
        createEAttribute(graphicsEClass, GRAPHICS__PEIN);
        createEAttribute(graphicsEClass, GRAPHICS__PEOUT);
        createEAttribute(graphicsEClass, GRAPHICS__GR_I);
        createEAttribute(graphicsEClass, GRAPHICS__ID);
        createEAttribute(graphicsEClass, GRAPHICS__IN_IMPLICIT);
        createEAttribute(graphicsEClass, GRAPHICS__OUT_IMPLICIT);

        modelEClass = createEClass(MODEL);
        createEAttribute(modelEClass, MODEL__SIM);
        createEAttribute(modelEClass, MODEL__IN);
        createEAttribute(modelEClass, MODEL__IN2);
        createEAttribute(modelEClass, MODEL__INTYP);
        createEAttribute(modelEClass, MODEL__OUT);
        createEAttribute(modelEClass, MODEL__OUT2);
        createEAttribute(modelEClass, MODEL__OUTTYP);
        createEAttribute(modelEClass, MODEL__EVTIN);
        createEAttribute(modelEClass, MODEL__EVTOUT);
        createEAttribute(modelEClass, MODEL__STATE);
        createEAttribute(modelEClass, MODEL__DSTATE);
        createEAttribute(modelEClass, MODEL__ODSTATE);
        createEAttribute(modelEClass, MODEL__RPAR);
        createEAttribute(modelEClass, MODEL__IPAR);
        createEAttribute(modelEClass, MODEL__OPAR);
        createEAttribute(modelEClass, MODEL__BLOCKTYPE);
        createEAttribute(modelEClass, MODEL__FIRING);
        createEAttribute(modelEClass, MODEL__DEP_UT);
        createEAttribute(modelEClass, MODEL__LABEL);
        createEAttribute(modelEClass, MODEL__NZCROSS);
        createEAttribute(modelEClass, MODEL__NMODE);
        createEAttribute(modelEClass, MODEL__EQUATION);

        linkEClass = createEClass(LINK);
        createEAttribute(linkEClass, LINK__XX);
        createEAttribute(linkEClass, LINK__YY);
        createEAttribute(linkEClass, LINK__ID);
        createEAttribute(linkEClass, LINK__TICK);
        createEAttribute(linkEClass, LINK__CT);
        createEAttribute(linkEClass, LINK__FROM);
        createEAttribute(linkEClass, LINK__TO);

        // Create data types
        scilabTypeEDataType = createEDataType(SCILAB_TYPE);
        scilabDoubleEDataType = createEDataType(SCILAB_DOUBLE);
        scilabIntegerEDataType = createEDataType(SCILAB_INTEGER);
        scilabBooleanEDataType = createEDataType(SCILAB_BOOLEAN);
        scilabStringEDataType = createEDataType(SCILAB_STRING);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) {
            return;
        }
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes, features, and operations; add parameters
        initEClass(diagramEClass, Diagram.class, "Diagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDiagram_Version(), ecorePackage.getEString(), "version", null, 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagram_Props(), this.getParams(), null, "props", null, 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(paramsEClass, Params.class, "Params", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getParams_Wpar(), this.getScilabDouble(), "wpar", null, 0, 1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParams_Title(), this.getScilabString(), "Title", null, 0, 1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParams_Tol(), this.getScilabDouble(), "tol", null, 0, 1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParams_Tf(), ecorePackage.getEDouble(), "tf", null, 0, 1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParams_Context(), this.getScilabString(), "context", null, 0, 1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParams_Void1(), this.getScilabDouble(), "void1", null, 0, 1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getParams_Options(), this.getScsopt(), null, "options", null, 0, 1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParams_Void2(), this.getScilabDouble(), "void2", null, 0, 1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParams_Void3(), this.getScilabDouble(), "void3", null, 0, 1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParams_Doc(), this.getScilabType(), "doc", null, 0, -1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(scsoptEClass, Scsopt.class, "Scsopt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getScsopt__3D(), this.getScilabType(), "_3D", null, 0, -1, Scsopt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScsopt_Background(), this.getScilabDouble(), "Background", null, 0, 1, Scsopt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScsopt_Link(), this.getScilabDouble(), "Link", null, 0, 1, Scsopt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScsopt_ID(), this.getScilabDouble(), "ID", null, 0, -1, Scsopt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScsopt_CMap(), this.getScilabDouble(), "CMap", null, 0, 1, Scsopt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getBlock_Gui(), ecorePackage.getEString(), "gui", null, 0, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBlock_Graphics(), this.getGraphics(), null, "graphics", null, 0, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBlock_Model(), this.getModel(), null, "model", null, 0, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getBlock_Doc(), this.getScilabType(), "doc", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(graphicsEClass, Graphics.class, "Graphics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGraphics_Orig(), this.getScilabDouble(), "orig", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Sz(), this.getScilabDouble(), "sz", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Flip(), ecorePackage.getEBoolean(), "flip", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Theta(), ecorePackage.getEDouble(), "theta", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Exprs(), this.getScilabString(), "exprs", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Pin(), this.getScilabDouble(), "pin", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Pout(), this.getScilabDouble(), "pout", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Pein(), this.getScilabDouble(), "pein", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Peout(), this.getScilabDouble(), "peout", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Gr_i(), this.getScilabType(), "gr_i", null, 0, -1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Id(), ecorePackage.getEString(), "id", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_In_implicit(), this.getScilabString(), "in_implicit", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGraphics_Out_implicit(), this.getScilabString(), "out_implicit", null, 0, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getModel_Sim(), this.getScilabType(), "sim", null, 0, 2, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_In(), this.getScilabInteger(), "in", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_In2(), this.getScilabInteger(), "in2", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Intyp(), this.getScilabInteger(), "intyp", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Out(), this.getScilabInteger(), "out", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Out2(), this.getScilabInteger(), "out2", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Outtyp(), this.getScilabInteger(), "outtyp", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Evtin(), this.getScilabInteger(), "evtin", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Evtout(), this.getScilabInteger(), "evtout", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_State(), this.getScilabDouble(), "state", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Dstate(), this.getScilabDouble(), "dstate", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Odstate(), this.getScilabType(), "odstate", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Rpar(), this.getScilabDouble(), "rpar", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Ipar(), this.getScilabInteger(), "ipar", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Opar(), this.getScilabType(), "opar", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Blocktype(), ecorePackage.getEString(), "blocktype", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Firing(), this.getScilabInteger(), "firing", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Dep_ut(), this.getScilabBoolean(), "dep_ut", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Label(), ecorePackage.getEString(), "label", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Nzcross(), ecorePackage.getEInt(), "nzcross", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Nmode(), ecorePackage.getEInt(), "nmode", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModel_Equation(), this.getScilabType(), "equation", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLink_Xx(), this.getScilabDouble(), "xx", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLink_Yy(), this.getScilabDouble(), "yy", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLink_Id(), ecorePackage.getEString(), "id", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLink_Tick(), this.getScilabDouble(), "tick", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLink_Ct(), this.getScilabDouble(), "ct", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLink_From(), this.getScilabDouble(), "from", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLink_To(), this.getScilabDouble(), "to", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        initEDataType(scilabTypeEDataType, org.scilab.modules.types.ScilabType.class, "ScilabType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(scilabDoubleEDataType, org.scilab.modules.types.ScilabDouble.class, "ScilabDouble", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(scilabIntegerEDataType, org.scilab.modules.types.ScilabInteger.class, "ScilabInteger", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(scilabBooleanEDataType, org.scilab.modules.types.ScilabBoolean.class, "ScilabBoolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(scilabStringEDataType, org.scilab.modules.types.ScilabString.class, "ScilabString", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //SystemPackageImpl

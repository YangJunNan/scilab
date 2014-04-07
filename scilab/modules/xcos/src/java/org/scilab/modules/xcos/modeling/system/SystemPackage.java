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
package org.scilab.modules.xcos.modeling.system;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.scilab.modules.xcos.modeling.system.SystemFactory
 * @model kind="package"
 * @generated
 */
public interface SystemPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "system";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://wiki.scilab.org/xcos/modeling/system";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "org.scilab.modules.xcos.modeling.system";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SystemPackage eINSTANCE = org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl.init();

    /**
     * The meta object id for the '{@link org.scilab.modules.xcos.modeling.system.impl.DiagramImpl <em>Diagram</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.xcos.modeling.system.impl.DiagramImpl
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getDiagram()
     * @generated
     */
    int DIAGRAM = 0;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__VERSION = 0;

    /**
     * The feature id for the '<em><b>Props</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__PROPS = 1;

    /**
     * The number of structural features of the '<em>Diagram</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Diagram</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl <em>Params</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.xcos.modeling.system.impl.ParamsImpl
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getParams()
     * @generated
     */
    int PARAMS = 1;

    /**
     * The feature id for the '<em><b>Wpar</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS__WPAR = 0;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS__TITLE = 1;

    /**
     * The feature id for the '<em><b>Tol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS__TOL = 2;

    /**
     * The feature id for the '<em><b>Tf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS__TF = 3;

    /**
     * The feature id for the '<em><b>Context</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS__CONTEXT = 4;

    /**
     * The feature id for the '<em><b>Void1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS__VOID1 = 5;

    /**
     * The feature id for the '<em><b>Options</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS__OPTIONS = 6;

    /**
     * The feature id for the '<em><b>Void2</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS__VOID2 = 7;

    /**
     * The feature id for the '<em><b>Void3</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS__VOID3 = 8;

    /**
     * The feature id for the '<em><b>Doc</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS__DOC = 9;

    /**
     * The number of structural features of the '<em>Params</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS_FEATURE_COUNT = 10;

    /**
     * The number of operations of the '<em>Params</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.scilab.modules.xcos.modeling.system.impl.ScsoptImpl <em>Scsopt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.xcos.modeling.system.impl.ScsoptImpl
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScsopt()
     * @generated
     */
    int SCSOPT = 2;

    /**
     * The feature id for the '<em><b>3D</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCSOPT__3D = 0;

    /**
     * The feature id for the '<em><b>Background</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCSOPT__BACKGROUND = 1;

    /**
     * The feature id for the '<em><b>Link</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCSOPT__LINK = 2;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCSOPT__ID = 3;

    /**
     * The feature id for the '<em><b>CMap</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCSOPT__CMAP = 4;

    /**
     * The number of structural features of the '<em>Scsopt</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCSOPT_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Scsopt</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCSOPT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.scilab.modules.xcos.modeling.system.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.xcos.modeling.system.impl.BlockImpl
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getBlock()
     * @generated
     */
    int BLOCK = 3;

    /**
     * The feature id for the '<em><b>Gui</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK__GUI = 0;

    /**
     * The feature id for the '<em><b>Graphics</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK__GRAPHICS = 1;

    /**
     * The feature id for the '<em><b>Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK__MODEL = 2;

    /**
     * The feature id for the '<em><b>Doc</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK__DOC = 3;

    /**
     * The number of structural features of the '<em>Block</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Block</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl <em>Graphics</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getGraphics()
     * @generated
     */
    int GRAPHICS = 4;

    /**
     * The feature id for the '<em><b>Orig</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__ORIG = 0;

    /**
     * The feature id for the '<em><b>Sz</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__SZ = 1;

    /**
     * The feature id for the '<em><b>Flip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__FLIP = 2;

    /**
     * The feature id for the '<em><b>Theta</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__THETA = 3;

    /**
     * The feature id for the '<em><b>Exprs</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__EXPRS = 4;

    /**
     * The feature id for the '<em><b>Pin</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__PIN = 5;

    /**
     * The feature id for the '<em><b>Pout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__POUT = 6;

    /**
     * The feature id for the '<em><b>Pein</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__PEIN = 7;

    /**
     * The feature id for the '<em><b>Peout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__PEOUT = 8;

    /**
     * The feature id for the '<em><b>Gr i</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__GR_I = 9;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__ID = 10;

    /**
     * The feature id for the '<em><b>In implicit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__IN_IMPLICIT = 11;

    /**
     * The feature id for the '<em><b>Out implicit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS__OUT_IMPLICIT = 12;

    /**
     * The number of structural features of the '<em>Graphics</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS_FEATURE_COUNT = 13;

    /**
     * The number of operations of the '<em>Graphics</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHICS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.xcos.modeling.system.impl.ModelImpl
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getModel()
     * @generated
     */
    int MODEL = 5;

    /**
     * The feature id for the '<em><b>Sim</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__SIM = 0;

    /**
     * The feature id for the '<em><b>In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__IN = 1;

    /**
     * The feature id for the '<em><b>In2</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__IN2 = 2;

    /**
     * The feature id for the '<em><b>Intyp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__INTYP = 3;

    /**
     * The feature id for the '<em><b>Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__OUT = 4;

    /**
     * The feature id for the '<em><b>Out2</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__OUT2 = 5;

    /**
     * The feature id for the '<em><b>Outtyp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__OUTTYP = 6;

    /**
     * The feature id for the '<em><b>Evtin</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__EVTIN = 7;

    /**
     * The feature id for the '<em><b>Evtout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__EVTOUT = 8;

    /**
     * The feature id for the '<em><b>State</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__STATE = 9;

    /**
     * The feature id for the '<em><b>Dstate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__DSTATE = 10;

    /**
     * The feature id for the '<em><b>Odstate</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__ODSTATE = 11;

    /**
     * The feature id for the '<em><b>Rpar</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__RPAR = 12;

    /**
     * The feature id for the '<em><b>Ipar</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__IPAR = 13;

    /**
     * The feature id for the '<em><b>Opar</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__OPAR = 14;

    /**
     * The feature id for the '<em><b>Blocktype</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__BLOCKTYPE = 15;

    /**
     * The feature id for the '<em><b>Firing</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__FIRING = 16;

    /**
     * The feature id for the '<em><b>Dep ut</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__DEP_UT = 17;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__LABEL = 18;

    /**
     * The feature id for the '<em><b>Nzcross</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__NZCROSS = 19;

    /**
     * The feature id for the '<em><b>Nmode</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__NMODE = 20;

    /**
     * The feature id for the '<em><b>Equation</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL__EQUATION = 21;

    /**
     * The number of structural features of the '<em>Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL_FEATURE_COUNT = 22;

    /**
     * The number of operations of the '<em>Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.scilab.modules.xcos.modeling.system.impl.LinkImpl <em>Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.xcos.modeling.system.impl.LinkImpl
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getLink()
     * @generated
     */
    int LINK = 6;

    /**
     * The feature id for the '<em><b>Xx</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK__XX = 0;

    /**
     * The feature id for the '<em><b>Yy</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK__YY = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK__ID = 2;

    /**
     * The feature id for the '<em><b>Tick</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK__TICK = 3;

    /**
     * The feature id for the '<em><b>Ct</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK__CT = 4;

    /**
     * The feature id for the '<em><b>From</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK__FROM = 5;

    /**
     * The feature id for the '<em><b>To</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK__TO = 6;

    /**
     * The number of structural features of the '<em>Link</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Link</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '<em>Scilab Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.types.ScilabType
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScilabType()
     * @generated
     */
    int SCILAB_TYPE = 7;

    /**
     * The meta object id for the '<em>Scilab Double</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.types.ScilabDouble
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScilabDouble()
     * @generated
     */
    int SCILAB_DOUBLE = 8;

    /**
     * The meta object id for the '<em>Scilab Integer</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.types.ScilabInteger
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScilabInteger()
     * @generated
     */
    int SCILAB_INTEGER = 9;

    /**
     * The meta object id for the '<em>Scilab Boolean</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.types.ScilabBoolean
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScilabBoolean()
     * @generated
     */
    int SCILAB_BOOLEAN = 10;

    /**
     * The meta object id for the '<em>Scilab String</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.scilab.modules.types.ScilabString
     * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScilabString()
     * @generated
     */
    int SCILAB_STRING = 11;


    /**
     * Returns the meta object for class '{@link org.scilab.modules.xcos.modeling.system.Diagram <em>Diagram</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Diagram</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Diagram
     * @generated
     */
    EClass getDiagram();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Diagram#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Diagram#getVersion()
     * @see #getDiagram()
     * @generated
     */
    EAttribute getDiagram_Version();

    /**
     * Returns the meta object for the reference '{@link org.scilab.modules.xcos.modeling.system.Diagram#getProps <em>Props</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Props</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Diagram#getProps()
     * @see #getDiagram()
     * @generated
     */
    EReference getDiagram_Props();

    /**
     * Returns the meta object for class '{@link org.scilab.modules.xcos.modeling.system.Params <em>Params</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Params</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params
     * @generated
     */
    EClass getParams();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Params#getWpar <em>Wpar</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Wpar</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params#getWpar()
     * @see #getParams()
     * @generated
     */
    EAttribute getParams_Wpar();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Params#getTitle <em>Title</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Title</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params#getTitle()
     * @see #getParams()
     * @generated
     */
    EAttribute getParams_Title();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Params#getTol <em>Tol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tol</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params#getTol()
     * @see #getParams()
     * @generated
     */
    EAttribute getParams_Tol();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Params#getTf <em>Tf</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tf</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params#getTf()
     * @see #getParams()
     * @generated
     */
    EAttribute getParams_Tf();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Params#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params#getContext()
     * @see #getParams()
     * @generated
     */
    EAttribute getParams_Context();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Params#getVoid1 <em>Void1</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Void1</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params#getVoid1()
     * @see #getParams()
     * @generated
     */
    EAttribute getParams_Void1();

    /**
     * Returns the meta object for the reference '{@link org.scilab.modules.xcos.modeling.system.Params#getOptions <em>Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Options</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params#getOptions()
     * @see #getParams()
     * @generated
     */
    EReference getParams_Options();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Params#getVoid2 <em>Void2</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Void2</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params#getVoid2()
     * @see #getParams()
     * @generated
     */
    EAttribute getParams_Void2();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Params#getVoid3 <em>Void3</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Void3</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params#getVoid3()
     * @see #getParams()
     * @generated
     */
    EAttribute getParams_Void3();

    /**
     * Returns the meta object for the attribute list '{@link org.scilab.modules.xcos.modeling.system.Params#getDocList <em>Doc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Doc</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Params#getDocList()
     * @see #getParams()
     * @generated
     */
    EAttribute getParams_Doc();

    /**
     * Returns the meta object for class '{@link org.scilab.modules.xcos.modeling.system.Scsopt <em>Scsopt</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Scsopt</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Scsopt
     * @generated
     */
    EClass getScsopt();

    /**
     * Returns the meta object for the attribute list '{@link org.scilab.modules.xcos.modeling.system.Scsopt#get_3DList <em>3D</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>3D</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Scsopt#get_3DList()
     * @see #getScsopt()
     * @generated
     */
    EAttribute getScsopt__3D();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Scsopt#getBackground <em>Background</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Background</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Scsopt#getBackground()
     * @see #getScsopt()
     * @generated
     */
    EAttribute getScsopt_Background();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Scsopt#getLink <em>Link</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Link</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Scsopt#getLink()
     * @see #getScsopt()
     * @generated
     */
    EAttribute getScsopt_Link();

    /**
     * Returns the meta object for the attribute list '{@link org.scilab.modules.xcos.modeling.system.Scsopt#getIDList <em>ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>ID</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Scsopt#getIDList()
     * @see #getScsopt()
     * @generated
     */
    EAttribute getScsopt_ID();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Scsopt#getCMap <em>CMap</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>CMap</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Scsopt#getCMap()
     * @see #getScsopt()
     * @generated
     */
    EAttribute getScsopt_CMap();

    /**
     * Returns the meta object for class '{@link org.scilab.modules.xcos.modeling.system.Block <em>Block</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Block</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Block
     * @generated
     */
    EClass getBlock();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Block#getGui <em>Gui</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Gui</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Block#getGui()
     * @see #getBlock()
     * @generated
     */
    EAttribute getBlock_Gui();

    /**
     * Returns the meta object for the reference '{@link org.scilab.modules.xcos.modeling.system.Block#getGraphics <em>Graphics</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Graphics</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Block#getGraphics()
     * @see #getBlock()
     * @generated
     */
    EReference getBlock_Graphics();

    /**
     * Returns the meta object for the reference '{@link org.scilab.modules.xcos.modeling.system.Block#getModel <em>Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Model</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Block#getModel()
     * @see #getBlock()
     * @generated
     */
    EReference getBlock_Model();

    /**
     * Returns the meta object for the attribute list '{@link org.scilab.modules.xcos.modeling.system.Block#getDocList <em>Doc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Doc</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Block#getDocList()
     * @see #getBlock()
     * @generated
     */
    EAttribute getBlock_Doc();

    /**
     * Returns the meta object for class '{@link org.scilab.modules.xcos.modeling.system.Graphics <em>Graphics</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Graphics</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics
     * @generated
     */
    EClass getGraphics();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getOrig <em>Orig</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Orig</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getOrig()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Orig();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getSz <em>Sz</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sz</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getSz()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Sz();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#isFlip <em>Flip</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Flip</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#isFlip()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Flip();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getTheta <em>Theta</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Theta</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getTheta()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Theta();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getExprs <em>Exprs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exprs</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getExprs()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Exprs();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getPin <em>Pin</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pin</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getPin()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Pin();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getPout <em>Pout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pout</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getPout()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Pout();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getPein <em>Pein</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pein</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getPein()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Pein();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getPeout <em>Peout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Peout</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getPeout()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Peout();

    /**
     * Returns the meta object for the attribute list '{@link org.scilab.modules.xcos.modeling.system.Graphics#getGr_iList <em>Gr i</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Gr i</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getGr_iList()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Gr_i();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getId()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Id();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getIn_implicit <em>In implicit</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>In implicit</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getIn_implicit()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_In_implicit();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Graphics#getOut_implicit <em>Out implicit</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Out implicit</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Graphics#getOut_implicit()
     * @see #getGraphics()
     * @generated
     */
    EAttribute getGraphics_Out_implicit();

    /**
     * Returns the meta object for class '{@link org.scilab.modules.xcos.modeling.system.Model <em>Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Model</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model
     * @generated
     */
    EClass getModel();

    /**
     * Returns the meta object for the attribute list '{@link org.scilab.modules.xcos.modeling.system.Model#getSimList <em>Sim</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Sim</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getSimList()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Sim();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getIn <em>In</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>In</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getIn()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_In();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getIn2 <em>In2</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>In2</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getIn2()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_In2();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getIntyp <em>Intyp</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Intyp</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getIntyp()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Intyp();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getOut <em>Out</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Out</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getOut()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Out();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getOut2 <em>Out2</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Out2</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getOut2()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Out2();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getOuttyp <em>Outtyp</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Outtyp</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getOuttyp()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Outtyp();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getEvtin <em>Evtin</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Evtin</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getEvtin()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Evtin();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getEvtout <em>Evtout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Evtout</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getEvtout()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Evtout();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getState <em>State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>State</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getState()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_State();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getDstate <em>Dstate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dstate</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getDstate()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Dstate();

    /**
     * Returns the meta object for the attribute list '{@link org.scilab.modules.xcos.modeling.system.Model#getOdstateList <em>Odstate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Odstate</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getOdstateList()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Odstate();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getRpar <em>Rpar</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rpar</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getRpar()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Rpar();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getIpar <em>Ipar</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ipar</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getIpar()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Ipar();

    /**
     * Returns the meta object for the attribute list '{@link org.scilab.modules.xcos.modeling.system.Model#getOparList <em>Opar</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Opar</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getOparList()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Opar();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getBlocktype <em>Blocktype</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Blocktype</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getBlocktype()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Blocktype();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getFiring <em>Firing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Firing</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getFiring()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Firing();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getDep_ut <em>Dep ut</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dep ut</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getDep_ut()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Dep_ut();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getLabel()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Label();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getNzcross <em>Nzcross</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Nzcross</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getNzcross()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Nzcross();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Model#getNmode <em>Nmode</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Nmode</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getNmode()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Nmode();

    /**
     * Returns the meta object for the attribute list '{@link org.scilab.modules.xcos.modeling.system.Model#getEquationList <em>Equation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Equation</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Model#getEquationList()
     * @see #getModel()
     * @generated
     */
    EAttribute getModel_Equation();

    /**
     * Returns the meta object for class '{@link org.scilab.modules.xcos.modeling.system.Link <em>Link</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Link</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Link
     * @generated
     */
    EClass getLink();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Link#getXx <em>Xx</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xx</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Link#getXx()
     * @see #getLink()
     * @generated
     */
    EAttribute getLink_Xx();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Link#getYy <em>Yy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Yy</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Link#getYy()
     * @see #getLink()
     * @generated
     */
    EAttribute getLink_Yy();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Link#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Link#getId()
     * @see #getLink()
     * @generated
     */
    EAttribute getLink_Id();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Link#getTick <em>Tick</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tick</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Link#getTick()
     * @see #getLink()
     * @generated
     */
    EAttribute getLink_Tick();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Link#getCt <em>Ct</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ct</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Link#getCt()
     * @see #getLink()
     * @generated
     */
    EAttribute getLink_Ct();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Link#getFrom <em>From</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>From</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Link#getFrom()
     * @see #getLink()
     * @generated
     */
    EAttribute getLink_From();

    /**
     * Returns the meta object for the attribute '{@link org.scilab.modules.xcos.modeling.system.Link#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>To</em>'.
     * @see org.scilab.modules.xcos.modeling.system.Link#getTo()
     * @see #getLink()
     * @generated
     */
    EAttribute getLink_To();

    /**
     * Returns the meta object for data type '{@link org.scilab.modules.types.ScilabType <em>Scilab Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Scilab Type</em>'.
     * @see org.scilab.modules.types.ScilabType
     * @model instanceClass="org.scilab.modules.types.ScilabType"
     * @generated
     */
    EDataType getScilabType();

    /**
     * Returns the meta object for data type '{@link org.scilab.modules.types.ScilabDouble <em>Scilab Double</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Scilab Double</em>'.
     * @see org.scilab.modules.types.ScilabDouble
     * @model instanceClass="org.scilab.modules.types.ScilabDouble"
     * @generated
     */
    EDataType getScilabDouble();

    /**
     * Returns the meta object for data type '{@link org.scilab.modules.types.ScilabInteger <em>Scilab Integer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Scilab Integer</em>'.
     * @see org.scilab.modules.types.ScilabInteger
     * @model instanceClass="org.scilab.modules.types.ScilabInteger"
     * @generated
     */
    EDataType getScilabInteger();

    /**
     * Returns the meta object for data type '{@link org.scilab.modules.types.ScilabBoolean <em>Scilab Boolean</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Scilab Boolean</em>'.
     * @see org.scilab.modules.types.ScilabBoolean
     * @model instanceClass="org.scilab.modules.types.ScilabBoolean"
     * @generated
     */
    EDataType getScilabBoolean();

    /**
     * Returns the meta object for data type '{@link org.scilab.modules.types.ScilabString <em>Scilab String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Scilab String</em>'.
     * @see org.scilab.modules.types.ScilabString
     * @model instanceClass="org.scilab.modules.types.ScilabString"
     * @generated
     */
    EDataType getScilabString();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    SystemFactory getSystemFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.scilab.modules.xcos.modeling.system.impl.DiagramImpl <em>Diagram</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.xcos.modeling.system.impl.DiagramImpl
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getDiagram()
         * @generated
         */
        EClass DIAGRAM = eINSTANCE.getDiagram();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIAGRAM__VERSION = eINSTANCE.getDiagram_Version();

        /**
         * The meta object literal for the '<em><b>Props</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DIAGRAM__PROPS = eINSTANCE.getDiagram_Props();

        /**
         * The meta object literal for the '{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl <em>Params</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.xcos.modeling.system.impl.ParamsImpl
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getParams()
         * @generated
         */
        EClass PARAMS = eINSTANCE.getParams();

        /**
         * The meta object literal for the '<em><b>Wpar</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMS__WPAR = eINSTANCE.getParams_Wpar();

        /**
         * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMS__TITLE = eINSTANCE.getParams_Title();

        /**
         * The meta object literal for the '<em><b>Tol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMS__TOL = eINSTANCE.getParams_Tol();

        /**
         * The meta object literal for the '<em><b>Tf</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMS__TF = eINSTANCE.getParams_Tf();

        /**
         * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMS__CONTEXT = eINSTANCE.getParams_Context();

        /**
         * The meta object literal for the '<em><b>Void1</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMS__VOID1 = eINSTANCE.getParams_Void1();

        /**
         * The meta object literal for the '<em><b>Options</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PARAMS__OPTIONS = eINSTANCE.getParams_Options();

        /**
         * The meta object literal for the '<em><b>Void2</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMS__VOID2 = eINSTANCE.getParams_Void2();

        /**
         * The meta object literal for the '<em><b>Void3</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMS__VOID3 = eINSTANCE.getParams_Void3();

        /**
         * The meta object literal for the '<em><b>Doc</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMS__DOC = eINSTANCE.getParams_Doc();

        /**
         * The meta object literal for the '{@link org.scilab.modules.xcos.modeling.system.impl.ScsoptImpl <em>Scsopt</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.xcos.modeling.system.impl.ScsoptImpl
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScsopt()
         * @generated
         */
        EClass SCSOPT = eINSTANCE.getScsopt();

        /**
         * The meta object literal for the '<em><b>3D</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCSOPT__3D = eINSTANCE.getScsopt__3D();

        /**
         * The meta object literal for the '<em><b>Background</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCSOPT__BACKGROUND = eINSTANCE.getScsopt_Background();

        /**
         * The meta object literal for the '<em><b>Link</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCSOPT__LINK = eINSTANCE.getScsopt_Link();

        /**
         * The meta object literal for the '<em><b>ID</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCSOPT__ID = eINSTANCE.getScsopt_ID();

        /**
         * The meta object literal for the '<em><b>CMap</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCSOPT__CMAP = eINSTANCE.getScsopt_CMap();

        /**
         * The meta object literal for the '{@link org.scilab.modules.xcos.modeling.system.impl.BlockImpl <em>Block</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.xcos.modeling.system.impl.BlockImpl
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getBlock()
         * @generated
         */
        EClass BLOCK = eINSTANCE.getBlock();

        /**
         * The meta object literal for the '<em><b>Gui</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BLOCK__GUI = eINSTANCE.getBlock_Gui();

        /**
         * The meta object literal for the '<em><b>Graphics</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BLOCK__GRAPHICS = eINSTANCE.getBlock_Graphics();

        /**
         * The meta object literal for the '<em><b>Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BLOCK__MODEL = eINSTANCE.getBlock_Model();

        /**
         * The meta object literal for the '<em><b>Doc</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BLOCK__DOC = eINSTANCE.getBlock_Doc();

        /**
         * The meta object literal for the '{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl <em>Graphics</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getGraphics()
         * @generated
         */
        EClass GRAPHICS = eINSTANCE.getGraphics();

        /**
         * The meta object literal for the '<em><b>Orig</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__ORIG = eINSTANCE.getGraphics_Orig();

        /**
         * The meta object literal for the '<em><b>Sz</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__SZ = eINSTANCE.getGraphics_Sz();

        /**
         * The meta object literal for the '<em><b>Flip</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__FLIP = eINSTANCE.getGraphics_Flip();

        /**
         * The meta object literal for the '<em><b>Theta</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__THETA = eINSTANCE.getGraphics_Theta();

        /**
         * The meta object literal for the '<em><b>Exprs</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__EXPRS = eINSTANCE.getGraphics_Exprs();

        /**
         * The meta object literal for the '<em><b>Pin</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__PIN = eINSTANCE.getGraphics_Pin();

        /**
         * The meta object literal for the '<em><b>Pout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__POUT = eINSTANCE.getGraphics_Pout();

        /**
         * The meta object literal for the '<em><b>Pein</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__PEIN = eINSTANCE.getGraphics_Pein();

        /**
         * The meta object literal for the '<em><b>Peout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__PEOUT = eINSTANCE.getGraphics_Peout();

        /**
         * The meta object literal for the '<em><b>Gr i</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__GR_I = eINSTANCE.getGraphics_Gr_i();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__ID = eINSTANCE.getGraphics_Id();

        /**
         * The meta object literal for the '<em><b>In implicit</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__IN_IMPLICIT = eINSTANCE.getGraphics_In_implicit();

        /**
         * The meta object literal for the '<em><b>Out implicit</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPHICS__OUT_IMPLICIT = eINSTANCE.getGraphics_Out_implicit();

        /**
         * The meta object literal for the '{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl <em>Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.xcos.modeling.system.impl.ModelImpl
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getModel()
         * @generated
         */
        EClass MODEL = eINSTANCE.getModel();

        /**
         * The meta object literal for the '<em><b>Sim</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__SIM = eINSTANCE.getModel_Sim();

        /**
         * The meta object literal for the '<em><b>In</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__IN = eINSTANCE.getModel_In();

        /**
         * The meta object literal for the '<em><b>In2</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__IN2 = eINSTANCE.getModel_In2();

        /**
         * The meta object literal for the '<em><b>Intyp</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__INTYP = eINSTANCE.getModel_Intyp();

        /**
         * The meta object literal for the '<em><b>Out</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__OUT = eINSTANCE.getModel_Out();

        /**
         * The meta object literal for the '<em><b>Out2</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__OUT2 = eINSTANCE.getModel_Out2();

        /**
         * The meta object literal for the '<em><b>Outtyp</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__OUTTYP = eINSTANCE.getModel_Outtyp();

        /**
         * The meta object literal for the '<em><b>Evtin</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__EVTIN = eINSTANCE.getModel_Evtin();

        /**
         * The meta object literal for the '<em><b>Evtout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__EVTOUT = eINSTANCE.getModel_Evtout();

        /**
         * The meta object literal for the '<em><b>State</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__STATE = eINSTANCE.getModel_State();

        /**
         * The meta object literal for the '<em><b>Dstate</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__DSTATE = eINSTANCE.getModel_Dstate();

        /**
         * The meta object literal for the '<em><b>Odstate</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__ODSTATE = eINSTANCE.getModel_Odstate();

        /**
         * The meta object literal for the '<em><b>Rpar</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__RPAR = eINSTANCE.getModel_Rpar();

        /**
         * The meta object literal for the '<em><b>Ipar</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__IPAR = eINSTANCE.getModel_Ipar();

        /**
         * The meta object literal for the '<em><b>Opar</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__OPAR = eINSTANCE.getModel_Opar();

        /**
         * The meta object literal for the '<em><b>Blocktype</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__BLOCKTYPE = eINSTANCE.getModel_Blocktype();

        /**
         * The meta object literal for the '<em><b>Firing</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__FIRING = eINSTANCE.getModel_Firing();

        /**
         * The meta object literal for the '<em><b>Dep ut</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__DEP_UT = eINSTANCE.getModel_Dep_ut();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__LABEL = eINSTANCE.getModel_Label();

        /**
         * The meta object literal for the '<em><b>Nzcross</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__NZCROSS = eINSTANCE.getModel_Nzcross();

        /**
         * The meta object literal for the '<em><b>Nmode</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__NMODE = eINSTANCE.getModel_Nmode();

        /**
         * The meta object literal for the '<em><b>Equation</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODEL__EQUATION = eINSTANCE.getModel_Equation();

        /**
         * The meta object literal for the '{@link org.scilab.modules.xcos.modeling.system.impl.LinkImpl <em>Link</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.xcos.modeling.system.impl.LinkImpl
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getLink()
         * @generated
         */
        EClass LINK = eINSTANCE.getLink();

        /**
         * The meta object literal for the '<em><b>Xx</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINK__XX = eINSTANCE.getLink_Xx();

        /**
         * The meta object literal for the '<em><b>Yy</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINK__YY = eINSTANCE.getLink_Yy();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINK__ID = eINSTANCE.getLink_Id();

        /**
         * The meta object literal for the '<em><b>Tick</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINK__TICK = eINSTANCE.getLink_Tick();

        /**
         * The meta object literal for the '<em><b>Ct</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINK__CT = eINSTANCE.getLink_Ct();

        /**
         * The meta object literal for the '<em><b>From</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINK__FROM = eINSTANCE.getLink_From();

        /**
         * The meta object literal for the '<em><b>To</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINK__TO = eINSTANCE.getLink_To();

        /**
         * The meta object literal for the '<em>Scilab Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.types.ScilabType
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScilabType()
         * @generated
         */
        EDataType SCILAB_TYPE = eINSTANCE.getScilabType();

        /**
         * The meta object literal for the '<em>Scilab Double</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.types.ScilabDouble
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScilabDouble()
         * @generated
         */
        EDataType SCILAB_DOUBLE = eINSTANCE.getScilabDouble();

        /**
         * The meta object literal for the '<em>Scilab Integer</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.types.ScilabInteger
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScilabInteger()
         * @generated
         */
        EDataType SCILAB_INTEGER = eINSTANCE.getScilabInteger();

        /**
         * The meta object literal for the '<em>Scilab Boolean</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.types.ScilabBoolean
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScilabBoolean()
         * @generated
         */
        EDataType SCILAB_BOOLEAN = eINSTANCE.getScilabBoolean();

        /**
         * The meta object literal for the '<em>Scilab String</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.scilab.modules.types.ScilabString
         * @see org.scilab.modules.xcos.modeling.system.impl.SystemPackageImpl#getScilabString()
         * @generated
         */
        EDataType SCILAB_STRING = eINSTANCE.getScilabString();

    }

} //SystemPackage

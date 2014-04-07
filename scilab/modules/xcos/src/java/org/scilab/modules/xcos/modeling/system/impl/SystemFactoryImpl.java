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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.scilab.modules.xcos.modeling.system.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemFactoryImpl extends EFactoryImpl implements SystemFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static SystemFactory init() {
        try {
            SystemFactory theSystemFactory = (SystemFactory)EPackage.Registry.INSTANCE.getEFactory(SystemPackage.eNS_URI);
            if (theSystemFactory != null) {
                return theSystemFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SystemFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case SystemPackage.DIAGRAM:
                return createDiagram();
            case SystemPackage.PARAMS:
                return createParams();
            case SystemPackage.SCSOPT:
                return createScsopt();
            case SystemPackage.BLOCK:
                return createBlock();
            case SystemPackage.GRAPHICS:
                return createGraphics();
            case SystemPackage.MODEL:
                return createModel();
            case SystemPackage.LINK:
                return createLink();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case SystemPackage.SCILAB_TYPE:
                return createScilabTypeFromString(eDataType, initialValue);
            case SystemPackage.SCILAB_DOUBLE:
                return createScilabDoubleFromString(eDataType, initialValue);
            case SystemPackage.SCILAB_INTEGER:
                return createScilabIntegerFromString(eDataType, initialValue);
            case SystemPackage.SCILAB_BOOLEAN:
                return createScilabBooleanFromString(eDataType, initialValue);
            case SystemPackage.SCILAB_STRING:
                return createScilabStringFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case SystemPackage.SCILAB_TYPE:
                return convertScilabTypeToString(eDataType, instanceValue);
            case SystemPackage.SCILAB_DOUBLE:
                return convertScilabDoubleToString(eDataType, instanceValue);
            case SystemPackage.SCILAB_INTEGER:
                return convertScilabIntegerToString(eDataType, instanceValue);
            case SystemPackage.SCILAB_BOOLEAN:
                return convertScilabBooleanToString(eDataType, instanceValue);
            case SystemPackage.SCILAB_STRING:
                return convertScilabStringToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Diagram createDiagram() {
        DiagramImpl diagram = new DiagramImpl();
        return diagram;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Params createParams() {
        ParamsImpl params = new ParamsImpl();
        return params;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Scsopt createScsopt() {
        ScsoptImpl scsopt = new ScsoptImpl();
        return scsopt;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Block createBlock() {
        BlockImpl block = new BlockImpl();
        return block;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Graphics createGraphics() {
        GraphicsImpl graphics = new GraphicsImpl();
        return graphics;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Model createModel() {
        ModelImpl model = new ModelImpl();
        return model;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Link createLink() {
        LinkImpl link = new LinkImpl();
        return link;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType createScilabTypeFromString(EDataType eDataType, String initialValue) {
        return (org.scilab.modules.types.ScilabType)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertScilabTypeToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble createScilabDoubleFromString(EDataType eDataType, String initialValue) {
        return (org.scilab.modules.types.ScilabDouble)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertScilabDoubleToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger createScilabIntegerFromString(EDataType eDataType, String initialValue) {
        return (org.scilab.modules.types.ScilabInteger)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertScilabIntegerToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabBoolean createScilabBooleanFromString(EDataType eDataType, String initialValue) {
        return (org.scilab.modules.types.ScilabBoolean)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertScilabBooleanToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabString createScilabStringFromString(EDataType eDataType, String initialValue) {
        return (org.scilab.modules.types.ScilabString)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertScilabStringToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemPackage getSystemPackage() {
        return (SystemPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SystemPackage getPackage() {
        return SystemPackage.eINSTANCE;
    }

} //SystemFactoryImpl

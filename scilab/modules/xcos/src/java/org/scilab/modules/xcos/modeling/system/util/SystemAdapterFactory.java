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
package org.scilab.modules.xcos.modeling.system.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.scilab.modules.xcos.modeling.system.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.scilab.modules.xcos.modeling.system.SystemPackage
 * @generated
 */
public class SystemAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static SystemPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = SystemPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SystemSwitch<Adapter> modelSwitch =
    new SystemSwitch<Adapter>() {
        @Override
        public Adapter caseDiagram(Diagram object) {
            return createDiagramAdapter();
        }
        @Override
        public Adapter caseParams(Params object) {
            return createParamsAdapter();
        }
        @Override
        public Adapter caseScsopt(Scsopt object) {
            return createScsoptAdapter();
        }
        @Override
        public Adapter caseBlock(Block object) {
            return createBlockAdapter();
        }
        @Override
        public Adapter caseGraphics(Graphics object) {
            return createGraphicsAdapter();
        }
        @Override
        public Adapter caseModel(Model object) {
            return createModelAdapter();
        }
        @Override
        public Adapter caseLink(Link object) {
            return createLinkAdapter();
        }
        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.scilab.modules.xcos.modeling.system.Diagram <em>Diagram</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.scilab.modules.xcos.modeling.system.Diagram
     * @generated
     */
    public Adapter createDiagramAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.scilab.modules.xcos.modeling.system.Params <em>Params</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.scilab.modules.xcos.modeling.system.Params
     * @generated
     */
    public Adapter createParamsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.scilab.modules.xcos.modeling.system.Scsopt <em>Scsopt</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.scilab.modules.xcos.modeling.system.Scsopt
     * @generated
     */
    public Adapter createScsoptAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.scilab.modules.xcos.modeling.system.Block <em>Block</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.scilab.modules.xcos.modeling.system.Block
     * @generated
     */
    public Adapter createBlockAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.scilab.modules.xcos.modeling.system.Graphics <em>Graphics</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.scilab.modules.xcos.modeling.system.Graphics
     * @generated
     */
    public Adapter createGraphicsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.scilab.modules.xcos.modeling.system.Model <em>Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.scilab.modules.xcos.modeling.system.Model
     * @generated
     */
    public Adapter createModelAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.scilab.modules.xcos.modeling.system.Link <em>Link</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.scilab.modules.xcos.modeling.system.Link
     * @generated
     */
    public Adapter createLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //SystemAdapterFactory

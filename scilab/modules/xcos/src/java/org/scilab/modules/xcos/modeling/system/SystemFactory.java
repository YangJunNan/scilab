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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.scilab.modules.xcos.modeling.system.SystemPackage
 * @generated
 */
public interface SystemFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SystemFactory eINSTANCE = org.scilab.modules.xcos.modeling.system.impl.SystemFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Diagram</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Diagram</em>'.
     * @generated
     */
    Diagram createDiagram();

    /**
     * Returns a new object of class '<em>Params</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Params</em>'.
     * @generated
     */
    Params createParams();

    /**
     * Returns a new object of class '<em>Scsopt</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Scsopt</em>'.
     * @generated
     */
    Scsopt createScsopt();

    /**
     * Returns a new object of class '<em>Block</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Block</em>'.
     * @generated
     */
    Block createBlock();

    /**
     * Returns a new object of class '<em>Graphics</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Graphics</em>'.
     * @generated
     */
    Graphics createGraphics();

    /**
     * Returns a new object of class '<em>Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Model</em>'.
     * @generated
     */
    Model createModel();

    /**
     * Returns a new object of class '<em>Link</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Link</em>'.
     * @generated
     */
    Link createLink();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    SystemPackage getSystemPackage();

} //SystemFactory

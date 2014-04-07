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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Diagram#getVersion <em>Version</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Diagram#getProps <em>Props</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends EObject {
    /**
     * Returns the value of the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' attribute.
     * @see #setVersion(String)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getDiagram_Version()
     * @model
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Diagram#getVersion <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Props</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Props</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Props</em>' reference.
     * @see #setProps(Params)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getDiagram_Props()
     * @model
     * @generated
     */
    Params getProps();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Diagram#getProps <em>Props</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Props</em>' reference.
     * @see #getProps()
     * @generated
     */
    void setProps(Params value);

} // Diagram

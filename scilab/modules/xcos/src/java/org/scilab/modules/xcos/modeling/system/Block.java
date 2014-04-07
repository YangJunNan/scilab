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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.scilab.modules.types.ScilabType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Block#getGui <em>Gui</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Block#getGraphics <em>Graphics</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Block#getModel <em>Model</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Block#getDocList <em>Doc</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends EObject {
    /**
     * Returns the value of the '<em><b>Gui</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gui</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Gui</em>' attribute.
     * @see #setGui(String)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getBlock_Gui()
     * @model
     * @generated
     */
    String getGui();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Block#getGui <em>Gui</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Gui</em>' attribute.
     * @see #getGui()
     * @generated
     */
    void setGui(String value);

    /**
     * Returns the value of the '<em><b>Graphics</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Graphics</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Graphics</em>' reference.
     * @see #setGraphics(Graphics)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getBlock_Graphics()
     * @model
     * @generated
     */
    Graphics getGraphics();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Block#getGraphics <em>Graphics</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Graphics</em>' reference.
     * @see #getGraphics()
     * @generated
     */
    void setGraphics(Graphics value);

    /**
     * Returns the value of the '<em><b>Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Model</em>' reference.
     * @see #setModel(Model)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getBlock_Model()
     * @model
     * @generated
     */
    Model getModel();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Block#getModel <em>Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Model</em>' reference.
     * @see #getModel()
     * @generated
     */
    void setModel(Model value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ScilabType[] getDoc();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ScilabType getDoc(int index);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    int getDocLength();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setDoc(ScilabType[] newDoc);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setDoc(int index, ScilabType element);

    /**
     * Returns the value of the '<em><b>Doc</b></em>' attribute list.
     * The list contents are of type {@link org.scilab.modules.types.ScilabType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Doc</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Doc</em>' attribute list.
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getBlock_Doc()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabType"
     * @generated
     */
    EList<ScilabType> getDocList();

} // Block

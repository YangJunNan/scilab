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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scsopt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Scsopt#get_3DList <em>3D</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Scsopt#getBackground <em>Background</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Scsopt#getLink <em>Link</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Scsopt#getIDList <em>ID</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Scsopt#getCMap <em>CMap</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getScsopt()
 * @model
 * @generated
 */
public interface Scsopt extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType[] get_3D();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType get_3D(int index);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    int get_3DLength();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void set_3D(org.scilab.modules.types.ScilabType[] new_3D);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void set_3D(int index, org.scilab.modules.types.ScilabType element);

    /**
     * Returns the value of the '<em><b>3D</b></em>' attribute list.
     * The list contents are of type {@link org.scilab.modules.types.ScilabType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>3D</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>3D</em>' attribute list.
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getScsopt__3D()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabType"
     * @generated
     */
    EList<org.scilab.modules.types.ScilabType> get_3DList();

    /**
     * Returns the value of the '<em><b>Background</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Background</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Background</em>' attribute.
     * @see #setBackground(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getScsopt_Background()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getBackground();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Scsopt#getBackground <em>Background</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Background</em>' attribute.
     * @see #getBackground()
     * @generated
     */
    void setBackground(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Link</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Link</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Link</em>' attribute.
     * @see #setLink(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getScsopt_Link()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getLink();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Scsopt#getLink <em>Link</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Link</em>' attribute.
     * @see #getLink()
     * @generated
     */
    void setLink(org.scilab.modules.types.ScilabDouble value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabDouble[] getID();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getID(int index);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    int getIDLength();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setID(org.scilab.modules.types.ScilabDouble[] newID);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setID(int index, org.scilab.modules.types.ScilabDouble element);

    /**
     * Returns the value of the '<em><b>ID</b></em>' attribute list.
     * The list contents are of type {@link org.scilab.modules.types.ScilabDouble}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>ID</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>ID</em>' attribute list.
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getScsopt_ID()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    EList<org.scilab.modules.types.ScilabDouble> getIDList();

    /**
     * Returns the value of the '<em><b>CMap</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CMap</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>CMap</em>' attribute.
     * @see #setCMap(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getScsopt_CMap()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getCMap();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Scsopt#getCMap <em>CMap</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>CMap</em>' attribute.
     * @see #getCMap()
     * @generated
     */
    void setCMap(org.scilab.modules.types.ScilabDouble value);

} // Scsopt

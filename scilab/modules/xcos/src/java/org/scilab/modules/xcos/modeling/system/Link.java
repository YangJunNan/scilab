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
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Link#getXx <em>Xx</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Link#getYy <em>Yy</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Link#getId <em>Id</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Link#getTick <em>Tick</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Link#getCt <em>Ct</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Link#getFrom <em>From</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Link#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends EObject {
    /**
     * Returns the value of the '<em><b>Xx</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Xx</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Xx</em>' attribute.
     * @see #setXx(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getLink_Xx()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getXx();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Link#getXx <em>Xx</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Xx</em>' attribute.
     * @see #getXx()
     * @generated
     */
    void setXx(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Yy</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Yy</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Yy</em>' attribute.
     * @see #setYy(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getLink_Yy()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getYy();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Link#getYy <em>Yy</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Yy</em>' attribute.
     * @see #getYy()
     * @generated
     */
    void setYy(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getLink_Id()
     * @model
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Link#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Tick</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tick</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tick</em>' attribute.
     * @see #setTick(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getLink_Tick()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getTick();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Link#getTick <em>Tick</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tick</em>' attribute.
     * @see #getTick()
     * @generated
     */
    void setTick(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Ct</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ct</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ct</em>' attribute.
     * @see #setCt(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getLink_Ct()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getCt();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Link#getCt <em>Ct</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ct</em>' attribute.
     * @see #getCt()
     * @generated
     */
    void setCt(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>From</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>From</em>' attribute.
     * @see #setFrom(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getLink_From()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getFrom();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Link#getFrom <em>From</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>From</em>' attribute.
     * @see #getFrom()
     * @generated
     */
    void setFrom(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>To</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' attribute.
     * @see #setTo(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getLink_To()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getTo();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Link#getTo <em>To</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' attribute.
     * @see #getTo()
     * @generated
     */
    void setTo(org.scilab.modules.types.ScilabDouble value);

} // Link

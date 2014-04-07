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
 * A representation of the model object '<em><b>Params</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Params#getWpar <em>Wpar</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Params#getTitle <em>Title</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Params#getTol <em>Tol</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Params#getTf <em>Tf</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Params#getContext <em>Context</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Params#getVoid1 <em>Void1</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Params#getOptions <em>Options</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Params#getVoid2 <em>Void2</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Params#getVoid3 <em>Void3</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Params#getDocList <em>Doc</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams()
 * @model
 * @generated
 */
public interface Params extends EObject {
    /**
     * Returns the value of the '<em><b>Wpar</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wpar</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wpar</em>' attribute.
     * @see #setWpar(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams_Wpar()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getWpar();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Params#getWpar <em>Wpar</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wpar</em>' attribute.
     * @see #getWpar()
     * @generated
     */
    void setWpar(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Title</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Title</em>' attribute.
     * @see #setTitle(org.scilab.modules.types.ScilabString)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams_Title()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabString"
     * @generated
     */
    org.scilab.modules.types.ScilabString getTitle();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Params#getTitle <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Title</em>' attribute.
     * @see #getTitle()
     * @generated
     */
    void setTitle(org.scilab.modules.types.ScilabString value);

    /**
     * Returns the value of the '<em><b>Tol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tol</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tol</em>' attribute.
     * @see #setTol(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams_Tol()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getTol();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Params#getTol <em>Tol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tol</em>' attribute.
     * @see #getTol()
     * @generated
     */
    void setTol(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Tf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tf</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tf</em>' attribute.
     * @see #setTf(double)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams_Tf()
     * @model
     * @generated
     */
    double getTf();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Params#getTf <em>Tf</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tf</em>' attribute.
     * @see #getTf()
     * @generated
     */
    void setTf(double value);

    /**
     * Returns the value of the '<em><b>Context</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context</em>' attribute.
     * @see #setContext(org.scilab.modules.types.ScilabString)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams_Context()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabString"
     * @generated
     */
    org.scilab.modules.types.ScilabString getContext();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Params#getContext <em>Context</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context</em>' attribute.
     * @see #getContext()
     * @generated
     */
    void setContext(org.scilab.modules.types.ScilabString value);

    /**
     * Returns the value of the '<em><b>Void1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Void1</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Void1</em>' attribute.
     * @see #setVoid1(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams_Void1()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getVoid1();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Params#getVoid1 <em>Void1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Void1</em>' attribute.
     * @see #getVoid1()
     * @generated
     */
    void setVoid1(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Options</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Options</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Options</em>' reference.
     * @see #setOptions(Scsopt)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams_Options()
     * @model
     * @generated
     */
    Scsopt getOptions();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Params#getOptions <em>Options</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Options</em>' reference.
     * @see #getOptions()
     * @generated
     */
    void setOptions(Scsopt value);

    /**
     * Returns the value of the '<em><b>Void2</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Void2</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Void2</em>' attribute.
     * @see #setVoid2(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams_Void2()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getVoid2();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Params#getVoid2 <em>Void2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Void2</em>' attribute.
     * @see #getVoid2()
     * @generated
     */
    void setVoid2(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Void3</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Void3</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Void3</em>' attribute.
     * @see #setVoid3(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams_Void3()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getVoid3();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Params#getVoid3 <em>Void3</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Void3</em>' attribute.
     * @see #getVoid3()
     * @generated
     */
    void setVoid3(org.scilab.modules.types.ScilabDouble value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType[] getDoc();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType getDoc(int index);

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
    void setDoc(org.scilab.modules.types.ScilabType[] newDoc);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setDoc(int index, org.scilab.modules.types.ScilabType element);

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
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getParams_Doc()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabType"
     * @generated
     */
    EList<org.scilab.modules.types.ScilabType> getDocList();

} // Params

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
 * A representation of the model object '<em><b>Graphics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getOrig <em>Orig</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getSz <em>Sz</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#isFlip <em>Flip</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getTheta <em>Theta</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getExprs <em>Exprs</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getPin <em>Pin</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getPout <em>Pout</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getPein <em>Pein</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getPeout <em>Peout</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getGr_iList <em>Gr i</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getId <em>Id</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getIn_implicit <em>In implicit</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Graphics#getOut_implicit <em>Out implicit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics()
 * @model
 * @generated
 */
public interface Graphics extends EObject {
    /**
     * Returns the value of the '<em><b>Orig</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Orig</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Orig</em>' attribute.
     * @see #setOrig(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Orig()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getOrig();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getOrig <em>Orig</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Orig</em>' attribute.
     * @see #getOrig()
     * @generated
     */
    void setOrig(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Sz</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sz</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sz</em>' attribute.
     * @see #setSz(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Sz()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getSz();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getSz <em>Sz</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sz</em>' attribute.
     * @see #getSz()
     * @generated
     */
    void setSz(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Flip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Flip</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Flip</em>' attribute.
     * @see #setFlip(boolean)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Flip()
     * @model
     * @generated
     */
    boolean isFlip();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#isFlip <em>Flip</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Flip</em>' attribute.
     * @see #isFlip()
     * @generated
     */
    void setFlip(boolean value);

    /**
     * Returns the value of the '<em><b>Theta</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Theta</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Theta</em>' attribute.
     * @see #setTheta(double)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Theta()
     * @model
     * @generated
     */
    double getTheta();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getTheta <em>Theta</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Theta</em>' attribute.
     * @see #getTheta()
     * @generated
     */
    void setTheta(double value);

    /**
     * Returns the value of the '<em><b>Exprs</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exprs</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exprs</em>' attribute.
     * @see #setExprs(org.scilab.modules.types.ScilabString)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Exprs()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabString"
     * @generated
     */
    org.scilab.modules.types.ScilabString getExprs();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getExprs <em>Exprs</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exprs</em>' attribute.
     * @see #getExprs()
     * @generated
     */
    void setExprs(org.scilab.modules.types.ScilabString value);

    /**
     * Returns the value of the '<em><b>Pin</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pin</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pin</em>' attribute.
     * @see #setPin(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Pin()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getPin();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getPin <em>Pin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pin</em>' attribute.
     * @see #getPin()
     * @generated
     */
    void setPin(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Pout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pout</em>' attribute.
     * @see #setPout(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Pout()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getPout();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getPout <em>Pout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pout</em>' attribute.
     * @see #getPout()
     * @generated
     */
    void setPout(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Pein</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pein</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pein</em>' attribute.
     * @see #setPein(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Pein()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getPein();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getPein <em>Pein</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pein</em>' attribute.
     * @see #getPein()
     * @generated
     */
    void setPein(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Peout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Peout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Peout</em>' attribute.
     * @see #setPeout(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Peout()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getPeout();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getPeout <em>Peout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Peout</em>' attribute.
     * @see #getPeout()
     * @generated
     */
    void setPeout(org.scilab.modules.types.ScilabDouble value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType[] getGr_i();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType getGr_i(int index);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    int getGr_iLength();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setGr_i(org.scilab.modules.types.ScilabType[] newGr_i);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setGr_i(int index, org.scilab.modules.types.ScilabType element);

    /**
     * Returns the value of the '<em><b>Gr i</b></em>' attribute list.
     * The list contents are of type {@link org.scilab.modules.types.ScilabType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gr i</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Gr i</em>' attribute list.
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Gr_i()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabType"
     * @generated
     */
    EList<org.scilab.modules.types.ScilabType> getGr_iList();

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
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Id()
     * @model
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>In implicit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In implicit</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>In implicit</em>' attribute.
     * @see #setIn_implicit(org.scilab.modules.types.ScilabString)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_In_implicit()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabString"
     * @generated
     */
    org.scilab.modules.types.ScilabString getIn_implicit();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getIn_implicit <em>In implicit</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>In implicit</em>' attribute.
     * @see #getIn_implicit()
     * @generated
     */
    void setIn_implicit(org.scilab.modules.types.ScilabString value);

    /**
     * Returns the value of the '<em><b>Out implicit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Out implicit</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Out implicit</em>' attribute.
     * @see #setOut_implicit(org.scilab.modules.types.ScilabString)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getGraphics_Out_implicit()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabString"
     * @generated
     */
    org.scilab.modules.types.ScilabString getOut_implicit();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Graphics#getOut_implicit <em>Out implicit</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Out implicit</em>' attribute.
     * @see #getOut_implicit()
     * @generated
     */
    void setOut_implicit(org.scilab.modules.types.ScilabString value);

} // Graphics

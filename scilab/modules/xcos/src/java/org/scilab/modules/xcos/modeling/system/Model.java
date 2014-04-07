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
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getSimList <em>Sim</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getIn <em>In</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getIn2 <em>In2</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getIntyp <em>Intyp</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getOut <em>Out</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getOut2 <em>Out2</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getOuttyp <em>Outtyp</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getEvtin <em>Evtin</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getEvtout <em>Evtout</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getState <em>State</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getDstate <em>Dstate</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getOdstateList <em>Odstate</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getRpar <em>Rpar</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getIpar <em>Ipar</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getOparList <em>Opar</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getBlocktype <em>Blocktype</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getFiring <em>Firing</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getDep_ut <em>Dep ut</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getLabel <em>Label</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getNzcross <em>Nzcross</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getNmode <em>Nmode</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.Model#getEquationList <em>Equation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType[] getSim();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType getSim(int index);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    int getSimLength();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setSim(org.scilab.modules.types.ScilabType[] newSim);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setSim(int index, org.scilab.modules.types.ScilabType element);

    /**
     * Returns the value of the '<em><b>Sim</b></em>' attribute list.
     * The list contents are of type {@link org.scilab.modules.types.ScilabType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sim</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sim</em>' attribute list.
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Sim()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabType" upper="2"
     * @generated
     */
    EList<org.scilab.modules.types.ScilabType> getSimList();

    /**
     * Returns the value of the '<em><b>In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>In</em>' attribute.
     * @see #setIn(org.scilab.modules.types.ScilabInteger)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_In()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabInteger"
     * @generated
     */
    org.scilab.modules.types.ScilabInteger getIn();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getIn <em>In</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>In</em>' attribute.
     * @see #getIn()
     * @generated
     */
    void setIn(org.scilab.modules.types.ScilabInteger value);

    /**
     * Returns the value of the '<em><b>In2</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In2</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>In2</em>' attribute.
     * @see #setIn2(org.scilab.modules.types.ScilabInteger)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_In2()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabInteger"
     * @generated
     */
    org.scilab.modules.types.ScilabInteger getIn2();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getIn2 <em>In2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>In2</em>' attribute.
     * @see #getIn2()
     * @generated
     */
    void setIn2(org.scilab.modules.types.ScilabInteger value);

    /**
     * Returns the value of the '<em><b>Intyp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Intyp</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Intyp</em>' attribute.
     * @see #setIntyp(org.scilab.modules.types.ScilabInteger)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Intyp()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabInteger"
     * @generated
     */
    org.scilab.modules.types.ScilabInteger getIntyp();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getIntyp <em>Intyp</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Intyp</em>' attribute.
     * @see #getIntyp()
     * @generated
     */
    void setIntyp(org.scilab.modules.types.ScilabInteger value);

    /**
     * Returns the value of the '<em><b>Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Out</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Out</em>' attribute.
     * @see #setOut(org.scilab.modules.types.ScilabInteger)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Out()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabInteger"
     * @generated
     */
    org.scilab.modules.types.ScilabInteger getOut();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getOut <em>Out</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Out</em>' attribute.
     * @see #getOut()
     * @generated
     */
    void setOut(org.scilab.modules.types.ScilabInteger value);

    /**
     * Returns the value of the '<em><b>Out2</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Out2</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Out2</em>' attribute.
     * @see #setOut2(org.scilab.modules.types.ScilabInteger)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Out2()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabInteger"
     * @generated
     */
    org.scilab.modules.types.ScilabInteger getOut2();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getOut2 <em>Out2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Out2</em>' attribute.
     * @see #getOut2()
     * @generated
     */
    void setOut2(org.scilab.modules.types.ScilabInteger value);

    /**
     * Returns the value of the '<em><b>Outtyp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outtyp</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outtyp</em>' attribute.
     * @see #setOuttyp(org.scilab.modules.types.ScilabInteger)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Outtyp()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabInteger"
     * @generated
     */
    org.scilab.modules.types.ScilabInteger getOuttyp();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getOuttyp <em>Outtyp</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Outtyp</em>' attribute.
     * @see #getOuttyp()
     * @generated
     */
    void setOuttyp(org.scilab.modules.types.ScilabInteger value);

    /**
     * Returns the value of the '<em><b>Evtin</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Evtin</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Evtin</em>' attribute.
     * @see #setEvtin(org.scilab.modules.types.ScilabInteger)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Evtin()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabInteger"
     * @generated
     */
    org.scilab.modules.types.ScilabInteger getEvtin();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getEvtin <em>Evtin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Evtin</em>' attribute.
     * @see #getEvtin()
     * @generated
     */
    void setEvtin(org.scilab.modules.types.ScilabInteger value);

    /**
     * Returns the value of the '<em><b>Evtout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Evtout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Evtout</em>' attribute.
     * @see #setEvtout(org.scilab.modules.types.ScilabInteger)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Evtout()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabInteger"
     * @generated
     */
    org.scilab.modules.types.ScilabInteger getEvtout();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getEvtout <em>Evtout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Evtout</em>' attribute.
     * @see #getEvtout()
     * @generated
     */
    void setEvtout(org.scilab.modules.types.ScilabInteger value);

    /**
     * Returns the value of the '<em><b>State</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>State</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>State</em>' attribute.
     * @see #setState(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_State()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getState();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getState <em>State</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>State</em>' attribute.
     * @see #getState()
     * @generated
     */
    void setState(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Dstate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dstate</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dstate</em>' attribute.
     * @see #setDstate(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Dstate()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getDstate();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getDstate <em>Dstate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dstate</em>' attribute.
     * @see #getDstate()
     * @generated
     */
    void setDstate(org.scilab.modules.types.ScilabDouble value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType[] getOdstate();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType getOdstate(int index);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    int getOdstateLength();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setOdstate(org.scilab.modules.types.ScilabType[] newOdstate);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setOdstate(int index, org.scilab.modules.types.ScilabType element);

    /**
     * Returns the value of the '<em><b>Odstate</b></em>' attribute list.
     * The list contents are of type {@link org.scilab.modules.types.ScilabType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Odstate</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Odstate</em>' attribute list.
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Odstate()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabType"
     * @generated
     */
    EList<org.scilab.modules.types.ScilabType> getOdstateList();

    /**
     * Returns the value of the '<em><b>Rpar</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rpar</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rpar</em>' attribute.
     * @see #setRpar(org.scilab.modules.types.ScilabDouble)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Rpar()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabDouble"
     * @generated
     */
    org.scilab.modules.types.ScilabDouble getRpar();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getRpar <em>Rpar</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rpar</em>' attribute.
     * @see #getRpar()
     * @generated
     */
    void setRpar(org.scilab.modules.types.ScilabDouble value);

    /**
     * Returns the value of the '<em><b>Ipar</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ipar</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ipar</em>' attribute.
     * @see #setIpar(org.scilab.modules.types.ScilabInteger)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Ipar()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabInteger"
     * @generated
     */
    org.scilab.modules.types.ScilabInteger getIpar();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getIpar <em>Ipar</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ipar</em>' attribute.
     * @see #getIpar()
     * @generated
     */
    void setIpar(org.scilab.modules.types.ScilabInteger value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType[] getOpar();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType getOpar(int index);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    int getOparLength();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setOpar(org.scilab.modules.types.ScilabType[] newOpar);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setOpar(int index, org.scilab.modules.types.ScilabType element);

    /**
     * Returns the value of the '<em><b>Opar</b></em>' attribute list.
     * The list contents are of type {@link org.scilab.modules.types.ScilabType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Opar</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Opar</em>' attribute list.
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Opar()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabType"
     * @generated
     */
    EList<org.scilab.modules.types.ScilabType> getOparList();

    /**
     * Returns the value of the '<em><b>Blocktype</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Blocktype</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Blocktype</em>' attribute.
     * @see #setBlocktype(String)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Blocktype()
     * @model
     * @generated
     */
    String getBlocktype();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getBlocktype <em>Blocktype</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Blocktype</em>' attribute.
     * @see #getBlocktype()
     * @generated
     */
    void setBlocktype(String value);

    /**
     * Returns the value of the '<em><b>Firing</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Firing</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Firing</em>' attribute.
     * @see #setFiring(org.scilab.modules.types.ScilabInteger)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Firing()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabInteger"
     * @generated
     */
    org.scilab.modules.types.ScilabInteger getFiring();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getFiring <em>Firing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Firing</em>' attribute.
     * @see #getFiring()
     * @generated
     */
    void setFiring(org.scilab.modules.types.ScilabInteger value);

    /**
     * Returns the value of the '<em><b>Dep ut</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dep ut</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dep ut</em>' attribute.
     * @see #setDep_ut(org.scilab.modules.types.ScilabBoolean)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Dep_ut()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabBoolean"
     * @generated
     */
    org.scilab.modules.types.ScilabBoolean getDep_ut();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getDep_ut <em>Dep ut</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dep ut</em>' attribute.
     * @see #getDep_ut()
     * @generated
     */
    void setDep_ut(org.scilab.modules.types.ScilabBoolean value);

    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Label()
     * @model
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

    /**
     * Returns the value of the '<em><b>Nzcross</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nzcross</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nzcross</em>' attribute.
     * @see #setNzcross(int)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Nzcross()
     * @model
     * @generated
     */
    int getNzcross();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getNzcross <em>Nzcross</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Nzcross</em>' attribute.
     * @see #getNzcross()
     * @generated
     */
    void setNzcross(int value);

    /**
     * Returns the value of the '<em><b>Nmode</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nmode</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nmode</em>' attribute.
     * @see #setNmode(int)
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Nmode()
     * @model
     * @generated
     */
    int getNmode();

    /**
     * Sets the value of the '{@link org.scilab.modules.xcos.modeling.system.Model#getNmode <em>Nmode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Nmode</em>' attribute.
     * @see #getNmode()
     * @generated
     */
    void setNmode(int value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType[] getEquation();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    org.scilab.modules.types.ScilabType getEquation(int index);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    int getEquationLength();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setEquation(org.scilab.modules.types.ScilabType[] newEquation);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    void setEquation(int index, org.scilab.modules.types.ScilabType element);

    /**
     * Returns the value of the '<em><b>Equation</b></em>' attribute list.
     * The list contents are of type {@link org.scilab.modules.types.ScilabType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Equation</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Equation</em>' attribute list.
     * @see org.scilab.modules.xcos.modeling.system.SystemPackage#getModel_Equation()
     * @model dataType="org.scilab.modules.xcos.modeling.system.ScilabType"
     * @generated
     */
    EList<org.scilab.modules.types.ScilabType> getEquationList();

} // Model

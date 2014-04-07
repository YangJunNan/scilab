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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.scilab.modules.xcos.modeling.system.Model;
import org.scilab.modules.xcos.modeling.system.SystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getSimList <em>Sim</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getIn <em>In</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getIn2 <em>In2</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getIntyp <em>Intyp</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getOut <em>Out</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getOut2 <em>Out2</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getOuttyp <em>Outtyp</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getEvtin <em>Evtin</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getEvtout <em>Evtout</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getState <em>State</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getDstate <em>Dstate</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getOdstateList <em>Odstate</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getRpar <em>Rpar</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getIpar <em>Ipar</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getOparList <em>Opar</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getBlocktype <em>Blocktype</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getFiring <em>Firing</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getDep_ut <em>Dep ut</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getNzcross <em>Nzcross</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getNmode <em>Nmode</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ModelImpl#getEquationList <em>Equation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model {
    /**
     * The cached value of the '{@link #getSimList() <em>Sim</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSimList()
     * @generated
     * @ordered
     */
    protected EList<org.scilab.modules.types.ScilabType> sim;

    /**
     * The empty value for the '{@link #getSim() <em>Sim</em>}' array accessor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSim()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabType[] SIM_EEMPTY_ARRAY = new org.scilab.modules.types.ScilabType [0];

    /**
     * The default value of the '{@link #getIn() <em>In</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIn()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabInteger IN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIn() <em>In</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIn()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabInteger in = IN_EDEFAULT;

    /**
     * The default value of the '{@link #getIn2() <em>In2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIn2()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabInteger IN2_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIn2() <em>In2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIn2()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabInteger in2 = IN2_EDEFAULT;

    /**
     * The default value of the '{@link #getIntyp() <em>Intyp</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIntyp()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabInteger INTYP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIntyp() <em>Intyp</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIntyp()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabInteger intyp = INTYP_EDEFAULT;

    /**
     * The default value of the '{@link #getOut() <em>Out</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOut()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabInteger OUT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOut() <em>Out</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOut()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabInteger out = OUT_EDEFAULT;

    /**
     * The default value of the '{@link #getOut2() <em>Out2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOut2()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabInteger OUT2_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOut2() <em>Out2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOut2()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabInteger out2 = OUT2_EDEFAULT;

    /**
     * The default value of the '{@link #getOuttyp() <em>Outtyp</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOuttyp()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabInteger OUTTYP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOuttyp() <em>Outtyp</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOuttyp()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabInteger outtyp = OUTTYP_EDEFAULT;

    /**
     * The default value of the '{@link #getEvtin() <em>Evtin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEvtin()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabInteger EVTIN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEvtin() <em>Evtin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEvtin()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabInteger evtin = EVTIN_EDEFAULT;

    /**
     * The default value of the '{@link #getEvtout() <em>Evtout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEvtout()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabInteger EVTOUT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEvtout() <em>Evtout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEvtout()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabInteger evtout = EVTOUT_EDEFAULT;

    /**
     * The default value of the '{@link #getState() <em>State</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getState()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble STATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getState() <em>State</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getState()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble state = STATE_EDEFAULT;

    /**
     * The default value of the '{@link #getDstate() <em>Dstate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDstate()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble DSTATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDstate() <em>Dstate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDstate()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble dstate = DSTATE_EDEFAULT;

    /**
     * The cached value of the '{@link #getOdstateList() <em>Odstate</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOdstateList()
     * @generated
     * @ordered
     */
    protected EList<org.scilab.modules.types.ScilabType> odstate;

    /**
     * The empty value for the '{@link #getOdstate() <em>Odstate</em>}' array accessor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOdstate()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabType[] ODSTATE_EEMPTY_ARRAY = new org.scilab.modules.types.ScilabType [0];

    /**
     * The default value of the '{@link #getRpar() <em>Rpar</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRpar()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble RPAR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRpar() <em>Rpar</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRpar()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble rpar = RPAR_EDEFAULT;

    /**
     * The default value of the '{@link #getIpar() <em>Ipar</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIpar()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabInteger IPAR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIpar() <em>Ipar</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIpar()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabInteger ipar = IPAR_EDEFAULT;

    /**
     * The cached value of the '{@link #getOparList() <em>Opar</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOparList()
     * @generated
     * @ordered
     */
    protected EList<org.scilab.modules.types.ScilabType> opar;

    /**
     * The empty value for the '{@link #getOpar() <em>Opar</em>}' array accessor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOpar()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabType[] OPAR_EEMPTY_ARRAY = new org.scilab.modules.types.ScilabType [0];

    /**
     * The default value of the '{@link #getBlocktype() <em>Blocktype</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlocktype()
     * @generated
     * @ordered
     */
    protected static final String BLOCKTYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBlocktype() <em>Blocktype</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlocktype()
     * @generated
     * @ordered
     */
    protected String blocktype = BLOCKTYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getFiring() <em>Firing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFiring()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabInteger FIRING_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFiring() <em>Firing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFiring()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabInteger firing = FIRING_EDEFAULT;

    /**
     * The default value of the '{@link #getDep_ut() <em>Dep ut</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDep_ut()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabBoolean DEP_UT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDep_ut() <em>Dep ut</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDep_ut()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabBoolean dep_ut = DEP_UT_EDEFAULT;

    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #getNzcross() <em>Nzcross</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNzcross()
     * @generated
     * @ordered
     */
    protected static final int NZCROSS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getNzcross() <em>Nzcross</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNzcross()
     * @generated
     * @ordered
     */
    protected int nzcross = NZCROSS_EDEFAULT;

    /**
     * The default value of the '{@link #getNmode() <em>Nmode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNmode()
     * @generated
     * @ordered
     */
    protected static final int NMODE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getNmode() <em>Nmode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNmode()
     * @generated
     * @ordered
     */
    protected int nmode = NMODE_EDEFAULT;

    /**
     * The cached value of the '{@link #getEquationList() <em>Equation</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEquationList()
     * @generated
     * @ordered
     */
    protected EList<org.scilab.modules.types.ScilabType> equation;

    /**
     * The empty value for the '{@link #getEquation() <em>Equation</em>}' array accessor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEquation()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabType[] EQUATION_EEMPTY_ARRAY = new org.scilab.modules.types.ScilabType [0];

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType[] getSim() {
        if (sim == null || sim.isEmpty()) {
            return SIM_EEMPTY_ARRAY;
        }
        BasicEList<org.scilab.modules.types.ScilabType> list = (BasicEList<org.scilab.modules.types.ScilabType>)sim;
        list.shrink();
        return (org.scilab.modules.types.ScilabType[])list.data();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType getSim(int index) {
        return getSimList().get(index);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getSimLength() {
        return sim == null ? 0 : sim.size();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSim(org.scilab.modules.types.ScilabType[] newSim) {
        ((BasicEList<org.scilab.modules.types.ScilabType>)getSimList()).setData(newSim.length, newSim);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSim(int index, org.scilab.modules.types.ScilabType element) {
        getSimList().set(index, element);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<org.scilab.modules.types.ScilabType> getSimList() {
        if (sim == null) {
            sim = new EDataTypeUniqueEList<org.scilab.modules.types.ScilabType>(org.scilab.modules.types.ScilabType.class, this, SystemPackage.MODEL__SIM);
        }
        return sim;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger getIn() {
        return in;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIn(org.scilab.modules.types.ScilabInteger newIn) {
        org.scilab.modules.types.ScilabInteger oldIn = in;
        in = newIn;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__IN, oldIn, in));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger getIn2() {
        return in2;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIn2(org.scilab.modules.types.ScilabInteger newIn2) {
        org.scilab.modules.types.ScilabInteger oldIn2 = in2;
        in2 = newIn2;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__IN2, oldIn2, in2));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger getIntyp() {
        return intyp;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIntyp(org.scilab.modules.types.ScilabInteger newIntyp) {
        org.scilab.modules.types.ScilabInteger oldIntyp = intyp;
        intyp = newIntyp;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__INTYP, oldIntyp, intyp));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger getOut() {
        return out;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOut(org.scilab.modules.types.ScilabInteger newOut) {
        org.scilab.modules.types.ScilabInteger oldOut = out;
        out = newOut;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__OUT, oldOut, out));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger getOut2() {
        return out2;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOut2(org.scilab.modules.types.ScilabInteger newOut2) {
        org.scilab.modules.types.ScilabInteger oldOut2 = out2;
        out2 = newOut2;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__OUT2, oldOut2, out2));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger getOuttyp() {
        return outtyp;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOuttyp(org.scilab.modules.types.ScilabInteger newOuttyp) {
        org.scilab.modules.types.ScilabInteger oldOuttyp = outtyp;
        outtyp = newOuttyp;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__OUTTYP, oldOuttyp, outtyp));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger getEvtin() {
        return evtin;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEvtin(org.scilab.modules.types.ScilabInteger newEvtin) {
        org.scilab.modules.types.ScilabInteger oldEvtin = evtin;
        evtin = newEvtin;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__EVTIN, oldEvtin, evtin));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger getEvtout() {
        return evtout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEvtout(org.scilab.modules.types.ScilabInteger newEvtout) {
        org.scilab.modules.types.ScilabInteger oldEvtout = evtout;
        evtout = newEvtout;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__EVTOUT, oldEvtout, evtout));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getState() {
        return state;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setState(org.scilab.modules.types.ScilabDouble newState) {
        org.scilab.modules.types.ScilabDouble oldState = state;
        state = newState;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__STATE, oldState, state));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getDstate() {
        return dstate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDstate(org.scilab.modules.types.ScilabDouble newDstate) {
        org.scilab.modules.types.ScilabDouble oldDstate = dstate;
        dstate = newDstate;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__DSTATE, oldDstate, dstate));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType[] getOdstate() {
        if (odstate == null || odstate.isEmpty()) {
            return ODSTATE_EEMPTY_ARRAY;
        }
        BasicEList<org.scilab.modules.types.ScilabType> list = (BasicEList<org.scilab.modules.types.ScilabType>)odstate;
        list.shrink();
        return (org.scilab.modules.types.ScilabType[])list.data();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType getOdstate(int index) {
        return getOdstateList().get(index);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getOdstateLength() {
        return odstate == null ? 0 : odstate.size();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOdstate(org.scilab.modules.types.ScilabType[] newOdstate) {
        ((BasicEList<org.scilab.modules.types.ScilabType>)getOdstateList()).setData(newOdstate.length, newOdstate);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOdstate(int index, org.scilab.modules.types.ScilabType element) {
        getOdstateList().set(index, element);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<org.scilab.modules.types.ScilabType> getOdstateList() {
        if (odstate == null) {
            odstate = new EDataTypeUniqueEList<org.scilab.modules.types.ScilabType>(org.scilab.modules.types.ScilabType.class, this, SystemPackage.MODEL__ODSTATE);
        }
        return odstate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getRpar() {
        return rpar;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRpar(org.scilab.modules.types.ScilabDouble newRpar) {
        org.scilab.modules.types.ScilabDouble oldRpar = rpar;
        rpar = newRpar;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__RPAR, oldRpar, rpar));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger getIpar() {
        return ipar;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIpar(org.scilab.modules.types.ScilabInteger newIpar) {
        org.scilab.modules.types.ScilabInteger oldIpar = ipar;
        ipar = newIpar;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__IPAR, oldIpar, ipar));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType[] getOpar() {
        if (opar == null || opar.isEmpty()) {
            return OPAR_EEMPTY_ARRAY;
        }
        BasicEList<org.scilab.modules.types.ScilabType> list = (BasicEList<org.scilab.modules.types.ScilabType>)opar;
        list.shrink();
        return (org.scilab.modules.types.ScilabType[])list.data();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType getOpar(int index) {
        return getOparList().get(index);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getOparLength() {
        return opar == null ? 0 : opar.size();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOpar(org.scilab.modules.types.ScilabType[] newOpar) {
        ((BasicEList<org.scilab.modules.types.ScilabType>)getOparList()).setData(newOpar.length, newOpar);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOpar(int index, org.scilab.modules.types.ScilabType element) {
        getOparList().set(index, element);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<org.scilab.modules.types.ScilabType> getOparList() {
        if (opar == null) {
            opar = new EDataTypeUniqueEList<org.scilab.modules.types.ScilabType>(org.scilab.modules.types.ScilabType.class, this, SystemPackage.MODEL__OPAR);
        }
        return opar;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBlocktype() {
        return blocktype;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBlocktype(String newBlocktype) {
        String oldBlocktype = blocktype;
        blocktype = newBlocktype;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__BLOCKTYPE, oldBlocktype, blocktype));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabInteger getFiring() {
        return firing;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFiring(org.scilab.modules.types.ScilabInteger newFiring) {
        org.scilab.modules.types.ScilabInteger oldFiring = firing;
        firing = newFiring;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__FIRING, oldFiring, firing));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabBoolean getDep_ut() {
        return dep_ut;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDep_ut(org.scilab.modules.types.ScilabBoolean newDep_ut) {
        org.scilab.modules.types.ScilabBoolean oldDep_ut = dep_ut;
        dep_ut = newDep_ut;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__DEP_UT, oldDep_ut, dep_ut));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLabel() {
        return label;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabel(String newLabel) {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__LABEL, oldLabel, label));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getNzcross() {
        return nzcross;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNzcross(int newNzcross) {
        int oldNzcross = nzcross;
        nzcross = newNzcross;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__NZCROSS, oldNzcross, nzcross));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getNmode() {
        return nmode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNmode(int newNmode) {
        int oldNmode = nmode;
        nmode = newNmode;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.MODEL__NMODE, oldNmode, nmode));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType[] getEquation() {
        if (equation == null || equation.isEmpty()) {
            return EQUATION_EEMPTY_ARRAY;
        }
        BasicEList<org.scilab.modules.types.ScilabType> list = (BasicEList<org.scilab.modules.types.ScilabType>)equation;
        list.shrink();
        return (org.scilab.modules.types.ScilabType[])list.data();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType getEquation(int index) {
        return getEquationList().get(index);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getEquationLength() {
        return equation == null ? 0 : equation.size();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEquation(org.scilab.modules.types.ScilabType[] newEquation) {
        ((BasicEList<org.scilab.modules.types.ScilabType>)getEquationList()).setData(newEquation.length, newEquation);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEquation(int index, org.scilab.modules.types.ScilabType element) {
        getEquationList().set(index, element);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<org.scilab.modules.types.ScilabType> getEquationList() {
        if (equation == null) {
            equation = new EDataTypeUniqueEList<org.scilab.modules.types.ScilabType>(org.scilab.modules.types.ScilabType.class, this, SystemPackage.MODEL__EQUATION);
        }
        return equation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SystemPackage.MODEL__SIM:
                return getSimList();
            case SystemPackage.MODEL__IN:
                return getIn();
            case SystemPackage.MODEL__IN2:
                return getIn2();
            case SystemPackage.MODEL__INTYP:
                return getIntyp();
            case SystemPackage.MODEL__OUT:
                return getOut();
            case SystemPackage.MODEL__OUT2:
                return getOut2();
            case SystemPackage.MODEL__OUTTYP:
                return getOuttyp();
            case SystemPackage.MODEL__EVTIN:
                return getEvtin();
            case SystemPackage.MODEL__EVTOUT:
                return getEvtout();
            case SystemPackage.MODEL__STATE:
                return getState();
            case SystemPackage.MODEL__DSTATE:
                return getDstate();
            case SystemPackage.MODEL__ODSTATE:
                return getOdstateList();
            case SystemPackage.MODEL__RPAR:
                return getRpar();
            case SystemPackage.MODEL__IPAR:
                return getIpar();
            case SystemPackage.MODEL__OPAR:
                return getOparList();
            case SystemPackage.MODEL__BLOCKTYPE:
                return getBlocktype();
            case SystemPackage.MODEL__FIRING:
                return getFiring();
            case SystemPackage.MODEL__DEP_UT:
                return getDep_ut();
            case SystemPackage.MODEL__LABEL:
                return getLabel();
            case SystemPackage.MODEL__NZCROSS:
                return getNzcross();
            case SystemPackage.MODEL__NMODE:
                return getNmode();
            case SystemPackage.MODEL__EQUATION:
                return getEquationList();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SystemPackage.MODEL__SIM:
                getSimList().clear();
                getSimList().addAll((Collection<? extends org.scilab.modules.types.ScilabType>)newValue);
                return;
            case SystemPackage.MODEL__IN:
                setIn((org.scilab.modules.types.ScilabInteger)newValue);
                return;
            case SystemPackage.MODEL__IN2:
                setIn2((org.scilab.modules.types.ScilabInteger)newValue);
                return;
            case SystemPackage.MODEL__INTYP:
                setIntyp((org.scilab.modules.types.ScilabInteger)newValue);
                return;
            case SystemPackage.MODEL__OUT:
                setOut((org.scilab.modules.types.ScilabInteger)newValue);
                return;
            case SystemPackage.MODEL__OUT2:
                setOut2((org.scilab.modules.types.ScilabInteger)newValue);
                return;
            case SystemPackage.MODEL__OUTTYP:
                setOuttyp((org.scilab.modules.types.ScilabInteger)newValue);
                return;
            case SystemPackage.MODEL__EVTIN:
                setEvtin((org.scilab.modules.types.ScilabInteger)newValue);
                return;
            case SystemPackage.MODEL__EVTOUT:
                setEvtout((org.scilab.modules.types.ScilabInteger)newValue);
                return;
            case SystemPackage.MODEL__STATE:
                setState((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.MODEL__DSTATE:
                setDstate((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.MODEL__ODSTATE:
                getOdstateList().clear();
                getOdstateList().addAll((Collection<? extends org.scilab.modules.types.ScilabType>)newValue);
                return;
            case SystemPackage.MODEL__RPAR:
                setRpar((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.MODEL__IPAR:
                setIpar((org.scilab.modules.types.ScilabInteger)newValue);
                return;
            case SystemPackage.MODEL__OPAR:
                getOparList().clear();
                getOparList().addAll((Collection<? extends org.scilab.modules.types.ScilabType>)newValue);
                return;
            case SystemPackage.MODEL__BLOCKTYPE:
                setBlocktype((String)newValue);
                return;
            case SystemPackage.MODEL__FIRING:
                setFiring((org.scilab.modules.types.ScilabInteger)newValue);
                return;
            case SystemPackage.MODEL__DEP_UT:
                setDep_ut((org.scilab.modules.types.ScilabBoolean)newValue);
                return;
            case SystemPackage.MODEL__LABEL:
                setLabel((String)newValue);
                return;
            case SystemPackage.MODEL__NZCROSS:
                setNzcross((Integer)newValue);
                return;
            case SystemPackage.MODEL__NMODE:
                setNmode((Integer)newValue);
                return;
            case SystemPackage.MODEL__EQUATION:
                getEquationList().clear();
                getEquationList().addAll((Collection<? extends org.scilab.modules.types.ScilabType>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case SystemPackage.MODEL__SIM:
                getSimList().clear();
                return;
            case SystemPackage.MODEL__IN:
                setIn(IN_EDEFAULT);
                return;
            case SystemPackage.MODEL__IN2:
                setIn2(IN2_EDEFAULT);
                return;
            case SystemPackage.MODEL__INTYP:
                setIntyp(INTYP_EDEFAULT);
                return;
            case SystemPackage.MODEL__OUT:
                setOut(OUT_EDEFAULT);
                return;
            case SystemPackage.MODEL__OUT2:
                setOut2(OUT2_EDEFAULT);
                return;
            case SystemPackage.MODEL__OUTTYP:
                setOuttyp(OUTTYP_EDEFAULT);
                return;
            case SystemPackage.MODEL__EVTIN:
                setEvtin(EVTIN_EDEFAULT);
                return;
            case SystemPackage.MODEL__EVTOUT:
                setEvtout(EVTOUT_EDEFAULT);
                return;
            case SystemPackage.MODEL__STATE:
                setState(STATE_EDEFAULT);
                return;
            case SystemPackage.MODEL__DSTATE:
                setDstate(DSTATE_EDEFAULT);
                return;
            case SystemPackage.MODEL__ODSTATE:
                getOdstateList().clear();
                return;
            case SystemPackage.MODEL__RPAR:
                setRpar(RPAR_EDEFAULT);
                return;
            case SystemPackage.MODEL__IPAR:
                setIpar(IPAR_EDEFAULT);
                return;
            case SystemPackage.MODEL__OPAR:
                getOparList().clear();
                return;
            case SystemPackage.MODEL__BLOCKTYPE:
                setBlocktype(BLOCKTYPE_EDEFAULT);
                return;
            case SystemPackage.MODEL__FIRING:
                setFiring(FIRING_EDEFAULT);
                return;
            case SystemPackage.MODEL__DEP_UT:
                setDep_ut(DEP_UT_EDEFAULT);
                return;
            case SystemPackage.MODEL__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case SystemPackage.MODEL__NZCROSS:
                setNzcross(NZCROSS_EDEFAULT);
                return;
            case SystemPackage.MODEL__NMODE:
                setNmode(NMODE_EDEFAULT);
                return;
            case SystemPackage.MODEL__EQUATION:
                getEquationList().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SystemPackage.MODEL__SIM:
                return sim != null && !sim.isEmpty();
            case SystemPackage.MODEL__IN:
                return IN_EDEFAULT == null ? in != null : !IN_EDEFAULT.equals(in);
            case SystemPackage.MODEL__IN2:
                return IN2_EDEFAULT == null ? in2 != null : !IN2_EDEFAULT.equals(in2);
            case SystemPackage.MODEL__INTYP:
                return INTYP_EDEFAULT == null ? intyp != null : !INTYP_EDEFAULT.equals(intyp);
            case SystemPackage.MODEL__OUT:
                return OUT_EDEFAULT == null ? out != null : !OUT_EDEFAULT.equals(out);
            case SystemPackage.MODEL__OUT2:
                return OUT2_EDEFAULT == null ? out2 != null : !OUT2_EDEFAULT.equals(out2);
            case SystemPackage.MODEL__OUTTYP:
                return OUTTYP_EDEFAULT == null ? outtyp != null : !OUTTYP_EDEFAULT.equals(outtyp);
            case SystemPackage.MODEL__EVTIN:
                return EVTIN_EDEFAULT == null ? evtin != null : !EVTIN_EDEFAULT.equals(evtin);
            case SystemPackage.MODEL__EVTOUT:
                return EVTOUT_EDEFAULT == null ? evtout != null : !EVTOUT_EDEFAULT.equals(evtout);
            case SystemPackage.MODEL__STATE:
                return STATE_EDEFAULT == null ? state != null : !STATE_EDEFAULT.equals(state);
            case SystemPackage.MODEL__DSTATE:
                return DSTATE_EDEFAULT == null ? dstate != null : !DSTATE_EDEFAULT.equals(dstate);
            case SystemPackage.MODEL__ODSTATE:
                return odstate != null && !odstate.isEmpty();
            case SystemPackage.MODEL__RPAR:
                return RPAR_EDEFAULT == null ? rpar != null : !RPAR_EDEFAULT.equals(rpar);
            case SystemPackage.MODEL__IPAR:
                return IPAR_EDEFAULT == null ? ipar != null : !IPAR_EDEFAULT.equals(ipar);
            case SystemPackage.MODEL__OPAR:
                return opar != null && !opar.isEmpty();
            case SystemPackage.MODEL__BLOCKTYPE:
                return BLOCKTYPE_EDEFAULT == null ? blocktype != null : !BLOCKTYPE_EDEFAULT.equals(blocktype);
            case SystemPackage.MODEL__FIRING:
                return FIRING_EDEFAULT == null ? firing != null : !FIRING_EDEFAULT.equals(firing);
            case SystemPackage.MODEL__DEP_UT:
                return DEP_UT_EDEFAULT == null ? dep_ut != null : !DEP_UT_EDEFAULT.equals(dep_ut);
            case SystemPackage.MODEL__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case SystemPackage.MODEL__NZCROSS:
                return nzcross != NZCROSS_EDEFAULT;
            case SystemPackage.MODEL__NMODE:
                return nmode != NMODE_EDEFAULT;
            case SystemPackage.MODEL__EQUATION:
                return equation != null && !equation.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (sim: ");
        result.append(sim);
        result.append(", in: ");
        result.append(in);
        result.append(", in2: ");
        result.append(in2);
        result.append(", intyp: ");
        result.append(intyp);
        result.append(", out: ");
        result.append(out);
        result.append(", out2: ");
        result.append(out2);
        result.append(", outtyp: ");
        result.append(outtyp);
        result.append(", evtin: ");
        result.append(evtin);
        result.append(", evtout: ");
        result.append(evtout);
        result.append(", state: ");
        result.append(state);
        result.append(", dstate: ");
        result.append(dstate);
        result.append(", odstate: ");
        result.append(odstate);
        result.append(", rpar: ");
        result.append(rpar);
        result.append(", ipar: ");
        result.append(ipar);
        result.append(", opar: ");
        result.append(opar);
        result.append(", blocktype: ");
        result.append(blocktype);
        result.append(", firing: ");
        result.append(firing);
        result.append(", dep_ut: ");
        result.append(dep_ut);
        result.append(", label: ");
        result.append(label);
        result.append(", nzcross: ");
        result.append(nzcross);
        result.append(", nmode: ");
        result.append(nmode);
        result.append(", equation: ");
        result.append(equation);
        result.append(')');
        return result.toString();
    }

} //ModelImpl

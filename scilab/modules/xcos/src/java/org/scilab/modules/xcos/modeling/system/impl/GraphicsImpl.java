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
import org.scilab.modules.xcos.modeling.system.Graphics;
import org.scilab.modules.xcos.modeling.system.SystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getOrig <em>Orig</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getSz <em>Sz</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#isFlip <em>Flip</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getTheta <em>Theta</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getExprs <em>Exprs</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getPin <em>Pin</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getPout <em>Pout</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getPein <em>Pein</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getPeout <em>Peout</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getGr_iList <em>Gr i</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getIn_implicit <em>In implicit</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.GraphicsImpl#getOut_implicit <em>Out implicit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphicsImpl extends MinimalEObjectImpl.Container implements Graphics {
    /**
     * The default value of the '{@link #getOrig() <em>Orig</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrig()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble ORIG_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOrig() <em>Orig</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrig()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble orig = ORIG_EDEFAULT;

    /**
     * The default value of the '{@link #getSz() <em>Sz</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSz()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble SZ_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSz() <em>Sz</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSz()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble sz = SZ_EDEFAULT;

    /**
     * The default value of the '{@link #isFlip() <em>Flip</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFlip()
     * @generated
     * @ordered
     */
    protected static final boolean FLIP_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isFlip() <em>Flip</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFlip()
     * @generated
     * @ordered
     */
    protected boolean flip = FLIP_EDEFAULT;

    /**
     * The default value of the '{@link #getTheta() <em>Theta</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTheta()
     * @generated
     * @ordered
     */
    protected static final double THETA_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getTheta() <em>Theta</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTheta()
     * @generated
     * @ordered
     */
    protected double theta = THETA_EDEFAULT;

    /**
     * The default value of the '{@link #getExprs() <em>Exprs</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExprs()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabString EXPRS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExprs() <em>Exprs</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExprs()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabString exprs = EXPRS_EDEFAULT;

    /**
     * The default value of the '{@link #getPin() <em>Pin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPin()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble PIN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPin() <em>Pin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPin()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble pin = PIN_EDEFAULT;

    /**
     * The default value of the '{@link #getPout() <em>Pout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPout()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble POUT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPout() <em>Pout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPout()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble pout = POUT_EDEFAULT;

    /**
     * The default value of the '{@link #getPein() <em>Pein</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPein()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble PEIN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPein() <em>Pein</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPein()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble pein = PEIN_EDEFAULT;

    /**
     * The default value of the '{@link #getPeout() <em>Peout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeout()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble PEOUT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPeout() <em>Peout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeout()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble peout = PEOUT_EDEFAULT;

    /**
     * The cached value of the '{@link #getGr_iList() <em>Gr i</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGr_iList()
     * @generated
     * @ordered
     */
    protected EList<org.scilab.modules.types.ScilabType> gr_i;

    /**
     * The empty value for the '{@link #getGr_i() <em>Gr i</em>}' array accessor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGr_i()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabType[] GR_I_EEMPTY_ARRAY = new org.scilab.modules.types.ScilabType [0];

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getIn_implicit() <em>In implicit</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIn_implicit()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabString IN_IMPLICIT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIn_implicit() <em>In implicit</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIn_implicit()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabString in_implicit = IN_IMPLICIT_EDEFAULT;

    /**
     * The default value of the '{@link #getOut_implicit() <em>Out implicit</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOut_implicit()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabString OUT_IMPLICIT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOut_implicit() <em>Out implicit</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOut_implicit()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabString out_implicit = OUT_IMPLICIT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GraphicsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.GRAPHICS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getOrig() {
        return orig;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOrig(org.scilab.modules.types.ScilabDouble newOrig) {
        org.scilab.modules.types.ScilabDouble oldOrig = orig;
        orig = newOrig;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__ORIG, oldOrig, orig));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getSz() {
        return sz;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSz(org.scilab.modules.types.ScilabDouble newSz) {
        org.scilab.modules.types.ScilabDouble oldSz = sz;
        sz = newSz;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__SZ, oldSz, sz));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isFlip() {
        return flip;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFlip(boolean newFlip) {
        boolean oldFlip = flip;
        flip = newFlip;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__FLIP, oldFlip, flip));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getTheta() {
        return theta;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTheta(double newTheta) {
        double oldTheta = theta;
        theta = newTheta;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__THETA, oldTheta, theta));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabString getExprs() {
        return exprs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExprs(org.scilab.modules.types.ScilabString newExprs) {
        org.scilab.modules.types.ScilabString oldExprs = exprs;
        exprs = newExprs;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__EXPRS, oldExprs, exprs));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getPin() {
        return pin;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPin(org.scilab.modules.types.ScilabDouble newPin) {
        org.scilab.modules.types.ScilabDouble oldPin = pin;
        pin = newPin;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__PIN, oldPin, pin));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getPout() {
        return pout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPout(org.scilab.modules.types.ScilabDouble newPout) {
        org.scilab.modules.types.ScilabDouble oldPout = pout;
        pout = newPout;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__POUT, oldPout, pout));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getPein() {
        return pein;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPein(org.scilab.modules.types.ScilabDouble newPein) {
        org.scilab.modules.types.ScilabDouble oldPein = pein;
        pein = newPein;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__PEIN, oldPein, pein));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getPeout() {
        return peout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPeout(org.scilab.modules.types.ScilabDouble newPeout) {
        org.scilab.modules.types.ScilabDouble oldPeout = peout;
        peout = newPeout;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__PEOUT, oldPeout, peout));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType[] getGr_i() {
        if (gr_i == null || gr_i.isEmpty()) {
            return GR_I_EEMPTY_ARRAY;
        }
        BasicEList<org.scilab.modules.types.ScilabType> list = (BasicEList<org.scilab.modules.types.ScilabType>)gr_i;
        list.shrink();
        return (org.scilab.modules.types.ScilabType[])list.data();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType getGr_i(int index) {
        return getGr_iList().get(index);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getGr_iLength() {
        return gr_i == null ? 0 : gr_i.size();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGr_i(org.scilab.modules.types.ScilabType[] newGr_i) {
        ((BasicEList<org.scilab.modules.types.ScilabType>)getGr_iList()).setData(newGr_i.length, newGr_i);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGr_i(int index, org.scilab.modules.types.ScilabType element) {
        getGr_iList().set(index, element);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<org.scilab.modules.types.ScilabType> getGr_iList() {
        if (gr_i == null) {
            gr_i = new EDataTypeUniqueEList<org.scilab.modules.types.ScilabType>(org.scilab.modules.types.ScilabType.class, this, SystemPackage.GRAPHICS__GR_I);
        }
        return gr_i;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId) {
        String oldId = id;
        id = newId;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__ID, oldId, id));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabString getIn_implicit() {
        return in_implicit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIn_implicit(org.scilab.modules.types.ScilabString newIn_implicit) {
        org.scilab.modules.types.ScilabString oldIn_implicit = in_implicit;
        in_implicit = newIn_implicit;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__IN_IMPLICIT, oldIn_implicit, in_implicit));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabString getOut_implicit() {
        return out_implicit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOut_implicit(org.scilab.modules.types.ScilabString newOut_implicit) {
        org.scilab.modules.types.ScilabString oldOut_implicit = out_implicit;
        out_implicit = newOut_implicit;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.GRAPHICS__OUT_IMPLICIT, oldOut_implicit, out_implicit));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SystemPackage.GRAPHICS__ORIG:
                return getOrig();
            case SystemPackage.GRAPHICS__SZ:
                return getSz();
            case SystemPackage.GRAPHICS__FLIP:
                return isFlip();
            case SystemPackage.GRAPHICS__THETA:
                return getTheta();
            case SystemPackage.GRAPHICS__EXPRS:
                return getExprs();
            case SystemPackage.GRAPHICS__PIN:
                return getPin();
            case SystemPackage.GRAPHICS__POUT:
                return getPout();
            case SystemPackage.GRAPHICS__PEIN:
                return getPein();
            case SystemPackage.GRAPHICS__PEOUT:
                return getPeout();
            case SystemPackage.GRAPHICS__GR_I:
                return getGr_iList();
            case SystemPackage.GRAPHICS__ID:
                return getId();
            case SystemPackage.GRAPHICS__IN_IMPLICIT:
                return getIn_implicit();
            case SystemPackage.GRAPHICS__OUT_IMPLICIT:
                return getOut_implicit();
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
            case SystemPackage.GRAPHICS__ORIG:
                setOrig((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.GRAPHICS__SZ:
                setSz((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.GRAPHICS__FLIP:
                setFlip((Boolean)newValue);
                return;
            case SystemPackage.GRAPHICS__THETA:
                setTheta((Double)newValue);
                return;
            case SystemPackage.GRAPHICS__EXPRS:
                setExprs((org.scilab.modules.types.ScilabString)newValue);
                return;
            case SystemPackage.GRAPHICS__PIN:
                setPin((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.GRAPHICS__POUT:
                setPout((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.GRAPHICS__PEIN:
                setPein((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.GRAPHICS__PEOUT:
                setPeout((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.GRAPHICS__GR_I:
                getGr_iList().clear();
                getGr_iList().addAll((Collection<? extends org.scilab.modules.types.ScilabType>)newValue);
                return;
            case SystemPackage.GRAPHICS__ID:
                setId((String)newValue);
                return;
            case SystemPackage.GRAPHICS__IN_IMPLICIT:
                setIn_implicit((org.scilab.modules.types.ScilabString)newValue);
                return;
            case SystemPackage.GRAPHICS__OUT_IMPLICIT:
                setOut_implicit((org.scilab.modules.types.ScilabString)newValue);
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
            case SystemPackage.GRAPHICS__ORIG:
                setOrig(ORIG_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__SZ:
                setSz(SZ_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__FLIP:
                setFlip(FLIP_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__THETA:
                setTheta(THETA_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__EXPRS:
                setExprs(EXPRS_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__PIN:
                setPin(PIN_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__POUT:
                setPout(POUT_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__PEIN:
                setPein(PEIN_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__PEOUT:
                setPeout(PEOUT_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__GR_I:
                getGr_iList().clear();
                return;
            case SystemPackage.GRAPHICS__ID:
                setId(ID_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__IN_IMPLICIT:
                setIn_implicit(IN_IMPLICIT_EDEFAULT);
                return;
            case SystemPackage.GRAPHICS__OUT_IMPLICIT:
                setOut_implicit(OUT_IMPLICIT_EDEFAULT);
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
            case SystemPackage.GRAPHICS__ORIG:
                return ORIG_EDEFAULT == null ? orig != null : !ORIG_EDEFAULT.equals(orig);
            case SystemPackage.GRAPHICS__SZ:
                return SZ_EDEFAULT == null ? sz != null : !SZ_EDEFAULT.equals(sz);
            case SystemPackage.GRAPHICS__FLIP:
                return flip != FLIP_EDEFAULT;
            case SystemPackage.GRAPHICS__THETA:
                return theta != THETA_EDEFAULT;
            case SystemPackage.GRAPHICS__EXPRS:
                return EXPRS_EDEFAULT == null ? exprs != null : !EXPRS_EDEFAULT.equals(exprs);
            case SystemPackage.GRAPHICS__PIN:
                return PIN_EDEFAULT == null ? pin != null : !PIN_EDEFAULT.equals(pin);
            case SystemPackage.GRAPHICS__POUT:
                return POUT_EDEFAULT == null ? pout != null : !POUT_EDEFAULT.equals(pout);
            case SystemPackage.GRAPHICS__PEIN:
                return PEIN_EDEFAULT == null ? pein != null : !PEIN_EDEFAULT.equals(pein);
            case SystemPackage.GRAPHICS__PEOUT:
                return PEOUT_EDEFAULT == null ? peout != null : !PEOUT_EDEFAULT.equals(peout);
            case SystemPackage.GRAPHICS__GR_I:
                return gr_i != null && !gr_i.isEmpty();
            case SystemPackage.GRAPHICS__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case SystemPackage.GRAPHICS__IN_IMPLICIT:
                return IN_IMPLICIT_EDEFAULT == null ? in_implicit != null : !IN_IMPLICIT_EDEFAULT.equals(in_implicit);
            case SystemPackage.GRAPHICS__OUT_IMPLICIT:
                return OUT_IMPLICIT_EDEFAULT == null ? out_implicit != null : !OUT_IMPLICIT_EDEFAULT.equals(out_implicit);
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
        result.append(" (orig: ");
        result.append(orig);
        result.append(", sz: ");
        result.append(sz);
        result.append(", flip: ");
        result.append(flip);
        result.append(", theta: ");
        result.append(theta);
        result.append(", exprs: ");
        result.append(exprs);
        result.append(", pin: ");
        result.append(pin);
        result.append(", pout: ");
        result.append(pout);
        result.append(", pein: ");
        result.append(pein);
        result.append(", peout: ");
        result.append(peout);
        result.append(", gr_i: ");
        result.append(gr_i);
        result.append(", id: ");
        result.append(id);
        result.append(", in_implicit: ");
        result.append(in_implicit);
        result.append(", out_implicit: ");
        result.append(out_implicit);
        result.append(')');
        return result.toString();
    }

} //GraphicsImpl

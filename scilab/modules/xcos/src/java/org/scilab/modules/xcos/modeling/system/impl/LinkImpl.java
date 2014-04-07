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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.scilab.modules.xcos.modeling.system.Link;
import org.scilab.modules.xcos.modeling.system.SystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.LinkImpl#getXx <em>Xx</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.LinkImpl#getYy <em>Yy</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.LinkImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.LinkImpl#getTick <em>Tick</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.LinkImpl#getCt <em>Ct</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.LinkImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.LinkImpl#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkImpl extends MinimalEObjectImpl.Container implements Link {
    /**
     * The default value of the '{@link #getXx() <em>Xx</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXx()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble XX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getXx() <em>Xx</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXx()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble xx = XX_EDEFAULT;

    /**
     * The default value of the '{@link #getYy() <em>Yy</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getYy()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble YY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getYy() <em>Yy</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getYy()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble yy = YY_EDEFAULT;

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
     * The default value of the '{@link #getTick() <em>Tick</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTick()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble TICK_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTick() <em>Tick</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTick()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble tick = TICK_EDEFAULT;

    /**
     * The default value of the '{@link #getCt() <em>Ct</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCt()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble CT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCt() <em>Ct</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCt()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble ct = CT_EDEFAULT;

    /**
     * The default value of the '{@link #getFrom() <em>From</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFrom()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble FROM_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFrom() <em>From</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFrom()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble from = FROM_EDEFAULT;

    /**
     * The default value of the '{@link #getTo() <em>To</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTo()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble TO_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTo() <em>To</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTo()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble to = TO_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LinkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.LINK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getXx() {
        return xx;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setXx(org.scilab.modules.types.ScilabDouble newXx) {
        org.scilab.modules.types.ScilabDouble oldXx = xx;
        xx = newXx;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.LINK__XX, oldXx, xx));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getYy() {
        return yy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setYy(org.scilab.modules.types.ScilabDouble newYy) {
        org.scilab.modules.types.ScilabDouble oldYy = yy;
        yy = newYy;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.LINK__YY, oldYy, yy));
        }
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
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.LINK__ID, oldId, id));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getTick() {
        return tick;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTick(org.scilab.modules.types.ScilabDouble newTick) {
        org.scilab.modules.types.ScilabDouble oldTick = tick;
        tick = newTick;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.LINK__TICK, oldTick, tick));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getCt() {
        return ct;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCt(org.scilab.modules.types.ScilabDouble newCt) {
        org.scilab.modules.types.ScilabDouble oldCt = ct;
        ct = newCt;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.LINK__CT, oldCt, ct));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getFrom() {
        return from;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFrom(org.scilab.modules.types.ScilabDouble newFrom) {
        org.scilab.modules.types.ScilabDouble oldFrom = from;
        from = newFrom;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.LINK__FROM, oldFrom, from));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getTo() {
        return to;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTo(org.scilab.modules.types.ScilabDouble newTo) {
        org.scilab.modules.types.ScilabDouble oldTo = to;
        to = newTo;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.LINK__TO, oldTo, to));
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
            case SystemPackage.LINK__XX:
                return getXx();
            case SystemPackage.LINK__YY:
                return getYy();
            case SystemPackage.LINK__ID:
                return getId();
            case SystemPackage.LINK__TICK:
                return getTick();
            case SystemPackage.LINK__CT:
                return getCt();
            case SystemPackage.LINK__FROM:
                return getFrom();
            case SystemPackage.LINK__TO:
                return getTo();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SystemPackage.LINK__XX:
                setXx((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.LINK__YY:
                setYy((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.LINK__ID:
                setId((String)newValue);
                return;
            case SystemPackage.LINK__TICK:
                setTick((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.LINK__CT:
                setCt((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.LINK__FROM:
                setFrom((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.LINK__TO:
                setTo((org.scilab.modules.types.ScilabDouble)newValue);
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
            case SystemPackage.LINK__XX:
                setXx(XX_EDEFAULT);
                return;
            case SystemPackage.LINK__YY:
                setYy(YY_EDEFAULT);
                return;
            case SystemPackage.LINK__ID:
                setId(ID_EDEFAULT);
                return;
            case SystemPackage.LINK__TICK:
                setTick(TICK_EDEFAULT);
                return;
            case SystemPackage.LINK__CT:
                setCt(CT_EDEFAULT);
                return;
            case SystemPackage.LINK__FROM:
                setFrom(FROM_EDEFAULT);
                return;
            case SystemPackage.LINK__TO:
                setTo(TO_EDEFAULT);
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
            case SystemPackage.LINK__XX:
                return XX_EDEFAULT == null ? xx != null : !XX_EDEFAULT.equals(xx);
            case SystemPackage.LINK__YY:
                return YY_EDEFAULT == null ? yy != null : !YY_EDEFAULT.equals(yy);
            case SystemPackage.LINK__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case SystemPackage.LINK__TICK:
                return TICK_EDEFAULT == null ? tick != null : !TICK_EDEFAULT.equals(tick);
            case SystemPackage.LINK__CT:
                return CT_EDEFAULT == null ? ct != null : !CT_EDEFAULT.equals(ct);
            case SystemPackage.LINK__FROM:
                return FROM_EDEFAULT == null ? from != null : !FROM_EDEFAULT.equals(from);
            case SystemPackage.LINK__TO:
                return TO_EDEFAULT == null ? to != null : !TO_EDEFAULT.equals(to);
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
        result.append(" (xx: ");
        result.append(xx);
        result.append(", yy: ");
        result.append(yy);
        result.append(", id: ");
        result.append(id);
        result.append(", tick: ");
        result.append(tick);
        result.append(", ct: ");
        result.append(ct);
        result.append(", from: ");
        result.append(from);
        result.append(", to: ");
        result.append(to);
        result.append(')');
        return result.toString();
    }

} //LinkImpl

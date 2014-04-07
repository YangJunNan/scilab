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
import org.scilab.modules.xcos.modeling.system.Scsopt;
import org.scilab.modules.xcos.modeling.system.SystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scsopt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ScsoptImpl#get_3DList <em>3D</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ScsoptImpl#getBackground <em>Background</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ScsoptImpl#getLink <em>Link</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ScsoptImpl#getIDList <em>ID</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ScsoptImpl#getCMap <em>CMap</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScsoptImpl extends MinimalEObjectImpl.Container implements Scsopt {
    /**
     * The cached value of the '{@link #get_3DList() <em>3D</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #get_3DList()
     * @generated
     * @ordered
     */
    protected EList<org.scilab.modules.types.ScilabType> _3D;

    /**
     * The empty value for the '{@link #get_3D() <em>3D</em>}' array accessor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #get_3D()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabType[] _3D_EEMPTY_ARRAY = new org.scilab.modules.types.ScilabType [0];

    /**
     * The default value of the '{@link #getBackground() <em>Background</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackground()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble BACKGROUND_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBackground() <em>Background</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackground()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble background = BACKGROUND_EDEFAULT;

    /**
     * The default value of the '{@link #getLink() <em>Link</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLink()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble LINK_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLink() <em>Link</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLink()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble link = LINK_EDEFAULT;

    /**
     * The cached value of the '{@link #getIDList() <em>ID</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIDList()
     * @generated
     * @ordered
     */
    protected EList<org.scilab.modules.types.ScilabDouble> id;

    /**
     * The empty value for the '{@link #getID() <em>ID</em>}' array accessor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getID()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble[] ID_EEMPTY_ARRAY = new org.scilab.modules.types.ScilabDouble [0];

    /**
     * The default value of the '{@link #getCMap() <em>CMap</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCMap()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble CMAP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCMap() <em>CMap</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCMap()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble cMap = CMAP_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScsoptImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.SCSOPT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType[] get_3D() {
        if (_3D == null || _3D.isEmpty()) {
            return _3D_EEMPTY_ARRAY;
        }
        BasicEList<org.scilab.modules.types.ScilabType> list = (BasicEList<org.scilab.modules.types.ScilabType>)_3D;
        list.shrink();
        return (org.scilab.modules.types.ScilabType[])list.data();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType get_3D(int index) {
        return get_3DList().get(index);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int get_3DLength() {
        return _3D == null ? 0 : _3D.size();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void set_3D(org.scilab.modules.types.ScilabType[] new_3D) {
        ((BasicEList<org.scilab.modules.types.ScilabType>)get_3DList()).setData(new_3D.length, new_3D);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void set_3D(int index, org.scilab.modules.types.ScilabType element) {
        get_3DList().set(index, element);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<org.scilab.modules.types.ScilabType> get_3DList() {
        if (_3D == null) {
            _3D = new EDataTypeUniqueEList<org.scilab.modules.types.ScilabType>(org.scilab.modules.types.ScilabType.class, this, SystemPackage.SCSOPT__3D);
        }
        return _3D;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getBackground() {
        return background;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBackground(org.scilab.modules.types.ScilabDouble newBackground) {
        org.scilab.modules.types.ScilabDouble oldBackground = background;
        background = newBackground;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SCSOPT__BACKGROUND, oldBackground, background));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getLink() {
        return link;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLink(org.scilab.modules.types.ScilabDouble newLink) {
        org.scilab.modules.types.ScilabDouble oldLink = link;
        link = newLink;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SCSOPT__LINK, oldLink, link));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble[] getID() {
        if (id == null || id.isEmpty()) {
            return ID_EEMPTY_ARRAY;
        }
        BasicEList<org.scilab.modules.types.ScilabDouble> list = (BasicEList<org.scilab.modules.types.ScilabDouble>)id;
        list.shrink();
        return (org.scilab.modules.types.ScilabDouble[])list.data();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getID(int index) {
        return getIDList().get(index);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getIDLength() {
        return id == null ? 0 : id.size();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setID(org.scilab.modules.types.ScilabDouble[] newID) {
        ((BasicEList<org.scilab.modules.types.ScilabDouble>)getIDList()).setData(newID.length, newID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setID(int index, org.scilab.modules.types.ScilabDouble element) {
        getIDList().set(index, element);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<org.scilab.modules.types.ScilabDouble> getIDList() {
        if (id == null) {
            id = new EDataTypeUniqueEList<org.scilab.modules.types.ScilabDouble>(org.scilab.modules.types.ScilabDouble.class, this, SystemPackage.SCSOPT__ID);
        }
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getCMap() {
        return cMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCMap(org.scilab.modules.types.ScilabDouble newCMap) {
        org.scilab.modules.types.ScilabDouble oldCMap = cMap;
        cMap = newCMap;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SCSOPT__CMAP, oldCMap, cMap));
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
            case SystemPackage.SCSOPT__3D:
                return get_3DList();
            case SystemPackage.SCSOPT__BACKGROUND:
                return getBackground();
            case SystemPackage.SCSOPT__LINK:
                return getLink();
            case SystemPackage.SCSOPT__ID:
                return getIDList();
            case SystemPackage.SCSOPT__CMAP:
                return getCMap();
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
            case SystemPackage.SCSOPT__3D:
                get_3DList().clear();
                get_3DList().addAll((Collection<? extends org.scilab.modules.types.ScilabType>)newValue);
                return;
            case SystemPackage.SCSOPT__BACKGROUND:
                setBackground((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.SCSOPT__LINK:
                setLink((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.SCSOPT__ID:
                getIDList().clear();
                getIDList().addAll((Collection<? extends org.scilab.modules.types.ScilabDouble>)newValue);
                return;
            case SystemPackage.SCSOPT__CMAP:
                setCMap((org.scilab.modules.types.ScilabDouble)newValue);
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
            case SystemPackage.SCSOPT__3D:
                get_3DList().clear();
                return;
            case SystemPackage.SCSOPT__BACKGROUND:
                setBackground(BACKGROUND_EDEFAULT);
                return;
            case SystemPackage.SCSOPT__LINK:
                setLink(LINK_EDEFAULT);
                return;
            case SystemPackage.SCSOPT__ID:
                getIDList().clear();
                return;
            case SystemPackage.SCSOPT__CMAP:
                setCMap(CMAP_EDEFAULT);
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
            case SystemPackage.SCSOPT__3D:
                return _3D != null && !_3D.isEmpty();
            case SystemPackage.SCSOPT__BACKGROUND:
                return BACKGROUND_EDEFAULT == null ? background != null : !BACKGROUND_EDEFAULT.equals(background);
            case SystemPackage.SCSOPT__LINK:
                return LINK_EDEFAULT == null ? link != null : !LINK_EDEFAULT.equals(link);
            case SystemPackage.SCSOPT__ID:
                return id != null && !id.isEmpty();
            case SystemPackage.SCSOPT__CMAP:
                return CMAP_EDEFAULT == null ? cMap != null : !CMAP_EDEFAULT.equals(cMap);
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
        result.append(" (_3D: ");
        result.append(_3D);
        result.append(", Background: ");
        result.append(background);
        result.append(", Link: ");
        result.append(link);
        result.append(", ID: ");
        result.append(id);
        result.append(", CMap: ");
        result.append(cMap);
        result.append(')');
        return result.toString();
    }

} //ScsoptImpl

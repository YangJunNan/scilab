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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.scilab.modules.xcos.modeling.system.Params;
import org.scilab.modules.xcos.modeling.system.Scsopt;
import org.scilab.modules.xcos.modeling.system.SystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Params</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl#getWpar <em>Wpar</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl#getTol <em>Tol</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl#getTf <em>Tf</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl#getVoid1 <em>Void1</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl#getVoid2 <em>Void2</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl#getVoid3 <em>Void3</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.ParamsImpl#getDocList <em>Doc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParamsImpl extends MinimalEObjectImpl.Container implements Params {
    /**
     * The default value of the '{@link #getWpar() <em>Wpar</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWpar()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble WPAR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getWpar() <em>Wpar</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWpar()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble wpar = WPAR_EDEFAULT;

    /**
     * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTitle()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabString TITLE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTitle()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabString title = TITLE_EDEFAULT;

    /**
     * The default value of the '{@link #getTol() <em>Tol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTol()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble TOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTol() <em>Tol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTol()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble tol = TOL_EDEFAULT;

    /**
     * The default value of the '{@link #getTf() <em>Tf</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTf()
     * @generated
     * @ordered
     */
    protected static final double TF_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getTf() <em>Tf</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTf()
     * @generated
     * @ordered
     */
    protected double tf = TF_EDEFAULT;

    /**
     * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContext()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabString CONTEXT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContext()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabString context = CONTEXT_EDEFAULT;

    /**
     * The default value of the '{@link #getVoid1() <em>Void1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVoid1()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble VOID1_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVoid1() <em>Void1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVoid1()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble void1 = VOID1_EDEFAULT;

    /**
     * The cached value of the '{@link #getOptions() <em>Options</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOptions()
     * @generated
     * @ordered
     */
    protected Scsopt options;

    /**
     * The default value of the '{@link #getVoid2() <em>Void2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVoid2()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble VOID2_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVoid2() <em>Void2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVoid2()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble void2 = VOID2_EDEFAULT;

    /**
     * The default value of the '{@link #getVoid3() <em>Void3</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVoid3()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabDouble VOID3_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVoid3() <em>Void3</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVoid3()
     * @generated
     * @ordered
     */
    protected org.scilab.modules.types.ScilabDouble void3 = VOID3_EDEFAULT;

    /**
     * The cached value of the '{@link #getDocList() <em>Doc</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDocList()
     * @generated
     * @ordered
     */
    protected EList<org.scilab.modules.types.ScilabType> doc;

    /**
     * The empty value for the '{@link #getDoc() <em>Doc</em>}' array accessor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDoc()
     * @generated
     * @ordered
     */
    protected static final org.scilab.modules.types.ScilabType[] DOC_EEMPTY_ARRAY = new org.scilab.modules.types.ScilabType [0];

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ParamsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.PARAMS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getWpar() {
        return wpar;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWpar(org.scilab.modules.types.ScilabDouble newWpar) {
        org.scilab.modules.types.ScilabDouble oldWpar = wpar;
        wpar = newWpar;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.PARAMS__WPAR, oldWpar, wpar));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabString getTitle() {
        return title;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTitle(org.scilab.modules.types.ScilabString newTitle) {
        org.scilab.modules.types.ScilabString oldTitle = title;
        title = newTitle;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.PARAMS__TITLE, oldTitle, title));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getTol() {
        return tol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTol(org.scilab.modules.types.ScilabDouble newTol) {
        org.scilab.modules.types.ScilabDouble oldTol = tol;
        tol = newTol;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.PARAMS__TOL, oldTol, tol));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getTf() {
        return tf;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTf(double newTf) {
        double oldTf = tf;
        tf = newTf;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.PARAMS__TF, oldTf, tf));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabString getContext() {
        return context;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContext(org.scilab.modules.types.ScilabString newContext) {
        org.scilab.modules.types.ScilabString oldContext = context;
        context = newContext;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.PARAMS__CONTEXT, oldContext, context));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getVoid1() {
        return void1;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVoid1(org.scilab.modules.types.ScilabDouble newVoid1) {
        org.scilab.modules.types.ScilabDouble oldVoid1 = void1;
        void1 = newVoid1;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.PARAMS__VOID1, oldVoid1, void1));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Scsopt getOptions() {
        if (options != null && options.eIsProxy()) {
            InternalEObject oldOptions = (InternalEObject)options;
            options = (Scsopt)eResolveProxy(oldOptions);
            if (options != oldOptions) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.PARAMS__OPTIONS, oldOptions, options));
                }
            }
        }
        return options;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Scsopt basicGetOptions() {
        return options;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOptions(Scsopt newOptions) {
        Scsopt oldOptions = options;
        options = newOptions;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.PARAMS__OPTIONS, oldOptions, options));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getVoid2() {
        return void2;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVoid2(org.scilab.modules.types.ScilabDouble newVoid2) {
        org.scilab.modules.types.ScilabDouble oldVoid2 = void2;
        void2 = newVoid2;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.PARAMS__VOID2, oldVoid2, void2));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabDouble getVoid3() {
        return void3;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVoid3(org.scilab.modules.types.ScilabDouble newVoid3) {
        org.scilab.modules.types.ScilabDouble oldVoid3 = void3;
        void3 = newVoid3;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.PARAMS__VOID3, oldVoid3, void3));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType[] getDoc() {
        if (doc == null || doc.isEmpty()) {
            return DOC_EEMPTY_ARRAY;
        }
        BasicEList<org.scilab.modules.types.ScilabType> list = (BasicEList<org.scilab.modules.types.ScilabType>)doc;
        list.shrink();
        return (org.scilab.modules.types.ScilabType[])list.data();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.scilab.modules.types.ScilabType getDoc(int index) {
        return getDocList().get(index);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getDocLength() {
        return doc == null ? 0 : doc.size();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDoc(org.scilab.modules.types.ScilabType[] newDoc) {
        ((BasicEList<org.scilab.modules.types.ScilabType>)getDocList()).setData(newDoc.length, newDoc);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDoc(int index, org.scilab.modules.types.ScilabType element) {
        getDocList().set(index, element);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<org.scilab.modules.types.ScilabType> getDocList() {
        if (doc == null) {
            doc = new EDataTypeUniqueEList<org.scilab.modules.types.ScilabType>(org.scilab.modules.types.ScilabType.class, this, SystemPackage.PARAMS__DOC);
        }
        return doc;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SystemPackage.PARAMS__WPAR:
                return getWpar();
            case SystemPackage.PARAMS__TITLE:
                return getTitle();
            case SystemPackage.PARAMS__TOL:
                return getTol();
            case SystemPackage.PARAMS__TF:
                return getTf();
            case SystemPackage.PARAMS__CONTEXT:
                return getContext();
            case SystemPackage.PARAMS__VOID1:
                return getVoid1();
            case SystemPackage.PARAMS__OPTIONS:
                if (resolve) {
                    return getOptions();
                }
                return basicGetOptions();
            case SystemPackage.PARAMS__VOID2:
                return getVoid2();
            case SystemPackage.PARAMS__VOID3:
                return getVoid3();
            case SystemPackage.PARAMS__DOC:
                return getDocList();
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
            case SystemPackage.PARAMS__WPAR:
                setWpar((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.PARAMS__TITLE:
                setTitle((org.scilab.modules.types.ScilabString)newValue);
                return;
            case SystemPackage.PARAMS__TOL:
                setTol((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.PARAMS__TF:
                setTf((Double)newValue);
                return;
            case SystemPackage.PARAMS__CONTEXT:
                setContext((org.scilab.modules.types.ScilabString)newValue);
                return;
            case SystemPackage.PARAMS__VOID1:
                setVoid1((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.PARAMS__OPTIONS:
                setOptions((Scsopt)newValue);
                return;
            case SystemPackage.PARAMS__VOID2:
                setVoid2((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.PARAMS__VOID3:
                setVoid3((org.scilab.modules.types.ScilabDouble)newValue);
                return;
            case SystemPackage.PARAMS__DOC:
                getDocList().clear();
                getDocList().addAll((Collection<? extends org.scilab.modules.types.ScilabType>)newValue);
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
            case SystemPackage.PARAMS__WPAR:
                setWpar(WPAR_EDEFAULT);
                return;
            case SystemPackage.PARAMS__TITLE:
                setTitle(TITLE_EDEFAULT);
                return;
            case SystemPackage.PARAMS__TOL:
                setTol(TOL_EDEFAULT);
                return;
            case SystemPackage.PARAMS__TF:
                setTf(TF_EDEFAULT);
                return;
            case SystemPackage.PARAMS__CONTEXT:
                setContext(CONTEXT_EDEFAULT);
                return;
            case SystemPackage.PARAMS__VOID1:
                setVoid1(VOID1_EDEFAULT);
                return;
            case SystemPackage.PARAMS__OPTIONS:
                setOptions((Scsopt)null);
                return;
            case SystemPackage.PARAMS__VOID2:
                setVoid2(VOID2_EDEFAULT);
                return;
            case SystemPackage.PARAMS__VOID3:
                setVoid3(VOID3_EDEFAULT);
                return;
            case SystemPackage.PARAMS__DOC:
                getDocList().clear();
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
            case SystemPackage.PARAMS__WPAR:
                return WPAR_EDEFAULT == null ? wpar != null : !WPAR_EDEFAULT.equals(wpar);
            case SystemPackage.PARAMS__TITLE:
                return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
            case SystemPackage.PARAMS__TOL:
                return TOL_EDEFAULT == null ? tol != null : !TOL_EDEFAULT.equals(tol);
            case SystemPackage.PARAMS__TF:
                return tf != TF_EDEFAULT;
            case SystemPackage.PARAMS__CONTEXT:
                return CONTEXT_EDEFAULT == null ? context != null : !CONTEXT_EDEFAULT.equals(context);
            case SystemPackage.PARAMS__VOID1:
                return VOID1_EDEFAULT == null ? void1 != null : !VOID1_EDEFAULT.equals(void1);
            case SystemPackage.PARAMS__OPTIONS:
                return options != null;
            case SystemPackage.PARAMS__VOID2:
                return VOID2_EDEFAULT == null ? void2 != null : !VOID2_EDEFAULT.equals(void2);
            case SystemPackage.PARAMS__VOID3:
                return VOID3_EDEFAULT == null ? void3 != null : !VOID3_EDEFAULT.equals(void3);
            case SystemPackage.PARAMS__DOC:
                return doc != null && !doc.isEmpty();
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
        result.append(" (wpar: ");
        result.append(wpar);
        result.append(", Title: ");
        result.append(title);
        result.append(", tol: ");
        result.append(tol);
        result.append(", tf: ");
        result.append(tf);
        result.append(", context: ");
        result.append(context);
        result.append(", void1: ");
        result.append(void1);
        result.append(", void2: ");
        result.append(void2);
        result.append(", void3: ");
        result.append(void3);
        result.append(", doc: ");
        result.append(doc);
        result.append(')');
        return result.toString();
    }

} //ParamsImpl

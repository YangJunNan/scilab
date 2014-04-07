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
import org.scilab.modules.xcos.modeling.system.Block;
import org.scilab.modules.xcos.modeling.system.Graphics;
import org.scilab.modules.xcos.modeling.system.Model;
import org.scilab.modules.xcos.modeling.system.SystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.BlockImpl#getGui <em>Gui</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.BlockImpl#getGraphics <em>Graphics</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.BlockImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.scilab.modules.xcos.modeling.system.impl.BlockImpl#getDocList <em>Doc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockImpl extends MinimalEObjectImpl.Container implements Block {
    /**
     * The default value of the '{@link #getGui() <em>Gui</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGui()
     * @generated
     * @ordered
     */
    protected static final String GUI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getGui() <em>Gui</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGui()
     * @generated
     * @ordered
     */
    protected String gui = GUI_EDEFAULT;

    /**
     * The cached value of the '{@link #getGraphics() <em>Graphics</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGraphics()
     * @generated
     * @ordered
     */
    protected Graphics graphics;

    /**
     * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModel()
     * @generated
     * @ordered
     */
    protected Model model;

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
    public BlockImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.BLOCK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getGui() {
        return gui;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGui(String newGui) {
        String oldGui = gui;
        gui = newGui;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.BLOCK__GUI, oldGui, gui));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Graphics getGraphics() {
        if (graphics != null && graphics.eIsProxy()) {
            InternalEObject oldGraphics = (InternalEObject)graphics;
            graphics = (Graphics)eResolveProxy(oldGraphics);
            if (graphics != oldGraphics) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.BLOCK__GRAPHICS, oldGraphics, graphics));
                }
            }
        }
        return graphics;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Graphics basicGetGraphics() {
        return graphics;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGraphics(Graphics newGraphics) {
        Graphics oldGraphics = graphics;
        graphics = newGraphics;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.BLOCK__GRAPHICS, oldGraphics, graphics));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Model getModel() {
        if (model != null && model.eIsProxy()) {
            InternalEObject oldModel = (InternalEObject)model;
            model = (Model)eResolveProxy(oldModel);
            if (model != oldModel) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.BLOCK__MODEL, oldModel, model));
                }
            }
        }
        return model;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Model basicGetModel() {
        return model;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setModel(Model newModel) {
        Model oldModel = model;
        model = newModel;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.BLOCK__MODEL, oldModel, model));
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
            doc = new EDataTypeUniqueEList<org.scilab.modules.types.ScilabType>(org.scilab.modules.types.ScilabType.class, this, SystemPackage.BLOCK__DOC);
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
            case SystemPackage.BLOCK__GUI:
                return getGui();
            case SystemPackage.BLOCK__GRAPHICS:
                if (resolve) {
                    return getGraphics();
                }
                return basicGetGraphics();
            case SystemPackage.BLOCK__MODEL:
                if (resolve) {
                    return getModel();
                }
                return basicGetModel();
            case SystemPackage.BLOCK__DOC:
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
            case SystemPackage.BLOCK__GUI:
                setGui((String)newValue);
                return;
            case SystemPackage.BLOCK__GRAPHICS:
                setGraphics((Graphics)newValue);
                return;
            case SystemPackage.BLOCK__MODEL:
                setModel((Model)newValue);
                return;
            case SystemPackage.BLOCK__DOC:
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
            case SystemPackage.BLOCK__GUI:
                setGui(GUI_EDEFAULT);
                return;
            case SystemPackage.BLOCK__GRAPHICS:
                setGraphics((Graphics)null);
                return;
            case SystemPackage.BLOCK__MODEL:
                setModel((Model)null);
                return;
            case SystemPackage.BLOCK__DOC:
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
            case SystemPackage.BLOCK__GUI:
                return GUI_EDEFAULT == null ? gui != null : !GUI_EDEFAULT.equals(gui);
            case SystemPackage.BLOCK__GRAPHICS:
                return graphics != null;
            case SystemPackage.BLOCK__MODEL:
                return model != null;
            case SystemPackage.BLOCK__DOC:
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
        result.append(" (gui: ");
        result.append(gui);
        result.append(", doc: ");
        result.append(doc);
        result.append(')');
        return result.toString();
    }

} //BlockImpl

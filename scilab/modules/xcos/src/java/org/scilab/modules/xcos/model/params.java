/*
 * Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
 * Copyright (C) 2014 - Scilab Enterprises - Clement DAVID
 *
 * This file must be used under the terms of the CeCILL.
 * This source file is licensed as described in the file COPYING, which
 * you should have received as part of this distribution.  The terms
 * are also available at
 * http://www.cecill.info/licences/Licence_CeCILL_V2.1-en.txt
 *
 */

package org.scilab.modules.xcos.model;

import java.util.ArrayList;

public class params {
    private double[] wpar;
    private String title;
    private double tf;
    private double tol;
    private String[] context;
    private Object options;
    private ArrayList<Object> doc;

    /**
     * @param wpar
     * @param title
     * @param tf
     * @param tol
     * @param context
     * @param options
     * @param doc
     */
    public params(double[] wpar, String title, double tf, double tol, String[] context, Object options, ArrayList<Object> doc) {
        this.wpar = wpar;
        this.title = title;
        this.tf = tf;
        this.tol = tol;
        this.context = context;
        this.options = options;
        this.doc = doc;
    }

    /**
     * @return the wpar
     */
    public double[] getWpar() {
        return wpar;
    }

    /**
     * @param wpar the wpar to set
     */
    public void setWpar(double[] wpar) {
        this.wpar = wpar;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the tf
     */
    public double getTf() {
        return tf;
    }

    /**
     * @param tf the tf to set
     */
    public void setTf(double tf) {
        this.tf = tf;
    }

    /**
     * @return the tol
     */
    public double getTol() {
        return tol;
    }

    /**
     * @param tol the tol to set
     */
    public void setTol(double tol) {
        this.tol = tol;
    }

    /**
     * @return the context
     */
    public String[] getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(String[] context) {
        this.context = context;
    }

    /**
     * @return the options
     */
    public Object getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(Object options) {
        this.options = options;
    }

    /**
     * @return the doc
     */
    public ArrayList<Object> getDoc() {
        return doc;
    }

    /**
     * @param doc the doc to set
     */
    public void setDoc(ArrayList<Object> doc) {
        this.doc = doc;
    }
}

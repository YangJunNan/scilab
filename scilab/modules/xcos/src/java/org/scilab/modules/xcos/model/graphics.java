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

public class graphics {
    private double[] orig;
    private double[] sz;
    private boolean flip;
    private double theta;
    private String exprs;
    private double[] pin;
    private double[] pout;
    private double[] pein;
    private double[] peout;
    private double[] gr_i;
    private String id;
    private String[] in_implicit;
    private String[] out_implicit;
    private String[] in_style;
    private String[] out_style;
    private String[] in_label;
    private String[] out_label;
    private String[] style;

    /**
     * @param orig
     * @param sz
     * @param flip
     * @param theta
     * @param exprs
     * @param pin
     * @param pout
     * @param pein
     * @param peout
     * @param gr_i
     * @param id
     * @param in_implicit
     * @param out_implicit
     * @param in_style
     * @param out_style
     * @param in_label
     * @param out_label
     * @param style
     */
    public graphics(double[] orig, double[] sz, boolean flip, double theta, String exprs, double[] pin, double[] pout, double[] pein, double[] peout,
                    double[] gr_i, String id, String[] in_implicit, String[] out_implicit, String[] in_style, String[] out_style, String[] in_label,
                    String[] out_label, String[] style) {
        this.orig = orig;
        this.sz = sz;
        this.flip = flip;
        this.theta = theta;
        this.exprs = exprs;
        this.pin = pin;
        this.pout = pout;
        this.pein = pein;
        this.peout = peout;
        this.gr_i = gr_i;
        this.id = id;
        this.in_implicit = in_implicit;
        this.out_implicit = out_implicit;
        this.in_style = in_style;
        this.out_style = out_style;
        this.in_label = in_label;
        this.out_label = out_label;
        this.style = style;
    }

    /**
     * @return the orig
     */
    public double[] getOrig() {
        return orig;
    }
    /**
     * @param orig the orig to set
     */
    public void setOrig(double[] orig) {
        this.orig = orig;
    }
    /**
     * @return the sz
     */
    public double[] getSz() {
        return sz;
    }
    /**
     * @param sz the sz to set
     */
    public void setSz(double[] sz) {
        this.sz = sz;
    }
    /**
     * @return the flip
     */
    public boolean isFlip() {
        return flip;
    }
    /**
     * @param flip the flip to set
     */
    public void setFlip(boolean flip) {
        this.flip = flip;
    }
    /**
     * @return the theta
     */
    public double getTheta() {
        return theta;
    }
    /**
     * @param theta the theta to set
     */
    public void setTheta(double theta) {
        this.theta = theta;
    }
    /**
     * @return the exprs
     */
    public String getExprs() {
        return exprs;
    }
    /**
     * @param exprs the exprs to set
     */
    public void setExprs(String exprs) {
        this.exprs = exprs;
    }
    /**
     * @return the pin
     */
    public double[] getPin() {
        return pin;
    }
    /**
     * @param pin the pin to set
     */
    public void setPin(double[] pin) {
        this.pin = pin;
    }
    /**
     * @return the pout
     */
    public double[] getPout() {
        return pout;
    }
    /**
     * @param pout the pout to set
     */
    public void setPout(double[] pout) {
        this.pout = pout;
    }
    /**
     * @return the pein
     */
    public double[] getPein() {
        return pein;
    }
    /**
     * @param pein the pein to set
     */
    public void setPein(double[] pein) {
        this.pein = pein;
    }
    /**
     * @return the peout
     */
    public double[] getPeout() {
        return peout;
    }
    /**
     * @param peout the peout to set
     */
    public void setPeout(double[] peout) {
        this.peout = peout;
    }
    /**
     * @return the gr_i
     */
    public double[] getGr_i() {
        return gr_i;
    }
    /**
     * @param gr_i the gr_i to set
     */
    public void setGr_i(double[] gr_i) {
        this.gr_i = gr_i;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the in_implicit
     */
    public String[] getIn_implicit() {
        return in_implicit;
    }
    /**
     * @param in_implicit the in_implicit to set
     */
    public void setIn_implicit(String[] in_implicit) {
        this.in_implicit = in_implicit;
    }
    /**
     * @return the out_implicit
     */
    public String[] getOut_implicit() {
        return out_implicit;
    }
    /**
     * @param out_implicit the out_implicit to set
     */
    public void setOut_implicit(String[] out_implicit) {
        this.out_implicit = out_implicit;
    }
    /**
     * @return the in_style
     */
    public String[] getIn_style() {
        return in_style;
    }
    /**
     * @param in_style the in_style to set
     */
    public void setIn_style(String[] in_style) {
        this.in_style = in_style;
    }
    /**
     * @return the out_style
     */
    public String[] getOut_style() {
        return out_style;
    }
    /**
     * @param out_style the out_style to set
     */
    public void setOut_style(String[] out_style) {
        this.out_style = out_style;
    }
    /**
     * @return the in_label
     */
    public String[] getIn_label() {
        return in_label;
    }
    /**
     * @param in_label the in_label to set
     */
    public void setIn_label(String[] in_label) {
        this.in_label = in_label;
    }
    /**
     * @return the out_label
     */
    public String[] getOut_label() {
        return out_label;
    }
    /**
     * @param out_label the out_label to set
     */
    public void setOut_label(String[] out_label) {
        this.out_label = out_label;
    }
    /**
     * @return the style
     */
    public String[] getStyle() {
        return style;
    }
    /**
     * @param style the style to set
     */
    public void setStyle(String[] style) {
        this.style = style;
    }
}

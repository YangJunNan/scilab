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

public final class xcs {
    private double[] x;
    private double[] z;
    private ArrayList<Object> oz;
    private double[] iz;
    private double[] tevts;
    private double[] evtspt;
    private double[] pointi;
    private ArrayList<Object> outtbb;

    /**
     * @param x
     * @param z
     * @param oz
     * @param iz
     * @param tevts
     * @param evtspt
     * @param pointi
     * @param outtbb
     */
    public xcs(double[] x, double[] z, ArrayList<Object> oz, double[] iz, double[] tevts, double[] evtspt, double[] pointi, ArrayList<Object> outtbb) {
        this.x = x;
        this.z = z;
        this.oz = oz;
        this.iz = iz;
        this.tevts = tevts;
        this.evtspt = evtspt;
        this.pointi = pointi;
        this.outtbb = outtbb;
    }

    /**
     * @return the x
     */
    public double[] getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double[] x) {
        this.x = x;
    }

    /**
     * @return the z
     */
    public double[] getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(double[] z) {
        this.z = z;
    }

    /**
     * @return the oz
     */
    public ArrayList<Object> getOz() {
        return oz;
    }

    /**
     * @param oz the oz to set
     */
    public void setOz(ArrayList<Object> oz) {
        this.oz = oz;
    }

    /**
     * @return the iz
     */
    public double[] getIz() {
        return iz;
    }

    /**
     * @param iz the iz to set
     */
    public void setIz(double[] iz) {
        this.iz = iz;
    }

    /**
     * @return the tevts
     */
    public double[] getTevts() {
        return tevts;
    }

    /**
     * @param tevts the tevts to set
     */
    public void setTevts(double[] tevts) {
        this.tevts = tevts;
    }

    /**
     * @return the evtspt
     */
    public double[] getEvtspt() {
        return evtspt;
    }

    /**
     * @param evtspt the evtspt to set
     */
    public void setEvtspt(double[] evtspt) {
        this.evtspt = evtspt;
    }

    /**
     * @return the pointi
     */
    public double[] getPointi() {
        return pointi;
    }

    /**
     * @param pointi the pointi to set
     */
    public void setPointi(double[] pointi) {
        this.pointi = pointi;
    }

    /**
     * @return the outtbb
     */
    public ArrayList<Object> getOuttbb() {
        return outtbb;
    }

    /**
     * @param outtbb the outtbb to set
     */
    public void setOuttbb(ArrayList<Object> outtbb) {
        this.outtbb = outtbb;
    }
}

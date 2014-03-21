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

public final class Link {
    private double[] xx;
    private double[] yy;
    private String id;
    private double[] thick;
    private double[] ct;
    private double[] from;
    private double[] to;

    /**
     * @param xx
     * @param yy
     * @param id
     * @param thick
     * @param ct
     * @param from
     * @param to
     */
    public Link(double[] xx, double[] yy, String id, double[] thick, double[] ct, double[] from, double[] to) {
        this.xx = xx;
        this.yy = yy;
        this.id = id;
        this.thick = thick;
        this.ct = ct;
        this.from = from;
        this.to = to;
    }

    /**
     * @return the xx
     */
    public double[] getXx() {
        return xx;
    }

    /**
     * @param xx the xx to set
     */
    public void setXx(double[] xx) {
        this.xx = xx;
    }

    /**
     * @return the yy
     */
    public double[] getYy() {
        return yy;
    }

    /**
     * @param yy the yy to set
     */
    public void setYy(double[] yy) {
        this.yy = yy;
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
     * @return the thick
     */
    public double[] getThick() {
        return thick;
    }

    /**
     * @param thick the thick to set
     */
    public void setThick(double[] thick) {
        this.thick = thick;
    }

    /**
     * @return the ct
     */
    public double[] getCt() {
        return ct;
    }

    /**
     * @param ct the ct to set
     */
    public void setCt(double[] ct) {
        this.ct = ct;
    }

    /**
     * @return the from
     */
    public double[] getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(double[] from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public double[] getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(double[] to) {
        this.to = to;
    }


}

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

public class scsopt {
    private ArrayList<Object> _3D;
    private double[] Background;
    private double[] Link;
    private ArrayList<Object> ID;
    private double[] col3d;

    /**
     * Default constructor
     */
    public scsopt() {
    }

    /**
     * @param _3d
     * @param background
     * @param link
     * @param iD
     * @param col3d
     */
    public scsopt(ArrayList<Object> _3d, double[] background, double[] link, ArrayList<Object> iD, double[] col3d) {
        _3D = _3d;
        Background = background;
        Link = link;
        ID = iD;
        this.col3d = col3d;
    }

    /**
     * @return the _3D
     */
    public ArrayList<Object> get3D() {
        return _3D;
    }

    /**
     * @param _3d the _3D to set
     */
    public void set3D(ArrayList<Object> _3d) {
        _3D = _3d;
    }

    /**
     * @return the background
     */
    public double[] getBackground() {
        return Background;
    }

    /**
     * @param background the background to set
     */
    public void setBackground(double[] background) {
        Background = background;
    }

    /**
     * @return the link
     */
    public double[] getLink() {
        return Link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(double[] link) {
        Link = link;
    }

    /**
     * @return the iD
     */
    public ArrayList<Object> getID() {
        return ID;
    }

    /**
     * @param iD the iD to set
     */
    public void setID(ArrayList<Object> iD) {
        ID = iD;
    }

    /**
     * @return the col3d
     */
    public double[] getCol3d() {
        return col3d;
    }

    /**
     * @param col3d the col3d to set
     */
    public void setCol3d(double[] col3d) {
        this.col3d = col3d;
    }
}

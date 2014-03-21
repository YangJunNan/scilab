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

public final class diagram {
    private params props;
    private ArrayList<Object> objs;
    private String version;
    private ArrayList<Object> contrib;

    public diagram(params props, ArrayList<Object> objs, String version, ArrayList<Object> contrib) {
        this.props = props;
        this.objs = objs;
        this.version = version;
        this.contrib = contrib;
    }

    /**
     * @return the props
     */
    public params getProps() {
        return props;
    }

    /**
     * @param props the props to set
     */
    public void setProps(params props) {
        this.props = props;
    }

    /**
     * @return the objs
     */
    public ArrayList<Object> getObjs() {
        return objs;
    }

    /**
     * @param objs the objs to set
     */
    public void setObjs(ArrayList<Object> objs) {
        this.objs = objs;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the contrib
     */
    public ArrayList<Object> getContrib() {
        return contrib;
    }

    /**
     * @param contrib the contrib to set
     */
    public void setContrib(ArrayList<Object> contrib) {
        this.contrib = contrib;
    }
}

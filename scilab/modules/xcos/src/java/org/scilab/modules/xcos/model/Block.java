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

public final class Block {
    private graphics graphics;
    private model model;
    private String gui;
    private ArrayList<Object> doc;

    /**
     * @param graphics
     * @param model
     * @param gui
     * @param doc
     */
    public Block(org.scilab.modules.xcos.model.graphics graphics, org.scilab.modules.xcos.model.model model, String gui, ArrayList<Object> doc) {
        this.graphics = graphics;
        this.model = model;
        this.gui = gui;
        this.doc = doc;
    }

    /**
     * @return the graphics
     */
    public graphics getGraphics() {
        return graphics;
    }

    /**
     * @param graphics the graphics to set
     */
    public void setGraphics(graphics graphics) {
        this.graphics = graphics;
    }

    /**
     * @return the model
     */
    public model getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(model model) {
        this.model = model;
    }

    /**
     * @return the gui
     */
    public String getGui() {
        return gui;
    }

    /**
     * @param gui the gui to set
     */
    public void setGui(String gui) {
        this.gui = gui;
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

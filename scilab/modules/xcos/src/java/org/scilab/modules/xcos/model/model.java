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

public class model {
    private ArrayList<Object> sim;
    private double[] in;
    private double[] in2;
    private double[] intyp;
    private double[] out;
    private double[] out2;
    private double[] outtyp;
    private double[] evtin;
    private double[] evtout;
    private double[] state;
    private double[] dstate;
    private ArrayList<Object> odstate;
    private ArrayList<Object> opar;
    private double[] rpar;
    private double[] ipar;
    private String blocktype;
    private double[] firing;
    private boolean[] dep_ut;
    private String label;
    private double nzcross;
    private double nmode;
    private ArrayList<Object> equations;
    private String uid;

    /**
     * @param sim
     * @param in
     * @param in2
     * @param intyp
     * @param out
     * @param out2
     * @param outtyp
     * @param evtin
     * @param evtout
     * @param state
     * @param dstate
     * @param odstate
     * @param opar
     * @param rpar
     * @param ipar
     * @param blocktype
     * @param firing
     * @param dep_ut
     * @param label
     * @param nzcross
     * @param nmode
     * @param equations
     * @param uid
     */
    public model(ArrayList<Object> sim, double[] in, double[] in2, double[] intyp, double[] out, double[] out2, double[] outtyp, double[] evtin,
                 double[] evtout, double[] state, double[] dstate, ArrayList<Object> odstate, ArrayList<Object> opar, double[] rpar, double[] ipar,
                 String blocktype, double[] firing, boolean[] dep_ut, String label, double nzcross, double nmode, ArrayList<Object> equations, String uid) {
        this.sim = sim;
        this.in = in;
        this.in2 = in2;
        this.intyp = intyp;
        this.out = out;
        this.out2 = out2;
        this.outtyp = outtyp;
        this.evtin = evtin;
        this.evtout = evtout;
        this.state = state;
        this.dstate = dstate;
        this.odstate = odstate;
        this.opar = opar;
        this.rpar = rpar;
        this.ipar = ipar;
        this.blocktype = blocktype;
        this.firing = firing;
        this.dep_ut = dep_ut;
        this.label = label;
        this.nzcross = nzcross;
        this.nmode = nmode;
        this.equations = equations;
        this.uid = uid;
    }

    /**
     * @return the sim
     */
    public ArrayList<Object> getSim() {
        return sim;
    }
    /**
     * @param sim the sim to set
     */
    public void setSim(ArrayList<Object> sim) {
        this.sim = sim;
    }
    /**
     * @return the in
     */
    public double[] getIn() {
        return in;
    }
    /**
     * @param in the in to set
     */
    public void setIn(double[] in) {
        this.in = in;
    }
    /**
     * @return the in2
     */
    public double[] getIn2() {
        return in2;
    }
    /**
     * @param in2 the in2 to set
     */
    public void setIn2(double[] in2) {
        this.in2 = in2;
    }
    /**
     * @return the intyp
     */
    public double[] getIntyp() {
        return intyp;
    }
    /**
     * @param intyp the intyp to set
     */
    public void setIntyp(double[] intyp) {
        this.intyp = intyp;
    }
    /**
     * @return the out
     */
    public double[] getOut() {
        return out;
    }
    /**
     * @param out the out to set
     */
    public void setOut(double[] out) {
        this.out = out;
    }
    /**
     * @return the out2
     */
    public double[] getOut2() {
        return out2;
    }
    /**
     * @param out2 the out2 to set
     */
    public void setOut2(double[] out2) {
        this.out2 = out2;
    }
    /**
     * @return the outtyp
     */
    public double[] getOuttyp() {
        return outtyp;
    }
    /**
     * @param outtyp the outtyp to set
     */
    public void setOuttyp(double[] outtyp) {
        this.outtyp = outtyp;
    }
    /**
     * @return the evtin
     */
    public double[] getEvtin() {
        return evtin;
    }
    /**
     * @param evtin the evtin to set
     */
    public void setEvtin(double[] evtin) {
        this.evtin = evtin;
    }
    /**
     * @return the evtout
     */
    public double[] getEvtout() {
        return evtout;
    }
    /**
     * @param evtout the evtout to set
     */
    public void setEvtout(double[] evtout) {
        this.evtout = evtout;
    }
    /**
     * @return the state
     */
    public double[] getState() {
        return state;
    }
    /**
     * @param state the state to set
     */
    public void setState(double[] state) {
        this.state = state;
    }
    /**
     * @return the dstate
     */
    public double[] getDstate() {
        return dstate;
    }
    /**
     * @param dstate the dstate to set
     */
    public void setDstate(double[] dstate) {
        this.dstate = dstate;
    }
    /**
     * @return the odstate
     */
    public ArrayList<Object> getOdstate() {
        return odstate;
    }
    /**
     * @param odstate the odstate to set
     */
    public void setOdstate(ArrayList<Object> odstate) {
        this.odstate = odstate;
    }
    /**
     * @return the opar
     */
    public ArrayList<Object> getOpar() {
        return opar;
    }
    /**
     * @param opar the opar to set
     */
    public void setOpar(ArrayList<Object> opar) {
        this.opar = opar;
    }
    /**
     * @return the rpar
     */
    public double[] getRpar() {
        return rpar;
    }
    /**
     * @param rpar the rpar to set
     */
    public void setRpar(double[] rpar) {
        this.rpar = rpar;
    }
    /**
     * @return the ipar
     */
    public double[] getIpar() {
        return ipar;
    }
    /**
     * @param ipar the ipar to set
     */
    public void setIpar(double[] ipar) {
        this.ipar = ipar;
    }
    /**
     * @return the blocktype
     */
    public String getBlocktype() {
        return blocktype;
    }
    /**
     * @param blocktype the blocktype to set
     */
    public void setBlocktype(String blocktype) {
        this.blocktype = blocktype;
    }
    /**
     * @return the firing
     */
    public double[] getFiring() {
        return firing;
    }
    /**
     * @param firing the firing to set
     */
    public void setFiring(double[] firing) {
        this.firing = firing;
    }
    /**
     * @return the dep_ut
     */
    public boolean[] getDep_ut() {
        return dep_ut;
    }
    /**
     * @param dep_ut the dep_ut to set
     */
    public void setDep_ut(boolean[] dep_ut) {
        this.dep_ut = dep_ut;
    }
    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }
    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }
    /**
     * @return the nzcross
     */
    public double getNzcross() {
        return nzcross;
    }
    /**
     * @param nzcross the nzcross to set
     */
    public void setNzcross(double nzcross) {
        this.nzcross = nzcross;
    }
    /**
     * @return the nmode
     */
    public double getNmode() {
        return nmode;
    }
    /**
     * @param nmode the nmode to set
     */
    public void setNmode(double nmode) {
        this.nmode = nmode;
    }
    /**
     * @return the equations
     */
    public ArrayList<Object> getEquations() {
        return equations;
    }
    /**
     * @param equations the equations to set
     */
    public void setEquations(ArrayList<Object> equations) {
        this.equations = equations;
    }
    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }
    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
}

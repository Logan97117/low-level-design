package com.lowleveldesign.projects.atm.concrete;

import com.lowleveldesign.projects.atm.interfaces.State;

public abstract class StateBase implements State {
    protected ATM atm;
    public StateBase(ATM atm) {
        this.atm = atm;
    }
}

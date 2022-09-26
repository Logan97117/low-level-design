package com.lowleveldesign.projects.texteditor;

import java.util.ArrayList;
import java.util.List;

public class DllStateManager {
    private List<String> lines;
    public DllStateManager() {
        this.lines = new ArrayList<>();
    }

    public void restoreToPreviousState(Dll dll) {
        //Traverse the list and add contents from lines to DLL
    }

    public void storeState(Dll dll) {
        //store the lines of the dll here
    }
}

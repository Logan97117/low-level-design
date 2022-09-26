package com.lowleveldesign.projects.texteditor;

import java.util.ArrayList;
import java.util.List;

public class DllClipBoard {
    private List<String> clipboardContents;
    public DllClipBoard() {
        this.clipboardContents = new ArrayList<>();
    }

    public void setClipboardContents(Dll dll, int start, int end) {
        //copy the lines from start to end to clipboardContents
    }

    public void pasteContents(Dll dll, int position) {
        //paste the contents from position into the Dll
    }
}

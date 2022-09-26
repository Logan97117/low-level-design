package com.lowleveldesign.projects.texteditor.commands;


import com.lowleveldesign.projects.texteditor.Dll;

public class DisplayAllCommand extends Command{
    public DisplayAllCommand(RequestParams requestParams) {
        super(requestParams);
    }
    @Override
    public void execute(Dll dll) {
        //call display all on the DLL
        dll.displayAllContents();
    }
}

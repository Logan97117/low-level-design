package com.lowleveldesign.projects.texteditor.commands;


import com.lowleveldesign.projects.texteditor.Dll;

public class UndoCommand extends Command {
    public UndoCommand(RequestParams requestParams) {
        super(requestParams);
    }

    @Override
    public void execute(Dll dll) {
        dll.undo();
    }
}

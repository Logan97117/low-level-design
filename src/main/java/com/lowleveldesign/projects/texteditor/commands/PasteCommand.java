package com.lowleveldesign.projects.texteditor.commands;


import com.lowleveldesign.projects.texteditor.Dll;

public class PasteCommand extends Command {
    public PasteCommand(RequestParams requestParams) {
        super(requestParams);
    }

    @Override
    public void execute(Dll dll) {
        dll.paste(this.requestParams.position);
    }
}

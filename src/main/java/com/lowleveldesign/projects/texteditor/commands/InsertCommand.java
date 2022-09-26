package com.lowleveldesign.projects.texteditor.commands;


import com.lowleveldesign.projects.texteditor.Dll;

public class InsertCommand extends Command{
    public InsertCommand(RequestParams requestParams) {
        super(requestParams);
    }

    @Override
    public void execute(Dll dll) {
        dll.insert(this.requestParams.line, this.requestParams.position);
    }
}

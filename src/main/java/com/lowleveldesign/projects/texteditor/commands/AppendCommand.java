package com.lowleveldesign.projects.texteditor.commands;


import com.lowleveldesign.projects.texteditor.Dll;

public class AppendCommand extends Command{
    public AppendCommand(RequestParams requestParams) {
        super(requestParams);
    }

    @Override
    public void execute(Dll dll) {
        dll.appendLast(this.requestParams.line);
    }
}

package com.lowleveldesign.projects.texteditor.commands;

import com.lowleveldesign.projects.texteditor.Dll;

public class CopyCommand extends Command{
    private RequestParams requestParams;

    public CopyCommand(RequestParams requestParams) {
        super(requestParams);
    }

    @Override
    public void execute(Dll dll) {
        dll.copy(this.requestParams.start ,this.requestParams.end);
    }
}

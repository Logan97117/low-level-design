package com.lowleveldesign.projects.texteditor.commands;


import com.lowleveldesign.projects.texteditor.Dll;

public class DeleteCommand extends Command{
    public DeleteCommand(RequestParams requestParams) {
        super(requestParams);
    }

    @Override
    public void execute(Dll dll) {
        dll.delete(this.requestParams.start, this.requestParams.end);
    }
}

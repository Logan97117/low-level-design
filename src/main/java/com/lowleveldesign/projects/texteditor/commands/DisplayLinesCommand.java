package com.lowleveldesign.projects.texteditor.commands;


import com.lowleveldesign.projects.texteditor.Dll;

public class DisplayLinesCommand extends Command{
    public DisplayLinesCommand(RequestParams requestParams) {
        super(requestParams);
    }

    @Override
    public void execute(Dll dll) {
        dll.displayLines(this.requestParams.start, this.requestParams.end);
    }
}

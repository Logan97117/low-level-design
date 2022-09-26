package com.lowleveldesign.projects.texteditor;


import com.lowleveldesign.projects.texteditor.commands.RequestParams;
import com.lowleveldesign.projects.texteditor.enums.CommandType;

public class TextEditor {
    private CommandFactory commandFactory;
    public TextEditor() {
        this.commandFactory = new CommandFactory();
    }
    public void displayAll() {
        this.commandFactory.executeCommand(CommandType.DISPLAY_ALL, null);
    }

    public void displayLines(int n, int m) {
        RequestParams requestParams = new RequestParams();
        requestParams.start = n;
        requestParams.end = m;
        this.commandFactory.executeCommand(CommandType.DISPLAY_LINES, requestParams);
    }

    public void insert(String line, int position) {
        RequestParams requestParams = new RequestParams();
        requestParams.line = line;
        requestParams.position = position;
        this.commandFactory.executeCommand(CommandType.INSERT, requestParams);
    }

    public void delete(int position) {
        this.delete(position, position);
    }

    public void delete(int start, int end){
        RequestParams requestParams = new RequestParams();
        requestParams.start = start;
        requestParams.end = end;
        this.commandFactory.executeCommand(CommandType.DELETE, requestParams);
    }

    public void copy(int start, int end) {
        RequestParams requestParams = new RequestParams();
        requestParams.start = start;
        requestParams.end = end;
        this.commandFactory.executeCommand(CommandType.COPY, requestParams);
    }

    public void paste(int position) {
        RequestParams requestParams = new RequestParams();
        requestParams.position = position;
        this.commandFactory.executeCommand(CommandType.PASTE, requestParams);
    }

    public void undo() {
        this.commandFactory.executeCommand(CommandType.UNDO, null);
    }

    public void redo() {
        this.commandFactory.redo();
    }
}

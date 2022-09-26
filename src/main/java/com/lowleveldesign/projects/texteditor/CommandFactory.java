package com.lowleveldesign.projects.texteditor;

import com.lowleveldesign.projects.texteditor.commands.*;
import com.lowleveldesign.projects.texteditor.enums.CommandType;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Dll dll;
    private Map<CommandType, Command> map;
    private Command lastCommand;
    public CommandFactory() {
        this.map = new HashMap<>();
        this.dll = new Dll();
    }

    public void executeCommand(CommandType commandType, RequestParams requestParams) {
        Command command = this.createIfNull(commandType);
        command.setRequestParams(requestParams);
        command.execute(this.dll);
        this.lastCommand = command;
    }

    public void redo() {
        if(this.lastCommand == null)
            return;

        this.lastCommand.execute(dll);
    }

    private Command createIfNull(CommandType commandType) {
        Command command = this.map.get(commandType);

        if(command != null)
            return command;

        switch(commandType) {
            case COPY: {
                command = new CopyCommand(new RequestParams());
                break;
            }
            case PASTE: {
                command = new PasteCommand(new RequestParams());
                break;
            }
            case UNDO: {
                command = new UndoCommand(new RequestParams());
                break;
            }

            case APPEND: {
                command = new AppendCommand(new RequestParams());
                break;
            }

            case DELETE: {
                command = new DeleteCommand(new RequestParams());
                break;
            }

            case INSERT: {
                command = new InsertCommand(new RequestParams());
                break;
            }

            case DISPLAY_ALL: {
                command = new DisplayAllCommand(new RequestParams());
                break;
            }

            case DISPLAY_LINES: {
                command = new DisplayLinesCommand(new RequestParams());
                break;
            }

            default: {
                break;
            }
        }
        this.map.put(commandType, command);
        return command;
    }

    public void executeCommand(Command command) {
        command.execute(this.dll);
    }
}

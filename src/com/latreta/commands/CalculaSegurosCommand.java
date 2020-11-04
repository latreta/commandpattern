package com.latreta.commands;

import java.util.ArrayList;
import java.util.List;

// Invoker class
public class CalculaSegurosCommand implements Command {
    private List<Command> commands;
    private List<Command> executedCommands;

    public CalculaSegurosCommand(){
        this.commands = new ArrayList<>();
        this.executedCommands = new ArrayList<>();
    }

    public void adicionarCalculo(Command cmd){
        this.commands.add(cmd);
    }

    @Override
    public void execute() {
        for(Command cmd : commands) {
            cmd.execute();
            executedCommands.add(cmd);
        }
    }

    @Override
    public void undo() {
        for(Command cmd : executedCommands){
            cmd.undo();
        }
        executedCommands.clear();
    }
}

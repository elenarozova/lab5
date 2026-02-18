package main;

import commands.*;
import interfaces.Comands;

import java.util.HashMap;
import java.util.Map;

public class ParserManager {
    private Map<String, Comands> commands;
    public ParserManager(){
        commands = new HashMap<>();
        commands.put("help", new Helps());
        commands.put("exit", new Exit());
        commands.put("insert", new Insert());
        commands.put("show", new Show());
        commands.put("clear", new Clear());
        commands.put("update", new Update());
        commands.put("remove_key", new RemoveKey());
        commands.put("info", new Info());
    }
    public boolean parse(String line){
        String[] command = line.split(" ");
        if (commands.containsKey(command[0])){
            Comands com = commands.get(command[0]);
            com.implementCommand();
            return true;
        }
        else {
            return false;
        }
    }

    public Map<String, Comands> getCommands() {
        return commands;
    }
}

package commands;

import interfaces.Comands;
import program.Program;

public class Clear implements Comands {
    @Override
    public void implementCommand() {
        Program.colman.getLabWork().clear();
    }
    @Override
    public String toString(){
        return "Очищает словарь";
    }
}

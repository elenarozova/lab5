package commands;

import interfaces.Comands;
import program.Program;

public class Exit implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.closeScan();
        System.exit(0);
    }
    @Override
    public String toString(){
        return "Завершает программу";
    }
}

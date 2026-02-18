package commands;

import interfaces.Comands;
import program.Program;

public class Show implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.write("id | LabWork" );
        for (int i:Program.colman.getLabWork().keySet()){
            Program.inout.write("" +i+Program.colman.getLabWork().get(i).toString());
        }
    }
    @Override
    public String toString(){
        return "Выводит все элементы коллекции";
    }
}

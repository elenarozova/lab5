package commands;

import interfaces.Comands;
import program.Program;

public class Info implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.write("Тип коллекции: TreeMap");
        Program.inout.write("Количество элементов: " + Program.colman.getLabWork().size());
        Program.inout.write("Время создания коллекции: "+ Program.colman.getTime());
    }

    @Override
    public String toString(){
        return "Выводит информацию о коллекции";
    }
}

package commands;

import data.LabWork;
import interfaces.Comands;
import program.Program;

public class FilterLessThanMinimalPoint implements Comands {
    Double minPoint;
    @Override
    public void implementCommand() {
        Program.inout.write("Введите значения минимального значения:");
        while (true) {
            try {
                minPoint = Double.parseDouble(Program.inout.read());
                break;
            } catch (NumberFormatException e) {
                Program.inout.write("Значение должно быть double.");
            }
        }

        for (int i:Program.colman.getLabWork().keySet()){
            if (minPoint>Program.colman.getLabWork().get(i).getMinimalPoint()){
                Program.inout.write(Program.colman.getLabWork().get(i).toString());
            }
        }
    }

    @Override
    public String toString(){
        return "Выводит все элементы, у которых значения минимального значения меньше заданного ";
    }
}

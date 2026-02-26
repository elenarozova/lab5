package commands;

import data.LabWork;
import interfaces.Comands;
import main.CheckValues;
import program.Program;

/**
 * Команда для фильтрации элементов коллекции по полю minimalPoint.
 * Выводит все элементы, у которых значение minimalPoint меньше заданного.
 *
 * @author Елена
 * @see Comands
 * @see LabWork#getMinimalPoint()
 */

public class FilterLessThanMinimalPoint implements Comands {
    Double minPoint;
    @Override
    public void implementCommand() {
        Program.inout.write("Введите значения минимального значения:");
        while (true) {
            try {
                minPoint = Double.parseDouble(CheckValues.checkValuesNull("минимального значения"));
                for (int i:Program.colman.getLabWork().keySet()){
                    if (minPoint>Program.colman.getLabWork().get(i).getMinimalPoint()){
                        Program.inout.write(Program.colman.getLabWork().get(i).toString());
                    }
                }
                break;
            } catch (NumberFormatException e) {
                Program.inout.write("Значение должно быть double.");
            }
        }


    }

    @Override
    public String toString(){
        return "Выводит все элементы, у которых значения минимального значения меньше заданного ";
    }
}

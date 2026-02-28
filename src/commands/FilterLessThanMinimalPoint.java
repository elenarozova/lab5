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
    String testMin;
    @Override
    public void implementCommand(String[] args) {
        int lenght = args.length;
        while (true) {
            if (lenght == 0) {
                Program.inout.write("Введите значения минимального значения:");
                testMin = CheckValues.checkValuesNull("минимального значения");
            } else if (lenght == 1){
                testMin = args[0].trim();
            } else {
                Program.inout.write("Было введено больше одного параметра, все превышающие параметры не учитываются");
                testMin=args[0].trim();
            }

            try {
                minPoint = Double.parseDouble(testMin.replace(",","."));
                for (int i : Program.colman.getLabWork().keySet()) {
                    if (minPoint > Program.colman.getLabWork().get(i).getMinimalPoint()) {
                        Program.inout.write(Program.colman.getLabWork().get(i).toString());
                    }
                }
                break;
            } catch (NumberFormatException e) {
                Program.inout.write("Значение должно быть double.");
                lenght=0;
            }
        }
    }

    @Override
    public String toString(){
        return "Выводит все элементы, у которых значения минимального значения меньше заданного ";
    }
}

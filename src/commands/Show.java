package commands;

import interfaces.Comands;
import program.Program;

/**
 * Команда для отображения всех элементов коллекции.
 * Выводит каждый элемент коллекции в формате "ключ + строковое представление элемента".
 *
 * @author Елена
 * @see Comands
 * @see Program#colman
 * @see data.LabWork#toString()
 */

public class Show implements Comands {
    @Override
    public void implementCommand(String[] args) {
        if (args.length==0) {
            Program.inout.write("id | LabWork");
            for (int i : Program.colman.getLabWork().keySet()) {
                Program.inout.write("" + i + Program.colman.getLabWork().get(i).toString());
            }
        } else {
            Program.inout.write("У этой команды нет параметров");
        }
    }
    @Override
    public String toString(){
        return "Выводит все элементы коллекции";
    }

}

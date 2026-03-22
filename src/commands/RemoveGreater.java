package commands;

import data.LabWork;
import interfaces.Comands;
import program.Program;

import java.util.ArrayList;
import java.util.List;

/**
 * Команда для удаления всех элементов, которые больше заданного.
 * Пользователь вводит элемент, затем все элементы коллекции,
 * которые больше этого эталона (согласно {@link data.LabWork#compareTo}),
 * удаляются из коллекции.
 *
 * @author Елена
 * @see Comands
 * @see Insert
 * @see Program#colman
 */

public class RemoveGreater implements Comands {
    @Override
    public void implementCommand(String[] args) {
        if (args.length==0) {
            Program.inout.write("Введите элемент, с которым будут сравниваться другие");
            LabWork lab = new LabWork.Builder().doLab();
            List<Integer> keyS = new ArrayList<>(Program.colman.getLabWork().keySet());
            for (int i : keyS) {
                if (lab.compareTo(Program.colman.getLabWork().get(i)) < 0) {
                    Program.colman.getLabWork().remove(i);
                }
            }
            Program.inout.write("Все элементы, которые больше заданного, были удалены.");
        } else {Program.inout.write("У этой команды нет параметров");}
    }
    @Override
    public String toString(){return "Удаляет все элементы, которые больше заданного элемента";}
}

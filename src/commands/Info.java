package commands;

import interfaces.Comands;
import program.Program;

/**
 * Команда для вывода информации о коллекции.
 * Отображает тип коллекции, количество элементов и время её создания.
 *
 * @author Елена
 * @see Comands
 * @see Program#colman
 */

public class Info implements Comands {
    @Override
    public void implementCommand(String[] args) {
        if (args.length==0) {
            Program.inout.write("Тип коллекции: TreeMap");
            Program.inout.write("Количество элементов: " + Program.colman.getLabWork().size());
            Program.inout.write("Время создания коллекции: " + Program.colman.getTime());
        } else {
            Program.inout.write("У этой команды нет параметров");
        }
    }

    @Override
    public String toString(){
        return "Выводит информацию о коллекции";
    }
}

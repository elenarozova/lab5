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

package commands;

import interfaces.Comands;
import program.Program;

/**
 * Команда для очистки коллекции лабораторных работ.
 * Удаляет все элементы из коллекции {@link Program#colman}.
 *
 * @author Елена
 * @see Comands
 * @see Program#colman
 */

public class Clear implements Comands {
    @Override
    public void implementCommand(String[] args) {
        if (args.length==0) {
            Program.colman.getLabWork().clear();
            Program.inout.write("Вся коллекция была удалена");
        } else {Program.inout.write("У этой команды нет параметров");}
    }
    @Override
    public String toString(){
        return "Очищает словарь";
    }
}

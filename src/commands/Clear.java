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
    public void implementCommand() {
        Program.colman.getLabWork().clear();
        Program.inout.write("Вся коллекция была удалена");
        Program.parser.parse("show");
    }
    @Override
    public String toString(){
        return "Очищает словарь";
    }
}

package commands;

import interfaces.Comands;
import main.FileManager;
import program.Program;

/**
 * Команда для сохранения текущего состояния коллекции в файл.
 * Использует {@link FileManager#writeXML(String)} для записи коллекции
 * в XML-файл с именем, хранящимся в {@link Program#nameFile}.
 *
 * @author Елена
 * @see Comands
 * @see FileManager
 * @see Program#fileManager
 * @see Program#nameFile
 */

public class Save implements Comands {
    @Override
    public void implementCommand(String[] args) {
        if (args.length==0) {
            Program.fileManager.writeXML(Program.nameFile);
        } else {
            Program.inout.write("У этой команды нет параметров");
        }
    }

    @Override
    public String toString(){
        return "Сохраняет коллекцию в заданный файл";
    }
}

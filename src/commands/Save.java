package commands;

import interfaces.Comands;
import main.FileManager;
import program.Program;

public class Save implements Comands {
    @Override
    public void implementCommand() {
        Program.fileManager.writeXML(Program.nameFile);
    }

    @Override
    public String toString(){
        return "Сохраняет коллекцию в заданный файл";
    }
}

package commands;

import interfaces.Comands;
import program.Program;

public class ExecuteScript implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.write("Введите название файла, из которого хотите читать скрипт:");
        String filename = Program.inout.read();
        Program.inout.startFileReading(filename);
        if (!Program.inout.isReadingFromFile()) {
            return;
        }
        while (Program.inout.hasNextLine()) {
            String command = Program.inout.read();
            if (command.trim().isEmpty()) {
                continue;
            }
            Program.parser.parse(command);
            if (Program.inout.isScriptHasError()) {
                Program.inout.write("В файле была совершена ошибка ввода данных.");
                break;
            }
        }
        Program.inout.stopFileReading();
    }

    @Override
    public String toString(){return "Выполняет скрипт из указанного вами файла.";}
}

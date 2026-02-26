package commands;

import interfaces.Comands;
import main.CheckValues;
import program.Program;

/**
 * Команда для выполнения скрипта из файла.
 * Читает указанный файл и последовательно выполняет содержащиеся в нём команды.
 * При возникновении ошибки выполнение скрипта прерывается.
 *
 * @author Елена
 * @see Comands
 * @see Program#inout
 * @see Program#parser
 */

public class ExecuteScript implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.write("Введите название файла, из которого хотите читать скрипт:");
        String filename = CheckValues.checkValuesNull("название файла, из которого хотите читать скрипт");
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

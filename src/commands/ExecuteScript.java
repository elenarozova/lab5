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
    private String filename;
    @Override
    public void implementCommand(String[] args) {
        if (args.length==0) {
            Program.inout.write("Введите название файла, из которого хотите читать скрипт:");
            filename = CheckValues.checkValuesNull("название файла, из которого хотите читать скрипт");
        } else if (args.length==1){
            filename=args[0].trim();
        } else {
            Program.inout.write("Вы ввели больше аргументов, чем надо, первый будет принят как название скрипта, а остальные будут откинуты");
            filename=args[0].trim();
        }
        Program.inout.startFileReading(filename);
        if (!Program.inout.isReadingFromFile()) {
            return;
        }
        boolean hadError = false;
        while (Program.inout.hasNextLine()) {
            String command = Program.inout.read();
            if (command.trim().isEmpty()) {
                continue;
            }
            Program.parser.parse(command);
            if (Program.inout.isScriptHasError()) {
                Program.inout.write("В файле была совершена ошибка ввода данных.");
                hadError = true;
                break;
            }
        }
        Program.inout.stopFileReading(filename);
        if (!hadError) {
            Program.inout.setScriptError(false);
        }
    }

    @Override
    public String toString(){return "Выполняет скрипт из указанного вами файла.";}
}

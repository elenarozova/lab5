package commands;
import interfaces.Comands;
import java.util.Map;
import program.Program;

/**
 * Команда для вывода справки по всем доступным командам.
 * Отображает список всех команд с их описаниями.
 *
 * @author Елена
 * @see Comands
 * @see Program#parser
 */

public class Helps implements Comands {
    Map<String,Comands> command;


    @Override
    public void implementCommand(String[] args) {
        if (args.length==0) {
            command = Program.parser.getCommands();
            Program.inout.write("Справка по доступным командам: ");
            for (String i : command.keySet()) {
                Program.inout.write(i + ": " + command.get(i));
            }
        } else {
            Program.inout.write("У этой команды нет параметров");
        }
    }
    @Override
    public String toString(){
        return "Выводит значения всех команд";
    }
}

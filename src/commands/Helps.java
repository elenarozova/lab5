package commands;
import interfaces.Comands;
import java.util.Map;
import program.Program;


public class Helps implements Comands {
    Map<String,Comands> command;


    @Override
    public void implementCommand() {
        command = Program.parser.getCommands();
        Program.inout.write("Справка по доступным командам: ");
        for (String i: command.keySet()){
            Program.inout.write(i + ": "+ command.get(i));
        }
    }
    @Override
    public String toString(){
        return "Выводит значения всех комманд";
    }
}

package commands;

import data.LabWork;
import interfaces.Comands;
import program.Program;

public class Update implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.write("Введите ключ объекта, который хотите поменять:");
        String keyStr = Program.inout.read();
        try {
            Integer key = Integer.parseInt(keyStr);
            if (Program.colman.getLabWork().containsKey(key)) {
                Program.colman.getLabWork().replace(key, new LabWork());
            } else {
                Program.inout.write("Такого ключа нет");
            }
        } catch (NumberFormatException e) {
            Program.inout.write("Ключи являются типом int");
        }
    }
    @Override
    public String toString(){
        return "Обновить значение элемента коллекции, id которого равен заданному";
    }
}

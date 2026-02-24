package commands;

import data.LabWork;
import interfaces.Comands;
import main.CheckValues;
import program.Program;

public class ReplaceIfLowe implements Comands {
    Integer id;

    @Override
    public void implementCommand() {
        Program.inout.write("Введите ключ значения,которое хотите изменить:");
        while (true) {
            try {
                id = Integer.parseInt(CheckValues.checkValuesNull("ключ значения,которое хотите изменить,"));
                break;
            } catch (NumberFormatException e) {
                Program.inout.write("Ключ должен быть int.");
            }
        }
        if (Program.colman.getLabWork().containsKey(id)) {
            LabWork lab = new LabWork();
            if (lab.compareTo(Program.colman.getLabWork().get(id))<0){
                Program.colman.getLabWork().replace(id,lab);
            }
        }
    }

    @Override
    public String toString(){
        return "Заменяет значение по ключу, если новое значение меньше старого.";
    }
}

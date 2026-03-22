package commands;

import data.LabWork;
import interfaces.Comands;
import main.CheckValues;
import program.Program;

/**
 * Команда для замены значения по ключу, если новое значение меньше старого.
 * Создаёт новый объект LabWork и сравнивает его с существующим по ключу.
 * Если новый объект меньше существующего (согласно {@link LabWork#compareTo}),
 * выполняет замену.
 *
 * @author Елена
 * @see Comands
 * @see LabWork
 * @see Program#colman
 */

public class ReplaceIfLowe implements Comands {
    Integer id;
    String idi;

    @Override
    public void implementCommand(String[] args) {

        int lenght = args.length;
        while (true) {
            if (lenght==0) {
                Program.inout.write("Введите ключ значения,которое хотите изменить:");
                idi = CheckValues.checkValuesNull("ключ значения,которое хотите изменить");
            } else if (lenght==1){
                idi = args[0].trim();
            } else {
                Program.inout.write("Было введено больше одного параметра, все превышающие параметры не учитываются");
                idi= args[0].trim();
            }
            try {
                id = Integer.parseInt(idi);
                break;
            } catch (NumberFormatException e) {
                Program.inout.write("Ключ должен быть int.");
                lenght=0;
            }
        }
        if (Program.colman.getLabWork().containsKey(id)) {
            Program.inout.write(String.valueOf(Program.colman.getLabWork().get(id)));
            LabWork lab = new LabWork.Builder().doLab();
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

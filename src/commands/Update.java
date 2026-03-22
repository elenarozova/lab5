package commands;

import data.LabWork;
import interfaces.Comands;
import main.CheckValues;
import program.Program;

/**
 * Команда для обновления значения элемента коллекции по его ключу.
 * Заменяет существующий элемент новым объектом LabWork, создаваемым
 * через пользовательский ввод.
 *
 * @author Елена
 * @see Comands
 * @see LabWork
 * @see Program#colman
 */

public class Update implements Comands {
    String keyStr;
    @Override
    public void implementCommand(String[] args) {
        if (args.length==0) {
            Program.inout.write("Введите ключ объекта, который хотите обновить:");
            keyStr = CheckValues.checkValuesNull("ключ объекта, который хотите обновить:");
        } else if (args.length==1){
            keyStr = args[0].trim();
        } else {
            Program.inout.write("Было введено больше одного параметра, все превышающие параметры не учитываются");
            keyStr= args[0].trim();
        }
        try {
            Integer key = Integer.parseInt(keyStr);
            if (Program.colman.getLabWork().containsKey(key)) {
                Program.colman.getLabWork().replace(key, new LabWork.Builder().doLab());
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

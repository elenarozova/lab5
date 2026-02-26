package commands;

import data.LabWork;
import interfaces.Comands;
import main.CheckValues;
import program.Program;

/**
 * Команда для удаления элемента из коллекции по его ключу.
 * Запрашивает у пользователя ключ и удаляет соответствующий элемент,
 * если он существует в коллекции.
 *
 * @author Елена
 * @see Comands
 * @see Program#colman
 */

public class RemoveKey implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.write("Введите ключ объекта, который хотите удалить:");
        String keyStr = CheckValues.checkValuesNull("ключ объекта, который хотите удалить,");
        try {
            Integer key = Integer.parseInt(keyStr);
            if (Program.colman.getLabWork().containsKey(key)) {
                Program.colman.getLabWork().remove(key);
            } else {
                Program.inout.write("Такого ключа нет");
            }
        } catch (NumberFormatException e) {
            Program.inout.write("Ключи являются типом int");
        }
    }
    @Override
    public String toString(){
        return "Удалить элемент из коллекции по его ключу";
    }
}

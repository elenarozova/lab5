package commands;

import interfaces.Comands;
import main.CheckValues;
import program.Program;

/**
 * Команда для удаления всех элементов, ключ которых превышает заданное значение.
 * Удаляет все элементы с ключом, большим или равным указанному пользователем.
 *
 * @author Елена
 * @see Comands
 * @see Program#colman
 */

public class RemoveGreaterKey implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.write("Введите ключ элемента, после которого все остальные необходимо удалить:");
        try {
            int id = Integer.parseInt(CheckValues.checkValuesNull("значение элемента, после которого все остальные необходимо удалить:"));
            for (int i : Program.colman.getLabWork().keySet()) {
                if (i >= id) {
                    Program.colman.getLabWork().remove(i);
                }
            }
            Program.inout.write("Были удалены все элементы c ключом, превышающий данный");
        } catch (NumberFormatException e){
            Program.inout.write("Вы ввели не ключ, он должен быть int. Команда не выполнена, введите её снова.");
        }
    }
    @Override
    public String toString(){
        return "Удаляет все элементы после данного";
    }
}

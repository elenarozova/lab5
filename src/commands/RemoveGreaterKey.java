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
    String testMin;

    @Override
    public void implementCommand(String[] args) {
        int lenght = args.length;
        if (lenght == 0) {
            Program.inout.write("Введите значение элемента, после которого все остальные необходимо удалить:");
            testMin = CheckValues.checkValuesNull("значение элемента, после которого все остальные необходимо удалить:");
        } else if (lenght == 1){
            testMin = args[0].trim();
        } else {
            Program.inout.write("Было введено больше одного параметра, все превышающие параметры не учитываются");
            testMin=args[0].trim();
        }
        try {
            int id = Integer.parseInt(testMin);
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

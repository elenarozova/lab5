package commands;

import interfaces.Comands;
import program.Program;

public class RemoveGreaterKey implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.write("Введите ключ элемента, после которого все остальные необходимо удалить:");
        try {
            int id = Integer.parseInt(Program.inout.read());
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

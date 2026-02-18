package commands;

import interfaces.Comands;
import program.Program;

public class RemoveGreater implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.write("Введите значение элемента, после которого все остальные необходимо удалить:");
        String id = Program.inout.read();
        Program.inout.write("Были удалены все элементы, превышающий данный");
    }
}

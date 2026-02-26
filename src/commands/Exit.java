package commands;

import interfaces.Comands;
import program.Program;

/**
 * Команда для завершения работы программы.
 * Корректно закрывает все ресурсы ввода-вывода и завершает выполнение JVM.
 *
 * @author Елена
 * @see Comands
 * @see Program#inout
 */

public class Exit implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.closeScan();
        System.exit(0);
    }
    @Override
    public String toString(){
        return "Завершает программу";
    }
}

package commands;

import interfaces.Comands;
import program.Program;

/**
 * Команда для удаления всех элементов, которые больше заданного.
 * Пользователь вводит элемент, затем все элементы коллекции,
 * которые больше этого эталона (согласно {@link data.LabWork#compareTo}),
 * удаляются из коллекции.
 *
 * @author Елена
 * @see Comands
 * @see Insert
 * @see Program#colman
 */

public class RemoveGreater implements Comands {
    @Override
    public void implementCommand() {
        Program.inout.write("Введите элемент, с которым будут сравниваться другие");
        Insert ins = new Insert();
        ins.implementCommand();
        Integer[] keys = Program.colman.getLabWork().keySet().toArray(new Integer[0]);
        for (int i:keys){
            if (ins.getLab().compareTo(Program.colman.getLabWork().get(i))<0){
                Program.colman.getLabWork().remove(i);
            }
        }
        Program.inout.write("Все элементы, которые больше заданного, были удалены.");
    }
    @Override
    public String toString(){return "Удаляет все элементы, которые больше заданного элемента";}
}

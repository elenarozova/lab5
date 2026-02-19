package commands;

import interfaces.Comands;
import program.Program;

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
    public String toString(){return "УДаляет все элементы, которые больше заданного элемента";}
}

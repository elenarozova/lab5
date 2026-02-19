package commands;

import data.LabWork;
import interfaces.Comands;
import program.Program;

public class Insert implements Comands {
    private Integer idi;
    private LabWork lab;
    @Override
    public void implementCommand() {
        setKey();
        lab = new LabWork();
        Program.colman.insert(idi,lab);

    }
    @Override
    public String toString(){return "Добавить новый элемент с заданным ключом";}

    private void setKey(){
        Program.inout.write("Введите ключ в виде числа:");
        while (true) {
            try {
                idi = Integer.valueOf(Program.inout.read());
                break;
            } catch (NumberFormatException e) {
                Program.inout.write("Ключ должен быть типа int");
                Program.inout.write("Введите ключ в виде числа:");
            }
        }
    }
    public Integer getIdi(){return idi;}
    public LabWork getLab(){return lab;}


}

package commands;

import data.LabWork;
import interfaces.Comands;
import main.CheckValues;
import program.Program;


/**
 * Команда для добавления нового элемента в коллекцию с заданным ключом.
 * Запрашивает у пользователя ключ, затем создаёт новый объект LabWork
 * и вставляет его в коллекцию по указанному ключу.
 *
 * @author Елена
 * @see Comands
 * @see LabWork
 * @see Program#colman
 */

public class Insert implements Comands {
    private Integer idi;
    private LabWork lab;
    @Override
    public void implementCommand(String[] args) {
        if (args.length==0) {
            setKey();
        }
        else if (args.length==1) {
            try{
                idi = Integer.valueOf(args[0].trim());
            } catch (NumberFormatException e) {
                Program.inout.write("Вы ввели неподходящий ключ, он должен быть int");
                setKey();
            }
        }
        lab = new LabWork();
        Program.colman.insert(idi,lab);

    }
    @Override
    public String toString(){return "Добавить новый элемент с заданным ключом";}

    private void setKey(){
        Program.inout.write("Введите ключ в виде числа:");
        while (true) {
            try {
                idi = Integer.valueOf(CheckValues.checkValuesNull("ключ"));
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

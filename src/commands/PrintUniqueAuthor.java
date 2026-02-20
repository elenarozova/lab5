package commands;

import data.Person;
import interfaces.Comands;
import program.Program;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PrintUniqueAuthor implements Comands {
    @Override
    public void implementCommand() {
        Set<Person> authers = new TreeSet<>();
        for (int i : Program.colman.getLabWork().keySet()) {
            authers.add(Program.colman.getLabWork().get(i).getAuthor());
        }
        for (Person i:authers) {
            Program.inout.write(i.toString());
        }
    }

    @Override
    public String toString(){
        return "Выводит всех авторов лабороторных работ и их данные";
    }
}

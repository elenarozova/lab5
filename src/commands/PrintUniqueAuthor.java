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
        TreeSet<Person> authors = new TreeSet<>();
        for (int i : Program.colman.getLabWork().keySet()) {
            authors.add(Program.colman.getLabWork().get(i).getAuthor());
        }
        printSet(authors);
    }

    protected void printSet(TreeSet<Person> authors){
        for (Person i:authors) {
            Program.inout.write(i.toString());
        }
    }
}

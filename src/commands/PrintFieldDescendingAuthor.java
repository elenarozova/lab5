package commands;

import data.Person;
import interfaces.Comands;
import program.Program;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class PrintFieldDescendingAuthor extends PrintUniqueAuthor{
    @Override
    protected void printSet(TreeSet<Person> authors){
        NavigableSet<Person> reversed = authors.descendingSet();
        for (Person author : reversed) {
            Program.inout.write(author.toString());
        }
    }
    @Override
    public String toString(){
        return "Выводит всех авторов лабороторных работ и их данные в порядке убывания";
    }
}

package commands;

import data.Person;
import interfaces.Comands;
import program.Program;


import java.util.TreeSet;

/**
 * Команда для вывода уникальных авторов лабораторных работ.
 * Собирает всех авторов из коллекции в TreeSet (что автоматически удаляет дубликаты
 * благодаря естественному порядку сортировки {@link Person}) и выводит их.
 *
 * @author Елена
 * @see Comands
 * @see Person
 * @see Program#colman
 */

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

    @Override
    public String toString(){
        return "Выводит всех авторов лабораторных работ.";
    }
}

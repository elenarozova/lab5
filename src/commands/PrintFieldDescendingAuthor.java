package commands;

import data.Person;
import program.Program;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Команда для вывода всех уникальных авторов лабораторных работ в порядке убывания.
 * Наследует функциональность сбора авторов от {@link PrintUniqueAuthor},
 * но переопределяет метод {@link #printSet(TreeSet)} для вывода элементов
 * в обратном порядке (по убыванию).
 *
 * @author Елена
 * @see PrintUniqueAuthor
 * @see Person
 * @see NavigableSet
 */

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
        return "Выводит всех авторов лабораторных работ и их данные в порядке убывания";
    }
}

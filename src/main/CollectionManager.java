package main;

import data.LabWork;

import java.util.Date;
import java.util.TreeMap;

/**
 * Менеджер коллекции, отвечающий за хранение и управление элементами LabWork.
 * Использует TreeMap для автоматической сортировки элементов по ключу (Integer).
 * Также хранит дату инициализации коллекции.
 *
 * @author Елена
 * @see LabWork
 */

public class CollectionManager {
    TreeMap<Integer, LabWork> labWork;
    Date time;

    public CollectionManager() {
        labWork = new TreeMap<>();
        time = new Date();
    }

    public void insert(Integer id, LabWork lab) {
        labWork.put(id, lab);
    }

    public TreeMap<Integer, LabWork> getLabWork() {
        return labWork;
    }

    public Date getTime() {
        return time;
    }
}

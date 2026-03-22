package main;

import data.LabWork;
import program.Program;

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

    public Integer maxKey(){
        int maxKey = 0;
        for (LabWork lab:labWork.values()){
            if(lab.getId()>maxKey){
                maxKey=lab.getId();
            }
        }
        return maxKey;
    }
}

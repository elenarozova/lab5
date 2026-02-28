package main;

/**
 * Генератор уникальных идентификаторов для элементов коллекции.
 * Предоставляет статические методы для получения последовательных ID и сброса генератор
 *
 * @author Елена
 */

public class Generate {
    private static int idi = 1;

    public static Integer generateId() {
        return idi++;  // возвращает и увеличивает
    }

    public static void reset() {
        idi = 1;
    }
    public static void setIdi(int id){idi = id;}
}

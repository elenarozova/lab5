package main;

public class Generate {
    private static int idi = 1;

    public static Integer generateId() {
        return idi++;  // возвращает и увеличивает
    }

    public static void reset() {
        idi = 1;
    }
}

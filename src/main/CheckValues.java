package main;

import program.Program;

/**
 * Утилитный класс для проверки и валидации пользовательского ввода.
 * Содержит статические методы, которые обеспечивают корректность вводимых данных,
 * предотвращая сохранение пустых или некорректных значений.
 *
 * @author Елена
 * @see Program#inout
 */

public class CheckValues {
    public static String checkValuesNull(String name) {
        String test = Program.inout.read();
        while (test.trim().isEmpty()) {
            Program.inout.write(name + " не может быть null");
            Program.inout.write("Введите значение " + name + " :");
            test = Program.inout.read();
        }
        return test.trim();
    }
}

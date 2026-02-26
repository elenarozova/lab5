package data;

import main.CheckValues;
import program.Program;

/**
 * Класс, представляющий координаты лабораторной работы.
 * Содержит координаты X и Y с ограничениями на допустимые значения.
 * Реализует интерфейс {@link Comparable} для сравнения координат.
 *
 * @author Елена
 * @version 1.0
 */

public class Coordinates implements Comparable<Coordinates> {
    private Float x; //Максимальное значение поля: 254, Поле не может быть null
    private Long y; //Значение поля должно быть больше -991, Поле не может быть null

    public Coordinates() {
        setX();
        setY();
    }

    public Coordinates(Float x, Long y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Устанавливает координату X через пользовательский ввод.
     * Проверяет, что введённое значение является числом типа float и не превышает 254.
     */

    private void setX() {
        Program.inout.write("Введите значение X:");
        String testX = CheckValues.checkValuesNull("X");
        while (true) {
            try {
                float x = Float.parseFloat(testX);
                while (x > 254) {
                    Program.inout.write("X не может быть больше 254");
                    Program.inout.write("Введите значение X для координат:");
                    x = Float.parseFloat(Program.inout.read());
                }
                this.x = x;
                break;
            } catch (NumberFormatException e) {
                Program.inout.write("X должно быть типа float");
            }
        }

    }

    /**
     * Устанавливает координату Y через пользовательский ввод.
     * Проверяет, что введённое значение является числом типа long и больше -991.
     */

    private void setY() {
        Program.inout.write("Введите значение Y:");
        while (true) {
            try {
                String testY = CheckValues.checkValuesNull("Y");
                long y = Long.parseLong(testY);
                while (y < -991) {
                    Program.inout.write("Y не может быть меньше -991");
                    Program.inout.write("Введите значение Y:");
                    y = Long.parseLong(Program.inout.read());
                }
                this.y = (long) y;
                break;
            } catch (NumberFormatException e) {
                Program.inout.write("Y должно быть типа float");
            }
        }

    }


    public Float getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    @Override
    public int compareTo(Coordinates coordinates) {
        int xCompare = Float.compare(this.x, coordinates.x);
        if (xCompare != 0) {
            return xCompare;
        }

        return Long.compare(this.y, coordinates.y);
    }
}

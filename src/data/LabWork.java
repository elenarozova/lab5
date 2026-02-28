package data;

import main.CheckValues;
import main.Generate;
import program.Program;

import java.time.LocalDate;

/**
 * Класс, представляющий лабораторную работу.
 * Содержит полную информацию о лабораторной работе: идентификатор, название,
 * координаты, дату создания, минимальный балл, сложность и автора.
 * Реализует интерфейс {@link Comparable} для сравнения работ по набору критериев.
 *
 * @author Елена
 * @see Coordinates
 * @see Difficulty
 * @see Person
 */

public class LabWork implements Comparable<LabWork> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double minimalPoint; //Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Person author;//Поле не может быть null

    public LabWork() {
        id = Generate.generateId();
        setName();
        coordinates = new Coordinates();
        creationDate = LocalDate.now();
        setMinimalPoint();
        setDifficult();
        author = new Person();
    }

    public LabWork(Integer id, String name, Coordinates coordinates, LocalDate creationDate, Double minimalPoint, Difficulty difficulty, Person author) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.minimalPoint = minimalPoint;
        this.difficulty = difficulty;
        this.author = author;
    }

    /**
     * Устанавливает сложность лабораторной работы через пользовательский ввод.
     * Предлагает выбрать из списка доступных значений enum {@link Difficulty}.
     * При некорректном вводе устанавливает значение по умолчанию NORMAL.
     */

    private void setDifficult() {
        Program.inout.write("Выберите сложность лабы: easy, normal, hard, impossible, insane");
        String test = CheckValues.checkValuesNull("сложность ");
        Difficulty difficult = switch (test) {
            case "easy" -> Difficulty.EASY;
            case "normal" -> Difficulty.NORMAL;
            case "hard" -> Difficulty.HARD;
            case "impossible" -> Difficulty.IMPOSSIBLE;
            case "insane" -> Difficulty.INSANE;
            default -> Difficulty.NORMAL;
        };
        this.difficulty = difficult;
    }

    /**
     * Устанавливает минимальный балл через пользовательский ввод.
     * Проверяет, что введённое значение является числом типа double и больше 0.
     * При некорректном вводе запрашивает значение повторно.
     */

    private void setMinimalPoint() {
        Program.inout.write("Введите минимальное значение:");
        while (true) {
            String test = CheckValues.checkValuesNull("минимальное значение");
            try {
                double minimalPoint = Double.parseDouble(test.replace(",","."));
                if (minimalPoint <= 0) {
                    Program.inout.write("Минимальное значение не может быть меньше 0");
                } else {
                    this.minimalPoint = minimalPoint;
                    break;
                }
            } catch (NumberFormatException e) {
                Program.inout.write("Минимальное значение должно быть типа double");
            }
        }
    }

    private void setName() {
        Program.inout.write("Введите название лабораторной работы:");
        name = CheckValues.checkValuesNull("Название лабораторной работы");
    }

    public Person getAuthor() {
        return author;
    }

    public Integer getId() {
        return id;
    }

    public Double getMinimalPoint() {
        return minimalPoint;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return " | "
                + id
                + " | " + name
                + " | " + coordinates.getX() + ", " + coordinates.getY()
                + " | " + creationDate
                + " | " + minimalPoint
                + " | " + difficulty
                + " | " + author.toString()
                + " | ";
    }

    @Override
    public int compareTo(LabWork o) {
        int nameCompare = Long.compare(this.name.length(), o.name.length());
        if (nameCompare != 0) {
            return nameCompare;
        }

        int coordCompare = coordinates.compareTo(o.coordinates);
        if (coordCompare != 0) {
            return coordCompare;
        }

        int minCompare = Double.compare(this.minimalPoint, o.minimalPoint);
        if (minCompare != 0) {
            return minCompare;
        }

        int personCompare = author.compareTo(o.author);
        if (personCompare != 0) {
            return personCompare;
        }

        return Integer.compare(this.id, o.id);
    }
}
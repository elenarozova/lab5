package data;

import main.Generate;
import program.Program;

import java.time.LocalDate;

public class LabWork {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double minimalPoint; //Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Person author; //Поле не может быть null

    public LabWork(){
        id = Generate.generateId();
        setName();
        coordinates = new Coordinates();
        creationDate = LocalDate.now();
        setMinimalPoint();
        setDifficult();
        author = new Person();
    }

    private void setDifficult() {
        Program.inout.write("Выберите сложность лабы: easy, normal, hard, impossible, insane");
        String test = Program.inout.read();
        while (test.isEmpty()) {
            Program.inout.write("Сложность не может быть null");
            Program.inout.write("Выберите сложность лабы: easy, normal, hard, impossible, insane");
            test = Program.inout.read();
        }
        Difficulty difficult = switch (test){
            case "easy" -> Difficulty.EASY;
            case "normal" -> Difficulty.NORMAL;
            case "hard" -> Difficulty.HARD;
            case "impossible" -> Difficulty.IMPOSSIBLE;
            case "insane" -> Difficulty.INSANE;
            default -> Difficulty.NORMAL;
        };
        this.difficulty=difficult;
    }

    private void setMinimalPoint() {
        Program.inout.write("Введите минимальное значение:");
        while (true) {
            String test = Program.inout.read();

            while (test.isEmpty()) {
                Program.inout.write("Минимальное значение не может быть null");
                Program.inout.write("Введите минимальное значение:");
                test = Program.inout.read();
            }

                try {
                    double minimalPoint = Double.parseDouble(test);
                    while (minimalPoint <= 0) {
                        Program.inout.write("Минимальное значение не может быть меньше 0");
                        Program.inout.write("Введите минимальное значение:");
                        minimalPoint = Long.parseLong(Program.inout.read());
                    }
                    this.minimalPoint = minimalPoint;
                    break;
                } catch (NumberFormatException e) {
                    Program.inout.write("Минимальное значение должно быть типа double");
                }
        }
    }

    private void setName(){
        Program.inout.write("Введите название лабораторной работы:");
        String testName = Program.inout.read();

        while (testName.isEmpty()) {
            Program.inout.write("NAME не может быть null");
            Program.inout.write("Введите название лабораторной работы: ");
            testName = Program.inout.read();
        }

        name = testName;
    }

    public Person getAuthor(){return author;}

    @Override
    public String toString(){
        return " | "
                + id
                + " | " + name
                + " | " + coordinates.getX() + ", " + coordinates.getY()
                + " | " + creationDate
                + " | " + minimalPoint
                + " | " + difficulty
                + " | " + author.toString()
                + " | " ;
    }

}
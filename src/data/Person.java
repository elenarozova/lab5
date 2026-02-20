package data;

import main.CheckValues;
import program.Program;
import java.util.Comparator;

public class Person implements Comparable<Person>{
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Double height; //Поле не может быть null, Значение поля должно быть больше 0
    private Double weight; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 26, Строка не может быть пустой, Поле может быть null

    public Person(){
        Program.inout.write("Введите данные автора лабораторной работы");
        setName();
        setHeight();
        setWeight();
        setPassportID();
    }

    public Person(String name,Double height,Double weight,String passportID){
        this.name=name;
        this.height=height;
        this.weight=weight;
        this.passportID=passportID;
    }

    private void setPassportID() {
        Program.inout.write("Введите паспортные данные автора:");
        String passportID = Program.inout.read();
        while (passportID.length()>26 && passportID ==" "){
            Program.inout.write("Значение не должно быть пустой строкой и должно быть меньше 26");
            Program.inout.write("Введите паспортные данные автора:");
            passportID = Program.inout.read();
        }
        this.passportID = passportID;
    }

    private void setWeight() {
        Program.inout.write("Введите вес автора:");
        String testWeight = CheckValues.checkValuesNull("вес автора");
        try {
            double weight = Double.parseDouble(testWeight);
            while (weight <= 0) {
                Program.inout.write("Вес должен быть больше нуля");
                Program.inout.write("Введите значение веса:");
                weight = Double.parseDouble(Program.inout.read());
            }
            this.weight = (double) weight;
        }catch (NumberFormatException e){
            Program.inout.write("Y должно быть типа double, автоматически рост равен 1");
            this.weight = (double) 1;
        }
    }

    private void setHeight() {
        Program.inout.write("Введите рост автора:");
        String testHeight = CheckValues.checkValuesNull("рост автора");
        try {
            double height = Double.parseDouble(testHeight);
            while (height <= 0) {
                Program.inout.write("Рост должен быть больше нуля");
                Program.inout.write("Введите значение роста:");
                height = Double.parseDouble(Program.inout.read());
            }
            this.height = (double) height;
        }catch (NumberFormatException e){
            Program.inout.write("Y должно быть типа double, автоматически рост равен 1");
            this.height = (double) 1;
        }

    }

    private void setName(){
        Program.inout.write("Введите имя автора:");
        String testName = CheckValues.checkValuesNull("имя автора");
        name = testName;
    }


    @Override
    public String toString(){
        return "Person: "
                +"имя: "+ name + ", "
                +"рост: "+ height + ", "
                +"вес: "+ weight + ", "
                +"паспортные данные: "+ passportID ;
    }

    @Override
    public int compareTo(Person person) {
        int nameCompare = Long.compare(this.name.length(),person.name.length());
        if (nameCompare!=0){return nameCompare;}

        int hCompare = Double.compare(this.height,person.height);
        if (hCompare!=0){return hCompare;}

        int wCompare = Double.compare(this.weight,person.weight);
        if (wCompare!=0){return wCompare;}
        return Long.compare(this.passportID.length(),person.passportID.length());
    }

    public String getName() {
        return name;
    }

    public String getPassportID() {
        return passportID;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }
}

package data;

import main.CheckValues;
import program.Program;

public class Coordinates implements Comparable<Coordinates>{
    private Float x; //Максимальное значение поля: 254, Поле не может быть null
    private Long y; //Значение поля должно быть больше -991, Поле не может быть null

    public Coordinates(){
        setX();
        setY();
    }

    public Coordinates(Float x,Long y){
        this.x=x;
        this.y=y;
    }

    private void setX(){
        Program.inout.write("Введите значение X:");
        String testX = CheckValues.checkValuesNull("X");
        try {
            float x = Float.parseFloat(testX);
            while (x > 254) {
                Program.inout.write("X не может быть больше 254");
                Program.inout.write("Введите значение X для координат:");
                x = Float.parseFloat(Program.inout.read());
            }

            this.x = x;
        } catch (NumberFormatException e){
            Program.inout.write("X должно быть типа float, автоматически x = 0");
            this.x = (float) 0;
        }

    }
    private void setY() {
        Program.inout.write("Введите значение Y:");

        String testY = CheckValues.checkValuesNull("Y");
        try {
            long y = Long.parseLong(testY);
            while (y < -991) {
                Program.inout.write("Y не может быть меньше -991");
                Program.inout.write("Введите значение Y:");
                y = Long.parseLong(Program.inout.read());
            }
            this.y = (long) y;
        }catch (NumberFormatException e){
                Program.inout.write("Y должно быть типа float, автоматически y = 0");
                this.y = (long) 0;
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
        int xCompare = Float.compare(this.x,coordinates.x);
        if (xCompare!=0) {return xCompare;}

        return Long.compare(this.y,coordinates.y);
    }
}

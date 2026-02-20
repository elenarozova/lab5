package program;

import main.*;

public class Program {
    public static Generate generate;
    public static InputOutputManage inout;
    public static ParserManager parser ;
    public static CollectionManager colman;
    public static String nameFile;
    public static FileManager fileManager;
    public Program(){
        inout=new InputOutputManage();
        parser=new ParserManager();
        colman=new CollectionManager();
        fileManager = new FileManager();
    }
    public void run(){
        inout.write("Добро пожаловать");
        inout.write("Введите название файла, из которого брать данные и куда их записывать:");
        nameFile = inout.read();
        fileManager.readXML(nameFile);
        inout.write("Введите help, чтобы узнать о командах");
        while (true){
            inout.write("Введите команду:");
            String line = inout.read();
            boolean flag= parser.parse(line);
            if (!flag){inout.write("Такой команды не существует");}
        }

    }

}

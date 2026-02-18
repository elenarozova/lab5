package program;

import main.CollectionManager;
import main.Generate;
import main.InputOutputManage;
import main.ParserManager;

public class Program {
    public static Generate generate;
    public static InputOutputManage inout;
    public static ParserManager parser ;
    public static CollectionManager colman;
    public Program(){
        inout=new InputOutputManage();
        parser=new ParserManager();
        colman=new CollectionManager();
    }
    public void run(){
        inout.write("Добо пожаловать, введите help, чтобы узнать о командах");
        while (true){
            inout.write("Введите комманду:");
            String line = inout.read();
            boolean flag= parser.parse(line);
            if (!flag){inout.write("Такой команды не существует");}
        }

    }

}

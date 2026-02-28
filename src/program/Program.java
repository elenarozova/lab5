package program;

import main.*;

/**
 * Главный класс приложения, содержащий точку входа и управляющий основным циклом программы.
 * Хранит статические ссылки на все основные компоненты системы:
 * <ul>
 *   <li>{@link #inout} - менеджер ввода-вывода</li>
 *   <li>{@link #parser} - менеджер команд</li>
 *   <li>{@link #colman} - менеджер коллекции</li>
 *   <li>{@link #fileManager} - менеджер файлов</li>
 *   <li>{@link #generate} - генератор ID</li>
 *   <li>{@link #nameFile} - имя текущего рабочего файла</li>
 * </ul>
 * Все компоненты доступны статически, что позволяет командам обращаться к ним без передачи ссылок.
 *
 * @author Елена
 * @see InputOutputManage
 * @see ParserManager
 * @see CollectionManager
 * @see FileManager
 * @see Generate
 */

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
    public void run(String name){
        inout.write("Добро пожаловать");
        if (name == null) {
            inout.write("Введите название файла, из которого брать данные и куда их записывать:");
            nameFile = CheckValues.checkValuesNull("Имя файла");
        } else {
            nameFile=name;
        }
        fileManager.readXML(nameFile);
        inout.write("Введите help, чтобы узнать о командах");
        while (true){
            inout.write("Введите команду:");
            String line = inout.read().trim();
            boolean flag= parser.parse(line);
            if (!flag){inout.write("Такой команды не существует");}
        }

    }

}

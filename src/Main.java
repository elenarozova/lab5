import program.Program;

/**
 * Главный класс для запуска приложения.
 * Содержит точку входа {@link #main(String[])}.
 *
 * @author Елена
 * @see Program
 */

public class Main {
    public static void main(String[] args) {
        Program prog=new Program ();
        if (args.length == 1) {
            prog.run(args[0]);
        } else {
            prog.run(null);
        }
    }
}
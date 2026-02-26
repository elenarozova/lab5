package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Управляет вводом-выводом.
 * Поддерживает два режима: чтение с консоли (по умолчанию) и чтение из файла (скрипты).
 * Также отвечает за вывод сообщений пользователю и отслеживание ошибок при выполнении скриптов.
 * @author Елена
 */

public class InputOutputManage {
    Scanner scan;
    Scanner fileScan;
    private boolean readFromFile;
    private boolean scriptHasError;

    public InputOutputManage(){
        scan = new Scanner(System.in);
        readFromFile = false;
        scriptHasError = false;
    }
    public void write(String line){
        System.out.println(line);
    }

    /**
     * Считывает одну строку ввода.
     * Источник ввода зависит от режима: консоль или файл
     * @return считанная строка
     */
    public String read(){
        if (readFromFile){
            return fileScan.nextLine();
        }
        else {
            return scan.nextLine();
        }
    }

    /** Переключает режим ввода на чтение из указанного файла.
     * Если файл не найден, выводит сообщение об ошибке и остаётся в режиме консоли
     * @param filename имя файла для чтения (путь к файлу)
     */

    public void startFileReading(String filename) {
        try {
            fileScan = new Scanner(new File(filename));
            readFromFile=true;
            scriptHasError = false;
        } catch (FileNotFoundException e) {
            write("Файл не найден: " + filename);
            readFromFile = false;
        }
    }

    /**
     * Завершает режим чтения из файла.
     */

    public void stopFileReading() {
        if (fileScan != null) {
            fileScan.close();
            fileScan = null;
        }
        readFromFile = false;
    }

    /**
     * Проверяет, есть ли ещё строки для чтения в текущем источнике.
     * В режиме файла проверяет, остались ли непрочитанные строки.
     * @return true, если есть следующая строка, иначе false
     */

    public boolean hasNextLine() {
        if (readFromFile) {
            return fileScan.hasNextLine();
        }
        return true;
    }

    /**
     * Устанавливает флаг ошибки выполнения скрипта
     * Используется для сигнализации о том, что в процессе выполнения скрипта произошла ошибка
     * @param error true, если ошибка произошла, иначе false
     */

    public void setScriptError(boolean error) {
        scriptHasError = error;
    }

    public boolean isScriptHasError() {
        return scriptHasError;
    }

    public void closeScan(){
        scan.close();
    }

    public boolean isReadingFromFile() {
        return readFromFile;
    }
}

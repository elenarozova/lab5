package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    public String read(){
        if (readFromFile){
            return fileScan.nextLine();
        }
        else {
            return scan.nextLine();
        }
    }

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

    public void stopFileReading() {
        if (fileScan != null) {
            fileScan.close();
            fileScan = null;
        }
        readFromFile = false;
    }
    public boolean hasNextLine() {
        if (readFromFile) {
            return fileScan.hasNextLine();
        }
        return true;
    }

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

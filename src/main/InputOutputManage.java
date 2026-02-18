package main;

import java.util.Scanner;

public class InputOutputManage {
    Scanner scan;
    public InputOutputManage(){
        scan = new Scanner(System.in);
    }
    public void write(String line){
        System.out.println(line);
    }

    public String read(){
        return scan.nextLine();
    }
    public void closeScan(){
        scan.close();
    }


}

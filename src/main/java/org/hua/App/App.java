package org.hua.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App{
    public static void main(String[] args) throws IOException {

        File file1 = new File("input.txt");
        File file2 = new File("input2.txt");
        File file3 = new File("input3.txt");
        BufferedReader readFirst = new BufferedReader (new FileReader (file1));
        BufferedReader readSecond = new BufferedReader (new FileReader (file2));
        BufferedReader readThird = new BufferedReader (new FileReader (file3));
        System.out.println("Letter Frequency A , B , C ");

        //int nextChar;
        //char ch = 0;
        Read r = new Read();
        
        /*int[] count1 = new int[128];
        int[] count2 = new int[128];
        int[] count3 = new int[128];
        */

        r.ReadCounter(readFirst);
        r.ReadCounter(readSecond);
        r.ReadCounter(readThird);
        
        readFirst.close();
        readSecond.close();
        readThird.close();
        
    }
}
package org.hua.App;
//hello world 
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

        int nextChar;
        char ch;

        int[] count1 = new int[128];
        int[] count2 = new int[128];
        int[] count3 = new int[128];

        while ((nextChar = readFirst.read()) != -1) {

            ch = ((char) nextChar);
            if (ch > 0 && ch <= 127)
                count1[ch ]++;
        }
        while ((nextChar = readSecond.read()) != -1) {

            ch = ((char) nextChar);
            if (ch > 0 && ch <= 127)
                count2[ch ]++;
        }
        while ((nextChar = readThird.read()) != -1) {

            ch = ((char) nextChar);
            if (ch > 0 && ch <= 127)
                count3[ch ]++;
        }
        
        for (int i = 0; i < 128; i++) {
            System.out.printf("%c %d | %d | %d", i  , count1[i],count2[i],count3[i]);
            System.out.println("");
            
        }
        readFirst.close();
        readSecond.close();
        readThird.close();
        
    }
}
package org.hua.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws IOException, InterruptedException {
        Frequencies r = new Frequencies("input.txt");
        Frequencies r2 = new Frequencies("input2.txt");
        Frequencies r3 = new Frequencies("input3.txt");

        for(int i = 0; i < 128; i++)
        {
            r.count[i]=r.count[i]+r2.count[i]+r3.count[i];
        }
        r.writeFile();
        //calling the exit method at the end of the app to close the file.

        Haffmantree h = new Haffmantree();


        //ArrayMinHeap h = new ArrayMinHeap();


    }

}
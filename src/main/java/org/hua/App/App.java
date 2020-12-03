package org.hua.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App{
    public static void main(String[] args) throws IOException {

        System.out.println("Letter Frequency A , B , C ");

        //int nextChar;
        //char ch = 0;
        Read r = new Read("input.txt");
        
        /*int[] count1 = new int[128];
        int[] count2 = new int[128];
        int[] count3 = new int[128];
        */

        //calling the method to read the file and saw the results to the user
        r.ReadCounter();

        //calling the exit method at the end of the app to close the file.
        r.exit_file();
        
    }
}
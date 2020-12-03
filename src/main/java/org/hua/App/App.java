package org.hua.App;

import java.io.IOException;


public class App{
    public static void main(String[] args) throws IOException 
    {
        Frequencies r = new Frequencies("input.txt");
        Frequencies r2 = new Frequencies("input2.txt");
        Frequencies r3 = new Frequencies("input3.txt");

//        //calling the method to read the file and show the results to the user
//        r.ReadCounter();
//        r2.ReadCounter();
//        r3.ReadCounter();
        r.writeFile();
        
        //calling the exit method at the end of the app to close the file.

        
    }
}
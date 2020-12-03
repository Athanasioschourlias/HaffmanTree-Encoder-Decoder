package org.hua.App;

/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;*/
import java.io.IOException;

public class App{
    public static void main(String[] args) throws IOException 
    {
        Read r = new Read("input.txt");
        Read r2 = new Read("input2.txt");
        Read r3 = new Read("input3.txt");

        //calling the method to read the file and show the results to the user
        r.ReadCounter();
        r2.ReadCounter();
        r3.ReadCounter();
        
        //calling the exit method at the end of the app to close the file.
        r.exit_file();
        
    }
}
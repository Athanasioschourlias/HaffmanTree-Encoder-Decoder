
package org.hua.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Read 
{

    //private String file;
    public Read()
    {
    }
    //File file = new File();
    int[] count = new int[128];
    char ch;
    int nextChar;
    int whichFile=1;
    //BufferedReader readFile = new BufferedReader (new FileReader (file));
    public void ReadCounter(BufferedReader readFile) throws IOException
    {
        
        
        while ((nextChar = readFile.read()) != -1) 
        {
            ch = ((char) nextChar);
            if (ch > 0 && ch <= 127) 
            {
              count[ch]++;
            }
        }
        for (int i = 0; i < 128; i++) {
           
            System.out.printf("%c %d", i  , count[i]);
            System.out.println("");
            
        }
        System.out.println("These results are from file"+whichFile);
        whichFile++;
    }
}




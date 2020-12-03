
package org.hua.App;

import java.io.*;

public class Read 
{
    //File file = new File();
    private int[] count = new int[128];
    private char ch;
    private int nextChar;
    public static int whichFile=1;


    File InFile;
    BufferedReader readFile;
   
    public Read(String file) throws FileNotFoundException 
    {

        this.InFile = new File(file);
        this.readFile = new BufferedReader(new FileReader (InFile));


    }


    //
    public void ReadCounter() throws IOException
    {
        System.out.println("These results are from file "+whichFile);
        while ((nextChar = readFile.read()) != -1)
        {
            ch = ((char) nextChar);
            if (ch > 0 && ch <= 127) 
            {
              count[ch]++;
            }
        }
        for (int i = 0; i < 128; i++) 
        {
           
            System.out.printf("%c %d", i  , count[i]);
            System.out.println("");
            
        }
        whichFile++;
    }

    public void exit_file() throws IOException 
    {
        readFile.close();
    }
}




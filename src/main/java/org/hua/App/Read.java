
package org.hua.App;

import java.io.*;

public class Read 
{
    //File file = new File();
    private int[] count = new int[128];
    private char ch;
    private int nextChar;
    private int whichFile=1;


    File In_file;
    BufferedReader read_file;
    //private String file;
    public Read(String file) throws FileNotFoundException {

        this.In_file = new File(file);
        this.read_file = new BufferedReader(new FileReader (In_file));


    }



    public void ReadCounter() throws IOException
    {
        System.out.println("These results are from file"+whichFile);
        while ((nextChar = read_file.read()) != -1)
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
        whichFile++;
    }

    public void exit_file() throws IOException {
        read_file.close();
    }
}




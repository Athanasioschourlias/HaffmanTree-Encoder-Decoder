package org.hua.App;

import java.io.FileNotFoundException;
import java.io.IOException;


public class App{
    public static void main(String[] args) {

        Frequencies r = makeFrequencies("input.txt");
        Frequencies r2 = makeFrequencies("input2.txt");
        Frequencies r3 = makeFrequencies("input3.txt");

        for(int i = 0; i < 128; i++)
        {
            r.count[i]=r.count[i]+r2.count[i]+r3.count[i];
        }
        r.writeFile();

        //calling the exit method at the end of the app to close the file.
        String fileName = "tree.dat";
        
        Huffmantree h = new Huffmantree();

        //writing in file
        
        /*Node n = h.Huffman();
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(n);
            os.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        */
        
    }

    public static Frequencies makeFrequencies(String filename){
        Frequencies r = null;
        try {
            r = new Frequencies(filename);
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return r;
    }

}
package org.hua.App;

import java.io.IOException;


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

}
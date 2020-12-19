package org.hua.App;

import java.io.FileNotFoundException;

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

        //making a huffmanTree object
        Huffmantree h = new Huffmantree();

        //this is the root node of the tree, that we return from the Huffman() method.
        //FIXME: Junkie solution to see the tree in the debuger.
        Huffmantree.Node node;
        h.storeTree( h.Huffman());
        //FIXME:h get tree den epistrefei to antikeimeno pisw MPOREI NA MHN TO GRAFEI EKSARXEIS
        node = h.GetTree();


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

    //Handling expetions the method might throw due to the absence of the file.
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
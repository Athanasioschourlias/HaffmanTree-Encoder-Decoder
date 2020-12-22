package org.hua.App;

import java.io.FileNotFoundException;

public class App{
    public static void main(String[] args)
    {

        Frequencies r = makeFrequencies("input.txt");
        Frequencies r2 = makeFrequencies("input2.txt");
        Frequencies r3 = makeFrequencies("input3.txt");

        for(int i = 0; i < 128; i++)
        {
            r.count[i]=r.count[i]+r2.count[i]+r3.count[i];
        }
        r.writeFile();

        //calling the exit method at the end of the app to close the file.
        //String fileName = "tree.dat";

        //making a huffmanTree object
        Huffmantree h = new Huffmantree();

        //this is the root node of the tree, that we return from the Huffman() method.
        Huffmantree.Node node = h.Huffman();
        h.storeTree(node);


        
    }

    //Handling expetions the method might throw due to the absence of the file.
    public static Frequencies makeFrequencies(String filename)
    {
        Frequencies r = null;
        try
        {
            r = new Frequencies(filename);
        } catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        return r;
    }

}
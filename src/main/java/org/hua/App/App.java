
package org.hua.App;

import java.io.FileNotFoundException;

public class App
{
    public static void main(String[] args) throws FileNotFoundException {

        Frequencies r = makeFrequencies("input.txt");
        Frequencies r2 = makeFrequencies("input2.txt");
        Frequencies r3 = makeFrequencies("input3.txt");

        for(int i = 0; i < 256; i++)
        {
            r.count[i]=r.count[i]+r2.count[i]+r3.count[i];
        }
        r.writeFile();

        //calling the exit method at the end of the app to close the file.
        //String fileName = "tree.dat";

        //making a huffmanTree object
        Huffmantree h = new Huffmantree();

        //this is the root node of the tree, that we return from the Huffman() method.
        h.storeTree(h.Huffman());

        //After we store the tree with the help of the storeTree method of Huffmantree class we read the tree and store
        //its root in a node object witht the help of the GetTree class.
        h.storeEncodingMap(h.buildEncodingMap(h.getTree()));

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
            e.printStackTrace();
        }
        return r;
    }

}

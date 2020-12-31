package org.hua.App;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;
//importing the huffman tree node that we made in the huffmantree class in order to store somewhere the nodes we returning
//from the deferent classes that we use, and not importing it localy all the time.
import org.hua.App.Huffmantree.Node;

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
        Node node = h.Huffman();
        h.storeTree(node);

        //After we store the tree with the help of the storeTree method of Huffmantree class we read the tree and store
        //its root in a node object witht the help of the GetTree class.
        node = h.getTree();
        h.storeEncodingMap(h.buildEncodingMap(node));
        //System.out.println(node);



        
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
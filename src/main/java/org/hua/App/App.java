package org.hua.App;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class App
{
    public static void main(String[] args) throws FileNotFoundException {

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
        h.storeTree(h.Huffman());

        //After we store the tree with the help of the storeTree method of Huffmantree class we read the tree and store
        //its root in a node object witht the help of the GetTree class.
        h.storeEncodingMap(h.buildEncodingMap(h.getTree()));

//        System.out.printf("THIS IS THE FIRST ARGUMENT %s !!!!!!!!!\n", args[0]);
        if(args.length == 0 || args.length > 2){
            System.out.println("Usage: arguments must be 2");
            System.exit(0);
        }
        Frequencies in = makeFrequencies(args[0]);
        System.out.println(args[0]);
        in.writeFile();

        h.storeTree(h.Huffman());
        h.storeEncodingMap(h.buildEncodingMap(h.getTree()));
        HashMap<Integer, String> cdmap = h.buildEncodingMap(h.getTree());

        BufferedWriter outputStream = null;
        try
        {

//            String filePath = args[1];
            outputStream = new BufferedWriter(new FileWriter(args[1]));
            // file to bytes[]
//            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            for (int i = 1; i < 128; i++)
            {
                outputStream.write(cdmap.get(i));
                outputStream.write("\n");

            }

            // bytes[] to file
//            Path path = Paths.get(args[1]);
//            Files.write(path, bytes);

            System.out.println("Done");

        } catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if (outputStream != null)
            {
                try
                {
                    outputStream.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        //EncodingFile encode = new EncodingFile();
        //encode.encodeFile("codes.dat");


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
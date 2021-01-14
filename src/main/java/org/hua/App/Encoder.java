package org.hua.App;

import java.io.File;
import java.io.FileNotFoundException;

public class Encoder
{
    public static void main(String[] args) {


        if(args.length == 0 || args.length > 2){
            System.out.println("Usage: arguments must be 2");
            System.exit(0);
        }

//        Frequencies in = makeFrequencies(args[0]);
//        in.writeFile();
//
//        h.storeTree(h.Huffman());
//        h.storeEncodingMap(h.buildEncodingMap(h.getTree()));

        EncodingFile encode = new EncodingFile();

        File codings = new File("codes.dat");
        File infile = new File(args[0]);


        encode.compress(codings ,infile, args[1]);

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
package org.hua.App;

import java.io.*;
import java.util.Arrays;

public class Decoder
{
    
    
    

    public static void main(String[] args)
    {
        if(args.length == 0 || args.length > 2){
            System.out.println("Usage: arguments must be 2");
            System.exit(0);
        }
        DecodingFile decode=new DecodingFile();
        int[] codings = decode.readHufFile(args[0]);
        //int[] codings=decode.readHufFile("result.huf");
        String dec = decode.decompress(codings);
        decode.writeStrToFile(args[1],dec);
        //the bits in our array from decodinfile
//        System.out.println(Arrays.toString(codings));
        //codings=decode.readHufFile(args[0]);
        //Now you have an int Array with all bits and the root node of the tree
        //Create a method that take each int and uses the tree to find the letters
        // if int==0 go left if int==1 go right
        // if is.leaf print into the file args[1]
        
        
    }
}

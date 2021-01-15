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
        String dec = decode.decompress(codings);
        decode.writeStrToFile(args[1],dec);
    }
}

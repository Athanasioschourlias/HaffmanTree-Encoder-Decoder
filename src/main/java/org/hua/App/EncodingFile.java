package org.hua.App;

import java.io.*;
import java.util.BitSet;


public class EncodingFile {

    private int nextChar;
    private String[] cdmap;
    private static BitSet buffer = new BitSet();

    public EncodingFile(){
        this.nextChar = 0;
         this.cdmap = new String[128];
    }

    public void compress(File codings, File inputFile,String outputFile) {

        //reading the huffman encoding values for each letter from the codes.dat file
        cdmap = readCodes(codings);

        try (BufferedReader reader = new BufferedReader(new FileReader (inputFile)))
        {

            FileOutputStream out = new FileOutputStream(outputFile);;
            do
            {
                nextChar = reader.read();
                //Reading the ascii chars
                if (nextChar >= 1 && nextChar < 128){

                    try {

                        out.write(setingBits(cdmap[nextChar]).toByteArray());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }while (nextChar != -1);

            out.close();

        } catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }

        System.out.println("Done");

    }

    private static BitSet setingBits(String cdmap){

        for(int i=0; i < cdmap.length(); i++){

            if (cdmap.charAt(i) == '1')
                buffer.set(i, true);
            else
                buffer.set(i, false);

        }

        return buffer;
    }

    private static String[] readCodes(File codings){
        String nextline;

        String[] cdmap = new String[128];

        try (BufferedReader reader = new BufferedReader(new FileReader (codings)))
        {
            String[] answer;
            for(int i=1; i < 128; i++){

                nextline = reader.readLine();

                answer = nextline.split(" ");

                cdmap[i]= answer[1];
//                System.out.println(answer[1]);
                //Reading the ascii chars

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cdmap;

    }
}

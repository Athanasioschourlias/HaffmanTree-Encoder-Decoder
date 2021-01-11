package org.hua.App;

import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.BitSet;


public class EncodingFile {

    private int nextChar;
    private String[] cdmap;
    private static int counter =0;
//    private BitSet buffer = new BitSet();

    public EncodingFile(){
        this.nextChar = 0;
         this.cdmap = new String[128];
    }

    public void compress(File codings, File inputFile,String outputFile) {

        //reading the huffman encoding values for each letter from the codes.dat file
        cdmap = readCodes(codings);
        try (BufferedReader reader = new BufferedReader(new FileReader (inputFile)))
        {
            BufferedWriter ot = new BufferedWriter(new FileWriter("hello.dat"));
            FileOutputStream out = new FileOutputStream(outputFile);;
            do
            {
                nextChar = reader.read();
                //Reading the ascii chars
                if (nextChar >= 1 && nextChar < 128){

                    try {
                        ot.write(cdmap[nextChar]);
//                        ot.write(" ");
                        out.write(setingBits(cdmap[nextChar]).toByteArray());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }while (nextChar != -1);
            ot.close();
            byte[] bytes = ByteBuffer.allocate(4).putInt(counter).array();
            out.write(bytes,0,4);
            System.out.println(counter);
            out.close();

        } catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }

        System.out.println("Done");

    }

    private static BitSet setingBits(String cdmap){
        BitSet buffer = new BitSet(cdmap.length());
        for(int i=0; i < cdmap.length(); i++){

            if (cdmap.charAt(i) == '1')
            {
                buffer.set(i, true);
                counter++;
            }else
            {
                buffer.set(i, false);
                counter++;
            }
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

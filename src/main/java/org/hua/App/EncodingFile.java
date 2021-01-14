package org.hua.App;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.BitSet;


public class EncodingFile {

    private int nextChar;
    private String[] cdmap;
    private static int counter =0;

    public EncodingFile(){
        this.nextChar = 0;
        this.cdmap = new String[256];
    }

    public void compress(File codings, File inputFile,String outputFile) {

        //reading the huffman encoding values for each letter from the codes.dat file
        cdmap = readCodes(codings);
        try (BufferedReader reader = new BufferedReader(new FileReader (inputFile)))
        {
            ArrayDeque<BitCount> stuck = new ArrayDeque<>();

            FileOutputStream out = new FileOutputStream(outputFile);;
            do
            {
                nextChar = reader.read();

                BitSet buffer = new BitSet();

                if( (cdmap[nextChar].length() % 8) != 0 ){
                    if(stuck.isEmpty()) {
                        //if the bitset has some padding then we are making an object that
                        EncodingFile.BitCount b = new EncodingFile.BitCount((cdmap[nextChar].length() % 8),cdmap[nextChar].length(), buffer);
                        stuck.add(b);

                    }else {
                        BitSet tmp = new BitSet();

                        for(int i = cdmap[nextChar].length() + 1; i < (cdmap[nextChar].length() + (cdmap[nextChar].length() % 8) + 1); i++){




                        }


                    }

                }else if((cdmap[nextChar].length() % 8) == 0 && stuck.isEmpty()){
                    //if the Bitset DOES NOT HAVE PADDING WE JUST WRITE IT TO THE FILE.
                    out.write(buffer.toByteArray());
                }



            }while (nextChar != -1);

            byte[] bytes = ByteBuffer.allocate(4).putInt(counter).array();

            out.write(bytes,0,4);
            out.close();

        } catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }

        System.out.println("Done");

    }


    private static class BitCount{

        public int modulo;
        public int bits;
        public BitSet byff;

        public BitCount(int modulo,int bits, BitSet byff){
            this.modulo=modulo;
            this.bits=bits;
            this.byff=byff;

        }

    }

    private static String[] readCodes(File codings){
        String nextline;

        String[] cdmap = new String[256];

        try (BufferedReader reader = new BufferedReader(new FileReader (codings)))
        {
            String[] answer;
            for(int i=1; i < 256; i++){

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

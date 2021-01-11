package org.hua.App;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.BitSet;


public class EncodingFile {

    private int nextChar;
    private String[] cdmap;
    private static int counterbit =0;
    private static int counterByte=0;
    ArrayDeque<Integer> stuck = new ArrayDeque<>();

    public EncodingFile(){
        this.nextChar = 0;
         this.cdmap = new String[256];
    }

    public void compress(File codings, File inputFile,String outputFile) {

        //reading the huffman encoding values for each letter from the codes.dat file
        cdmap = readCodes(codings);
        BitSet buffer = new BitSet(8);
        byte[] b;
        try (BufferedReader reader = new BufferedReader(new FileReader (inputFile)))
        {
            FileOutputStream out = new FileOutputStream(outputFile);;
            do
            {
                nextChar = reader.read();
                //Reading the ascii chars
                if (nextChar >= 1 && nextChar < 256){
                    for(int i=0;i< cdmap[nextChar].length();i++)
                    {
                        if(cdmap[nextChar].charAt(i)=='1')
                        {
                            if(stuck.size()==8)
                            {
                                for (int j=0;j<8;j++)
                                {
                                    if(stuck.getFirst()==1)
                                    {
                                        buffer.set(j);
                                    }
                                    stuck.removeFirst();
                                }
                                b=buffer.toByteArray();
                                out.write(b);
                                counterByte++;
                                buffer.clear();
                                stuck.clear();
                            }
                            stuck.add(1);
                            counterbit++;
                        }
                        else
                        {
                            if(stuck.size()==8)
                            {
                                for (int j=0;j<8;j++)
                                {
                                    if(stuck.getFirst()==1)
                                    {
                                        buffer.set(j);
                                    }
                                    stuck.removeFirst();
                                }
                                b=buffer.toByteArray();
                                out.write(b);
                                counterByte++;
                                buffer.clear();
                                stuck.clear();
                            }
                            stuck.add(0);
                            counterbit++;
                        }
                    }
                }

            }while (nextChar != -1);

            if(!stuck.isEmpty())
            {
                for (int j=0;j<stuck.size()-1;j++)
                {
                    if(stuck.getFirst()==1)
                    {
                        buffer.set(j);
                    }
                    stuck.removeFirst();
                }
                b=buffer.toByteArray();
                out.write(b);
                counterByte++;
                buffer.clear();
                stuck.clear();
            }
            byte[] eofByte="EOF".getBytes();
            out.write(eofByte,0,3);
            out.close();
        } catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }
        System.out.println("Done");
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
                //Reading the ascii chars
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cdmap;
    }
}

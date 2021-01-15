package org.hua.App;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;

public class DecodingFile
{
    private static int counterBits;

    private static BitSet fromByte(byte b)
    {
        BitSet bits = new BitSet(8);
        for (int i = 0; i < 8; i++)
        {
            bits.set(i, (b & 1) == 1);
            b >>= 1;
        }
        return bits;
    }

    private  int[] bits2Ints(BitSet bs) {
        int[] temp = new int[bs.size() / 1];

        for (int i = 0; i < temp.length; i++)
            for (int j = 0; j < 1; j++)
                if (bs.get(i * 1 + j))
                    temp[i] |= 1 << j;

        return temp;
    }

    public int[] readHufFile(String inputfile) {
        int[] codings;
        int size=0;
        BitSet bits;

        try {
            Path path = Paths.get(inputfile);
            byte[] data = Files.readAllBytes(path);
            byte[] tmp = new byte[4];
            tmp[0]=data[data.length-4];
            tmp[1]=data[data.length-3];
            tmp[2]=data[data.length-2];
            tmp[3]=data[data.length-1];
            counterBits=convertByteArrayToInt2(tmp);
            codings = new int[data.length*8];
            for(int j=0;j<data.length;j++)
            {
                bits = fromByte(data[j]);
                //System.out.println(bits);
                int[] intArray = bits2Ints(bits);

                for (int i=0; i < 8; i++)
                {
                    codings[size]=intArray[i];
                    size++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        return codings;
    }

    private static int convertByteArrayToInt2(byte[] bytes) {
        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8) |
                ((bytes[3] & 0xFF) << 0);
    }

    //Decompressing the array of 0 and 1
    public String decompress(int[] codings){

        StringBuilder sb = new StringBuilder();
        //creating our huffmantree object
        Huffmantree huffmantree = new Huffmantree();
        //returning the root of the tree
        Huffmantree.Node root = huffmantree.getTree();
        //setting root as the current
        Huffmantree.Node cur = root;

        int i =0;
        int notUsedBits = codings.length-(counterBits-4);
        while(i<=codings.length-notUsedBits){
            //while current node not a leaf do the ifs depending on the int of the array
            while(!cur.isLeaf()){
                int bit = codings[i];
                if(bit==1){
                    cur=cur.right;
                }else if (bit==0){
                    cur=cur.left;
                }else{
                    throw new IllegalArgumentException("Invalid bit: "+bit);
                }
                i++;
            }
            //append to string builder
            //casting integer to character
            sb.append((char)cur.letter);
            cur= root;

        }
        return sb.toString();
    }

    public void writeStrToFile(String outputfile,String str)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile));
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

}

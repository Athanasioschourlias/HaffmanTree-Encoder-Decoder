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
        BitSet bits;
        try {
            Path path = Paths.get(inputfile);
            byte[] data = Files.readAllBytes(path);
            codings = new int[(data.length-3)*8];
            int size=0;
            for(int j=0;j< data.length-3;j++)
            {
                bits = fromByte(data[j]);
                //System.out.println(bits);
                int[] intArray = bits2Ints(bits);


                for (int i = 0; i < 8; i++)
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
        while(i<codings.length-8){
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
    }

}

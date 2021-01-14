package org.hua.App;

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

    private String toBinary(int num) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 1; i++) {
            sb.append(((num & 1) == 1) ? '1' : '0');
            num >>= 1;
        }

        return sb.reverse().toString();
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
                System.out.println(bits);
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

}

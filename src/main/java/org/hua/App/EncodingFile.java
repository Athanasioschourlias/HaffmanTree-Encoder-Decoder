package org.hua.App;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class EncodingFile {

    public void ReadCompressWrite(String codesDat, String inputFile , String outputFile) {
        File file = new File(codesDat);
        Scanner scan = null;
        int[] ascii = new int[128];
        String[] cdmap = new String[128];
//        HashMap<Integer, String> cdmap = new HashMap<>();
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader(codesDat));
            scan = new Scanner(file);
            for (int i = 1; i < 128; i++)
            {
                ascii[i]=scan.nextInt();
                cdmap[i]=scan.nextLine();
            }
        }catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }
        BufferedWriter outputStream = null;
        int nextChar;
        try
        {
            outputStream = new BufferedWriter(new FileWriter(outputFile));


            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)))
            {
                /**
                 *  Reading each character in the file, with the read() function:
                 *  The read() method of BufferedReader class in Java is used to read a single character
                 *  from the given buffered reader. This read() method reads one character at a
                 *  time from the buffered stream and return it as an integer value.
                 */
                do
                {
                    nextChar = reader.read();

                    //increasing the counter of each character from the ASCII table

                    if (nextChar >= 1 && nextChar <= 128){
                        outputStream.write(cdmap[nextChar]);
                        outputStream.write(" ");
                    }

                }while (nextChar != -1);

            } catch (IOException x)
            {
                System.err.format("IOException: %s%n", x);
            }

            System.out.println("Done");

        } catch (
                IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if (outputStream != null)
            {
                try
                {
                    outputStream.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private void compress()
    {
        //here we have to compress the haffman coding
    }

}

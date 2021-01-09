package org.hua.App;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class EncodingFile {

    public void compress(HashMap<Integer, String> cdmap, String outputFile) {

        BufferedWriter outputStream = null;

        try
        {

//            String filePath = outputFile;
            outputStream = new BufferedWriter(new FileWriter(outputFile));
            // file to bytes[]
//            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            for (int i = 1; i < 128; i++)
            {
                outputStream.write(cdmap.get(i));
                outputStream.write("\n");

            }

            // bytes[] to file
//            Path path = Paths.get(args[1]);
//            Files.write(path, bytes);

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
        //EncodingFile encode = new EncodingFile();
        //encode.encodeFile("codes.dat");

    }


}

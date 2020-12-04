
package org.hua.App;

import static java.nio.file.StandardOpenOption.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Frequencies
{
    private final int[] count = new int[128];
    private char ch;
    private int nextChar;
    private final File InFile;
//    private static int whichFile=1;
    private final BufferedReader readFile;
    private OutputStream out;

    public Frequencies(String file) throws IOException
    {

        /**
         * By adding this bit of code we try to give the user a better understanding
         * of what went wrong.Alongside with the exeption the user will see a message
         * which describes to the user some of the most likely reasons the execution
         * failed
         */
        Path path = Paths.get(file);
        if(!Files.exists(path) && Files.isReadable(path)){
            System.out.println("Plese check if the given path is right or you have the right permissions to this file.");
            throw new FileNotFoundException();
        }

        //Just initializing the file, no more actions needed from constructor
        this.InFile = new File(file);
        this.readFile = new BufferedReader(new FileReader (InFile));

        writeFile();

    }

    private void writeFile() throws IOException {
        /**
         * Preferred way from java documentation,Creating and Writing a File by Using Stream I/O.
         */
        Path p = Paths.get("./frequencies.dat");
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND)))
        {
            /**
             * WRITE – Opens the file for write access.
             * APPEND – Appends the new data to the end of the file. This option is used with the WRITE or CREATE options.
             * TRUNCATE_EXISTING – Truncates the file to zero bytes. This option is used with the WRITE option.
             * CREATE_NEW – Creates a new file and throws an exception if the file already exists.
             * CREATE – Opens the file if it exists or creates a new file if it does not.
             * DELETE_ON_CLOSE – Deletes the file when the stream is closed. This option is useful for temporary files.
             * SPARSE – Hints that a newly created file will be sparse. This advanced option is honored on some file systems, such as NTFS, where large files with data "gaps" can be stored in a more efficient manner where those empty gaps do not consume disk space.
             * SYNC – Keeps the file (both content and metadata) synchronized with the underlying storage device.
             * DSYNC – Keeps the file content synchronized with the underlying storage device.
             */
            ReadCounter();

            String line = "\n";
            byte[] nLine = line.getBytes();

            for (int i = 0; i < 128; i++)

            {

                String s = String.valueOf(count[i]);
                byte[] d = s.getBytes();
                out.write(d);
                out.write(nLine);


            }
            out.write(nLine);

        } catch (IOException x) {

            System.err.println(x);

        }
        out.close();


    }

    private void ReadCounter() throws IOException {

        /**
         * Preferred way from java documentation,Reading a File by Using Buffered Stream I/O.
         */
        try (BufferedReader reader = readFile) {
            /**
             *  Reading each character in the file, with the read() function:
             *  The read() method of BufferedReader class in Java is used to read a single character
             *  from the given buffered reader. This read() method reads one character at a
             *  time from the buffered stream and return it as an integer value.
             */
            while ((nextChar = reader.read()) != -1) {

                //increasing the counter of each character from the ASCII table
                ch = ((char) nextChar);

                if (ch > 0 && ch <= 127){

                    //count is a table of int's
                    count[ch]++;

                }

            }

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        //Backup way.
//        int nextChar;
//        while ((nextChar = readFile.read()) != -1)
//        {
//            //increasing the counter of each character from the ASCII table
//            ch = ((char) nextChar);
//            if (ch > 0 && ch <= 127)
//            {
//              count[ch]++;
//            }
//        }

//        whichFile++;

        /**
         * Releasing System Resources:
         * Many of the resources that are used in this API, such as streams or channels,
         * implement or extend the java.io.Closeable interface.
         * A requirement of a Closeable resource is that the close method must be
         * invoked to release the resource when no longer required.
         * Neglecting to close a resource can have a negative implication on an
         * application's performance. The try-with-resources statement,
         * described in the next section, handles this step for you.
         */
        readFile.close();

    }



}




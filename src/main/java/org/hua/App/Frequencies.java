package org.hua.App;

import static java.nio.file.StandardOpenOption.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Frequencies
{
    public final long[] count = new long[128];
    private char ch;
    private int nextChar;
    private final File InFile;
    private static int fileCounter = 1;

    public Frequencies(String file) throws FileNotFoundException
    {

        this.ch = 0;
        this.nextChar = 0;
        /*
         * By adding this bit of code we try to give the user a better understanding
         * of what went wrong.Alongside with the exeption the user will see a message
         * which describes to the user some of the most likely reasons the execution
         * failed
         */
        Path path = Paths.get(file);
        if(!Files.exists(path) && Files.isReadable(path))
        {
            System.out.println("Plese check if the given path is right or you have the right permissions to this file.");
            throw new FileNotFoundException();
        }
        this.InFile = new File(file);
        ReadCounter();
    }

    public void writeFile()
    {
        /*
         * Preferred way from java documentation,Creating and Writing a File by Using Stream I/O.
         * The file name is hardcoded because of the exercise's explenation.
         */
        Path p = Paths.get("./frequencies.dat");

        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, TRUNCATE_EXISTING)))
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


            String line = "\n";
            byte[] nLine = line.getBytes();
            long c=0;
            for(int i = 0; i < 128; i++)
            {

                c =c + count[i];

                //System.out.println("ascii char " +(char)i+" with number " +i+ " is printed " +count[i] );
                //System.out.println(c);

                //it count how many characters exist in this file
            }


            for (int i = 0; i < 128; i++)

            {
                //double f = count[i]/c ;
                String s = String.valueOf(count[i]);
                byte[] d = s.getBytes();
                String s1 = String.valueOf(i);
                byte[] ascii = s1.getBytes();
                out.write(ascii);
                out.write(32);
                out.write(d);
                out.write(nLine);


            }
            out.write(nLine);

        } catch (IOException x)
        {

            System.err.println(x);

        }
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


        //cheking how many times we've written to the file.
        fileCounter++;

    }

    private void ReadCounter()
    {

        /*
         * Preferred way from java documentation,Reading a File by Using Buffered Stream I/O.
         */
        try (BufferedReader reader = new BufferedReader(new FileReader (InFile)))
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

                if (nextChar >= 0 && nextChar <= 127){

                    //count is a table of int's
                    count[nextChar]++;

                }

            }while (nextChar != -1);

        } catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }
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
        

    }



}




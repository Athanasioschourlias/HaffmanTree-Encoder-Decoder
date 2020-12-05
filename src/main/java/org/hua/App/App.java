package org.hua.App;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App{
    public static void main(String[] args) throws IOException, InterruptedException {
        Frequencies r = new Frequencies("input.txt");
        Frequencies r2 = new Frequencies("input2.txt");
        Frequencies r3 = new Frequencies("input3.txt");


        r.writeFile();
        r2.writeFile();
        r3.writeFile();

        /**
         *"DEN EISAI FLOGERAS AN TO VLEPEIS"
         * "DEN EISAI FLOGERAS AN TO VLEPEIS"
         * "DEN EISAI FLOGERAS AN TO VLEPEIS"
         * "DEN EISAI FLOGERAS AN TO VLEPEIS"
         * "DEN EISAI FLOGERAS AN TO VLEPEIS"
         * v
         * v"DEN EISAI FLOGERAS AN TO VLEPEIS"
         * "DEN EISAI FLOGERAS AN TO VLEPEIS"
         * "DEN EISAI FLOGERAS AN TO VLEPEIS"
         * v
         * "DEN EISAI FLOGERAS AN TO VLEPEIS"
         * "DEN EISAI FLOGERAS AN TO VLEPEIS"
         * "DEN EISAI FLOGERAS AN TO VLEPEIS"
         *
         */

        //print test of the file.and then deleting it
        final File InFile;
        int nextChar;
        char ch;
        int[] count = new int[128];
        InFile = new File("frequencies.dat");
        BufferedReader reader = new BufferedReader(new FileReader(InFile));

        for(int j = 0;j < 3; j++) {
            for (int i = 0; i < 128; i++) {
                System.out.printf("%c %s", i, reader.readLine());
                System.out.println("");

            }
        }
        
        //calling the exit method at the end of the app to close the file.
        //TODO:DELETE THE FILE WE CREATED FOR THE FREQUENCIES
        Path path = Paths.get("./frequencies.dat");
        if(!Files.exists(path) && Files.isReadable(path)){
            System.out.println("Plese check if the given path is right or you have the right permissions to this file.");
            throw new FileNotFoundException();
        }
        File myObj = new File("frequencies.dat");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

    }
}
package org.hua.App;

import java.util.Map;

public class EncodingFile
{
    public void compress(boolean force) {
        TextFile textFile = new TextFile(input, 'r');

        /* Calculate Character Frequencies */

        freq = new HashMap<Character, Integer>();

        System.out.println("Building Huffman tree...");

        while (!textFile.EndOfFile()) {
            Character c = new Character(textFile.readChar());
            Integer currFreq = freq.get(c);
            if (currFreq == null) {
                currFreq = new Integer(1);
            } else {
                int newFreq = currFreq.intValue() + 1;
                currFreq = new Integer(newFreq);
            }
            freq.put(c, currFreq);
        }

        textFile.close();

        MapValueComparator comp = new MapValueComparator(freq);
        Map<Character, Integer> sortedFreq = new TreeMap<Character, Integer>(
                comp);
        sortedFreq.putAll(freq);

        long numChars = 0;
        for (Character c : sortedFreq.keySet()) {
            long f = sortedFreq.get(c);
            numChars += f;
        }

        // Size of uncompressed file (bits) = (# of chars in input file) * 8
        long sizeU = numChars * 8;

        /* Build Huffman Tree */
        tree = new HuffTree(sortedFreq);
        tree.buildCompressionTree();

        /* Build Lookup Table */
        System.out.println("Building lookup table...");
        encodingTable = tree.buildEncodingTable();

        // Size of the compressed file (bits)
        long sizeC = 0;

        /* Check File Size */

        for (Character c : freq.keySet()) {
            // (frequency of c) * (size of the encoding for c)
            // Size of tree (1 bit per internal node, 9 bits per leaf)
            // 16 bits for magic number & 32 bits for header info
            sizeC += (freq.get(c) * encodingTable.get(c).size());
        }
//		System.out.println(sizeC + " bits characters");

        // 8 more for padding count
        sizeC += tree.getSize() + 48 + 8;

        // System.out.println("******************");
//		System.out.println(sizeU + " bits (Uncompressed)");
//		System.out.println(sizeC + " bits (Compressed before padding)");

        // make file size a multiple of 8
        int padding = 0;
        if (sizeC % 8 != 0) {
            padding = 8 - (int) sizeC % 8;
            sizeC += padding;
        }

//		System.out.println(sizeC + " bits (Compressed) (padding = " + padding
//				+ ")");

        if ((sizeC < sizeU) || force) {
            BinaryFile binaryFile = new BinaryFile(output, 'w');
            if(sizeC >= sizeU) {
                System.out.println("Forced compression.");
            }
            System.out.println("Writing compressed file...");
            tree.writeCompressed(input, binaryFile, padding);
            binaryFile.close();
        } else {
            System.out
                    .println("The file cannot be compressed to a smaller size.");
        }

    }


}

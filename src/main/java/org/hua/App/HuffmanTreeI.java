package org.hua.App;

public interface HuffmanTreeI<Node>
{

    /**
     * creating the structure of the tree
     * @return Node
     */
    Node Huffman();

    /**
     * reads fequencies from our file in an array so they can be inserted in the min heap
     * @return int table
     */
    int[] ReadFrequencies();

    /**
     * This method takes the root node of the huffman tree that Huffamn() method created and stores the Huffman tree
     * in a file tree.dat.
     * @param root
     */
    void storeTree(Node root);

    /**
     * This method when its called it reads the huffman tree that was stored by the storeTree method in the tree.dat
     * file.
     * @return Node
     */
    Node getTree();

}

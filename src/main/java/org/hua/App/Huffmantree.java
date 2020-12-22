package org.hua.App;

import java.io.*;
import java.util.Scanner;

public class Huffmantree implements Serializable
{

    private final String dataFile = "tree.dat";
    private int ASCII_TABLE;
    private String filename;
    //No argument constractor
    public Huffmantree()
    {
        this.ASCII_TABLE=128;
        //This is the standard file that we read the frequences from.
        this.filename="frequencies.dat";
    }

    public void storeTree(Node root)
    {
        String dataFile = "tree.dat";
        try {
            FileOutputStream fileOut = new FileOutputStream(dataFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(root);
            objectOut.close();
        } catch (IOException e)
        {
            e.getMessage();
            e.printStackTrace();
        }
    }


    //building the tree
    public Node Huffman()
    {
        //using our priorityque(implimented with the minheap)
        int[] frq = ReadFrequencies(filename);
        ArrayMinHeap<Node> minheap = new ArrayMinHeap<>();
        //creating the nodes without children
        for(char i=1;i<ASCII_TABLE;i++){

            minheap.insert(new Node(i,frq[i],null,null));

        }
        //starting to add children from the min heap
        //keep looping until we reach the root of the tree
        Node root = null;
        while(minheap.getSize()>1)
        {
            Node left = minheap.extractMin();
            Node right = minheap.extractMin();
            //adding the two frequencies we get and making the parent node
            //'\0'(null) indicates that its not a leaf node/letter.
            Node parent = new Node('\0',left.frequency + right.frequency,left,right);
            minheap.insert(parent);
            // Keep track until we actually find the root
            root = parent;
        }//returns the final Node(root)

        return root;
    }

    public int[] ReadFrequencies(String filename)
    {
        File file = new File(filename);
        Scanner scan = null;
        try
        {
            scan = new Scanner(file);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        int[]  ascii = new int[128];
        int[] frq = new int[128];
        for(int i=0;i<=127;i++)
        {
            ascii[i] = scan.nextInt();
            frq[i] = scan.nextInt();
            //System.out.println("Ascii character "+ascii[i]+" found "+frq[i]+" times");
        }
        return frq;
    }
    //this is the class where we create the template for the nodes of the binnary tree.
    //root of the tree
    public class Node implements  Comparable<Node> , Serializable
    {
        public int frequency;
        public int letter;//if the node is a leaf we store the letter of this node.
        public Node left, right;

        public Node( int letter,int frequency,Node left, Node right)
        {
            this.letter = letter;
            this.frequency = frequency;
            this.left = left;
            this.right = right;

        }

        @Override
        public int compareTo(Node o)
        {
            int frequencycomparison = Integer.compare(this.frequency, o.frequency);
            if(frequencycomparison !=0)
            {
                return frequencycomparison;
            }
            return 0;
        }


    }

}

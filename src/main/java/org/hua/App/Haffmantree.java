package org.hua.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Haffmantree {

    private static int ASCII_TABLE = 128;

    //building the tree
    public Node Haffman(int[] freq){
        //using our priorityque(implimented with the minheap)
        ArrayMinHeap<Node> minheap = new ArrayMinHeap<>();
        //creating the nodes without children
        for(char i=1;i<ASCII_TABLE;i++){

            minheap.insert(new Node(i,freq[i],null,null));

        }
        //starting to add children from the min heap
        //keep looping until we reach the root of the tree
        Node root = null;
        while(minheap.getSize()>1){
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

    private void ReadFrequencies()
    {
        File file = new File("Frequencies.dat");
        Scanner scan = new Scanner("file");
        int[]  ascii = new int[128];
        long[] frq = new long[128];
        for(int i=0;i<=127;i++)
        {
            ascii[i] = scan.nextInt();
            frq[i] = scan.nextLong();
            System.out.println("Ascii character "+ascii[i]+" found "+frq[i]+" times");
        }
    }
    //this is the class where we create the template for the nodes of the binnary tree.
    //root of the tree
    public class Node implements Comparable<Node> {
        public int frequency;
        public int letter;//if the node is a leaf we store the letter of this node.
        public Node left, right;

        public Node( int letter,int frequency,Node left, Node right){
            this.letter = letter;
            this.frequency = frequency;
            this.left = left;
            this.right = right;

        }
        //checking if a node has children
        boolean isLeaf(){
            return this.left ==null && this.right==null;
        }

        @Override
        public int compareTo(Node o) {
            int frequencycomparison = Integer.compare(this.frequency, o.frequency);
            if(frequencycomparison !=0){
                return frequencycomparison;
            }
            return 0;
        }


    }
//
//    public int[] FrequencyTable() {
//        int[] freq = new int[ASCII_TABLE];
//        BufferedReader br =null;
//        try {
//
//            String sCurrentLine;
//            br = new BufferedReader(new FileReader("frequencies.dat"));
//
//            int i = 0;
//            while ((sCurrentLine = br.readLine()) != null) {
//                String[] arr = sCurrentLine.split(" ");
//                freq[i] = Integer.parseInt(arr[1]);
//                i++;
//            }
//            return freq;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }


}


package org.hua.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


class Huffman_tree {
    private static int ASCII_TABLE = 128;


    //building the tree
    public static Node Huffman(int[] freq){
        //using our priorityque(min heap)
        MinHeap<Node> minheap = new MinHeap<>();
        //creating the nodes without children
        for(char i=0;i<ASCII_TABLE;i++){
            if(freq[i]>0){
                minheap.insert(new Node(i,freq[i],null,null));
            }
        }
        //if our input array has only one character
        if(minheap.size()==1){
            minheap.insert(new Node('\0',1,null,null));
        }
        //starting to add children from the min heap
        //keep looping until we reach the root of the tree
        while(minheap.size()>1){
            Node left = minheap.deleteMin();
            Node right = minheap.deleteMin();
            //adding the two frequencies we get and making the parent node
            //'\0'(null) indicates that its not a leaf node
            Node parent = new Node('\0',left.frequency + right.frequency,left,right);
            minheap.insert(parent);
        }//returns the final Node(root)
        return minheap.deleteMin();

    }
    //root of tree
    static class Node implements Comparable<Node>{
        private char character;
        private int frequency;
        private Node left;
        private Node right;

        private Node(char character,int frequency,Node left, Node right){
            this.character= character;
            this.frequency=frequency;
            this.left=left;
            this.right=right;
        }
        //checking if a node has children
        boolean isLeaf(){
            return this.left ==null && this.right==null;
        }
        //comparing nodes
        //without it we cannot call minheap
        @Override
        public int compareTo(Node o) {
            int freqComp = Integer.compare(this.frequency, o.frequency);
            if(freqComp !=0){
                return freqComp;
            }
            return Integer.compare(this.character, o.character);
        }
    }
    //check every character in the file and return freqyency of every character
    public static int[] FrequencyTable(String data) throws FileNotFoundException, IOException {
        int[] freq = new int[ASCII_TABLE];

        for(char character :data.toCharArray()){
            freq[character]++;
        }
        return freq;

    }
    

}


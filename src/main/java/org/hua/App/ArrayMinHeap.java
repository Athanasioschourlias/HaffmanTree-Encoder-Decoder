package org.hua.App;

import java.util.PriorityQueue;

public class ArrayMinHeap implements MinHeap {

    private final int CAP = 127;//Because we want to start from 1.
    private int[] Heap = new int[CAP];
    private static final int root = 1;//the Heap[1] is the root of the binary tree.
    private int size;


    public ArrayMinHeap(){
        this.size = 0;
//        Heap[0] = Integer.MIN_VALUE;

    }

    @Override
    public void insert() {

    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int extractMin() {
        return 0;
    }

    @Override
    public void Heapify() {

    }

    /*
     Function to swap two nodes of the heap, the order doesnt matter but it is prefered to put the node with the smallest index at
     the first positional parameter and the node with the higher index at the second positional parameter.
     */
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to return the position of
    // the parent for the node currently
    // at pos
    private int parent(int pos)
    {
        return pos / 2;
    }

    // Function to return the position of the
    // left child for the node currently at pos
    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    // Function to return the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    // Function that returns true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    //this is the class where we create the template for the nodes of the binnary tree.
    private static class node<F extends Comparable<F>,L>{
        public F frequency;
        public L letter;//if the node is a leaf we store the letter of this node.
        public node<F,L> left, right;

        public node(F frequency, L letter){
            this.frequency = frequency;
            this.letter = letter;
            this.left = null;
            this.right = null;

        }

    }

}

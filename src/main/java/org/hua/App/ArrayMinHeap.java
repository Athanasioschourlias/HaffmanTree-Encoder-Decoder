package org.hua.App;

import java.util.NoSuchElementException;

class ArrayMinHeap<Node extends Comparable<Node>> implements MinHeap {

    private final int CAP = 128;//Because we want to start from 1.
    private Node[] HeapArray;
    private static final int root = 1;//the Heap[1] is the root of the binary tree.
    private int size;


    public ArrayMinHeap(){
        this.size = 0;
        this.HeapArray = (Node[]) new Comparable[CAP + 1];


    }

    //TODO:Check the interface.
    //adding an ellement to th array
    @Override
    public void insert(Object elem) {
        /*
         * We adding one to the size variable before we use it because we decided to
         * start the table from the index one possition.
         *
         */
        //TODO:POSSIBLE BUG with the casting.
        HeapArray[++size] = (Node) elem;
        fixup(size);
    }

    @Override
    public Node getMin() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return HeapArray[1];
    }

    @Override
    public Node extractMin() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        //Making a variable node to keep the node we will delete from the heap.
        Node result = HeapArray[1];

        HeapArray[1]=HeapArray[size];
        HeapArray[size]=null;
        size--;
        fixdown(1);
        /*
         * We call the fixdown method at the first element of the table because
         * when we delete an element from a array min heap(only the first one can
         * be deleted) we first swap the last element of the table with the first
         * one and then we delete the min(first) element.
         */
        return result;
    }

    @Override
    public void clear() {
        for(int i=1; i<= size ; i++){
            HeapArray[i]=null;
        }
        size =0;
        return;
    }

    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /*
     Function to swap two nodes of the heap, the order doesnt matter but it is prefered to put the node with the smallest index at
     the first positional parameter and the node with the higher index at the second positional parameter.
     */
    private void swap(int fpos, int spos)
    {
        Node tmp;
        tmp = HeapArray[fpos];
        HeapArray[fpos] = HeapArray[spos];
        HeapArray[spos] = tmp;

    }
    //starts with last element added and checks if its smaller than its parent
    //if it is parent and child swap
    private void fixup(int size) {
        //TODO:Check size
        //KEEP IN MIND: the size variable has nothing to do with the size variable
        //of the class.
        while (size > 1 && HeapArray[size].compareTo(HeapArray[parent(size)]) < 0) {
            swap(size, parent(size));
            size = parent(size);
        }

    }

    private void fixdown(int pos) {
        while(leftChild(pos) <= this.size){
            int j = leftChild(pos);
            if(rightChild(pos) <pos && HeapArray[j+1].compareTo(HeapArray[j])< 0){
                j++;
            }
            if(HeapArray[pos].compareTo(HeapArray[j])<= 0){
                break;
            }
            swap(pos,j);
            pos = j;
        }
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

}

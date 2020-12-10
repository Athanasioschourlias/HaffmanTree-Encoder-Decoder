package org.hua.App;

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
    public void clear() {

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

    private void fixup(int k) {

    }

    private void fixdown(int k) {

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

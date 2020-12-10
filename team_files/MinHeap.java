package org.hua.App;

import java.util.NoSuchElementException;

class MinHeap<Node extends Comparable<Node>> {
    public static final int DEFAULT_CAPACITY =128;
    private Node[] array;
    private int size;


    public MinHeap() {
        this.size = 0;
        this.array = (Node[]) new Comparable[DEFAULT_CAPACITY+1];
    }

    //add element in array
    public void insert(Node elem) {

        if(size+1 >= array.length){
            doubleCapacity();
        }
        array[++size] = elem;
        fixup(size);
    }

    //returns the first element of the array which is also the minimum(root)
    public Node findMin() {
        if(isEmpty()){
            throw new NoSuchElementException();

        }
        return array[1];
    }
    //extract the minimum element
    public Node deleteMin() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node result = array[1];

        array[1]=array[size];
        array[size]=null;
        size--;
        fixdown(1);

        return result;
    }
    //checks if array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {

        return size;
    }

    public void clear() {
        for(int i=1; i<= size ; i++){
            array[i]=null;
        }
        size =0;
    }
    private void swap(int i, int j){
        Node tmp = array[i];
        array[i]=array[j];
        array[j]= tmp;
    }
    //starts with last element added and checks if its smaller than its parent
    //if it is parent and child swap
    private void fixup(int k){
        assert k>=1 && k<= size;
        while(k>1 && array[k].compareTo(array[k/2]) <0){
            swap(k, k/2);
            k = k/2;
        }

    }
    //starts by checking if the element has children
    //compares which children is smaller and then swaps with the smallest one
    private void fixdown(int k){
        while(2*k <= size){
            int j = 2*k;
            if(j+1 <size && array[j+1].compareTo(array[j])< 0){
                j++;
            }
            if(array[k].compareTo(array[j])<= 0){
                break;
            }
            swap(k,j);
            k= j;
        }
    }



}


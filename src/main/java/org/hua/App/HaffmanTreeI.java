package org.hua.App;

public interface HaffmanTreeI<Node> {
    
    //creating the structure of the tree 
    Node Haffman();
    //reads fequencies from our file in an array so they can be inserted in the min heap
    int[] ReadFrequencies();


}

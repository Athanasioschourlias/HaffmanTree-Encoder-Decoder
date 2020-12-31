package org.hua.App;

public interface MinHeap<Node extends Comparable<Node>>
{

    /**
     * For inserting an element to the heap
     * @param elem
     */

    void insert(Node elem);

    /**
     *
     * @return root element, smallest element  in a Binary tree.
     */

    Node getMin();

    /**
     * With this method we delete the smallest element of the tree(root, if the execution is with minHeap)
     * @return the value of the element we deleted.If the deletion of the element fails we return -1.(In this case we know this will not effect
     * us in the future because our algorithm only deals with possitive numbers.
     */

    Node extractMin();

    /**
     * This method when it's called it goes through the table and puting a null value to every pointer to a node.
     * with this method, we leave the job of "cleaning" the memmory.
     */

    void clear();

    /**
     * This method checks if the array/tree is empty and returns the respective result to
     * the user.
     * @return true/false
     */

    boolean isEmpty();
}

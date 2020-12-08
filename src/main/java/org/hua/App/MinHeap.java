package org.hua.App;

public interface MinHeap {

    /**
     * For insserting an ellement to the heap
     */
    void insert();

    /**
     *
     * @return root element, smallest element  in a Binary tree.
     */
    int getMin();

    /**
     * With this method we delete the smallest element of the tree(root, if the execution is with minHeap)
     * @return the value of the element we deleted.If the deletion of the element fails we return -1.(In this case we know this will not effect
     * us in the future because our algorithm only deals with possitive numbers.
     */
    int extractMin();

    /**
     * By starting from the midle of the table (i/2),rounded down. Which this will be the parent node of the ferthest right binary tree there is
     * we execute a up-down short to this binary tree and subtract one from the parent node we found untill we are on the root element.
     */
    void Heapify();
}

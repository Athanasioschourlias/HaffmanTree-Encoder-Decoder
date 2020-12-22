package org.hua.App;

import org.junit.Test;

import java.util.Random;
import static org.junit.Assert.*;

public class MinHeapTest {

    @Test
    public void testArrayMinHeap()
    {

        Random rng = new Random(23);

        ArrayMinHeap<Node> h = new ArrayMinHeap<>();
        Node currentMin = null;

        for (int i = 0; i < 128; i++)
        {
            Node node = new Node(rng.nextInt());

            if ( currentMin == null || node.value < currentMin.value )
            {
                currentMin = node;
            }

            h.insert(node);

            assertTrue(h.getSize() == i + 1);
            if (currentMin.compareTo(h.getMin()) != 0 ){
                throw new AssertionError();
            }

        }

        while (!h.isEmpty())
        {
            h.extractMin();
        }

        assertTrue(h.isEmpty());

    }

    public class Node implements Comparable<Node> {
        public int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            //Advanced way to do tha same thing.
//            int frequencycomparison = Integer.compare(this.value, o.value);
//            if(frequencycomparison !=0)
//            {
//                return frequencycomparison;
//            }
//            return 0;
            if(this.value == o.value){
                return 0;
            }else if(this.value > o.value ){
                return 1;
            }else {
                return -1;
            }
        }
    }

}

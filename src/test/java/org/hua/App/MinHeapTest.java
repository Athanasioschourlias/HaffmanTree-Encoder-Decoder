package org.hua.App;

import org.junit.Test;

import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MinHeapTest {

    @Test
    public void testArrayMinHeap()
    {

        Random rng = new Random(17);

        ArrayMinHeap<Node> h = new ArrayMinHeap<>();
        Node currentMin = new Node(rng.nextInt());
        for (int i = 0; i < 128; i++)
        {
            Node node = new Node(rng.nextInt());

            if ( node.value < currentMin.value )
            {
                currentMin.value = node.value;
            }
            h.insert(node);
            assertEquals(h.getSize(), i + 1);
            if (currentMin.compareTo(h.getMin()) == 0 ){

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
            int frequencycomparison = Integer.compare(this.value, o.value);
            if(frequencycomparison !=0)
            {
                return frequencycomparison;
            }
            return 0;
        }
    }

}

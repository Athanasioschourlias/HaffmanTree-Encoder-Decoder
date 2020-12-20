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

        ArrayMinHeap<Huffmantree.Node> h = new ArrayMinHeap<>();
        Integer currentMin = null;
        for (int i = 0; i < 10000; i++)
        {
            int key = rng.nextInt(500);
            if (currentMin == null || key < currentMin)
            {
                currentMin = key;
            }
            h.insert(key);
            assertTrue(h.getSize() == i + 1);
            assertEquals(h.getMin(), currentMin);
        }

        while (!h.isEmpty())
        {
            h.extractMin();
        }

        assertTrue(h.isEmpty());

    }


}

/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.App;

import java.util.Iterator;

public interface Queue<E> extends Iterable<E> {

	/**
	 * Push a new element into the queue
	 * 
	 * @param elem the element
	 */
	void push(E elem);
	
	/**
	 * Pop last element from the queue
	 */
	E pop();
	
	/**
	 * Return the first element of the queue
	 *  
	 * @return the first element of the queue
	 */
	E first();
	
	/**
	 * Check if a queue is empty
	 * 
	 * @return true if empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Get the size of the queue
	 * 
	 * @return the size of the queue
	 */
	int size();
	
	/**
	 * Clear the queue
	 */
	void clear();

	/**
	 * Get a key iterator.
	 *
	 * @return a key iterator
	 */
	@Override
	Iterator<E> iterator();
	
}

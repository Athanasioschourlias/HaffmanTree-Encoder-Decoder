package org.hua.App;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E>  {

	private Node<E> head,tail;
	private int size;

	public LinkedQueue(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}


	private static class Node<E>{
		public  E data;
		public Node<E> next;
	}

	@Override
	public void push(E elem) {
		Node<E> n = new Node<>();
		n.data = elem;
		n.next = null;

		if(head == null){
			//queue is empty
			head = n;
		}else {
			//queue not empty
			tail.next = n;
		}
		tail = n;
		size++;
	}

	@Override
	public E pop() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}

		E result = head.data;
		head = head.next;
		if(head == null){
			tail = null;
		}
		size--;
		return result;
	}

	@Override
	public E first() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}

		return head.data;
	}

	public Node<E> getHead()
	{
		return head;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		return;
	}


	@Override
	public Iterator<E> iterator() {
		//with the keyword this we "give" the iterator the specific list we are right now to iterate.
		return new QueueIterator<>(this);
	}

	private class  QueueIterator<E> implements Iterator<E>{

		//TODO: FINISH MEE
		Node<E> current;

		// initialize pointer to head of the list for iteration
		public QueueIterator(LinkedQueue<E> Queue)
		{
			current = Queue.getHead();
		}

		// returns false if next element does not exist
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E data = current.data;
			current = current.next;
			return data;
		}
	}
	
}

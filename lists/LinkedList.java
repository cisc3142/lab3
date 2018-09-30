package lists;

import java.util.*;

public class LinkedList<E> extends AbstractList<E> implements List<E> {

	protected class Node {
		protected E data;
		protected Node next;
		protected Node() {}
		protected Node(E data) { this.data = data; }
	}

	protected void rangeCheck(int idx) {
		if (idx < 0 || idx >= size()) 
			throw new IndexOutOfBoundsException();
	}

	protected Node head;

	public LinkedList() {
		head = new Node();
		head.next = head;
	}

	public boolean add (E elt) {
		Node nnd = new Node(elt);
		Node tnd = head.next;
		while (tnd.next != head) tnd = tnd.next;
		tnd.next = nnd;
		nnd.next = head;
		return true;
	}

	public void add(int idx, E elt) {
		if (idx != size()) rangeCheck(idx);		
		// rangeCheck would throw an exception for an index equal to size(),
		// but that is a legal place to insert
		Node tnd = head.next;
		for (int i = 0; i < idx-1; i++) tnd = tnd.next;
		// tnd is now at the node before idx
		Node nnd = new Node(elt);
		nnd.next = tnd.next;
		tnd.next = nnd;
	}

	public E get(int idx) {
		rangeCheck(idx);
		Node tnd = head.next;
		for (int tidx = 0; tidx < idx; tidx++) tnd = tnd.next;
		// tnd now points to the node at idx
		// we don't need to check for null because we confirmed
		// that idx is in range
		return tnd.data;
	}

	public E remove() {
		if (head.next != head) {
			E removed = head.next.data;
			head.next = head.next.next;
			return removed;
		}
		throw new NoSuchElementException();		// if list is empty
	}

	public E remove(int index) {
		rangeCheck(index);
		Node tnd = head.next;
		for (int i = 0; i < index-1; i++) tnd = tnd.next;
		// tnd is now at the node before idx
		E removed = tnd.next.data;
		tnd.next = tnd.next.next;	
		return removed;
	}

	public int size() {
		int size = 0;
		for (Node tnd = head.next; tnd != head; tnd = tnd.next) {	
			size++;
		}
		return size;
	}

	public ListIterator listIterator() {
		return new LinkedListIterator(this, head.next, 0);
	}

	public ListIterator listIterator(int idx) {
		Node tnd = head.next;
		for (int i = 0; i < idx; i++) tnd = tnd.next;
		return new LinkedListIterator(this, tnd, idx);
	}
}

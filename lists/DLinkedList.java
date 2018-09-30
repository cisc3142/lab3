package lists;

import java.util.*;

public class DLinkedList<E> extends AbstractList<E> implements List<E> {

	protected class Node {
		protected E data;
		protected Node next, prev;
		protected Node() {}
		protected Node(E data) { this.data = data; }
	}

	protected void rangeCheck(int idx) {
		if (idx < 0 || idx >= size()) 
			throw new IndexOutOfBoundsException();
	}

	protected Node head;

	public DLinkedList() {
		head = new Node();
		head.prev = head;
		head.next = head;
	}

	public boolean add (E elt) {
		Node nnd = new Node(elt);
		nnd.next = head;
		nnd.prev = head.prev;
		nnd.next.prev = nnd;
		nnd.prev.next = nnd;
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
		nnd.prev = tnd;
		nnd.next.prev = nnd;
		nnd.prev.next = nnd;
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
			head.next.prev = head;
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
		tnd.next.prev = tnd;
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
		return new DLinkedListIterator(this, head.next, 0);
	}

	public ListIterator listIterator(int idx) {
		Node tnd = head.next;
		for (int i = 0; i < idx; i++) tnd = tnd.next;
		return new DLinkedListIterator(this, tnd, idx);
	}
}

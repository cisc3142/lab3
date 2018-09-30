package lists;

import java.util.*;

public class LinkedListIterator<E> implements ListIterator<E> {
	protected LinkedList<E>.Node next, lastReturned;
	protected int nextIndex;
	protected LinkedList<E> list;

	public LinkedListIterator(LinkedList<E> list, LinkedList<E>.Node next, int nextIndex) {
		this.next = next;
		this.nextIndex = nextIndex;
		this.list = list;
		this.lastReturned = null;
	}

	public boolean hasNext() {
		return next != list.head;
	}

	public boolean hasPrevious() {
		throw new UnsupportedOperationException();
	}

	public E next() {
		if (next == list.head) throw new NoSuchElementException();
		E elt = next.data;
		lastReturned = next;
		next = next.next;
		nextIndex++;
		return elt;
	}

	public E previous() {
		throw new UnsupportedOperationException(); 
	}
	
	public int nextIndex() { return nextIndex; }
	public int previousIndex() { throw new UnsupportedOperationException(); }

	public void add(E elt) {
		LinkedList<E>.Node nnd = list.new Node(elt);
		nnd.next = next;
		nextIndex++;
		lastReturned = null;
	}

	public void remove() {
		if (lastReturned == null) throw new IllegalStateException();
		LinkedList<E>.Node tnd = list.head;
		while (tnd.next != lastReturned) tnd = tnd.next;
		tnd.next = tnd.next.next;
		nextIndex--;
		lastReturned = null;
	}

	public void set(E elt) {
		if (lastReturned == null) throw new IllegalStateException();
		lastReturned.data = elt;
	}

}

package lists;

import java.util.*;

public class DLinkedListIterator<E> implements ListIterator<E> {
	protected DLinkedList<E>.Node next, lastReturned;
	protected int nextIndex;
	protected DLinkedList<E> list;

	public DLinkedListIterator(DLinkedList<E> list, DLinkedList<E>.Node next, int nextIndex) {
		this.next = next;
		this.nextIndex = nextIndex;
		this.list = list;
		this.lastReturned = null;
	}

	public boolean hasNext() {
		return next != list.head;
	}

	public boolean hasPrevious() {
		throw new UnsupportedOperationException();		// TODO
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
		throw new UnsupportedOperationException(); 	// TODO
	}
	
	public int nextIndex() { return nextIndex; }
	public int previousIndex() { throw new UnsupportedOperationException(); }	// TODO

	public void add(E elt) {
		DLinkedList<E>.Node nnd = list.new Node(elt);
		nnd.next = next;		// TODO
		nextIndex++;
		lastReturned = null;
	}

	public void remove() {
		if (lastReturned == null) throw new IllegalStateException();
		DLinkedList<E>.Node tnd = list.head;
		while (tnd.next != lastReturned) tnd = tnd.next;
		tnd.next = tnd.next.next;		// TODO
		nextIndex--;
		lastReturned = null;
	}

	public void set(E elt) {
		if (lastReturned == null) throw new IllegalStateException();
		lastReturned.data = elt;
	}

}

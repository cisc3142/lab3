package lists;

import java.lang.Comparable;
import java.util.*;

public class Sorts {
	
	public static <E extends Comparable> void SelectionSort(List<E> c) {
		// Implement selection sort using the ListIterator interface
		// Look up the selection sort code in our notes and translate
		// it line by line.
		// Use the ListIterator methods hasNext(), next(), nextIndex(),
		// and set(E)
		// The first line is included to get you started.
		ListIterator<E> iit = c.listIterator(), jit;
	}

	public static void printList(List c) {
		for (Object i : c) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	public static void fillList(List c) {
		Random r = new Random();
		for (int i = 0; i < 20; i++) c.add(i);
		Collections.shuffle(c);
	}

	public static void testList(List c) throws Exception {
		fillList(c);
		printList(c);
		SelectionSort(c);
		printList(c);
		List cc = new ArrayList(c);
		Collections.sort(c);
		for (int i = 0; i < c.size(); i++) 
			if (c.get(i) != cc.get(i))
				throw new Exception("List not sorted");
	}
	
	public static void main(String[] args) throws Exception {
		List<Integer> lst2 = new ArrayList<Integer>();
		testList(lst2);
		List<Integer> lst1 = new DLinkedList<Integer>();
		testList(lst1);
		List<Integer> lst3 = new LinkedList<Integer>();
		testList(lst3);
	}
}

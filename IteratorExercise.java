import java.lang.Comparable;
import java.util.*;

public class IteratorExercise {
	
	public static <E extends Comparable<? super E>> void bubbleSort(List<E> c) throws Exception {
		// first line to start you off
		ListIterator<E> iit = c.listIterator(), jit;

		/**** Test code: do not modify *****/
		List cc = new LinkedList(c);
		Collections.sort(c);
		ListIterator it1 = c.listIterator(), it2 = cc.listIterator();
    while (it1.hasNext()) {
      if (!it1.next().equals(it2.next()))
				throw new Exception("List not sorted");
    }
		/***********************************/
	}

  public static <E> void reverseList(List<E> c) throws Exception {
		/**** Test code: do not modify *****/
		LinkedList cc = new LinkedList(c);
		/***********************************/

		// Reverse the list using iterators. Do not use List methods

  	/**** Test code: do not modify *****/
		Iterator it1 = c.listIterator(), it2 = cc.descendingIterator();
		while (it1.hasNext()) {
      if (!it1.next().equals(it2.next()))
				throw new Exception("List not reversed");
    }
		/***********************************/
  }

	public static <E> void removeEveryOtherElement(List<E> c) throws Exception {
		/**** Test code: do not modify *****/
		LinkedList cc = new LinkedList(c);
		/***********************************/

		// Remove every other element (starting with the second element:
		// all odd indices)

  	/**** Test code: do not modify *****/
		printList(cc);
		printList(c);
		ListIterator it1 = c.listIterator(), it2 = cc.listIterator();
		while (it1.hasNext()) {
      if (!it1.next().equals(it2.next()))
				throw new Exception("Even indices not equal");
			if (!it1.hasNext()) break;
			if (it1.next().equals(it2.next()))
				throw new Exception("Odd index not removed");
			it1.previous();
    }
		/***********************************/
	}

	public static void printList(List c) {
		StringBuilder str = new StringBuilder();
		String sep = " ";
		for (Object i : c) {
			str.append(i);
			str.append(sep);
		}
		System.out.println(str.toString());
	}

	public static void fillList(List<Integer> c) {
		Random r = new Random();
		for (int i = 0; i < 23; i++) c.add(i);
		Collections.shuffle(c);
	}

	public static void main(String[] args) {
		try {
		List<Integer> lst = new ArrayList<Integer>();
		fillList(lst);

		bubbleSort(lst);

		removeEveryOtherElement(lst);

		reverseList(lst);
		} catch (Exception e) { System.err.println(e.getMessage()); }
	}
}

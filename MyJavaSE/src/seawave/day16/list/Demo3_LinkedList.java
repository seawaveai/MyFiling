package seawave.day16.list;

import java.util.LinkedList;

public class Demo3_LinkedList {

	/**
	 * 	 public void addFirst(E e)及addLast(E e)
		* public E getFirst()及getLast()
		* public E removeFirst()及public E removeLast()
		* public E get(int index);
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst("a");
		list.addFirst("b");
		list.addFirst("c");
		list.addFirst("d");
		list.addLast("e");
		
		//System.out.println(list.getFirst());
		//System.out.println(list.getLast());
		//System.out.println(list.removeFirst());
		//System.out.println(list.removeLast());
		
		System.out.println(list.get(1));
		System.out.println(list);
	}
/*dcbae*/
}


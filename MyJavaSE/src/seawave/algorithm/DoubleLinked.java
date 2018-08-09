/**
 * 
 */
package seawave.algorithm;

/**
 * 双链表
 * 
 * @author Xikang61
 * 
 */
public class DoubleLinked {

	private class Node {// 节点 
		Node pre;
		Object data;
		Node next;
	}

	private Node head;// 指向头节点
	private Node real;// 指向尾节点

	public void add(Object data) {
		// 1.创建节点
		Node note = new Node();
		// 2.添加数据
		note.data = data;
		// 3.把节点链接到链表中
		if (head == null) {
			head = note;
			real = note;
		} else {
			// 原来尾节点的next属性指向新的节点
			real.next = note;
			// 新节点的pre属性指向原来的尾节点
			note.pre = real;
			// 新的节点成为尾节点
			real = note;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer mess = new StringBuffer("[");
		// 从头节点遍历所有节点的数据
		Node temp = head;
		while (temp != null) {
			// 节点有数据
			// 如果是最后一个节点，加] 否则 加 ，
			if (temp != real) {
				// 不是最后一个节点
				mess.append(temp.data + ", ");
			} else {
				// 最后一个节点
				mess.append(temp.data + "]");
			}
			temp = temp.next;
		}
		return mess.toString();
	}

}

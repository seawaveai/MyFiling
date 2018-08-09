/**
 * 
 */
package seawave.algorithm;

import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * @author Xikang61
 * 1.添加泛型
 * 2.实现迭代器
 * 3.添加堆栈功能
 */
public class DoubleLink2<T> implements Iterable<T> {

	// 添加堆栈的功能
	public boolean isEmpty() {
		return head == null;
	}

	public void push(T data) {
		add(data);
	}

	/**
	 * 出栈
	 */
	public T pop() {
		T data = null;
		// 从尾节点开始取
		if (rear == null) {
			// 没有数据
			throw new EmptyStackException();
		} else {
			data = rear.data;
			// 防止有重复数据,不调用remove方法 ;重新写移除
			if (rear.prev != null) {
				// 前面有数据
				rear = rear.prev;
				rear.next = null;
			} else {
				// 前面没有数据
				rear = null;
				head = null;
			}
		}

		return data;
	}

	// 节点类
	private class Node {
		Node prev;// 存放上一个节点的地址
		T data;// 节点存放的数据
		Node next;// 存放下一个节点的地址
	}

	private Node head;// 指向头节点
	private Node rear;// 指向尾节点

	private int modCount;

	/**
	 * 添加数据 尾部添加
	 * 
	 * @param data
	 */
	public void add(T data) {
		// 1.创建节点
		Node node = new Node();
		// 2. 放数据
		node.data = data;
		// 3.把节点链接到链表中
		if (head == null) {
			// 没有数据
			// 是链表中的第一个节点
			head = node;
			rear = node;
		} else {
			// 1. 尾部添加
			// 原来的尾节点的next属性指向新节点
			rear.next = node;
			// 新节点的prev属性指向原来的尾节点
			node.prev = rear;
			// 新节点成为新的尾节点
			rear = node;
		}
		modCount++;
	}

	private Node find(T data) {
		Node temp = head;// 从头节点开始遍历
		while (temp != null) {
			if (temp.data.equals(data)
					&& temp.data.hashCode() == data.hashCode()) {
				// 判断数据是否一致 1.equals 2. hashCode 共同决定
				break;// 已经找到数据
			} else {
				// 继续查找下一个节点
				temp = temp.next;
			}
		}
		return temp;// 找到数据所在的节点
	}

	/**
	 * 删除数据
	 * 
	 * @param data
	 */
	public void remove(T data) {
		// 删除节点 4种： 0.即使头节点也是尾节点 1.head 2. rear 3. middle

		// 1. 先查找数据所在的节点
		Node delete = find(data);

		if (delete != null) {
			// 4种
			if (delete == head && delete == rear) {
				// 0. 即使头节点也是尾节点
				head = null;
				rear = null;// 链表为空
			} else if (delete == head) {
				// 1. head,后面肯定有节点
				head = head.next;// 第二个节点成头节点
				head.prev = null;// 头节点前面没有节点

			} else if (delete == rear) {
				// 2. rear
				rear = rear.prev;// 倒数第二节点成为新的尾节点
				rear.next = null;// 尾节点后面没数据

			} else {
				// 3. middle
				// 1. 删除节点的前一个节点的next属性指向删除节点的下一个节点
				delete.prev.next = delete.next;
				// 2. 删除节点的后一个节点的prev属性指向删除节点的上一个节点
				delete.next.prev = delete.prev;
			}
			modCount++;
		}
	}

	/**
	 * 容器中是否包含data
	 * 
	 * @param data
	 * @return
	 */
	public boolean contains(T data) {
		Node node = find(data);
		return node != null;
	}

	/**
	 * 数据的更新
	 * 
	 * @param oldData
	 *            老数据
	 * @param newData
	 *            新数据
	 */
	public void update(T oldData, T newData) {
		// 1. 先找到老数据所在的节点
		Node node = find(oldData);
		// 2. 把节点中data属性指向newData
		if (node != null) {
			// 找到
			node.data = newData;
			modCount++;
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
			if (temp != rear) {
				// 不是最后一个节点
				mess.append(temp.data + ", ");
			} else {
				// 最后一个节点
				mess.append(temp.data + "]");
			}
			temp = temp.next;
		}
		return mess + "";
	}

	@Override
	public Iterator<T> iterator() {
		// 匿名类对象
		return new Iterator<T>() {
			private Node temp = head;// temp指向头节点
			private int currentTag = modCount;

			@Override
			public boolean hasNext() {
				if (temp != null) {
					return true;
				}
				return false;
			}

			@Override
			public T next() {
				if (currentTag != modCount) {
					// 迭代数据过程中，对容器做了增删改操作
					throw new ConcurrentModificationException("不能做增删改");
				}
				// 返回数据
				T data = temp.data;
				temp = temp.next;// 改变temp指向下一个节点
				return data;
			}

			@Override
			public void remove() {

			}
		};
	}
}

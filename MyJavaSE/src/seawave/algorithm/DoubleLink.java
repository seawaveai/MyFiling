/**
 * 
 */
package seawave.algorithm;

/**
 * @author Xikang61
 * 判断数据是否一致： 1.equals 2.hashCode 共同决定。
 */
public class DoubleLink {
	// 节点类
	public class Node {
		Node prev;// 存放上一个节点的地址
		Object data;// 节点存放的数据
		Node next;// 存放下一个节点的地址
	}

	public Node head;// 指向头节点
	public Node rear;// 指向尾节点

	/**
	 * 添加数据 尾部添加
	 * 
	 * @param data
	 */
	public void add(Object data) {
		/*if (contains(data)) {//判断该元素是否已经存在
			return;			
		}*/
		
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
	}

	private Node find(Object data) {
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
		return temp;//找到数据所在的节点
	}

	/**
	 * 删除数据
	 * 
	 * @param data
	 */
	public void remove(Object data) {
		// 删除节点 3种 1. head 2. rear 3. middle

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
		}
	}

	/**
	 * 容器中是否包含data
	 * 
	 * @param data
	 * @return
	 */
	public boolean contains(Object data) {
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
	public void update(Object oldData, Object newData) {
		// 1. 先找到老数据所在的节点
		Node node = find(oldData);
		// 2. 把节点中data属性指向newData
		if (node != null) {
			// 找到
			node.data = newData;
		}
	}

	@Override
	public String toString() {
		StringBuffer mess = new StringBuffer("[");
		// 从头节点遍历所有节点的数据
		Node temp = this.head;
		while (temp != null) {
			// 节点有数据
			// 如果是最后一个节点，加] 否则 加 ，
			if (temp != this.rear) {
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

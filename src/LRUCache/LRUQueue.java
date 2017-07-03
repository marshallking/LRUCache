package LRUCache;

import java.util.LinkedList;

public class LRUQueue {

	public class QueueNode {
		public String Value; // use an interface so that it will accept any data
								// type
	}

	private int capasity;
	private LinkedList<QueueNode> Queue;

	public LRUQueue(int size) {
		// TODO Auto-generated constructor stub
		Queue = new LinkedList<QueueNode>();
		capasity = size;
	}

	public void printLRU(LinkedList<QueueNode> lruQueue) {
		lruQueue.forEach((temp) -> {
			System.out.println(temp.Value);
		});
	}

	public LinkedList<QueueNode>  getQueue() {
		return Queue;
	}
	public int  capasity() {
		return capasity;
	}

	public QueueNode newNode() {
		return new QueueNode();
	}

	public boolean removeNode(QueueNode node) {
		return Queue.remove(node);
	}

	public boolean containsNode(QueueNode node) {
		return Queue.contains(node);
	}

	public boolean isFirstNode(QueueNode node) {
		return Queue.getFirst() == node;

	}

	public void addFirst(QueueNode node) {
		Queue.addFirst(node);
		return;
	}

	public QueueNode removeLast() {
		return Queue.removeLast();
	}

	public boolean isQueueFull() {

		return (Queue.size() == capasity);
	}

}

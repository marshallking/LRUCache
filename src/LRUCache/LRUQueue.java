package LRUCache;

import java.util.LinkedList;

public class LRUQueue {

	public class QueueNode {
		public String Value; // use an interface so that it will accept any data
								// type
	}
	int count;
	int capasity;
	LinkedList<QueueNode> Queue;

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

	public QueueNode newNode() {
		return new QueueNode();
	}

}

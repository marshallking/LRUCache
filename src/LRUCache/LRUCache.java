package LRUCache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

	public static final int NOT_FOUND = 0;
	public static final int FOUND = 1;
	public static final int OK = 1;
	public static final int ERROR = 0;

	public LRUQueue cacheQueue;

	public LRUCache(LRUQueue lruQueue) {
		// TODO Auto-generated constructor stub
		cacheQueue = lruQueue;
	}

	public Hash hash;

	class Hash {
		public int capasity;
		public HashMap<String, LRUQueue.QueueNode> hashmap;
	}

	public Hash createHash(int capasity) {

		// create the queue
		hash = new Hash();
		hash.hashmap = new HashMap<String, LRUQueue.QueueNode>(capasity);
		hash.capasity = capasity;

		return hash;
	}

	public void printHash(Hash iihash) {
		hash.hashmap.forEach((key, value) -> System.out.println("HASH VALUE " + key + " : " + value));
	}

	public int set(String key, String value) {

		synchronized (hash) {
			LRUQueue.QueueNode tmpNode = null;
			// --------------------------------------------- DEBUG ONLY
			// int myQueueSize = lruqueue.Queue.size();
			// int myHashSize = hash.hashmap.size();
			// System.out.println("queue size:" + " : " + myQueueSize + "
			// Hashsize
			// :" + myHashSize);
			// --------------------------------------------- DEBUG ONLY
			// -----------------------------------------------------------
			// check if key is in hash.. if so, then get the node pointer
			// -----------------------------------------------------------
			if (hash.hashmap.containsKey(key)) {
				tmpNode = hash.hashmap.get(key);
			}

			if (tmpNode != null) {
				// if the node is in the queue,then remove
				if (cacheQueue.Queue.contains(tmpNode)) {
					cacheQueue.removeNode(tmpNode);
					// else if the queue is full,then make room for new node
				} else if (cacheQueue.isQueueFull()) {
					cacheQueue.removeLast();
				}
			} else {
				// if (cacheQueue.Queue.size() == hash.capasity) {
				if (cacheQueue.isQueueFull()) {
					cacheQueue.removeLast();
				}
			}
			// in all cases we add the node to beginning of the queue
			LRUQueue.QueueNode node = cacheQueue.newNode();
			node.Value = value;
			cacheQueue.addFirst(node);
			hash.hashmap.put(key, node);
		}
		// --------------------------------------------- DEBUG ONLY
		// myQueueSize = lruqueue.Queue.size();
		// myHashSize = hash.hashmap.size();
		// System.out.println("queue size:" + " : " + myQueueSize + " Hashsize
		// :" + myHashSize);
		// --------------------------------------------
		return OK;
	}

	// ---------------------------------------------------------------------------------------
	// Get an item out of the cache, If it is not there, then return NOTFOUND
	// If the item is there, then promote the item to front of LRU cache
	// ---------------------------------------------------------------------------------------
	public LRUQueue.QueueNode get(String key) {

		synchronized (hash) {
			LRUQueue.QueueNode tmpNode = null;
			// -------DEBUG ONLY
			// -----------------------------------------------------------------
			// int myQueueSize = lruqueue.Queue.size();
			// int myHashSize = hash.hashmap.size();
			// System.out.println("queue size:" + " : " + myQueueSize + "
			// Hashsize
			// :" + myHashSize);
			// -----------------------------------------------------------------------------------
			// check if key is in hash.. if so, then get the node pointer
			if (hash.hashmap.containsKey(key)) {
				tmpNode = hash.hashmap.get(key);
			}

			if (tmpNode != null) {
				if (cacheQueue.containsNode(tmpNode)) {
					// if it is already on top of queue, then do nothing
					if (!cacheQueue.isFirstNode(tmpNode)) {
						cacheQueue.removeNode(tmpNode);
					} else {
						return tmpNode;
					}
				} else {
					return null;
				}
				// ------------------------------------------------
				// add/promote the new node to front of LRU cache
				// ------------------------------------------------
				LRUQueue.QueueNode node = cacheQueue.newNode();
				node.Value = key;
				cacheQueue.addFirst(node);
				hash.hashmap.put(key, node);
			} else {
				return null;
			}
			return tmpNode;
		}
	}
}

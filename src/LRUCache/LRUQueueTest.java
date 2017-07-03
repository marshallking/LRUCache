package LRUCache;

import static org.junit.Assert.*;
import org.junit.*;
 
public class LRUQueueTest {

	@Test
	public void testQueueSize() {
		LRUQueue test = new LRUQueue(5);
		assertEquals(5, test.capasity);
	}

	@Test
	public void testNewNode() {
		LRUQueue test = new LRUQueue(5);
		LRUQueue.QueueNode result = test.newNode();
		assertNotEquals(null, result);
	}

}

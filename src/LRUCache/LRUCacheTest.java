package LRUCache;

import static org.junit.Assert.*;
import org.junit.Test;


public class LRUCacheTest {

	@Test
	public void testHashSize() {

		LRUQueue lruQueue = new LRUQueue(3);
		LRUCache lruCache = new LRUCache(lruQueue);
		LRUCache.Hash result = lruCache.createHash(3);
		assertEquals(3, result.capasity);
	}

	@Test
	public void testSet() {

		LRUQueue lruQueue = new LRUQueue(3);
		LRUCache lruCache = new LRUCache(lruQueue);
		lruCache.createHash(3);
		lruCache.set("foo", "5");
		LRUQueue.QueueNode resultNode = lruCache.get("foo");
		assertEquals("5", resultNode.Value);
	}

	@Test
	public void testMultipleSet() {

		LRUQueue lruQueue = new LRUQueue(3);
		LRUCache lruCache = new LRUCache(lruQueue);
	    lruCache.createHash(3);
		lruCache.set("foo", "5");
		lruCache.set("foo", "6");
		lruCache.set("foo", "7");
	    lruCache.set("foo", "8");

		LRUQueue.QueueNode resultNode = lruCache.get("foo");

		assertEquals("8", resultNode.Value);
	}

	@Test
	public void testMultipleMixedSet() {

		LRUQueue lruQueue = new LRUQueue(3);
		LRUCache lruCache = new LRUCache(lruQueue);
		lruCache.createHash(3);
		lruCache.set("foo", "5");
		lruCache.set("foo1", "6");
		lruCache.set("foo2", "7");
		lruCache.set("foo3", "8");

		LRUQueue.QueueNode resultNode = lruCache.get("foo1");

		assertEquals("6", resultNode.Value);
	}

	@Test
	public void testMultipleMixedSetFallOff() {

		LRUQueue lruQueue = new LRUQueue(3);
		LRUCache lruCache = new LRUCache(lruQueue);
		lruCache.createHash(3);
		lruCache.set("foo", "5");
		lruCache.set("foo1", "6");
		lruCache.set("foo2", "7");
		lruCache.set("foo3", "8");

		LRUQueue.QueueNode resultNode = lruCache.get("foo");

		assertEquals(null, resultNode);
	}

	@Test
	public void testBrandVerity() {

		LRUQueue lruQueue = new LRUQueue(3);
		LRUCache lruCache = new LRUCache(lruQueue);
		LRUCache.Hash result = lruCache.createHash(3);

		/*
		 * GET foo NOTFOUND SET foo 1 SET OK GET foo GOT 1 SET foo 1.1 SET OK
		 * GET foo GOT 1.1 SET spam 2 SET OK GET spam GOT 2 SET ham third SET OK
		 * SET parrot four SET OK GET foo NOTFOUND GET spam GOT 2 GET ham GOT
		 * third GET ham parrot ERROR GET parrot GOT four
		 * 
		 */

		LRUQueue.QueueNode resultNode = lruCache.get("foo");
		assertEquals(null, resultNode);

		int nRet = lruCache.set("foo", "1");
		assertEquals(LRUCache.OK, nRet);

		resultNode = lruCache.get("foo");
		assertEquals("1", resultNode.Value);

		nRet = lruCache.set("foo", "1.1");
		assertEquals(LRUCache.OK, nRet);

		resultNode = lruCache.get("foo");
		assertEquals("1.1", resultNode.Value);

		nRet = lruCache.set("spam", "2");
		assertEquals(LRUCache.OK, nRet);

		resultNode = lruCache.get("spam");
		assertEquals("2", resultNode.Value);

		nRet = lruCache.set("ham", "third");
		assertEquals(LRUCache.OK, nRet);

		nRet = lruCache.set("parrot", "four");
		assertEquals(LRUCache.OK, nRet);

		resultNode = lruCache.get("foo");
		assertEquals(null, resultNode);

		resultNode = lruCache.get("spam");
		assertEquals("2", resultNode.Value);

		resultNode = lruCache.get("ham");
		assertEquals("third", resultNode.Value);

		resultNode = lruCache.get("ham parrot");
		assertEquals(null, resultNode);

		resultNode = lruCache.get("parrot");
		assertEquals("four", resultNode.Value);

	}

}

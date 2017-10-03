package ica.app.algorithms.les5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HANQueueTest {

	private HANQueue<String> queue;
	
	@Before
	public void setup(){
		queue = new HANQueue<String>();
		
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
	}
	
	@Test
	public void dequeue(){
		assertEquals("1", queue.dequeue());
	}
	
	@Test
	public void getFront(){
		assertEquals("1", queue.getFront());
	}
	
	@Test
	public void isEmpty(){
		queue = new HANQueue<String>();
		
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void emptyQueue(){
		queue = new HANQueue<String>();
		
		assertEquals(null, queue.dequeue());
		assertEquals(null, queue.getFront());
	}
	
	
	
	
}

package ica.app.algorithms.les5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HANLinkedListTest {

	private HANLinkedList<String> list;

	@Before
	public void setup() {
		list = new HANLinkedList<String>();

		list.addFirst("1");
		list.addFirst("2");
		list.addFirst("3");
	}

	@Test
	public void addTest() {
		assertEquals("2", list.get(1));
	}

	@Test
	public void setTest() {
		list.insert(1, "4");
		assertEquals("4", list.get(1));
	}
	
	@Test
	public void deleteTest() {
		list.delete(1);
		assertEquals("1", list.get(1));
	}
	
	@Test
	public void toStringTest() {
		assertEquals("[3, 2, 1]", list.toString());
	}
	
	@Test
	public void emptyList(){
		list = new HANLinkedList<String>();
		list.delete(1);
		
		assertEquals(null, list.get(2));
		assertEquals("[]", list.toString());
	}
	
}

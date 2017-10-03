package ica.app.algorithms.les5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HANStackTest {

	private HANStack<String> stack;
	
	@Before
	public void setup() {
		stack = new HANStack<String>();
	
		stack.push("1");
		stack.push("2");
		stack.push("3");
	}
	
	@Test
	public void topTest() throws Exception {
		assertEquals("3", stack.top());
	}
	
	@Test
	public void popTest() {
		stack.pop();
		String s = stack.pop();
		
		assertEquals("2", s);
	}
	
	@Test
	public void sizeTest() {
		assertEquals(3, stack.getSize());
	}
	
	@Test
	public void lowSizeTest() {
		for (int i = 0; i < 5; i++) {
			stack.pop();
		}
		
		assertEquals(0, stack.getSize());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("[3, 2, 1]", stack.toString());
	}
	
	@Test
	public void emptyStack() throws Exception {
		stack = new HANStack<String>();
		
		assertEquals(0, stack.getSize());
		assertEquals(null, stack.pop());
		assertEquals("[]", stack.toString());
		assertEquals(null, stack.top());
	}
}

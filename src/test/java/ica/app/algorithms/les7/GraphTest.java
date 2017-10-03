package ica.app.algorithms.les7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

	private Graph graph;
	
	@Before
	public void setup(){
		graph = new Graph();
		
		/*
		 * A ---9--- B ---6--- C
		 * 			 |		  /
		 * 			 20		 /
		 * 			 |		/
		 * E --18--- D ---4
		 */
		
		graph.addEdge("A", "B", 9);
		graph.addEdge("B", "C", 6);
		graph.addEdge("B", "D", 20);
		graph.addEdge("C", "D", 4);
		graph.addEdge("D", "E", 18);
	}
	
	@Test
	public void dijkstra(){
		graph.dijkstra("A");
		
		assertRoute("E", "D", "C", "B", "A");
	}

	@Test
	public void unweighted(){
		graph.unweighted("A");
		
		assertRoute("E", "D", "B", "A");
	}
	
	private void assertRoute(String... path) {
		Vertex v = graph.getVertex(path[0]);
		
		for (int i = 1; i < path.length; i++) {
			assertEquals(path[i], v.prev.name);
			v = v.prev;
		}
	}
	
	@Test
	public void isConnected(){
		assertFalse(graph.isConnected());
	}
	
	@Test
	public void isConnectedTrue(){
		graph.addEdge("B", "A", 9);
		graph.addEdge("C", "B", 6);
		graph.addEdge("D", "B", 20);
		graph.addEdge("D", "C", 4);
		graph.addEdge("E", "D", 18);
		
		assertTrue(graph.isConnected());
	}
	
}

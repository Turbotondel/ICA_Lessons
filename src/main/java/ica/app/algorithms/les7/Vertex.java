package ica.app.algorithms.les7;

import ica.app.algorithms.les5.HANLinkedList;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
    public String name;
    public List<Edge> adj;
    public HANLinkedList<Edge> adjHAN;
    public double dist;
    public Vertex prev;
    public int scratch;

    public Vertex(String name) {
        this.name = name;
        adj = new LinkedList<Edge>();
        adjHAN = new HANLinkedList<Edge>();
        reset();
    }

    public void reset() {
        dist = Graph.INFINITY;
        prev = null;
        scratch = 0;
    }
}

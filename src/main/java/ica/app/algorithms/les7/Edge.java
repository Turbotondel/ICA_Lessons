package ica.app.algorithms.les7;

public class Edge {
    public Vertex dest;
    public double cost;


    public Edge(Vertex dest, double cost) {
        this.dest = dest;
        this.cost = cost;
    }

    public String toString() {
        return "" + cost;
    }
}

package ica.app.les7;

public class Edge {
    public Vertex dest;
    public double cost;

    public Edge(Vertex dest, double cost) {
        this.dest = dest;
        this.cost = cost;
    }
}

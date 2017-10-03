package ica.app.algorithms.les7;

public class Path implements Comparable<Path> {
    public Vertex dest;
    public double cost;

    public Path(Vertex dest, double cost) {
        this.dest = dest;
        this.cost = cost;
    }

    public int compareTo(Path path) {
        double otherCost = path.cost;
        return cost < otherCost ? -1 : cost > otherCost ? 1 : 0;
    }
}

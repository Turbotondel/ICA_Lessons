package ica.app.algorithms.les7;

public class les7 {

    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(9);

        graph.addEdge("A", "B", 3.0);
        graph.addEdge("A", "C", 2.0);
        graph.addEdge("D", "E", 8.0);
        graph.addEdge("C", "F", 2.0);
        graph.addEdge("D", "B", 1.0);
        graph.addEdge("F", "D", 4.0);
        graph.addEdge("G", "H", 9.0);
        graph.addEdge("H", "I", 1.0);

        graph.addEdge("B", "A", 3.0);
        graph.addEdge("C", "A", 2.0);
        graph.addEdge("E", "D", 8.0);
        graph.addEdge("F", "C", 2.0);
        graph.addEdge("B", "D", 1.0);
        graph.addEdge("D", "F", 4.0);
        graph.addEdge("H", "G", 9.0);
        graph.addEdge("I", "H", 1.0);

        graph.print();
        System.out.println();
        System.out.println(graph.isUndirectedConnected());
    }
}

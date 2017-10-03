package ica.app.algorithms.les7;

import java.util.HashMap;
import java.util.Map;

public class GraphMatrix {

    private int currentIndex = 0;
    private int nrOfNodes;
    private Map<String, Integer> vertexIndex = new HashMap<String, Integer>();
    private Double[][] edges;

    public GraphMatrix(int nrOfNodes) {
        this.nrOfNodes = nrOfNodes;
        edges = new Double[nrOfNodes][nrOfNodes];
    }

    public void addEdge(String v, String w, Double c) {
        int i = getIndex(v);
        int j = getIndex(w);

        edges[i][j] = c;
    }

    private Integer getIndex(String v) {
        Integer index = vertexIndex.get(v);
        if(index == null) {
            vertexIndex.put(v, currentIndex);
            index = currentIndex;
            currentIndex++;
        }

        return index;
    }

    public boolean isUndirectedConnected() {
        for (int i = nrOfNodes - 1; i > 0 ; i--) {
            boolean hasValue = false;

            for (int y = i; y < edges.length; y++) {


                for (int x = 0; x < edges.length; x++) {
                    if(edges[x][y] != null && x < i) hasValue = true;
                }

                if(!hasValue) {
                    return false;
                }
            }
        }

        return true;
    }

    public void print() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }
}

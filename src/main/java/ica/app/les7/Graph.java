package ica.app.les7;

import ica.app.les5.HANQueue;
import java.util.*;

public class Graph {
    public static final double INFINITY = Double.MAX_VALUE;
    private Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();

    public boolean isConnected() {
        for(String key : vertexMap.keySet()) {
            dijkstraNormalStructure(key);
            for(Vertex v : vertexMap.values()) {
                if(v.scratch != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void addEdge(String sourceName, String destName, double cost) {
        Vertex v = getVertex(sourceName);
        Vertex w = getVertex(destName);
        v.adjHAN.add(new Edge(w, cost));
    }

    public void printPath(String destName) {
        Vertex w = vertexMap.get(destName);
        if (w == null) {
            throw new NoSuchElementException();
        } else if (w.dist == INFINITY) {
            System.out.println(destName + " is unreachable");
        } else {
            System.out.println("(Cost is: " + w.dist + ")");
            printPath(w);
            System.out.println();
        }
    }

    public void unweightedNormalStructure(String startName) {
        clearAll();

        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex is not found!");
        }

        Queue<Vertex> vertices = new LinkedList<Vertex>();
        vertices.add(start);
        start.dist = 0;

        while (!vertices.isEmpty()) {
            Vertex v = vertices.remove();
            for (Edge e : v.adj) {
                Vertex w = e.dest;
                if (w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    vertices.add(w);
                }
            }
        }
    }

    public void unweightedHANDataStructure(String startName) {
        clearAll();
        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex is not found!");
        }

        HANQueue<Vertex> vertices = new HANQueue<Vertex>();
        vertices.enqueue(start);
        start.dist = 0;

        while (!vertices.isEmpty()) {
            Vertex v = vertices.dequeue();
            for (Edge e : v.adjHAN) {
                Vertex w = e.dest;
                if (w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    vertices.enqueue(w);
                }
            }
        }
    }

    public void dijkstraNormalStructure(String startName) {
        PriorityQueue<Path> paths = new PriorityQueue<Path>();

        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found!");
        }

        clearAll();
        paths.add(new Path(start, 0));
        start.dist = 0;

        int nodesSeen = 0;
        while (!paths.isEmpty() && nodesSeen < vertexMap.size()) {
            Path vrec = paths.remove();
            Vertex v = vrec.dest;
            if (v.scratch != 0) {
                continue;
            }
            v.scratch = 1;
            nodesSeen++;

            for (Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if (cvw < 0) {
                    throw new GraphException("Graph has negative edges");
                }

                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    paths.add(new Path(w, w.dist));
                }
            }
        }
    }

    public void dijkstraHANDataStructure(String startName) {
        PriorityQueue<Path> paths = new PriorityQueue<Path>();

        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found!");
        }

        clearAll();
        paths.add(new Path(start, 0));
        start.dist = 0;

        int nodesSeen = 0;
        while (!paths.isEmpty() && nodesSeen < vertexMap.size()) {
            Path vrec = paths.remove();
            Vertex v = vrec.dest;
            if (v.scratch != 0) {
                continue;
            }
            v.scratch = 1;
            nodesSeen++;

            for(Edge e : v.adjHAN) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if(cvw < 0) {
                    throw new GraphException("Graph has negative edges!");
                }

                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    paths.add(new Path(w, w.dist));
                }
            }
        }
    }

    public void negative(String startName) {
        //TODO: Implementation of negative?
    }

    public void acyclic(String startName) {
        //TODO: Implementation of acyclic?
    }

    private Vertex getVertex(String vertexName) {
        Vertex v = vertexMap.get(vertexName);
        if (v == null) {
            v = new Vertex(vertexName);
            vertexMap.put(vertexName, v);
        }
        return v;
    }

    private void printPath(Vertex dest) {
        if (dest.prev != null) {
            printPath(dest.prev);
            System.out.println("to");
        }
        System.out.println(dest.name);
    }

    private void clearAll() {
        for (Vertex v : vertexMap.values()) {
            v.reset();
        }
    }
}

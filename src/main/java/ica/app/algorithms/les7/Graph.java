package ica.app.algorithms.les7;

import java.util.*;

public class Graph {

    public static final double INFINITY = Double.MAX_VALUE;

    private Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();

    public void addEdge(String sourceName, String destName, double cost) {
        //Figure 14.10
        Vertex v = getVertex(sourceName);
        Vertex w = getVertex(destName);
        v.adj.add(new Edge(w, cost));
    }

    public void printPath(String destName) {
        //Figure 14.13
        Vertex w = vertexMap.get(destName);
        if(w == null) {
            throw new NoSuchElementException();
        }else if(w.dist == INFINITY) {
            System.out.println(destName + " is unreachable");
        }else {
            System.out.println("(Cost is: " + w.dist + ") ");
            printPath(w);
            System.out.println();
        }
    }

    public void unweighted(String startName) {
        //Figure 14.22
        clearAll();

        Vertex start = vertexMap.get(startName);
        if(start == null) throw new NoSuchElementException("Start vertex not found");

        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(start);
        start.dist = 0;

        while(!q.isEmpty()) {
            Vertex v = q.remove();

            for(Edge e : v.adj) {
                Vertex w = e.dest;

                if(w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.add(w);
                }
            }
        }
    }

    public void dijkstra(String startName) {
        //Figure 14.27
        PriorityQueue<Path> pq = new PriorityQueue<Path>();

        Vertex start = vertexMap.get(startName);
        if(start == null) throw new NoSuchElementException();

        clearAll();
        pq.add(new Path(start, 0));
        start.dist = 0;

        int nodesSeen = 0;
        while(!pq.isEmpty() && nodesSeen < vertexMap.size()) {
            Path vrec = pq.remove();
            Vertex v = vrec.dest;
            if(v.scratch != 0) //already processed v
                continue;

            v.scratch = 1;
            nodesSeen++;

            for(Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if(cvw < 0) throw new GraphException("Graph has negative edges");

                if(w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    pq.add(new Path(w, w.dist));
                }
            }
        }
    }

    public boolean isConnected() {
        for(String key : vertexMap.keySet()) {
            dijkstra(key);

            for (Vertex v : vertexMap.values()) {
                if(v.scratch != 1) return false;
            }
        }

        return true;
    }

    public void negative(String startName) {
        //Figure 14.29
        clearAll();

        Vertex start = vertexMap.get(startName);
        if(start == null) throw new NoSuchElementException("Start vertex not found");

        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(start);

        while(!q.isEmpty()) {
            Vertex v = q.remove();	//Book says q.removeFirst but it doesn't exist
            if(v.scratch++ > 2 * vertexMap.size()) throw new GraphException("Negative cycle detected");

            for(Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if(w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;

                    //Enqueue only if not already on the queue
                    if(w.scratch++ % 2 == 0) {
                        q.add(w);
                    }else {
                        w.scratch--; //Undo the enqueue increment
                    }
                }
            }
        }
    }

    public void acyclic(String startName) {
        //Figure 14.32
        Vertex start = vertexMap.get(startName);
        if(start == null) throw new NoSuchElementException("Start vertex not found");

        clearAll();
        Queue<Vertex> q = new LinkedList<Vertex>();
        start.dist = 0;

        //Compute the indegrees
        Collection<Vertex> vertexSet = vertexMap.values();
        for(Vertex v : vertexSet) {
            for(Edge e : v.adj) {
                e.dest.scratch++;
            }
        }

        //Enqueue vertices of indegree zero
        for(Vertex v : vertexSet) {
            if(v.scratch == 0) q.add(v);
        }

        int iterations = 0;
        for(iterations = 0; !q.isEmpty(); iterations++) {
            Vertex v = q.remove();

            for(Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if(--w.scratch == 0) {
                    q.add(w);
                }

                if(v.dist == INFINITY) {
                    continue;
                }

                if(w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                }
            }
        }

        if(iterations != vertexMap.size()) throw new GraphException("Graph has a cycle!");
    }

    public Vertex getVertex(String vertexName) {
        //Figure 14.9
        Vertex v = vertexMap.get(vertexName);
        if(v == null) {
            v = new Vertex(vertexName);
            vertexMap.put(vertexName, v);
        }

        return v;
    }

    private void printPath(Vertex dest) {
        //Figure 14.12
        if(dest.prev != null) {
            printPath(dest.prev);
            System.out.println(" to ");
        }
        System.out.println(dest.name);
    }

    private void clearAll() {
        //Figure 14.11
        for(Vertex v : vertexMap.values()) v.reset();
    }

    class GraphException extends RuntimeException{
        private static final long serialVersionUID = -7928347690200003517L;

        public GraphException(String name) {
            super(name);
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(Map.Entry<String, Vertex> entry : vertexMap.entrySet()) {
            s += entry.getKey() + ": " + entry.getValue().toString() + "\n";
        }
        return s;
    }
}

package Graphs;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private final int V;
    private List<Integer>[] adj;
    private int E;

    public Graph(int V) {
        this.V = V;
        adj =  (LinkedList<Integer>[]) new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    public Graph(int V, int E) {
        this(V);
        this.E = E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(v);
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return  adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    @Override
    public String toString() {

        StringBuilder sb  = new StringBuilder();

        for (int v = 0; v < V; v++) {
            for (int w: adj(v)) {
                sb.append(v);
                sb.append(" -> ");
                sb.append(w);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

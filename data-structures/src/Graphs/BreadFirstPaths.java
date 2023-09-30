package Graphs;

import edu.princeton.cs.algs4.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class BreadFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;


    public BreadFirstPaths(Graph G, int s){
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        bfs(G, s);
    }


    private void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w:  G.adj(v)) {
                if (!marked[w]){
                    q.offer(w);
                    edgeTo[w] = v;
                    marked[w] = true;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);

        return path;
    }


}

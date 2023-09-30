package Graphs;

public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;


    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }


    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    private void dfs(Graph G, int s) {

            marked[s] = true;
            id[s] = count;
            for (int w: G.adj(s)) {
                if (!marked[w]){
                    dfs(G, w);
                }
            }

    }


}

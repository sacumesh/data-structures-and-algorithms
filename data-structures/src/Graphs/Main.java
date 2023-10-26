package Graphs;
import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        testDGraph();
    }


    public static void testDGraph() {
        File file = new File("data-structures/src/Graphs/testDG.txt");
        try (Scanner scanner = new Scanner(file)) {

            int V = scanner.nextInt();
            int E = scanner.nextInt();
            DiGraph G = new DiGraph(V);
            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                G.addEdge(v, w);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void testGraph() {

        File file = new File("data-structures/src/Graphs/testG.txt");
        try (Scanner scanner = new Scanner(file)) {

            int V = scanner.nextInt();
            int E = scanner.nextInt();
            Graph G = new Graph(V, E);
            for (int i = 0; i < E; ++i) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                G.addEdge(v, w);
            }

            System.out.println("dfs-------");
            DepthFirstPaths depthFirstPaths = new DepthFirstPaths(G, 0);
            for (int v: depthFirstPaths.pathTo(3)) {
                System.out.print(v + " ");
            }
            System.out.println();

            System.out.println("bfs--------");
            BreadFirstPaths breadFirstPaths = new BreadFirstPaths(G, 0);
            for (int v: breadFirstPaths.pathTo(3)) {
                System.out.print(v + " ");
            }

            System.out.println();
            System.out.println("cc----------");
            CC cc = new CC(G);

            System.out.println(G);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

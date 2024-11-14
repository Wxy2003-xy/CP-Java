package Graph;

import java.util.List;

public class Graph {
    private final int[][] adjMat;
    private final int V; // Number of vertices

    public Graph(int V) {
        this.V = V;
        this.adjMat = new int[V][V]; // Adjacency matrix initialized to 0
    }

    // Add an edge to the graph
    public void addEdge(int u, int v, int weight) {
        adjMat[u][v] = weight; // Directed graph
        adjMat[v][u] = weight; // Undirected graph (remove if directed only)
    }

    // Add multiple edges
    public void addEdges(List<Edge> edges) {
        for (Edge edge : edges) {
            addEdge(edge.getU(), edge.getV(), edge.getWeight());
        }
    }

    // Print adjacency matrix
    public void printGraph() {
        int cellWidth = 5; // Adjust width as needed based on the largest number or value

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjMat[i][j] == Integer.MIN_VALUE) {
                    System.out.printf("%" + cellWidth + "s", "x");
                } else {
                    System.out.printf("%" + cellWidth + "d", adjMat[i][j]);
                }
            }
            System.out.println();
        }
    }


    public int[][] getAdjMatrix() {
        return adjMat; // Return the adjacency matrix
    }
}

package Graph;

import java.util.*;

public class RandomGraphGenerator {
    private final int V; // Number of vertices
    private final int E; // Number of edges
    private final boolean isWeighted; // Whether the graph is weighted
    private final boolean isConnected; // Whether the graph must be connected
    private final boolean isComplete; // Whether the graph is complete
    private final double density; // Desired density (0 to 1)

    public RandomGraphGenerator(int V, int E, boolean isWeighted, boolean isConnected, boolean isComplete, double density) {
        this.V = V;
        this.E = Math.min(E, V * (V - 1) / 2); // Cap E at the maximum possible edges
        this.isWeighted = isWeighted;
        this.isConnected = isConnected;
        this.isComplete = isComplete;
        this.density = Math.min(Math.max(density, 0), 1); // Clamp density to [0, 1]
    }

    public Graph generate() {
        Graph graph = new Graph(V);
        Random random = new Random();
        final int MIN_WEIGHT = Integer.MIN_VALUE; // Define the minimum weight for unconnected edges

        // If complete graph, override edge count and add all edges
        if (isComplete) {
            for (int i = 0; i < V; i++) {
                for (int j = i + 1; j < V; j++) {
                    int weight = isWeighted ? random.nextInt(10) + 1 : 1;
                    graph.addEdge(i, j, weight);
                }
            }
            return graph;
        }

        // Ensure connectivity if required
        if (isConnected) {
            List<Integer> connected = new ArrayList<>();
            List<Integer> unconnected = new ArrayList<>();
            for (int i = 0; i < V; i++) unconnected.add(i);

            connected.add(unconnected.remove(0));

            while (!unconnected.isEmpty()) {
                int u = connected.get(random.nextInt(connected.size()));
                int v = unconnected.remove(random.nextInt(unconnected.size()));
                int weight = isWeighted ? random.nextInt(10) + 1 : 1;
                graph.addEdge(u, v, weight);
                connected.add(v);
            }
        }

        // Add remaining edges while respecting edge count and density
        int remainingEdges = isConnected ? E - (V - 1) : E;
        while (remainingEdges > 0) {
            int u = random.nextInt(V);
            int v = random.nextInt(V);
            if (u != v && graph.getAdjMatrix()[u][v] == 0) { // Ensure no duplicate edges
                double probability = random.nextDouble();
                if (probability <= density) {
                    int weight = isWeighted ? random.nextInt(10) + 1 : 1;
                    graph.addEdge(u, v, weight);
                    remainingEdges--;
                }
            }
        }

        // Set the weight of unconnected edges to MIN_WEIGHT
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && graph.getAdjMatrix()[i][j] == 0) {
                    graph.addEdge(i, j, MIN_WEIGHT);
                }
            }
        }

        return graph;
    }

    /**
     *      Example Usage:
     *         public static void main(String[] args) {
     *             RandomGraphGenerator generator = new RandomGraphGenerator(5, 6, true, true, false, 1);
     *             Graph randomGraph = generator.generate();
     *             randomGraph.printGraph();
     *         }
     * */
}

package GraphProblems;
import Graph.Edge;
import Graph.Graph;
import Graph.RandomGraphGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TSP {
    public int exhaustiveSolve(Graph g) {
        int[][] adjMat = g.getAdjMatrix();
        int numOfVertices = g.getVertexCount();
        int currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < numOfVertices - 1; i++) {

        }
        return 0;
    }
    public int greedySolve(Graph g) {
        int[][] adjMat = g.getAdjMatrix();
        int numOfVertices = g.getVertexCount();
        List<Integer> unvisited = new ArrayList<>(IntStream.range(0, numOfVertices).boxed().toList());
        while(!unvisited.isEmpty()) {
            
        }
    }


    public static void main(String[] args) {
        RandomGraphGenerator r =
                new RandomGraphGenerator(4, 14, true, true, false, 1);
        Graph g = r.generate();
        g.printGraph();
    }
}

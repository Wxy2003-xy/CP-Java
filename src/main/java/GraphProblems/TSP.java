package GraphProblems;
import Graph.Edge;
import Graph.Graph;
import Graph.RandomGraphGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TSP {
    public int[] exhaustiveSolve(Graph g) {
        int[][] adjMat = g.getAdjMatrix();
        int numOfVertices = g.getVertexCount();
        int currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < numOfVertices - 1; i++) {
            
        }
        return null;
    }

    private int[] subarray(int[] arr, int init, int end) {
        int len = end - init + 1;
        int[] res = new int[len];
        for (int i = init; i <= end; i++) {
            res[i - init] = arr[i];
        }
        return res;
    }

    private boolean ifFeasible(int[] sequence, int[][] adjMat, int limit) {
        int sum = 0;
        for (int i = 0; i < sequence.length - 1; i++) {
            int curr = sequence[i];
            int nxt = sequence[i + 1];
            if (adjMat[curr][nxt] < 0) {
                return false;
            }
            sum = sum + adjMat[curr][nxt];
        }
        return sum <= limit;
    }
    public int greedySolve(Graph g) {
        int[][] adjMat = g.getAdjMatrix();
        int numOfVertices = g.getVertexCount();
        List<Integer> unvisited = new ArrayList<>(IntStream.range(0, numOfVertices).boxed().toList());
        while(!unvisited.isEmpty()) {
            
        }
        return 0;
    }

    public static void main(String[] args) {
        RandomGraphGenerator r =
                new RandomGraphGenerator(4, 14, true, true, false, 1);
        Graph g = r.generate();
        g.printGraph();
    }

}

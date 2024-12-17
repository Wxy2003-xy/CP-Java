package Util;

import java.util.*;

public class GraphDFS {
    public List<Integer> dfs(Node start) {
        List<Integer> result = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        dfsHelper(start, visited, result);
        return result;
    }

    private void dfsHelper(Node node, Set<Node> visited, List<Integer> result) {
        visited.add(node);
        result.add(node.value);

        for (Node neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited, result);
            }
        }
    }
}

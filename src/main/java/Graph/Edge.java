package Graph;

public class Edge {
    private final int u; // Start vertex
    private final int v; // End vertex
    private final int weight; // Weight of the edge

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }
}

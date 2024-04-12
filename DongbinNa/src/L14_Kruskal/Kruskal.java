package L14_Kruskal;

import L13_UnionFind.UnionFind;

import java.util.ArrayList;

public class Kruskal {
    static int e;
    static ArrayList<Edge> edges = new ArrayList<>();

    private static class Edge {
        int dist;
        int nodeA;
        int nodeB;

        public Edge(int dist, int nodeA, int nodeB) {
            this.dist = dist;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }
    }

    public static void main(String[] args) {

        // cost 오름차순
        edges.sort((a,b) -> b.dist - a.dist);


        int result = 0;
        for (Edge e : edges) {
            int a = e.nodeA;
            int b = e.nodeB;
            int cost = e.dist;

            if (UnionFind.find(a) != UnionFind.find(b)) {
                UnionFind.union(a, b);
                result += cost;
            }

        }
    }
}

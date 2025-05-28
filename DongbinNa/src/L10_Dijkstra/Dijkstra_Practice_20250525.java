package L10_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Start: A(0)
 End : G(6)

7
0 5 10 9 0 0 0
5 0 3 0 0 11 0
10 3 0 7 3 10 0
9 0 7 0 0 7 12
0 0 3 0 0 4 0
0 11 10 7 4 0 2
0 0 0 12 0 2 0
*/
public class Dijkstra_Practice_20250525 {
    static int V;
    static List<Node>[] graph;
    static int[] dist;
    static boolean[] visited;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new List[V + 1];
        dist = new int[V];
        visited = new boolean[V];

        for (int i = 1; i < V + 1; i++) {
            String[] s = br.readLine().split(" ");
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node(0, 0));
        dist[0] = 0;

        _dijkstra();

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }

    private static void _dijkstra() {
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curIndex = node.index;
            int curDist = node.dist;

            if (dist[curIndex] < curDist) {
                continue;
            }

            List<Node> list = graph[curIndex];
            for (Node next : list) {
                int nextIndex = next.index;
                int nextDist = next.dist + curDist;
                if (dist[nextIndex] > nextDist) {
                    dist[nextIndex] = nextDist;
                    pq.offer(new Node(nextIndex, nextDist));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int index, dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }


        @Override
        public boolean equals(Object obj) {
            return false;
        }

        @Override
        public int compareTo(Node o) {
            return o.dist - this.dist;
        }
    }

}

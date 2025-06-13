import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 역방향 Dijkstra !!
public class BOJ_1238_파티_Dijkstra {
    static int N, M, X;
    static List[] graph;
    static List[] reverse;
    static int INF = (int) 1e9;
    static int[] dist;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        reverse = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Node>();
            reverse[i] = new ArrayList<Node>();
        }
        dist = new int[N + 1];
        result = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(v, w));
            reverse[v].add(new Node(x,w));

        }

        _dijkstra(graph);
        _dijkstra(reverse);

//        for (int i = 0; i < N + 1; i++) {
//            System.out.print(result[i] + " ");
//        }
        int max = -1;
        for (int i = 0; i < N + 1; i++) {
            max = Math.max(max, result[i]);
        }
        System.out.println(max);
    }

    private static void _dijkstra(List[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        pq.offer(new Node(X, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curIndex = node.index;
            int curDist = node.dist;
            if (dist[curIndex] < curDist) continue;

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

        for (int i = 1; i < N + 1; i++) {
            result[i] += dist[i];
        }

    }


    private static class Node implements Comparable<Node> {
        int index, dist;

        public Node(int index, int weight) {
            this.index = index;
            this.dist = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

}

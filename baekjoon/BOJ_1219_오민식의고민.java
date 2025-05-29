import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// fail...19%  what test case
public class BOJ_1219_오민식의고민 {
    static int N, start, end, M;
    static List<Edge> edges = new ArrayList<>();
    static int[] revenue;
    static int[] dist;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        start = Integer.parseInt(s[1]);
        end = Integer.parseInt(s[2]);
        M = Integer.parseInt(s[3]);

        for (int i = 0; i < M; i++) {
            String[] s2 = br.readLine().split(" ");
            int x = Integer.parseInt(s2[0]);
            int v = Integer.parseInt(s2[1]);
            int w = Integer.parseInt(s2[2]);

            edges.add(new Edge(x, v, w));
        }

        revenue = new int[N];
        String[] s3 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            revenue[i] = Integer.parseInt(s3[i]);
        }

        dist = new int[N];
        Arrays.fill(dist, INF);
        _bellmanFord();

        if (dist[end] == INF) {
            System.out.println("gg");
            return;
        }
        if (_isCycle()) {
            System.out.println("Gee");
            return;
        }
        System.out.println(dist[end]);
    }

    private static boolean _isCycle() {
        for (Edge e : edges) {
            if (dist[e.from] != INF && dist[e.to] != INF && dist[e.from] + revenue[e.to] - e.cost > dist[e.to]) {
                return true;
            }
        }
        return false;
    }

    private static void _bellmanFord() {
        dist[start] = revenue[start];
        for (int i = 0; i < N - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != INF) {
                    if (dist[e.to] == INF) {
                        dist[e.to] = dist[e.from] + revenue[e.to] - e.cost;
                    } else if (dist[e.from] + revenue[e.to] - e.cost > dist[e.to]) {
                        dist[e.to] = dist[e.from] + revenue[e.to] - e.cost;
                    }
                }
            }
        }
    }

    private static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}

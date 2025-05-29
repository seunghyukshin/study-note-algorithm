import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_11780_플로이드2 {
    static int INF = 100001;
    static int n, m;
    static Node[][] graph;

    private static class Node {
        int dist;
        List<Integer> path;

        public Node(int dist, List<Integer> path) {
            this.dist = dist;
            this.path = path;
        }

        public String toString() {
            if (dist == 0 || dist == INF) {
                return "0";
            }

            String pathStr = path.stream().map(String::valueOf).collect(Collectors.joining(" "));

            return path.size() + " " + pathStr;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new Node[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                if (i == j) {
                    graph[i][j] = new Node(0, list);
                } else {
                    list.add(j);
                    graph[i][j] = new Node(INF, list);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);

            if (graph[x][v].dist > w) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(v);
                graph[x][v] = new Node(w, list);
            }
        }
        _floydWarshall();
        _printDist();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.println(graph[i][j]);
            }
        }

    }

    private static void _floydWarshall() {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][j].dist > graph[i][k].dist + graph[k][j].dist) {
                        List<Integer> list = new ArrayList<>();
                        list.addAll(graph[i][k].path);
                        list.remove(list.size() - 1);
                        list.addAll(graph[k][j].path);
                        graph[i][j] = new Node(graph[i][k].dist + graph[k][j].dist, list);
                    }
                }
            }
        }

    }


    private static void _printDist() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int num = graph[i][j].dist;
                if (num == INF) {
                    num = 0;
                }
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    private static void _printPath() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.println(graph[i][j].path.toString());
            }
            System.out.println();
        }

    }
}

package L15_LowestCommonAncestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_11438_3T {
    private static int N, M;
    private static List[] graph;

    private static int[][] parent;
    private static final int LOG = 21;

    private static boolean[] visited;
    private static int[] depthes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        parent = new int[N + 1][LOG];
        visited = new boolean[N + 1];
        depthes = new int[N + 1];


//        for (int i = 0; i < graph.length; i++) {
//            System.out.println(graph[i].toString());
//        }


        initParent();
//
//        for (int i = 0; i < parent.length; i++) {
//            for (int j = 0; j < parent[i].length; j++) {
//                System.out.print(parent[i][j] + " ");
//            }
//            System.out.println();
//        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            System.out.println(lca(a, b));


        }

    }

    private static int lca(int a, int b) {

        if (depthes[a] < depthes[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // depth 통일
        for (int i = LOG - 1; i >= 0; i--) {
            if (depthes[a] - depthes[b] >= (1 << i)) {
                a = parent[a][i];
            }
        }

        if (a == b) {
            return a;
        }


        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }

    private static void initParent() {
        dfs(1, 0);

        for (int i = 1; i < LOG; i++) {
            for (int j = 1; j < N + 1; j++) {
                int parentIndex = parent[j][i - 1];
                parent[j][i] = parent[parentIndex][i - 1];
            }
        }

    }

    private static void dfs(int node, int depth) {
        visited[node] = true;
        depthes[node] = depth;

        List<Integer> list = graph[node];
        for (int child : list) {
            if (visited[child]) {
                continue;
            }

            parent[child][0] = node;
            dfs(child, depth + 1);
        }

    }
}

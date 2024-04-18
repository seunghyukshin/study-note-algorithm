package L15_LowestCommonAncestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_11438_2T {

    private static final int LOG = 21;
    private static int N, M;
    private static List<Integer>[] graph;
    private static int[] depthes;
    private static int[][] parent;
    private static boolean[] visitied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        depthes = new int[N + 1];
        parent = new int[N + 1][LOG];
        visitied = new boolean[N + 1];
        graph = new List[N + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        setParent();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            System.out.println(lca(a, b));

        }


    }


    private static void setParent() {
        dfs(1, 0);

        for (int i = 1; i < LOG; i++) {
            for (int j = 1; j < N + 1; j++) {
                int parentIndex = parent[j][i - 1];

                parent[j][i] = parent[parentIndex][i - 1];

            }
        }
    }

    private static void dfs(int node, int depth) {
        depthes[node] = depth;
        visitied[node] = true;
        List<Integer> list = graph[node];
        for (int nextNode : list) {
            if (visitied[nextNode]) continue;

            parent[nextNode][0] = node;
            dfs(nextNode, depth + 1);
        }


    }

    private static int lca(int a, int b) {
        if (depthes[a] > depthes[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = LOG - 1; i >= 0; i--) {
            if (depthes[b] - depthes[a] >= (1 << i)) {
                b = parent[b][i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[a][i] == parent[b][i]) {
                continue;
            }
            a = parent[a][i];
            b = parent[b][i];
        }


        return parent[a][0];
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}

package L15_LowestCommonAncestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_11437_2T {

    private static int N, M;
    private static List[] edges;

    private static int[] depthes;
    private static int[] parent;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        edges = new List[N + 1];
        depthes = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            edges[a].add(b);
            edges[b].add(a);
        }


        dfs(1, 0);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            System.out.println(lca(a, b));
        }


    }

    private static int lca(int a, int b) {

        while (depthes[a] > depthes[b]) {
            a = parent[a];
        }

        while (depthes[b] > depthes[a]) {
            b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    private static void dfs(int node, int depth) {
        depthes[node] = depth;
        visited[node] = true;

        List<Integer> list = edges[node];
        for (int childNode : list) {
            if (visited[childNode]) {
                continue;
            }
            parent[childNode] = node;
            dfs(childNode, depth + 1);
        }
    }


}

package L15_LowestCommonAncestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_11438 {

    private static int N, M;
    private static int[] depthes;
    private static int[][] parent;
    private static boolean[] visited;
    private static List<Integer>[] graph;

    private static final int LOG = 21;// 2^20 = 1,000,000


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        depthes = new int[N + 1];
        parent = new int[N + 1][LOG];
        visited = new boolean[N + 1];
        graph = new List[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        setParent();

//        for (int i = 0; i < parent.length; i++) {
//            print(parent[i]);
//        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {

            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            System.out.println(lca(a, b));
        }
    }

    private static void setParent() {
        dfs(1, 0);

        for (int i = 1; i < LOG; i++) {
            for (int j = 1; j < N + 1; j++) {
                int parentIndex = parent[j][i - 1];
                int grandParent = parent[parentIndex][i - 1];

                parent[j][i] = grandParent;
            }
        }

    }

    private static void dfs(int node, int depth) {
        visited[node] = true;
        depthes[node] = depth;

        for (int nextNode : graph[node]) {
            if (visited[nextNode]) {
                continue;
            }
            parent[nextNode][0] = node;
            dfs(nextNode, depth + 1);
        }

    }

    private static int lca(int a, int b) {

        // b가 더 깊도록 설정
        if (depthes[a] > depthes[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 먼저 깊이(depth)가 동일하도록
        for (int i = LOG; i >= 0; i--) {
            if (depthes[b] - depthes[a] >= (1 << i)) {
                b = parent[b][i];
            }
        }

        // 부모가 같아지도록
        if (a == b) {
            return a;
        }


        for (int i = LOG - 1; i >= 0; i--) {
            // 조상을 향해 거슬러 올라기
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
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

/**
 * 15
 * 1 2
 * 1 3
 * 2 4
 * 3 7
 * 6 2
 * 3 8
 * 4 9
 * 2 5
 * 5 11
 * 7 13
 * 10 4
 * 11 15
 * 12 5
 * 14 7
 * 6
 * 6 11
 * 10 9
 * 2 6
 * 7 6
 * 8 13
 * 8 15
 */
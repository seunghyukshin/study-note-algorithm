package L15_LowestCommonAncestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_11437 {

    private static int N, M;
    private static int[] depthes;
    private static int[] parent;
    private static boolean[] visited;
    private static List<Integer>[] graph;
    private static ArrayList<Edge> edges = new ArrayList<>();


    private static class Edge {
        int nodeA;
        int nodeB;

        public Edge(int nodeA, int nodeB) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        depthes = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new List[N + 1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a].add(b);
            graph[b].add(a);
//            edges.add(new Edge(a, b));
        }

//        for (int i = 0; i < graph.length; i++) {
//            System.out.println(graph[i].toString());
//        }

        dfs(1, 0);
//        System.out.println("depthes");
//        print(depthes);
//        System.out.println("parent");
//        print(parent);


        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {

            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            System.out.println(lca(a, b));
        }
    }

    private static void dfs(int node, int depth) {
        visited[node] = true;
        depthes[node] = depth;

        for (int nextNode : graph[node]) {
            if (visited[nextNode]) {
                continue;
            }
            parent[nextNode] = node;
            dfs(nextNode, depth + 1);
        }

    }

    private static int lca(int a, int b) {
        // 먼저 깊이(depth)가 동일하도록
        while (depthes[a] != depthes[b]) {
            if (depthes[a] > depthes[b]) {
                a = parent[a];
            } else {
                b = parent[b];
            }
        }

        // 노드가 같아지도록
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
    private static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}

/**
15
1 2
1 3
2 4
3 7
6 2
3 8
4 9
2 5
5 11
7 13
10 4
11 15
12 5
14 7
6
6 11
10 9
2 6
7 6
8 13
8 15
 */
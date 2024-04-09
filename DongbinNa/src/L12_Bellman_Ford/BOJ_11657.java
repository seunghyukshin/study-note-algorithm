package L12_Bellman_Ford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11657 {

    private static final int INF = (int) 1e6;

    private static int N, M;
    private static int[][] edges;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        init();
        boolean negativeCycle = process(1);
        printResult(negativeCycle);

    }

    private static void printResult(boolean negativeCycle) {
        if (negativeCycle) {
            System.out.println("-1");
            return;
        }

        for (int i = 2; i <= N + 1; i++) {
            if (dist[i] == INF) {
                System.out.println("-1");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static boolean process(int start) {
        dist[start] = 0;

        for (int i = 1; i <= N + 1; i++) {

            for (int j = 0; j < M; j++) { // 모든 간선 확인
                int cur = edges[j][0];
                int next = edges[j][1];
                int cost = edges[j][2];

                // 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (dist[cur] != INF && dist[next] > dist[cur] + cost) {
                    dist[next] = dist[cur] + cost;

                    if (i == N + 1) { // N번째 라운드에서도 값이 갱신된다면 음수 '순환' 존재
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        edges = new int[N + 1][N + 1];
        dist = new int[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            String[] inputs2 = br.readLine().split(" ");
            int start = Integer.parseInt(inputs2[0]);
            int end = Integer.parseInt(inputs2[1]);
            int dist = Integer.parseInt(inputs2[2]);

            edges[start][end] = dist;
        }
    }

    private static void print(int[] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.print(map[i] + " ");
        }
        System.out.println();
    }
}
/*

3 4
1 2 4
1 3 3
2 3 -1
3 1 -2

3 4
1 2 4
1 3 3
2 3 -1
3 1 -2

3 2
1 2 4
1 2 3
*/

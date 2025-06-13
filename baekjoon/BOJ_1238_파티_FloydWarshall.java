import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1238_파티_FloydWarshall {
    static int N, M, X;
    static int[][] graph;
    static int INF = (int) 1e9;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        for (int i = 1; i < N  + 1; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        dist = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from][to] = weight;
        }


        _floydWarshall();

//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; j < N + 1; j++) {
//                System.out.print(graph[i][j] + "\t ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i < N + 1; i++) {
            dist[i] = graph[i][X] + graph[X][i];
        }
        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(dist[i], max);
        }
        System.out.println(max);
    }

    private static void _floydWarshall() {
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}

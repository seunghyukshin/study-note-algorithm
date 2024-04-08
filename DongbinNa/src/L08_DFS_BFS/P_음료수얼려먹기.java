package L08_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 구멍 : 0, 칸막이 : 1
 * 총 아이스크림 갯수
 * 00110
 * 00011
 * 11111
 * 00000
 * <p>
 * => 총 3개
 * ( 1 <= N,M <= 1000 )
 */
public class P_음료수얼려먹기 {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        map = new int[N][K];
        visited = new boolean[N][K];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                map[i][j] = charArray[j] - '0';
            }
        }

        int count = 0;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new Point(i, j));
                    count++;

                    bfs(queue);
                }
            }
        }
        System.out.println(count);

    }

    private static void bfs(Queue<Point> queue) {

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ny = dy[d] + p.y;
                int nx = dx[d] + p.x;

                if (_isGo(ny, nx) && !visited[ny][nx] && map[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.offer(new Point(ny, nx));
                }
            }
        }

    }

    private static boolean _isGo(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < N && nx < K;
    }

    private static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}


/**
 * 4 5
 * 00110
 * 00011
 * 11111
 * 00000
 */
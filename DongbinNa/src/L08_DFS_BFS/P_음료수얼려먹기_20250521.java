package L08_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 구멍 : 0, 칸막이 : 1
 * 총 아이스크림 갯수
 * 4 5
 * 00110
 * 00011
 * 11111
 * 00000
 * <p>
 * => 총 3개
 * ( 1 <= N,M <= 1000 )
 */
public class P_음료수얼려먹기_20250521 {
    static Queue<Point> queue = new LinkedList<>();
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    private static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = c[j] - '0';
            }
        }


        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    System.out.println(count);
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                    _bfs();
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void _bfs() {

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            System.out.println(p);

            int ny, nx;
            for (int d = 0; d < 4; d++) {
                ny = p.y + dy[d];
                nx = p.x + dx[d];

                if (_isGo(ny, nx) && map[ny][nx] == 0 && !visited[ny][nx]) {
                    queue.offer(new Point(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static boolean _isGo(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }

}


/**
 * 4 5
 * 00110
 * 00011
 * 11111
 * 00000
 */
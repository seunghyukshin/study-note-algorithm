package BOJ_7569_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// start 19:16
// fail
// 반례
/*
3 2 2
0 0 0
0 0 0
1 1 1
1 1 -1

정답:2
*/
public class BOJ_7569_토마토_20250521 {
    static int N, M, H;
    static int[][][] map; // 1:익은토마토, 0:익지않은토마토, -1:빈공간
    static boolean[][][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static int minDist = -1;

    private static class Point {
        int y;
        int x;
        int h;
        int dist;

        public Point(int y, int x, int h, int dist) {
            this.y = y;
            this.x = x;
            this.h = h;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    ", h=" + h +
                    ", dist=" + dist +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[1]);
        M = Integer.parseInt(s[0]);
        H = Integer.parseInt(s[2]);

        map = new int[N][M][H];
        visited = new boolean[N][M][H];
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                String[] s2 = br.readLine().split(" ");
                for (int m = 0; m < M; m++) {
                    map[n][m][h] = Integer.parseInt(s2[m]);
                }
            }
        }

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j][h] == 1 && !visited[i][j][h]) {
                        queue.offer(new Point(i, j, h, 0));
                        visited[i][j][h] = true;
                        _bfs();

                    }
                }
            }
        }

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j][h] == 0 && !visited[i][j][h]) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
        System.out.println(minDist);
    }

    private static void _bfs() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            minDist = Math.max(minDist, p.dist);

            int ny, nx, nh;
            for (int d = 0; d < 6; d++) {
                ny = p.y + dy[d];
                nx = p.x + dx[d];
                nh = p.h + dh[d];

                if (_isGo(ny, nx, nh) && map[ny][nx][nh] == 0 && !visited[ny][nx][nh]) {
                    visited[ny][nx][nh] = true;
                    queue.offer(new Point(ny, nx, nh, p.dist + 1));
                }
            }
        }
    }

    private static boolean _isGo(int y, int x, int h) {
        return y >= 0 && x >= 0 && h >= 0 && y < N & x < M & h < H;
    }
}

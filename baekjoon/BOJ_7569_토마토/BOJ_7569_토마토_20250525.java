package BOJ_7569_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// start 17:30
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
public class BOJ_7569_토마토_20250525 {
    static int N, M, H;
    static int[][][] map; // 1:익은토마토, 0:익지않은토마토, -1:빈공간
    static Queue<Point> queue = new LinkedList<>();
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static int minDist = 0 ;

    private static class Point {
        int y;
        int x;
        int h;

        public Point(int y, int x, int h) {
            this.y = y;
            this.x = x;
            this.h = h;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    ", h=" + h +
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
                    if (_isOfferable(i, j, h)) {
                        queue.offer(new Point(i, j, h));
                    }
                }
            }
        }

        _bfs();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j][h] == 0){
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
//
        System.out.println(minDist);
    }

    private static boolean _isOfferable(int i, int j, int h) {
        return map[i][j][h] == 1;

    }

    private static void _bfs() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
//            System.out.println(p);
//            minDist = Math.max(minDist, p.dist);

//            int  curDay = map[]

            int ny, nx, nh;
            for (int d = 0; d < 6; d++) {
                ny = p.y + dy[d];
                nx = p.x + dx[d];
                nh = p.h + dh[d];

                int curDay = map[p.y][p.x][p.h];
                if (_isGo(ny, nx, nh) && map[ny][nx][nh] != -1
                        && (curDay + 1 < map[ny][nx][nh] || map[ny][nx][nh] == 0)) {
                    map[ny][nx][nh] = curDay + 1;
                    minDist = curDay;
                    queue.offer(new Point(ny, nx, nh));
                }
            }
        }
    }

    private static boolean _isGo(int y, int x, int h) {
        return y >= 0 && x >= 0 && h >= 0 && y < N & x < M & h < H;
    }
}

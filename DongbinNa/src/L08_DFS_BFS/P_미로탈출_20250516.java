package L08_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 0:괴물, 1:괴물X
 * 탈출하기 위한 최소 이동칸 수
 * 시작(1,1), 탈출구(N,M)
 * 시작칸과 마지막칸 모두 포함
 * (4 <= N,M <= 200)
 */
public class P_미로탈출_20250516 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = c[j] - '0';
            }

        }
        visit[0][0] = true;
        _bfs(new Point(0, 0, 1));

//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//
//            }
//            System.out.println();
//        }
    }

    private static void _bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(start);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            System.out.println(p);

            int nx, ny;
            for (int d = 0; d < 4; d++) {
                nx = p.x + dx[d];
                ny = p.y + dy[d];

                if (_isGo(ny, nx) && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    int ndist = map[ny][nx] + p.dist;

                    if (ny == N - 1 && nx == M - 1) {
                        System.out.println(ndist);
                        return;
                    }
                    queue.offer(new Point(ny, nx, ndist));
                }


            }


        }

    }

    private static boolean _isGo(int y, int x) {
        return y >= 0 && x >= 0 && x < M && y < N && map[y][x] == 1;
    }

    private static class Point {
        int y, x, dist;

        public Point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    ", dist=" + dist +
                    '}';
        }
    }
}
/**
 * 5 6
 * 101010
 * 111111
 * 000001
 * 111111
 * 111111
 */
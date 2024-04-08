package L08_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 0:괴물, 1:괴물X
 * 탈출하기 위한 최소 이동칸 수
 * 시작(1,1), 탈출구(N,M)
 * 시작칸과 마지막칸 모두 포함
 * (4 <= N,M <= 200)
 */
public class P_미로탈출 {

    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int minDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        map = new int[N][K];
        visited = new boolean[N][K];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();

            for (int j = 0; j < K; j++) {
                map[i][j] = charArray[j] - '0';
            }

        }

        bfs();
        System.out.println(minDist);

    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1));

        boolean exist = false;
        while (!queue.isEmpty() && !exist) {
            Point p = queue.poll();

            int ny, nx;

            for (int d = 0; d < 4; d++) {
                nx = dx[d] + p.x;
                ny = dy[d] + p.y;

                if (_isGo(ny, nx) && !visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.offer(new Point(ny, nx, p.dist + 1));
                } else if (_isGo(ny, nx) && ny == N - 1 && nx == K - 1) { // 탈출
                    minDist = p.dist + 1;
                    exist = true;
                    break;
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
        int dist;

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
5 6
101010
111111
000001
111111
111111
 */
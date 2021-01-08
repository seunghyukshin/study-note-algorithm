import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class FirstTry {
    static int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    static char VISITED = 't';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // N M C L
            //세로 가로 맨홀뚜껑좌표 시간
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);
            int c1 = Integer.parseInt(temp[2]);
            int c2 = Integer.parseInt(temp[3]);
            int L = Integer.parseInt(temp[4]);
            Point C = new Point(c1, c2);

            char[][] map = new char[N][M];
            int[][] mapL = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = s[j].charAt(0);
                }
                //toCharArray();
            }

            Queue<Point> pointQueue = new LinkedList<>();
            pointQueue.add(C);
            mapL[c1][c2] = L;

            /* L을 처리해주는 방법 : 이차원배열 하나 더 생성함 */

            while (!pointQueue.isEmpty()) {

                Point nowPoint = pointQueue.poll();
                char nowTunnelValue = map[nowPoint.x][nowPoint.y];
                map[nowPoint.x][nowPoint.y] = VISITED;


                for (int directions[] : DIRECTIONS) {
                    Point nextPoint = new Point(nowPoint.x + directions[0], nowPoint.y + directions[1]);
                    if (nextPoint.x > -1 && nextPoint.y > -1 && nextPoint.x < N && nextPoint.y < M) {
                        char nextTunnelValue = map[nextPoint.x][nextPoint.y];
                        int nextL = mapL[nextPoint.x][nextPoint.y] = mapL[nowPoint.x][nowPoint.y] - 1;
                        if (nextTunnelValue == '0' || nextTunnelValue == VISITED || nextL == 0) {
                            continue;
                        }

                        if (nowPoint.x < nextPoint.x) {// ↓
                            if (nowTunnelValue == '1' || nowTunnelValue == '2' || nowTunnelValue == '5' || nowTunnelValue == '6') {
                                if (nextTunnelValue == '1' || nextTunnelValue == '7' || nextTunnelValue == '2' || nextTunnelValue == '4') {
                                    pointQueue.add(nextPoint);
                                }
                            }
                        } else if (nowPoint.x > nextPoint.x) {//↑
                            if (nowTunnelValue == '1' || nowTunnelValue == '2' || nowTunnelValue == '4' || nowTunnelValue == '7') {
                                if (nextTunnelValue == '1' || nextTunnelValue == '5' || nextTunnelValue == '2' || nextTunnelValue == '6') {
                                    pointQueue.add(nextPoint);
                                }
                            }

                        } else if (nowPoint.y > nextPoint.y) {//←
                            if (nowTunnelValue == '1' || nowTunnelValue == '3' || nowTunnelValue == '6' || nowTunnelValue == '7') {
                                if (nextTunnelValue == '1' || nextTunnelValue == '3' || nextTunnelValue == '4' || nextTunnelValue == '5') {
                                    pointQueue.add(nextPoint);
                                }
                            }
                        } else if (nowPoint.y < nextPoint.y) {//→
                            if (nowTunnelValue == '1' || nowTunnelValue == '3' || nowTunnelValue == '4' || nowTunnelValue == '5') {
                                if (nextTunnelValue == '1' || nextTunnelValue == '3' || nextTunnelValue == '6' || nextTunnelValue == '7') {
                                    pointQueue.add(nextPoint);
                                }
                            }
                        }
                    }
                }
            }

            // VISITED count

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    //bw.write(map[i][j] + " ");
                    if (map[i][j] == VISITED) {
                        count++;
                    }
                }
                //bw.write("\n");
            }
            bw.write("#" + t + " ");
            bw.write(count + "\n");


        }
        bw.close();
    }
}

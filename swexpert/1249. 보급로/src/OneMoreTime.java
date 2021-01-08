import java.awt.*;
import java.util.*;
import java.io.*;

public class OneMoreTime {
    static int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            char[][] charArray = new char[N][N];

            for (int n = 0; n < N; n++) {
                charArray[n] = br.readLine().toCharArray();
            }

            int[][] timeArray = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    timeArray[i][j] = charArray[i][j] - '0';
                }
            }
            int[][] valuePath = new int[N][N];

            bw.write("#" + t + " ");
            bw.write(searchShortPath(timeArray, valuePath)+"\n");

        }
        bw.close();
    }

    private static int searchShortPath(int[][] timeArray, int[][] valuePath) {
        int N = timeArray.length;
        Queue<Point> pointQueue = new LinkedList<>();
        pointQueue.add(new Point(0, 0));
        valuePath[0][0] = 1;
        while (!pointQueue.isEmpty()) {
            Point nowPoint = pointQueue.poll();
            for (int[] directions : DIRECTIONS) {
                Point nextPoint = new Point(nowPoint.x + directions[0], nowPoint.y + directions[1]);
                if (nextPoint.x > -1 && nextPoint.y > -1 && nextPoint.x < N && nextPoint.y < N) {
                    int nextValue = timeArray[nextPoint.x][nextPoint.y] + valuePath[nowPoint.x][nowPoint.y];
                    if (nextValue < valuePath[nextPoint.x][nextPoint.y] || valuePath[nextPoint.x][nextPoint.y] == 0) {
                        pointQueue.add(nextPoint);
                        valuePath[nextPoint.x][nextPoint.y] = nextValue;
                    }
                }
            }
        }

        return valuePath[N - 1][N - 1] - 1;
    }
}

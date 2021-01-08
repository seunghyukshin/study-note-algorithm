import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class FirstTry {
    static char ROAD = '0';
    static char WALL = '1';
    static char START = '2';
    static char FINISH = '3';
    static int SIZE = 16;
    private static int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int garbage = Integer.parseInt(br.readLine());
            char[][] charArray = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                charArray[i] = br.readLine().toCharArray();
            }

            Point startPoint = new Point(0, 0);
            // start 찾기
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (charArray[i][j] == START) {
                        startPoint = new Point(i, j);
                    }
                }
            }
            bw.write("#" + t + " ");
            bw.write(escapeMap(charArray, startPoint) + " \n");

        }
        bw.close();

    }

    private static int escapeMap(char[][] map, Point startPoint) {
        Queue<Point> pointQueue = new LinkedList<>();
        pointQueue.add(startPoint);
        while (!pointQueue.isEmpty()) {
            Point nowPoint = pointQueue.poll();
            for (int[] directions : DIRECTIONS) {
                Point nextPoint = new Point(nowPoint.x + directions[0], nowPoint.y + directions[1]);
                if (nextPoint.x > -1 && nextPoint.y > -1 && nextPoint.x < SIZE && nextPoint.y < SIZE) {
                    char nextValue = map[nextPoint.x][nextPoint.y];
                    if (nextValue == FINISH) {
                        return 1;
                    }
                    if (nextValue == ROAD) {
                        pointQueue.add(nextPoint);
                        map[nowPoint.x][nowPoint.y] = '1';
                    }
                }

            }
        }
        return 0;
    }

}

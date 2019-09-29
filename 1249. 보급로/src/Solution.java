import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static int[][] DIRECTIONS = {
            {1, 0}, //down
            {-1, 0},//up
            {0, 1}, //right
            {0, -1} //left
    };

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // Input Data
            int N = Integer.parseInt(br.readLine());
            char[][] charArray = new char[N][N];
            for (int n = 0; n < N; n++) {
                charArray[n] = br.readLine().toCharArray();
            }

            int[][] timeArray = new int[N][N];
            int[][] valuePath = new int[N][N];
            //boolean[][] visitArray = new boolean[N][N];
            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < charArray[i].length; j++) {
                    timeArray[i][j] = charArray[i][j] - '0';
                }
            }

            // Search
            //int i = 0;
            //int j = 0;

            bw.write("#" + t + " ");
            //bw.write(searchShortLength(i, j, timeArray, visitArray) + "\n");
            bw.write(searchShortLength(timeArray, valuePath) + "\n");

        }
        bw.close();
    }

    private static int searchShortLength(int[][] timeArray, int[][] valuePath) {
        int N = timeArray.length;
        Queue<Point> positionQueue = new LinkedList<>();
        positionQueue.add(new Point(0, 0));
        valuePath[0][0] = 1;// 나중에 다시 빼줄 것.
        while (!positionQueue.isEmpty()) {
            Point nowPoint = positionQueue.poll();
            for (int directions[] : DIRECTIONS) {
                Point nextPoint = new Point(nowPoint.x + directions[0], nowPoint.y + directions[1]);
                if ((nextPoint.x > -1 && nextPoint.x < N) && (nextPoint.y > -1 && nextPoint.y < N)) {
                    int nextValue = timeArray[nextPoint.x][nextPoint.y] + valuePath[nowPoint.x][nowPoint.y];
                    if (nextValue < valuePath[nextPoint.x][nextPoint.y] || valuePath[nextPoint.x][nextPoint.y] == 0) {
                        valuePath[nextPoint.x][nextPoint.y] = nextValue;
                        positionQueue.add(nextPoint);
                    }
                }
            }
        }
        return valuePath[N - 1][N - 1] - 1;
    }


    // ①재귀짤때 void형태에서 못벗어남
    // ②그리고. 항상 재귀로 풀생각을함..
    // dfs : 재귀 , stack
    // bfs : queue
    // ③이문제를 교과서로삼고 코드암기하자
    /*
    private static int searchShortLength(int i, int j, int[][] time, boolean[][] visit) {
        int n = time.length;
        int thisTime = time[i][j];

        if (i == n && j == n) {
            return;
        }

        if (j == 0) { // 왼쪽x

        }
        if (i == 0) { // 위쪽x

        }
        if (i == n,)


    }*/


}

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 완전탐색 실행시간 3461ms 

public class Solution_D5_1247_최적경로_3 {
	public static List<Integer> list;
	public static Point[] pointArray;
	public static Point start;
	public static Point end;
	public static int min;

	private static class Point {
		int x;
		int y;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			pointArray = new Point[N];
			min = Integer.MAX_VALUE;

			String[] s = br.readLine().split(" ");

			start = new Point(Integer.parseInt(s[1]), Integer.parseInt(s[0]));
			end = new Point(Integer.parseInt(s[3]), Integer.parseInt(s[2]));

			for (int i = 0; i < N * 2; i += 2) {
				int x = Integer.parseInt(s[i + 4]);
				int y = Integer.parseInt(s[i + 5]);

				pointArray[i / 2] = new Point(y, x);
			}

			nPr(0, new boolean[N], N, start, 0);
			System.out.print("#" + t + " ");
			System.out.println(min);
		}
	}

	private static void nPr(int count, boolean[] isGo, int N, Point prePoint, int subSum) {
		if (subSum >= min)
			return;
		if (count == N) {
			int lastLength = calLength(prePoint, end);
			subSum += lastLength;

			min = Math.min(min, subSum);

			return;
		}

		for (int i = 0; i < N; i++) {
			if (isGo[i] == true) {
				continue;
			}

			isGo[i] = true;
			Point nowPoint = pointArray[i];
//			list.add(i);
			nPr(count + 1, isGo, N, nowPoint, subSum + calLength(prePoint, nowPoint));
//			list.remove(list.indexOf(i));
			isGo[i] = false;

		}

	}

	private static int calLength(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}

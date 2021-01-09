import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 완전탐색 실행시간 3461ms 

public class Solution_D5_1247_최적경로_2 {
	public static List<Integer> list;
	public static Point[] pointArray;
	public static Point start;
	public static Point end;
	public static int min;

	private static class Point {
		int x;
		int y;

//		public Point() {
//			x = 0;
//			y = 0;
//		}

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
			min =Integer.MAX_VALUE;
			
			String[] s = br.readLine().split(" ");

			start = new Point(Integer.parseInt(s[1]), Integer.parseInt(s[0]));
			end = new Point(Integer.parseInt(s[3]), Integer.parseInt(s[2]));

			for (int i = 0; i < N * 2; i += 2) {
				int x = Integer.parseInt(s[i + 4]);
				int y = Integer.parseInt(s[i + 5]);

				pointArray[i / 2] = new Point(y, x);
			}

//			for (int i = 0; i < pointArray.length; i++) {
//				System.out.println(pointArray[i]);
//			}
			nPr(0, new boolean[N], N, N);
			System.out.print("#" + t+" ");
			System.out.println(min);
		}
	}

	private static void nPr(int count, boolean[] isGo, int N, int R) {
		if (count == R) {
			int sum = 0;

			// 전체 길이 계산

			int sLen = calLength(start, pointArray[list.get(0)]);
			int eLen = calLength(end, pointArray[list.get(N - 1)]);
			sum += sLen + eLen;

			for (int i = 0; i < list.size() - 1; i++) {
				int index = list.get(i);
				int nextIndex = list.get(i + 1);

				Point p1 = pointArray[index];
				Point p2 = pointArray[nextIndex];

				sum += calLength(p1, p2);
			}
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isGo[i] == true) {
				continue;
			}

			isGo[i] = true;
			list.add(i);
			nPr(count + 1, isGo, N, R);
			list.remove(list.indexOf(i));
			isGo[i] = false;

		}

	}

	private static int calLength(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution_D5_7396_종구의딸이름짓기_풀이 {
	static char[][] map;
	static boolean[][] visit;
	static int N, M;
	static int[] dy = { 0, 1 };
	static int[] dx = { 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			String[] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			M = Integer.parseInt(line[1]);

			map = new char[N][];
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			PriorityQueue<Point> pq = new PriorityQueue<>();
			ArrayList<Point> list = new ArrayList<>();
			pq.add(new Point(0, 0, map[0][0]));// 출발점
			visit[0][0] = true;

			bw.write("#" + tc + " ");
			while (!pq.isEmpty()) {
				int size = pq.size();

				Point first = pq.peek(); // 현재 큐에 있는 글자중에 알파벳순 제일 빠른게 뭔지 일단 확보.
				for (int s = 0; s < size; s++) {
					Point p = pq.poll(); // 큐에서 빼면서

					if (first.ch == p.ch) { // 내가 관심있는 알파벳 빠른 좌표들만 추려서
						for (int d = 0; d < 2; d++) {
							int ny = p.i + dy[d];
							int nx = p.j + dx[d];

							if (ny >= 0 && nx >= 0 && ny < N && nx < M && !visit[ny][nx]) {
								list.add(new Point(ny, nx, map[ny][nx])); // 리스트에 옮겨담는 작업.
								visit[ny][nx] = true;
							}
						}
					} else {
						break;
					}
				} // 출발점에서 거리가 같은 좌표의 탐색이 끝난.
				pq.clear(); // 남은 좌표 몰라 버려.
				pq.addAll(list); // 알파벳 빠른거 따로 추렸으니까 얘네만 스케줄에 넣어서 탐색하자!
				list.clear();
				bw.write(first.ch);
			} // 탐색 끝

			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	static class Point implements Comparable<Point> {
		int i, j;
		char ch;

		Point(int i, int j, char ch) {
			this.i = i;
			this.j = j;
			this.ch = ch;
		}

		@Override
		public int compareTo(Point o) {
			return this.ch - o.ch;
		}
	}
}

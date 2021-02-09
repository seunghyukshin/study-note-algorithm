import java.io.*;
import java.util.*;

// dijkstra  why ? 
public class Solution_D4_5684_운동 {
	static int N, M;
	static int[][] map;
	static boolean[] visit;
	static int[][] dist;
	static int[] prev;
	static int min;

	static PriorityQueue<Vertex> pq;

	public static class Vertex implements Comparable<Vertex> {
		int index;
		int dist;

		public Vertex(int index, int dist) {
			super();
			this.index = index;
			this.dist = dist;
		}

		@Override
		public int compareTo(Vertex v2) {
			return dist - v2.dist;
		}

		@Override
		public String toString() {
			return "Vertex [index=" + index + ", dist=" + dist + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(new InputStreamReader(System.in));

//		int T = Integer.parseInt(br.readLine().trim());
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
//			String[] sss = br.readLine().trim().split(" ");
//			N = Integer.parseInt(sss[0]);
//			M = Integer.parseInt(sss[1]);
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			dist = new int[N][N];

			min = Integer.MAX_VALUE;
			for (int i = 0; i < M; i++) {
//				String[] ss = br.readLine().trim().split(" ");
//				int s = Integer.parseInt(ss[0]) - 1;
//				int e = Integer.parseInt(ss[1]) - 1;
//				int c = Integer.parseInt(ss[2]);
				int s = sc.nextInt() - 1;
				int e = sc.nextInt() - 1;
				int c = sc.nextInt();
				map[s][e] = c;
			}

			System.out.print("#" + t + " ");

			for (int i = 0; i < N; i++) {
				pq = new PriorityQueue<>();
				visit = new boolean[N];
				Arrays.fill(dist[i], Integer.MAX_VALUE);
				dist[i][i] = map[i][i];

				pq.add(new Vertex(i, dist[i][i]));
				dijkstra(i);
			}

			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
//					System.out.print(dist[i][j] + " ");
					if (dist[i][j] != 0 && dist[i][j] != Integer.MAX_VALUE && dist[j][i] != 0
							&& dist[j][i] != Integer.MAX_VALUE) {
						if (i == j) {
							min = Math.min(min, dist[i][j]);
						} else {
							min = Math.min(min, dist[i][j] + dist[j][i]);
						}
					}
				}
//				System.out.println();
			}
			System.out.println(min);
		}

	}

	private static void dijkstra(int start) {
//		for (int i = 0; i < dist.length; i++) {
//			System.out.print(dist[start][i] + " ");
//		}
//		System.out.println();
//		System.out.println();
		while (!pq.isEmpty()) {
			Vertex v = pq.poll();
//			System.out.print((char) (v.index + 97) + " ");
			if (visit[v.index]) {
				continue;
			}
			for (int i = 0; i < N; i++) {
				if (map[v.index][i] != 0 && !visit[i]) {
					dist[start][i] = Math.min(dist[start][v.index] + map[v.index][i], dist[start][i]);
					pq.add(new Vertex(i, dist[start][i]));
//					prev[i] = v.index;
				}
			}
			visit[v.index] = true;
		}

	}
}

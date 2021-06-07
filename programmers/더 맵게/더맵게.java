
import java.util.*;

public class 더맵게 {
	public static void main(String[] args) {
		int[] scoville = { 9, 10, 11, 1, 3, 2 };
		int K = 7;
		int answer = solution(scoville, K);

	}

	public static int solution(int[] scoville, int K) {
		// asList -> 얕은 복사
		// ArrayList<Integer> list = Arrays.asList(scoville);
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int sco : scoville) {
			pq.add(sco);
		}

		int count = 0;
		while (true) {
			if (pq.peek() >= K) {
				break;
			}

			if (pq.size() == 1) {
				count = -1;
				break;
			}

			int a = pq.poll();
			int b = pq.poll();
			pq.add(a + 2 * b);

			count++;
		}

		return count;
	}
}

import java.util.Deque;
import java.util.LinkedList;

import sun.net.www.content.text.plain;

public class Solution_862_ShortestSubarrayWithSumAtLeastK_답 {
	public static void main(String[] args) {
		Solution_862_ShortestSubarrayWithSumAtLeastK_답 sol = new Solution_862_ShortestSubarrayWithSumAtLeastK_답();
//		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
//		int k = 8;
//		int[] nums = { 2, -1, 2 };
//		int k = 3;
		int[] nums = { -1, 10, -3, 5, 4 };
		int k = 11;
		int answer = sol.shortestSubarray(nums, k);
		System.out.println(answer);
	}

	public int shortestSubarray(int[] nums, int k) {
		int N = nums.length;
		long[] sums = new long[N + 1];
		for (int i = 0; i < N; ++i)
			sums[i + 1] = sums[i] + (long) nums[i];

		int ans = N + 1;
		Deque<Integer> deque = new LinkedList();
		for (int i = 0; i < sums.length; ++i) {

			// deque 맨앞값 index 부터 현재 i까지 더한 값이 k보다 크거나 같으면
			// 맨앞값 짜르고 window크기 저장
			while (!deque.isEmpty() && sums[i] - sums[deque.getFirst()] >= k)
				ans = Math.min(ans, i - deque.removeFirst());

			// 추가하려는 값이 deque 맨뒤 값보다 작거나 같으면
			// (=더해지다가 갑자기 작아졌다)
			// 맨뒤값 짜른다
			// (=그때까지의 sum값은 필요가없음)
			while (!deque.isEmpty() && sums[i] <= sums[deque.getLast()])
				deque.removeLast();

			deque.addLast(i);
		}

		return ans < N + 1 ? ans : -1;
	}
}

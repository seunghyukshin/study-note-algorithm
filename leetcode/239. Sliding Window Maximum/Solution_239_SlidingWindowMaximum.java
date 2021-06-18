import java.util.*;

// FAIL ; 최대 heap ; 시간초과
public class Solution_239_SlidingWindowMaximum {

	public static void main(String[] args) {
		Solution_239_SlidingWindowMaximum sol = new Solution_239_SlidingWindowMaximum();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] answer = sol.maxSlidingWindow(nums, k);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		// Collections.reverseOrder() 메모
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			pq.add(nums[i]);
		}
		int p = 0;
		int q = k;

		List<Integer> list = new ArrayList<>();
		while (true) {
			list.add(pq.peek());
//			System.out.println(pq);
			if (q == nums.length) {
				break;
			}
			pq.remove(nums[p]);
			pq.add(nums[q]);
			p++;
			q++;
		}
//		System.out.println(list.toString());

		// List to Array (Integer to int) 메모
		int result[] = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}

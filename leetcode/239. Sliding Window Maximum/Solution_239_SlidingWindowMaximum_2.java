import java.util.*;

// deque
public class Solution_239_SlidingWindowMaximum_2 {

	public static void main(String[] args) {
		Solution_239_SlidingWindowMaximum_2 sol = new Solution_239_SlidingWindowMaximum_2();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] answer = sol.maxSlidingWindow(nums, k);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int N = nums.length;
		int result[] = new int[N - k + 1];
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			// window 크기 k보다 크면 맨앞 짜른다.
			while (!deque.isEmpty() && i - deque.peekFirst() >= k)
				deque.pollFirst();
			
			// 추가할 값이 맨뒤보다 크면 짜른다.
			while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
				deque.pollLast();

			deque.addLast(i);
			
			// 최대값 저장
			if (i >= k - 1)
				result[i - k + 1] = nums[deque.peekFirst()];
		}
		return result;
	}
}

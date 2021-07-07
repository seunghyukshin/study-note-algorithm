import java.util.*;

// stack O(NlogN)
public class Solution_84_LargestRectangleInHistogram_답 {
	public static void main(String[] args) {
		Solution_84_LargestRectangleInHistogram_답 sol = new Solution_84_LargestRectangleInHistogram_답();
//		int[] heights = { 2, 1, 2 }; // 3
//		int[] heights = { 2, 4 };
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		int answer = sol.largestRectangleArea(heights);
		System.out.println(answer);
	}

	public int largestRectangleArea(int[] heights) {
		int N = heights.length;
		int max = 0;
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i <= N; i++) {
			int v = i == N ? 0 : heights[i];
			while (!s.isEmpty() && v < heights[s.peek()]) {
				max = Math.max(max, heights[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
			}
			s.push(i);
		}
		return max;
	}
}

import java.util.*;

// O(N)
public class Solution_84_LargestRectangleInHistogram_답2 {
	public static void main(String[] args) {
		Solution_84_LargestRectangleInHistogram_답2 sol = new Solution_84_LargestRectangleInHistogram_답2();
//		int[] heights = { 2, 1, 2 }; // 3
//		int[] heights = { 2, 4 };
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		int answer = sol.largestRectangleArea(heights);
		System.out.println(answer);
	}

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
		int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
		lessFromRight[height.length - 1] = height.length;
		lessFromLeft[0] = -1;

		for (int i = 1; i < height.length; i++) {
			int p = i - 1;

			while (p >= 0 && height[p] >= height[i]) {
				System.out.println(p);
				print(lessFromLeft);
				p = lessFromLeft[p];
				System.out.println();
			}
			lessFromLeft[i] = p;
		}

		for (int i = height.length - 2; i >= 0; i--) {
			int p = i + 1;

			while (p < height.length && height[p] >= height[i]) {
				System.out.println(p);
				print(lessFromRight);
				p = lessFromRight[p];
				System.out.println();
			}
			lessFromRight[i] = p;
		}

		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
		}

		return maxArea;
	}

	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

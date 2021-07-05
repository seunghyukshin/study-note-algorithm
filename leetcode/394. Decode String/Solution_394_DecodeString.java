import java.util.Stack;

public class Solution_394_DecodeString {
	public static void main(String[] args) {
		Solution_394_DecodeString sol = new Solution_394_DecodeString();
//		String s = "3[a]2[bc]";
//		String s = "3[a2[c]]";
//		String s = "100[abc]";
		String s = "3[a10[bc]]";
		String answer = sol.decodeString(s);
		System.out.println(answer);
	}

	public String decodeString(String s) {
		StringBuilder answer = new StringBuilder(s);

		Stack<Integer> stack = new Stack<>();
		int iterLength = answer.length();
		for (int i = 0; i < iterLength; i++) {
			if (answer.charAt(i) == '[') {
				stack.push(i);
			}

			if (answer.charAt(i) == ']') {
				int front = stack.pop();
				String sub = answer.substring(front + 1, i);
				int iterFront = front - 1;
				int iter = 0;
				int iterEnd = iterFront;
				for (; iterEnd >= 0; iterEnd--) {
					if (answer.charAt(iterEnd) >= '0' && answer.charAt(iterEnd) <= '9') {
					} else {
						break;
					}
				}
				if (iterEnd == -1) {
					iterEnd = 0;
				} else {
					iterEnd++;
				}
				String iterSub = answer.substring(iterEnd, iterFront + 1);
				iter = Integer.parseInt(iterSub);
				answer.delete(front, i + 1);
				answer.delete(iterEnd, iterFront + 1);
				for (int j = 0; j < iter; j++) {
					answer.insert(iterEnd, sub);
				}
				int a = i - front + 1;
				int b = sub.length() * iter;
				i -= (a - b + 2);

				iterLength = answer.length();
			}
		}

		return answer.toString();
	}
}

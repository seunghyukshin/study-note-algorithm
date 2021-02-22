import java.util.*;

public class Solution_127_WordLadder {
	public class Word {
		String s;
		int length;

		public Word(String s, int length) {
			super();
			this.s = s;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Word [s=" + s + ", length=" + length + "]";
		}

	}

	public static void main(String[] args) {
		Solution_127_WordLadder sol = new Solution_127_WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordArray = { "hot", "dot", "dog", "lot", "log" };
		List<String> wordList = Arrays.asList(wordArray);

		System.out.println(sol.ladderLength(beginWord, endWord, wordList));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<Word> queue = new LinkedList<>();
		queue.add(new Word(beginWord, 1));
		int min = Integer.MAX_VALUE;
		boolean[] visit = new boolean[wordList.size()];
		while (!queue.isEmpty()) {
			Word w = queue.poll();
//			System.out.println(w);
			if (w.length > min)
				break;
			for (int i = 0; i < wordList.size(); i++) {
				if (!visit[i] && isDistanceOne(w.s, wordList.get(i))) {
					if (wordList.get(i).equals(endWord)) {
						return w.length + 1;

					} else {
						visit[i] = true;
						queue.add(new Word(wordList.get(i), w.length + 1));
					}
				}
			}
		}
//		return min == Integer.MAX_VALUE ? 0 : min;
		return 0;
	}

	private boolean isDistanceOne(String s1, String s2) {
		boolean flag = true;
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
				if (count >= 2) {
					flag = false;
					break;
				}
			}
		}

		return flag && count == 1;
	}
}

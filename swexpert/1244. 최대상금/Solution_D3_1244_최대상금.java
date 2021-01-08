import java.io.*;
import java.util.*;

public class Solution_D3_1244_최대상금 {
	static int N;
	static int R = 2;
	static List<Integer> list = new ArrayList<>();
	static Set<String> set;
	static Queue<String> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			String numberBoard = s[0];
			N = numberBoard.length();
			int changableCount = Integer.parseInt(s[1]);

			set = new TreeSet<>();
			set.add(numberBoard);
			for (int c = 0; c < changableCount; c++) {
				// set에 넣은 것을 queue로 옮기고 queue에서 돌리자
				moveSet2Queue();
				while (!queue.isEmpty()) {
					String polledNumber = queue.poll();
					nCr(0, 0, polledNumber);
				}
			}
			String lastElement = getLastElement();
			System.out.print("#" + t + " ");
			System.out.println(lastElement);
		}

	}

	private static String getLastElement() {
		Iterator<String> iter = set.iterator();
		String s = null;
		while (iter.hasNext()) {
			s = iter.next();
		}
		return s;
	}

	private static void moveSet2Queue() {
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			queue.add(iter.next());
		}
		set.clear();
	}

	private static void nCr(int start, int count, String number) {
		if (count == R) {
			String s = swap(list.get(0), list.get(1), number);
			set.add(s);
			return;
		}
		for (int i = start; i < N; i++) {
			list.add(i);
			nCr(i + 1, count + 1, number);
			list.remove(list.indexOf(i));
		}
	}

	private static String swap(int i, int j, String number) {
		char[] charArray = number.toCharArray();

		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;

		return String.valueOf(charArray);
	}

}

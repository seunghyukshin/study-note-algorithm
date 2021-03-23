package kakao2021;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 신규아이디추천 {
	public static void main(String[] args) {
		신규아이디추천 sol = new 신규아이디추천();
//		String new_id = "...!@BaT#*..y.abcdefghijklm";
//		String new_id = "z-+.^.";
//		String new_id = "=.=";
//		String new_id = "123_.def";
		String new_id = "abcdefghijklmn.p";

		String res = sol.solution(new_id);
	}

	/*
	 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
	 * 
	 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
	 * 
	 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	 * 
	 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	 * 
	 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	 * 
	 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다. 만약 제거 후
	 * 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	 * 
	 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	 */

	public String solution(String new_id) {

		// 1
		new_id = new_id.toLowerCase();
		System.out.println("1");
		System.out.println(new_id);

		// 2
		new_id = new_id.replaceAll("[^a-zA-Z0-9-_.]", "");
		System.out.println("2");
		System.out.println(new_id);

		// 3
		new_id = new_id.replaceAll("[.]{2,}", ".");
		System.out.println("3");
		System.out.println(new_id);

		// 4
		System.out.println("4");
		new_id = new_id.replaceAll("[.]$", "");
		new_id = new_id.replaceAll("^[.]", "");
		System.out.println(new_id);

		// 5
		if (new_id.equals("")) {
			new_id = "a";
		}
		System.out.println("5");
		System.out.println(new_id);

		// 6
		if (new_id.length() > 15) {
			new_id = new_id.substring(0, 15);
		}
		System.out.println("6");
		System.out.println(new_id);
		new_id = new_id.replaceAll("[.]$", "");
		System.out.println(new_id);

		// 7
		while (new_id.length() < 3) {
			new_id += new_id.charAt(new_id.length() - 1);
		}
		System.out.println("7");
		System.out.println(new_id);
		return new_id;
	}
}

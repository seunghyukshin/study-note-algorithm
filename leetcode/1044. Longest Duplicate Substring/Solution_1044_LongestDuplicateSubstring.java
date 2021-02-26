
public class Solution_1044_LongestDuplicateSubstring {
	public static void main(String[] args) {
		Solution_1044_LongestDuplicateSubstring sol = new Solution_1044_LongestDuplicateSubstring();
//		String s = "nanana";
//		String s = "qoassasmcmntmgylwkujr";
		String s = "unuoqslvgaekunapeaapsxbodakcrapmmfuxoowlysenyiygzhawbfbuxlswtxzzhlspfgzckzuoxizijrluvndcpnknsvrnfulksqqxdznfjgjlocozuolroealyhhwrzcsuzgcsekkqmwlnylsscpmynjchwvpwebwkraudfqboeqmxhghekcstrcozldbwyniwqmyrbkzwvknulehzxwckwohlmjvlqyexvzzlptbnnbctywyezcssubmiukcsixmnapgttmlfwtwnmxqgsobqsnxucwrszxcuprnlxjteytwqzridgtgkkbsekeytuxslavhebbpjewdwlhchtzwohqkojiqneahxacutymteoyloottnsmmrphngclortfvudoeckxkjqatxqmvboumxmdrxoxpyprkwvfpviqkbhsjdeosxdbzzfsomrxojkokofrrdoavhjufyayisibcgngqprircpcjyvynhzmrtyynfgfgeomscywbcvmlhcmyesuxwurmpdxhddyfnumgkvphmtqzrbsbjeliyrqfswrchkurvqtsmzchjfvotdmueabpllagtfvefssmgevrzydftuvxqdbdrpysifoxgvlkljhkiksoxfndxayrsaxeoefmimnqfeerggwxsbyarfvfwvrmtwjainqposafhwysxaaegzeewhyrsfnduqihpwipeewnubscqpvjekikyiwmpwynydbnvylqydgiwsenvulkknlbuqpwhxqclrnuvdwqpxkksyewsklffwtggbmxnttvnjbiqjdoezffmmighfdcirjakacncwckjqwqsjxsbsxbaeaagmnybxpwvucyskfkydlkxdlfmodygcxzimmhdgmwwqxrflldkwvyqlfwasxxoetlgtopmqnfkfvkshkrikfcvdrguxciupphxyssowakrnsiutntlliedxnqkldzfkqefgvyaargpqbknlmlbejkuup";
		String ans = sol.longestDupSubstring(s);
		System.out.println(ans);
	}

	public String longestDupSubstring(String s) {
		int max = 0;
		String result = "";
		for (int i = 0; i < s.length() - max; i++) {
			for (int j = i; j < s.length();) {
				String sub = s.substring(i, j + max + 1);
				int index = s.indexOf(sub, i + 1);
				if (index == -1)
					break;
				if (max < sub.length()) {
					max = sub.length();
					result = sub;
				} else {
					j++;
				}
			}

		}
		return result;
	}
}

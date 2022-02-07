class Solution {
    public char findTheDifference(String s, String t) {
        int total = 0;
        for(int n : s.toCharArray()) total += n;
        for(int n : t.toCharArray()) total -= n;
        return (char) Math.abs(total);
    }
}
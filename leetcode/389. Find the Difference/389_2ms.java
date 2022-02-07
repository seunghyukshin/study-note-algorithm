class Solution {
    public char findTheDifference(String s, String t) {
        
        int[] counts = new int[26];
        
        
        for(int i = 0; i < t.length(); i++) {
            int index = t.charAt(i)-'0' - 49;
            counts[index]++;
        }
    
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'0' - 49;
            counts[index]--;
        }
        
        for(int i = 0; i < counts.length; i++) {
            if(counts[i] != 0) return (char) (i + 97);
        }
        // not reached
        return 'z';
    }
}
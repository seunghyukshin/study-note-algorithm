class Solution {
    // #3 Using HashMap 45%
    public int findMaxLength(int[] nums) {
        int N = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int answer = 0;
        for(int i = 0; i < N; i++){
            if(nums[i] == 1) count ++;
            else count --;
            
            if(!map.containsKey(count)) map.put(count,i);
            else answer = Math.max(answer, i- map.get(count));
        }
        return answer ;
    }
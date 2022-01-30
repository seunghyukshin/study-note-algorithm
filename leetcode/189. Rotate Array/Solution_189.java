class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        if(N == k) return;
        
        k %= N;
        int[] temp = new int[N];
        System.arraycopy(nums, N - k, temp, 0, k);
        System.arraycopy(nums, 0, temp, k, N - k);
        System.arraycopy(temp, 0, nums, 0, N);
    }
}
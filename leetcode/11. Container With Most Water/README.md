### Container With Most Water

```java
class Solution {
    public int maxArea(int[] height) {
        int N = height.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                int width = j - i;
                int nowHeight = Math.min(height[i], height[j]);
                max = Math.max(max, nowHeight * width);
            }
        }
        return max;
    }
}
```

O(n^2)



##### Optimal Solution

O(n)

```java
class Solution {
    public int maxArea(int[] height) {
        int N = height.length;
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = N - 1;
        while(l < r){
            int width = r - l;
            int nowHeight = 0;
            if(heigth[l] < height[r]){
                nowHeight = height[l];
                l++;
            }else{
                nowHeight = height[r];
                r--;
            }
            max = Math.max(max, width * nowHeight);
        }
        
        return max;
    }
}
```




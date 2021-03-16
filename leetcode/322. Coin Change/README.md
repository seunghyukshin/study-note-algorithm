### 문제

coins = [a, b, c] , amount = d.

ax + by + cz = d를 만족하는 x+y+z의 최소값을 구하여라.



###### 조건 

1 <= coins.length <= 12

1 <= coins[i] <= 2^31 -1

0 <= amount <= 10^4

0 <= x,y,z  



### 풀이

###### DP

index : amount , value : count , dp[0] = 0



coins 값들을 빼면서 dp배열을 채운다.

``` java
dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
```

![322](https://user-images.githubusercontent.com/31649100/111275638-b45b9e00-8679-11eb-84e1-6a2645c04228.png)
#### 문제 개요

- 주가를 파고 사는 행위를 최대 2번 할 수 있다. (한번만 혹은 0번도 가능)
- 2번째 살때는, 앞에서 산 주식을 팔아야지 살 수 있다.
- 최대 이익을 구하라.



##### 예시

```
prices = [3,3,5,0,0,3,1,4]
```

[3]일때 사서 [5]일때 팔면 3의 이익 +
[6]일때 사서 [7]일때 팔면 3의 이익 = 총 6의 이익



```
prices = [1,2,3,4,5]
```

[0]일때 사서 [4]일때 팔면 4의 이익 



```
prices = [7,6,4,3,1]
```

0의 이익



#### 시도 아이디어

dfs : 처음살 때 한 번 돌리고 판 다음에 한 번 더 돌림. 방문체크도 불가능해서 효율이 떨어짐 

최악의 경우 : O(n^3)



#### 풀이

[42번](https://github.com/seunghyukshin/study-note-algorithm/tree/master/leetcode/42.%20Trapping%20Rain%20Water)이랑 약간 비슷하다.

- 하나의 min 변수를 이용하여 좌측에서 만드는 배열과 
  또 하나의 max 변수를 이용하여 우측에서 만드는 배열

- 두 배열 값의 합들 중 최댓값

```java 
int N = prices.length;
int[] lefts = new int[N];
int[] rights = new int[N];
int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;

// make array
for (int i = 0; i < N; i++) {
    min = Math.min(min, prices[i]);
    if (i != 0)
        lefts[i] = Math.max(lefts[i - 1], prices[i] - min);
}
for (int i = N - 1; i >= 0; i--) {
    max = Math.max(max, prices[i]);
    if (i != N - 1)
        rights[i] = Math.max(rights[i + 1], max - prices[i]);
}

int maxSum = 0;
for (int i = 0; i < N; i++) {
    int sum = lefts[i] + rights[i];
    maxSum = Math.max(maxSum, sum);
}

return maxSum;
```


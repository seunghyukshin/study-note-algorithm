#### 문제 개요

String A에서 B로 바꾸려고하는데 최소의 작업 수는? 

작업은 총 3가지로 구분된다.

1. insert
2. delete
3. replace



##### 예시

"input" → "output"

1. replace 'i' → 'o'
2. replace 'n' → 'u' 
3. insert 't'

result = 3



#### 시도 아이디어

[115번](https://github.com/seunghyukshin/study-note-algorithm/tree/master/leetcode/115.%20Distinct%20Subsequences)의 풀이 방식을 빌려 **연속적으로 나열할 수 있는 문자 개수의 최대값**(replace하기 위해)을 찾고, 그 값을 A와 B에서 각각 뺀 후, 작은 값을 return



###### 그러나 but

"intention" → "execution"의 예를 보면

intention의 'e'를 execution의 'e' 중 어떤 것으로 대체할 지에 따라 작업수가 달라지는데, 이를 염두하지 못 함



#### 풀이법

##### 초기화

|       |  ·   |  i   |  n   |  t   |  e   |  n   |  t   |  i   |  o   |  n   |
| :---: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: |
| **·** |  0   |  1   |  2   |  3   |  4   |  5   |  6   |  7   |  8   |  9   |
| **e** |  1   |      |      |      |      |      |      |      |      |      |
| **x** |  2   |      |      |      |      |      |      |      |      |      |
| **e** |  3   |      |      |      |      |      |      |      |      |      |
| **c** |  4   |      |      |      |      |      |      |      |      |      |
| **u** |  5   |      |      |      |      |      |      |      |      |      |
| **t** |  6   |      |      |      |      |      |      |      |      |      |
| **i** |  7   |      |      |      |      |      |      |      |      |      |
| **o** |  8   |      |      |      |      |      |      |      |      |      |
| **n** |  9   |      |      |      |      |      |      |      |      |      |

예시로 ```a[0]a[3]```을 보면 "int" → "" 바꾸기 위한 최소 작업 수는 3 



##### 배열값 채우기

이중 반복을 하면서 

1. insert
2. delete
3. replace 

의 경우를 확인하여 가장 작은 값을 채워준다.

```java
for (int i = 1; i < R + 1; i++) {
    for (int j = 1; j < C + 1; j++) {
        if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
            dp[i][j] = dp[i - 1][j - 1];
        } else {
            int insertedNum = dp[i][j - 1] + 1;
            int deletedNum = dp[i - 1][j] + 1;
            int replacedNum = dp[i - 1][j - 1] + 1;
            dp[i][j] = Math.min(insertedNum, Math.min(deletedNum, replacedNum));
        }
    }
}
return dp[R][C];
```






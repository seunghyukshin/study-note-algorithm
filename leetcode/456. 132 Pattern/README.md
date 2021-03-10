#### 풀이

1. leftArray / midValue / rightArray처럼 가운데 값을 기준으로 좌,우 배열 구분 지음
2. midIndex는 1부터 length-1 까지 증가하며 midValue가 가장 큰 값이라고 가정한다.
3. right값이 두번째로 큰 값이 되어야하므로 rightArray를 탐색하며 midValue보다 작은 값 중 가장 큰 값을 찾아 저장한다.
4. leftArray를 탐색하며 rightMaxValue보다 작은 값이 있다면 return true;



결과: 322 ms, faster than 5.04%



#### 속도 개선

위의 3번 과정을 2번의 midIndex가 변할 때마다 계산해야한다.

**dp배열을 만들어 최소값을 미리 기억해두자.**

3번과정의 rightMaxValue는 midValue에 영향을 받는다.

다른 변수에 영향을 받지 않는, 가장 작은 값이 되어야하는 leftValue를 위해 min dp 배열을 생성한다.

dp[i-1] < nums[j] < nums[i] 조건에 해당하는 값이 있다면 return true;



결과 : 57 ms, faster than 24.09%


#### 문제 개요

- 배열과 k가 주어질 때, window의 합이 k보다 크거나 같게하는 window 크기의 최소값을 구하라.
- k보다 크거나 같은 경우가 아예 없으면 -1 반환



##### 예시

```
nums = [-1, 10, -3, 5, 4], k = 11
```

3





#### 풀이

##### Deque를 이용하여 O(N)으로 

인덱스 0부터 합한 값을 갖고 있는 배열을 이용

ex) 3번째부터 5번째까지의 합 = S[5] - S[2]



```java 
public int shortestSubarray(int[] nums, int k) {
    int N = nums.length;
    long[] sums = new long[N + 1];
    for (int i = 0; i < N; ++i)
        sums[i + 1] = sums[i] + (long) nums[i];

    int ans = N + 1;
    Deque<Integer> deque = new LinkedList();
    for (int i = 0; i < sums.length; ++i) {
        // deque 맨앞값 index 부터 현재 i까지 더한 값이 k보다 크거나 같으면
        // 맨앞값 짜르고 window크기 저장
        while (!deque.isEmpty() && sums[i] - sums[deque.getFirst()] >= k)
            ans = Math.min(ans, i - deque.removeFirst());

        // 추가하려는 값이 deque 맨뒤 값보다 작거나 같으면
        // (=더해지다가 갑자기 작아졌다)
        // 맨뒤값 짜른다
        // (=그때까지의 sum값은 필요가없음)
        while (!deque.isEmpty() && sums[i] <= sums[deque.getLast()])
            deque.removeLast();

        deque.addLast(i);
    }

    return ans < N + 1 ? ans : -1;
}
```


#### 문제 개요

- 배열과 window 크기 k가 주어질 때, window 중 최대 값으로 배열을 만들어라.



##### 예시

```
nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
```

[3, 3, 5, 5, 6, 7]





#### 시도 아이디어

크기가 k 만큼인 최대 Heap을 만들어서, 인덱스가 증가 할때마다 Heap에 추가, 삭제해준다.

=> 최대 값 조회, 추가는 빠르지만 삭제할 때 값을 찾는 부분때문에 시간초과가 난다.

```java
// 최대 heap 선언
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
```





#### 풀이

##### Deque를 이용하여 O(N)으로 

```java 
public int[] maxSlidingWindow(int[] nums, int k) {
    int N = nums.length;
    int result[] = new int[N - k + 1];
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < N; i++) {
        // window 크기 k보다 크면 맨앞 짜른다.
        while (!deque.isEmpty() && i - deque.peekFirst() >= k)
            deque.pollFirst();

        // 추가할 값이 맨뒤보다 크면 짜른다.
        while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
            deque.pollLast();

        deque.addLast(i);

        // 최대값 저장
        if (i >= k - 1)
            result[i - k + 1] = nums[deque.peekFirst()];
    }
    return result;
}
```


### Sliding Window



#### Code Frame

```java 
Deque<Integer> deque = new LinkedList<>();

for (int i = 0; i < N; i++) {
    while (!deque.isEmpty() && 조건 A )
        deque.pollFirst();

    while (!deque.isEmpty() && 조건 B )
        deque.pollLast();

    deque.addLast(i);
}
```



####  구현

1. deque에는 인덱스를 이용 
   1. **window의 크기**를 사용하기 위해 ```i - deque.pollFirst()```
2. deque의 맨 앞에 값을 무슨 값으로 유지할 지 컨셉을 정한다. ex) 최대값, 
3. 조건A : peekFirst()와 
   i값을 이용하여 비교한다.
   deque의 맨 앞에 값이 컨셉과 맞는지 걸러준다.
4. 조건B: peekLast()와 i값을 이용하여 비교한다.
   이전 loop단계에서 last에 추가한 값이 필요한 지 판단.
5. 추가는 offerLast() **조건없이**



#### 관련 문제

- [LeetCode 239. Sliding Window Maximum](https://github.com/seunghyukshin/study-note-algorithm/tree/master/leetcode/239.%20Sliding%20Window%20Maximum)
- [LeetCode 862. Shortest Subarray with Sum at Least K](https://github.com/seunghyukshin/study-note-algorithm/tree/master/leetcode/862.%20Shortest%20Subarray%20with%20Sum%20at%20Least%20K)
- [LeetCode 84. Largest Rectangle in Histogram](https://github.com/seunghyukshin/study-note-algorithm/tree/master/leetcode/84.%20Largest%20Rectangle%20in%20Histogram)





#### 주의 사항 :no_entry_sign: 

음수가 포함되어있으면 슬라이딩 윈도우를 쓸 수 없다.
(조건의 일관성이 깨지기 때문에)

##### 관련 문제 : [LeetCode 560. Subarray Sum Equals K](https://github.com/seunghyukshin/study-note-algorithm/tree/master/leetcode/560.%20Subarray%20Sum%20Equals%20K)


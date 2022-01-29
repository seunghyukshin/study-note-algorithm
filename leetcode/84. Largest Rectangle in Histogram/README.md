### Overview

주어진 배열로 그려진 그래프에서 가장 큰 직사각형 면적은?



##### 예시

```java
heights = [2, 1, 5, 6, 2, 3]
```

5 * 2 = 10



### Solution

**Stack**

~~O(NlogN)~~

오름차순 컨셉

스택의 가장 위의 값보다 작은 값이 들어오려한다?
그러면 이 값보다 큰 값들 계속 pop해서 면적값 구해준다.

###### Java

```java
public int largestRectangleArea(int[] heights) {
    int N = heights.length;
    int max = 0;
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i <= N; i++) {
        int v = i == N ? 0 : heights[i];
        while (!s.isEmpty() && v < heights[s.peek()]) {
            max = Math.max(max, heights[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
        }
        s.push(i);
    }
    return max;
}
```





~~O(N) 코드는 아..직~~

O(N)이다. 

###### Javascript

```javascript
/**
 * @param {number[]} heights
 * @return {number}
 */
const largestRectangleArea = function (heights) {
  let answer = 0;

  const deque = [];
  heights.push(0);
  const n = heights.length;
  for (let i = 0; i < n; i++) {
    while (deque.length !== 0 && heights[peek(deque)] > heights[i]) {
      const h = heights[deque.pop()];
      let len = deque.length === 0 ? i : i - peek(deque) - 1;
      answer = Math.max(answer, h * len);
    }
    deque.push(i);
  }
  return answer;
};

const peek = (stack) => {
  return stack[stack.length - 1];
};
```


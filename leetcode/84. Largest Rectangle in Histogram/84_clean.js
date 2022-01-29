// 두가지 접근법 1. Sliding Window  2. left, right
// 둘 다 맞다.
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
// const heights = [2, 1, 5, 6, 2, 3];
const heights = [2, 4];
const answer = largestRectangleArea(heights);
console.log(answer);

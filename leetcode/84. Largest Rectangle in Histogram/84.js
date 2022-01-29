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
    while (
      deque.length !== 0 &&
      heights[deque[deque.length - 1]] > heights[i]
    ) {
      const h = heights[deque.pop()];
      let len = i;
      if (deque.length !== 0) {
        len = i - deque[deque.length - 1] - 1;
      }
      //   console.log(i, h, len);
      answer = Math.max(answer, h * len);
    }
    deque.push(i);
  }
  return answer;
};
// const heights = [2, 1, 5, 6, 2, 3];
const heights = [2, 4];
const answer = largestRectangleArea(heights);
console.log(answer);

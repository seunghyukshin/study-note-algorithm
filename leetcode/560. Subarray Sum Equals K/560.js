// fail : Sliding Window

// 깨달은 점 : 음수가 포함되어 있으면 슬라이딩 윈도우를 쓸 수가 없다.

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const subarraySum = function (nums, k) {
  let answer = 0;
  const N = nums.length;
  const sums = new Array(N + 1).fill(0);
  for (let i = 0; i < N; i++) {
    sums[i + 1] = sums[i] + nums[i];
  }
  const deque = [];
  const isEmpty = (arr) => {
    return arr.length === 0;
  };
  const peek = (arr) => {
    return arr[arr.length - 1];
  };
  if (sums[1] < 0) sums.shift();
  for (let i = 0; i < sums.length; i++) {
    console.log(i);
    while (!isEmpty(deque) && sums[i] - sums[deque[0]] >= k) {
      if (sums[i] - sums[deque.shift()] === k) answer++;
    }
    console.log(deque);
    // while (!isEmpty(deque) && peek(deque) >= sums[i] ) deque.pop();
    console.log(deque);
    deque.push(i);
    console.log(deque);
  }
  return answer;
};

const nums = [-1, -1, 1],
  k = 1;

// const nums = [1, 2, 3],
//   k = 3;

// const nums = [1, 2, 5, 6, 8, 9],
//   k = 8;
// expected : 2 [1,2,5] / [8]

const answer = subarraySum(nums, k);
console.log(answer);

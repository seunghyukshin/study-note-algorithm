/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const findPairs = function (nums, k) {
  const treeSet = [...new Set(nums)].sort((a, b) => a - b);

  if (k == 0) {
    const set = new Set();
    const result = new Set();
    nums.forEach((v) => {
      if (!set.has(v)) set.add(v);
      else result.add(v);
    });
    return result.size;
  }
  // Sliding Window
  let answer = 0;
  const deque = [];
  for (let i = 0; i < treeSet.length; i++) {
    while (deque.length !== 0 && treeSet[i] - treeSet[deque[0]] >= k) {
      if (treeSet[i] - treeSet[deque[0]] == k) answer++;
      deque.shift();
    }
    deque.push(i);
  }
  return answer;
};

// const nums = [3, 1, 4, 1, 5],
//   k = 2;
// const nums = [1, 2, 3, 4, 5],
//   k = 1;
const nums = [1, 2, 3, 1, 1, 1, 1, 1, 4, 2, 5],
  k = 0;
const answer = findPairs(nums, k);
console.log(answer);

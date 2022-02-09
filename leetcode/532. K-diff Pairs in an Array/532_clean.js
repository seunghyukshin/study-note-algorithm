/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const findPairs = function (nums, k) {
  const map = new Map();
  let answer = 0;
  nums.forEach((v) => {
    if (map.has(v)) map.set(v, map.get(v) + 1);
    else map.set(v, 1);
  });

  if (k == 0) {
    map.forEach((v) => {
      if (v >= 2) answer++;
    });
  } else {
    map.forEach((v, key) => {
      if (map.has(key + k)) answer++;
    });
  }
  return answer;
};

const nums = [3, 1, 4, 1, 5],
  k = 2;
// const nums = [1, 2, 3, 4, 5],
//   k = 1;
// const nums = [3, 1, 1, 2, 1, 1, 4, 2, 5],
//   k = 0;
const answer = findPairs(nums, k);
console.log(answer);

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
const subsets = function (nums) {
  const N = nums.length;
  const answer = [];
  const list = [];

  const nCr = (start, count, N, R) => {
    if (count == R) {
      //   const copyList = [];
      //   for (const l of list) {
      //     copyList.push(l);
      //   }
      //   answer.push(copyList);

      // Deep Copy
      answer.push([...list]);
      return;
    }

    for (let i = start; i < N; i++) {
      list.push(nums[i]);
      nCr(i + 1, count + 1, N, R);
      list.pop();
    }
  };

  for (let r = 0; r <= N; r++) {
    nCr(0, 0, N, r);
  }
  return answer;
};

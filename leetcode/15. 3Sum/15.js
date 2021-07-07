/**
 * @param {number[]} nums
 * @return {number[][]}
 */
const threeSum = function (nums) {
  N = nums.length;
  nums.sort((a, b) => a - b);
  //   console.log(nums);
  const answer = [];
  for (let p = 0; p < N - 2; ) {
    console.log(p);
    let l = p + 1;
    let r = N - 1;
    while (true) {
      if (l == r) {
        p++;
        break;
      }

      const sum = nums[p] + nums[l] + nums[r];
      if (sum > 0) r--;
      else if (sum < 0) l++;
      else {
        // const list = [];
        !answer.find(
          (item) =>
            item[0] === nums[p] && item[1] === nums[l] && item[2] === nums[r]
        ) && answer.push([nums[p], nums[l], nums[r]]);
        l++;
      }
    }
  }
  //   nCr(0, 0, nums);
  return answer;
};

const nums = [-1, 0, 1, 2, -1, -4];
// const nums = [];
console.log(threeSum(nums));

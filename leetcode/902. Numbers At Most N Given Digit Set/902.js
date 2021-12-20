// 완탐 time limit fail

/**
 * @param {string[]} digits
 * @param {number} n
 * @return {number}
 */
const atMostNGivenDigitSet = function (digits, n) {
  let count = 0;
  const dfs = (sum) => {
    if (sum > n) return;
    // console.log(sum);
    count++;
    for (let i = 0; i < digits.length; i++) {
      dfs(sum + digits[i]);
    }
  };
  dfs("");
  return count - 1;
};

const digits = ["1", "3", "5", "7"];
// digits = ["1", "4", "9"];
// digits = ["7"];
const answer = atMostNGivenDigitSet(digits, 550);
console.log(answer);

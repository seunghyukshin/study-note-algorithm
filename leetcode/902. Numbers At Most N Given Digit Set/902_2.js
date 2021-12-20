/**
 * @param {string[]} digits
 * @param {number} n
 * @return {number}
 */
const atMostNGivenDigitSet = function (digits, n) {
  let count = 0;

  const base = (r, n) => {
    if (r === 1) return n - 1;
    return ((Math.pow(r, n - 1) - 1) / (r - 1)) * r;
  };
  const baseCount = base(digits.length, n.toString().length);
  const dfs = (index, value) => {
    if (index === n.toString().length) return;
    console.log(value, index, n.toString()[index]);
    if (value < n.toString()[index]) {
      count += Math.pow(digits.length, n.toString().length - index - 1);
      return;
    } else if (value > n.toString()[index]) return;
    else {
      if (index === n.toString().length - 1) count++;
      // same
      for (let i = 0; i < digits.length; i++) {
        dfs(index + 1, digits[i]);
      }
    }
  };

  //   console.log(n.toString()[1]);
  for (let i = 0; i < digits.length; i++) {
    dfs(0, digits[i]);
  }
  return baseCount + count;
};

// const digits = ["1", "3", "5", "7"];
// digits = ["1", "4", "9"];
// const digits = ["7"];
digits = ["3", "4", "8"];
const answer = atMostNGivenDigitSet(digits, 4);
console.log(answer);

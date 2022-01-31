/**
 * @param {number[][]} accounts
 * @return {number}
 */
const maximumWealth = function (accounts) {
  let max = 0;
  accounts.map((v) => {
    const value = v.reduce((a, b) => a + b);
    max = Math.max(max, value);
    return value;
  });
  return max;
};

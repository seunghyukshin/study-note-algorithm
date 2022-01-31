/**
 * @param {number[][]} accounts
 * @return {number}
 */
const maximumWealth = function (accounts) {
  return accounts.reduce((max, c) => {
    const wealth = c.reduce((s, c) => s + c, 0);
    return Math.max(max, wealth);
  }, 0);
};

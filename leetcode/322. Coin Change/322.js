/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
const coinChange = function (coins, amount) {
  if (amount == 0) return 0;
  coins.sort((a, b) => a - b);
  const dp = new Array(amount + 1);
  dp.fill(Number.MAX_VALUE);
  for (let i = 0; i < coins.length; i++) {
    dp[coins[i]] = 1;
  }
  for (let i = 1; i <= amount; i++) {
    for (let j = 0; j < coins.length; j++) {
      const index = i - coins[j];
      if (index <= 0) break;
      dp[i] = Math.min(dp[i], dp[index] + 1);
    }
  }
  return dp[amount] === Number.MAX_VALUE ? -1 : dp[amount];
};

const coins = [1, 2, 5],
  amount = 11;
console.log(coinChange(coins, amount));

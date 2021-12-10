/**
 * @param {number} n
 * @return {number}
 */
const numTilings = (n) => {
  const dp = new Array(n + 1).fill(0);

  dp[0] = 0;
  dp[1] = 1;
  dp[2] = 2;
  dp[3] = 5;
  for (let i = 4; i <= n; i++) {
    dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
  }
  return dp[n];
};
const answer = numTilings(28);
console.log(answer);
console.log(Number.MAX_VALUE);

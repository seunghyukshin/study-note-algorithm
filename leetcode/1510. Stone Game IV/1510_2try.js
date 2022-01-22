/**
 * @param {number} n
 * @return {boolean}
 */
const winnerSquareGame = function (n) {
  const dp = new Array(n + 1);

  dp[1] = true;
  dp[2] = false;
  for (let i = 3; i < n + 1; i++) {
    let flag = true;
    for (let j = 1; Math.pow(j, 2) <= i && flag; j++) {
      flag = dp[i - Math.pow(j, 2)];
    }
    dp[i] = !flag;
  }
  console.log(dp);
  return dp[n];
};
console.log(winnerSquareGame(10));

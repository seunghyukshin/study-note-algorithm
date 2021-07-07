/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
const numDistinct = function (s, t) {
  const N = t.length;
  const M = s.length;
  const dp = new Array(N + 1);
  for (let i = 0; i < N + 1; i++) {
    dp[i] = new Array(M + 1);
  }
  for (let i = 0; i < N + 1; i++) {
    dp[i].fill(0);
  }
  dp[0].fill(1);

  //   console.log(dp);
  for (let i = 1; i < N + 1; i++) {
    for (let j = 1; j < M + 1; j++) {
      if (t.charAt(i - 1) == s.charAt(j - 1)) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
      } else {
        dp[i][j] = dp[i][j - 1];
      }
    }
  }

  //   console.log(dp);
  return dp[N][M];
};

const s = "rabbbit",
  t = "rabbit";
console.log(numDistinct(s, t));

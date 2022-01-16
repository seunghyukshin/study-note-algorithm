/**
 * @param {number[]} seats
 * @return {number}
 */
const maxDistToClosest = function (seats) {
  const n = seats.length;
  const dp = new Array(n).fill(Infinity);

  let seat = -1;
  for (let i = 0; i < n; i++) {
    if (seats[i] === 1) seat = i;
    else {
      if (seat == -1) continue;
      dp[i] = i - seat;
    }
  }

  seat = -1;
  let answer = 0;
  for (let i = n - 1; i >= 0; i--) {
    if (seats[i] === 1) {
      seat = i;
    } else {
      if (seat !== -1) {
        dp[i] = Math.min(dp[i], seat - i);
      }
      answer = Math.max(answer, dp[i]);
    }
  }
  return answer;
};

/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
const findJudge = function (n, trust) {
  const counts = new Array(n + 1).fill(0);
  for (const [a, b] of trust) {
    counts[a]--;
    counts[b]++;
  }
  const answer = [];
  for (let i = 1; i < counts.length; i++) {
    if (counts[i] === n - 1) return i;
  }
  return -1;
};

// const n = 3,
//   trust = [
//     [1, 3],
//     [2, 3],
//   ];
const n = 1,
  trust = [];
const answer = findJudge(n, trust);
console.log(answer);

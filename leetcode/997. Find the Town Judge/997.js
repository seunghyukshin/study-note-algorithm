/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
const findJudge = function (n, trust) {
  const judges = new Array(n + 1).fill(true);
  judges[0] = false;
  for (const [a, b] of trust) {
    judges[a] = false;
  }

  const answer = [];
  judges.map((v, i) => v && answer.push(i));

  if (answer.length !== 1) return -1;

  const temp = [];
  for (const [a, b] of trust) {
    if (b === answer[0]) temp.push(a);
  }

  if (temp.length !== n - 1) return -1;

  return answer[0];
};

const n = 3,
  trust = [
    [1, 2],
    [2, 3],
  ];

const answer = findJudge(n, trust);
console.log(answer);

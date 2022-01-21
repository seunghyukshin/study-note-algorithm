/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
const canCompleteCircuit = function (gas, cost) {
  let n = gas.length;
  const diff = new Array(n).fill(0);
  const rightSum = new Array(n).fill(0);
  for (let i = 0; i < n; i++) {
    diff[i] = gas[i] - cost[i];
  }
  //   console.log(diff);

  if (rightSum[0] < 0) return -1;
  rightSum[n - 1] = diff[n - 1];
  for (let i = n - 2; i >= 0; i--) {
    rightSum[i] = diff[i] + rightSum[i + 1];
  }

  let answer = -1;
  let max = -1;
  rightSum.map((v, i) => {
    if (max < v) {
      max = v;
      answer = i;
    }
  });
  return answer;
};
const gas = [1, 2, 3, 4, 5],
  cost = [3, 4, 5, 1, 2];

// const gas = [2, 3, 4],
//   cost = [3, 4, 3];
const answer = canCompleteCircuit(gas, cost);
console.log(answer);

/**
 * @param {number} low
 * @param {number} high
 * @return {number[]}
 */
const sequentialDigits = function (low, high) {
  const sequence = new Array(9).fill(0).map((v, i) => (v = v + i + 1));
  const answer = [];
  for (let i = low.toString().length; i <= high.toString().length; i++) {
    for (let j = 0; j <= 9 - i; j++) {
      const temp = [];
      for (let k = 0; k < i; k++) {
        temp.push(sequence[k + j]);
      }
      const num = Number(temp.join(""));
      if (low <= num && num <= high) answer.push(num);
    }
  }

  return answer;
};
const low = 1000,
  high = 13000;
const answer = sequentialDigits(low, high);
console.log(answer);

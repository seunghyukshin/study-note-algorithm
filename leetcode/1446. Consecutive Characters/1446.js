/**
 * @param {string} s
 * @return {number}
 */
const maxPower = function (s) {
  let char = s.charAt(0);
  let answer = 1;
  let count = 1;
  for (let i = 1; i < s.length; i++) {
    if (char === s.charAt(i)) {
      count++;
    } else {
      count = 1;
    }
    char = s.charAt(i);
    answer = Math.max(answer, count);
  }

  return answer;
};

const s = "hooraaaaaaaaaaay";
const answer = maxPower(s);
console.log(answer);

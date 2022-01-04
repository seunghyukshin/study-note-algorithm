/**
 * @param {number} n
 * @return {number}
 */
const bitwiseComplement = function (n) {
  if (n === 0) return 1;
  if (n === 1) return 0;
  let i = 1;
  while (i <= n) {
    i *= 2;
  }
  return i - n - 1;
};

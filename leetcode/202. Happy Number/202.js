/**
 * @param {number} n
 * @return {boolean}
 */
const isHappy = function (n) {
  if (n === 1) return true;

  const set = new Set();
  set.add(n);
  while (true) {
    if (n.toString().length === 1) n *= 10;
    n = n
      .toString()
      .split("")
      .map((v) => Math.pow(v, 2))
      .reduce((a, b) => a + b);
    if (n === 1) return true;
    if (set.has(n)) return false;
    set.add(n);
  }
};

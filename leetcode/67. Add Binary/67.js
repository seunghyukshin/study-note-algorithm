/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
const addBinary = function (a, b) {
  const i = BigInt("0b" + a) + BigInt("0b" + b);
  return i.toString(2);
};

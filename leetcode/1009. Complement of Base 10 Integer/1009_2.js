/**
 * @param {number} n
 * @return {number}
 */
const bitwiseComplement = function (n) {
  return parseInt(
    n
      .toString(2)
      .split("")
      .map((v) => (v == 1 ? 0 : 1))
      .join(""),
    2
  );
};

/**
 * @param {number} n
 * @return {number}
 */
const bitwiseComplement = function (n) {
  let mask = 1;
  while (mask < n) mask = (mask << 1) + 1; // Creating the mask
  return mask ^ n;
};

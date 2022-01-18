/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
const canPlaceFlowers = function (flowerbed, n) {
  let size = flowerbed.length;
  for (let i = 0; i < size; i++) {
    if (
      (i === 0 && !flowerbed[i] && !flowerbed[i + 1]) ||
      (i === size - 1 && !flowerbed[i] && !flowerbed[i - 1]) ||
      (i !== 0 &&
        i !== size - 1 &&
        !flowerbed[i] &&
        !flowerbed[i - 1] &&
        !flowerbed[i + 1])
    ) {
      flowerbed[i] = 1;
      n--;
    }
    if (n <= 0) return true;
  }
  return false;
};

/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
const canPlaceFlowers = function (flowerbed, n) {
  flowerbed.unshift(0);
  flowerbed.push(0);
  let size = flowerbed.length;
  for (let i = 1; i < size - 1; i++) {
    if (!flowerbed[i] && !flowerbed[i - 1] && !flowerbed[i + 1]) {
      flowerbed[i] = 1;
      n--;
    }
    if (n <= 0) return true;
  }
  return false;
};

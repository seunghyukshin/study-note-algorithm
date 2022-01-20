// binary search

/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
const minEatingSpeed = function (piles, h) {
  piles.sort((a, b) => b - a);
  let left = 1;
  let right = piles[0];
  while (true) {
    if (left === right) break;
    const mid = Math.floor((left + right) / 2);
    // console.log(mid);
    let sum = 0;
    let flag = true;
    for (let i = 0; i < piles.length && flag; i++) {
      sum += Math.ceil(piles[i] / mid);
      if (sum > h) flag = false;
    }
    if (flag) {
      // succes
      right = mid;
    } else {
      left = mid + 1;
    }
  }
  return left;
};
const piles = [30, 11, 23, 4, 20];
h = 5;

const answer = minEatingSpeed(piles, h);
console.log(answer);

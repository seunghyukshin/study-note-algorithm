// k를 1부터 넣어본다. => 시간초과 ([1000000000, 1000000000] , 3)

/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
const minEatingSpeed = function (piles, h) {
  piles.sort((a, b) => b - a);
  console.log(piles);
  const max = piles[0];

  for (let k = 1; k < max; k++) {
    let sum = 0;
    let flag = true;
    for (let i = 0; i < piles.length && flag; i++) {
      sum += Math.ceil(piles[i] / k);
      //   console.log(k, i, sum);
      if (sum > h) flag = false;
    }
    if (flag) {
      return k;
    }
  }
};
const piles = [3, 6, 7, 11],
  h = 8;
const answer = minEatingSpeed(piles, h);
console.log(answer);

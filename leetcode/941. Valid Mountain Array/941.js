/**
 * @param {number[]} arr
 * @return {boolean}
 */
const validMountainArray = function (arr) {
  let point = -1;
  for (let i = 0; i < arr.length - 1; i++) {
    if (arr[i] > arr[i + 1]) {
      point = i;
      break;
    } else if (arr[i] === arr[i + 1]) return false;
  }
  if (point === -1) return false;

  for (let i = arr.length - 1; i > 0; i--) {
    if (arr[i - 1] < arr[i]) {
      if (i === point) return true;
      else return false;
    } else if (arr[i] === arr[i + 1]) return false;
  }
  return false;
};
const arr = [1, 2];
// const arr = [0, 3, 2, 1];
const answer = validMountainArray(arr);
console.log(answer);

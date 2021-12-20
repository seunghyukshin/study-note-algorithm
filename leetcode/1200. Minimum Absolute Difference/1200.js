/**
 * @param {number[]} arr
 * @return {number[][]}
 */
const minimumAbsDifference = function (arr) {
  arr.sort((b, a) => b - a);
  let min = Infinity;
  const answer = [];
  //   console.log(arr);
  for (let i = 1; i < arr.length; i++) {
    if (min > arr[i] - arr[i - 1]) {
      min = arr[i] - arr[i - 1];
      answer.length = 0;
      answer.push([arr[i - 1], arr[i]]);
    } else if (min === arr[i] - arr[i - 1]) answer.push([arr[i - 1], arr[i]]);
  }
  return answer;
};

// const arr = [4, 2, 1, 3];
// const arr = [1, 3, 6, 10, 15];
// const arr = [3, 8, -10, 23, 19, -4, -14, 27];
const arr = [40, 11, 26, 27, -20];
const answer = minimumAbsDifference(arr);
console.log(answer);

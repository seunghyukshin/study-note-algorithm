/**
 * @param {number[][]} points
 * @return {number}
 */
const findMinArrowShots = function (points) {
  points.sort((a, b) => a[0] - b[0] || a[1] - b[1]);
  console.log(points);
  let p = -Infinity;
  let count = 0;

  for (const [start, end] of points) {
    if (p < start) {
      p = end;
      //   console.log(p);
      count++;
    } else if (start < p && end < p) {
      p = end;
    }
  }

  return count;
};

const points = [
  [10, 16],
  [2, 8],
  [1, 6],
  [7, 12],
  [1, 4],
  [2, 3],
];
// const points = [
//   [1, 2],
//   [3, 4],
//   [5, 6],
//   [7, 8],
// ];
// const points = [
//   [1, 2],
//   [2, 3],
//   [3, 4],
//   [4, 5],
// ];
const answer = findMinArrowShots(points);
console.log(answer);

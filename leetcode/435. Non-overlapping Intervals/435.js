/**
 * @param {number[][]} intervals
 * @return {number}
 */
const eraseOverlapIntervals = function (intervals) {
  intervals.sort((a, b) => a[1] - b[1] || a[0] - b[0]);
  //   console.log(intervals);
  let p = -Infinity;
  let count = 0;
  for (const [start, end] of intervals) {
    if (p <= start) {
      p = end;
    } else {
      count++;
    }
  }
  return count;
};

const intervals = [
  [1, 2],
  [2, 3],
  [3, 4],
  [1, 3],
];

// const intervals = [
//   [1, 2],
//   [1, 2],
//   [1, 2],
// ];

// const intervals = [
//   [1, 2],
//   [2, 3],
// ];

console.log(eraseOverlapIntervals(intervals));

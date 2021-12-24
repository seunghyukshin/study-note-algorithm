/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
const merge = function (intervals) {
  intervals.sort((a, b) => a[0] - b[0]);

  // 앞뒤 비교해서 b[0] <= a[1] 이면 a,b를 a[0] ~ b[1] 로 합쳐서 배열에 넣는다.
  const length = intervals.length;
  for (let i = 1; i < intervals.length; i++) {
    if (intervals[i - 1][1] >= intervals[i][0]) {
      intervals.splice(i - 1, 2, [
        intervals[i - 1][0],
        Math.max(intervals[i - 1][1], intervals[i][1]),
      ]);
      i--;
    }
  }
  return intervals;
};

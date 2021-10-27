const solution = (sizes) => {
  let widthMax = 0;
  let heightMax = 0;
  sizes.map((v) => {
    if (v[0] < v[1]) {
      widthMax = Math.max(widthMax, v[1]);
      heightMax = Math.max(heightMax, v[0]);
    } else {
      widthMax = Math.max(widthMax, v[0]);
      heightMax = Math.max(heightMax, v[1]);
    }
  });
  return widthMax * heightMax;
};

const sizes = [
  [60, 50],
  [30, 70],
  [60, 30],
  [80, 40],
];

const answer = solution(sizes);
console.log(answer);

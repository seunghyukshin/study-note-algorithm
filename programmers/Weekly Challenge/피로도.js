const solution = (k, dungeons) => {
  let N = dungeons.length;
  let R = N;
  let answer = 0;
  const nPr = (count, isGo, k) => {
    answer = Math.max(answer, count);
    if (count == R) {
      return;
    }
    for (let i = 0; i < N; i++) {
      if (isGo[i] || dungeons[i][0] > k) continue;

      isGo[i] = true;
      nPr(count + 1, isGo, k - dungeons[i][1]);
      isGo[i] = false;
    }
  };

  nPr(0, new Array(N).fill(false), k);

  return answer;
};

const k = 80;
const dungeons = [
  [80, 20],
  [50, 40],
  [30, 10],
];
const answer = solution(k, dungeons);
console.log(answer);

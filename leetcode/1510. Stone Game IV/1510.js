// 항상 서로 최적의 수를 둔다는 가정을 빼먹음
/**
 * @param {number} n
 * @return {boolean}
 */
const winnerSquareGame = function (n) {
  const squares = [];
  let answer = false;

  for (let i = 1; i < 320; i++) {
    squares.push(Math.pow(i, 2));
  }

  while (true) {
    if (n === 0) return answer;
    const temp = squares.filter((v) => v <= n);
    console.log(temp);
    n -= temp[temp.length - 1];
    answer = !answer;
  }
};
console.log(winnerSquareGame(8));

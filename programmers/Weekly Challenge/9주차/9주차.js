/* 정답지 보고 풂. 외우자 */
const solution = (n, wires) => {
  const nodes = Array.from({ length: n + 1 }, () => []);
  wires.map((v) => {
    nodes[v[0]].push(v[1]);
    nodes[v[1]].push(v[0]);
  });

  const countChildren = (index, visited) => {
    if (visited[index]) return;
    count++;
    visited[index] = true;

    nodes[index].map((next) => {
      if (!visited[next]) countChildren(next, visited);
    });
  };

  let count = 0;
  let answer = n + 1;
  for (let i = 1; i < n + 1; i++) {
    nodes[i].map((child) => {
      const visited = new Array(n + 1).fill(false);
      count = 0;
      visited[i] = true;
      countChildren(child, visited);
      answer = Math.min(answer, Math.abs(count - (n - count)));
    });
  }
  return answer;
};

const n = 7;
// const wires = [
//   [1, 3],
//   [2, 3],
//   [3, 4],
//   [4, 5],
//   [4, 6],
//   [4, 7],
//   [7, 8],
//   [7, 9],
// ];
const wires = [
  [1, 2],
  [2, 7],
  [3, 7],
  [3, 4],
  [4, 5],
  [6, 7],
];
const answer = solution(n, wires);
console.log(answer);

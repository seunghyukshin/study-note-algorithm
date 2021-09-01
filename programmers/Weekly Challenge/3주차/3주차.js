const solution = (game_board, table) => {
  const N = game_board.length;
  const queue = [];

  const point = {
    x: 0,
    y: 0,
  };
  const dx = [1, -1, 0, 0];
  const dy = [0, 0, 1, -1];

  const isGo = (y, x, N) => {
    return y >= 0 && x >= 0 && y < N && x < N;
  };

  const bfs = (queue, map, visited, target) => {
    let min_x = queue[0].x;
    let max_x = queue[0].x;
    let min_y = queue[0].y;
    let max_y = queue[0].y;
    while (queue.length != 0) {
      const p = queue.shift();

      min_x = Math.min(min_x, p.x);
      min_y = Math.min(min_y, p.y);
      max_x = Math.max(max_x, p.x);
      max_y = Math.max(max_y, p.y);

      let nx, ny;
      for (let d = 0; d < 4; d++) {
        nx = p.x + dx[d];
        ny = p.y + dy[d];

        if (isGo(ny, nx, N) && !visited[ny][nx] && map[ny][nx] == target) {
          visited[ny][nx] = true;
          queue.push({ x: nx, y: ny });
        }
      }
    }

    return {
      min_x,
      max_x,
      min_y,
      max_y,
    };
  };

  /*  rotate right */
  const rotate = (claim) => {
    const N = claim.length;
    const M = claim[0].length;

    const result = new Array(M);
    for (let i = 0; i < M; i++) {
      result[i] = new Array(N);
    }

    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        result[j][N - 1 - i] = claim[i][j];
      }
    }
    return result;
  };

  const divide = (map, startX, startY, endX, endY) => {
    const N = endY - startY;
    const M = endX - startX;

    const result = new Array(N + 1);
    for (let i = 0; i <= N; i++) {
      result[i] = new Array(M + 1);
    }

    for (let i = 0; i <= N; i++) {
      for (let j = 0; j <= M; j++) {
        result[i][j] = map[i + startY][j + startX];
      }
    }
    // console.log(result);
    return result;
  };

  const sort = (arr) => {
    arr.sort((a, b) => {
      const x = a.value.toString();
      const y = b.value.toString();
      return x < y ? -1 : x > y ? 1 : 0;
    });
  };

  const count = (boards, claims) => {
    let count = 0;
    while (boards.length != 0) {
      const b = boards.shift();
      for (let j = 0; j < claims.length; j++) {
        const c = claims.shift();

        if (JSON.stringify(b) === JSON.stringify(c)) {
          console.log(b);
          count += b.count;
          break;
        } else {
          claims.push(c);
        }
      }
    }
    return count;
  };
  const init = (map, target) => {
    const visited = new Array(N);

    for (let i = 0; i < N; i++) {
      visited[i] = new Array(N);
      visited[i].fill(false);
    }

    const claims = [];
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        if (map[i][j] == target && !visited[i][j]) {
          point.x = j;
          point.y = i;

          queue.push(point);
          visited[i][j] = true;

          const area = bfs(queue, map, visited, target);
          const { min_x, max_x, min_y, max_y } = area;
          let binaries = [];

          const dividedMap = divide(map, min_x, min_y, max_x, max_y);
          // for 문으로 4방향 rotate
          let rotatedMap = dividedMap;
          for (let r = 0; r < 4; r++) {
            rotatedMap = rotate(rotatedMap);

            const binary = {
              value: [],
              count: 0,
            };
            for (let i = 0; i < rotatedMap.length; i++) {
              const row = [];
              let count = 0;
              for (let j = 0; j < rotatedMap[0].length; j++) {
                target == 0
                  ? row.push(rotatedMap[i][j] == 0 ? 1 : 0)
                  : row.push(rotatedMap[i][j]);

                target == 0 && rotatedMap[i][j] == 0 ? count++ : "";
                target == 1 && rotatedMap[i][j] == 1 ? count++ : "";
              }
              // console.log(row);
              binary.value.push(parseInt(row.join(""), 2));
              binary.count += count;
            }
            binaries.push(binary);
            // console.log(binaries);
          }

          /* binaries 4개 중 하나만 남긴다 (lexical 빠른거) */
          sort(binaries);
          claims.push(binaries[0]);
        }
      }
    }

    return claims;
  };

  // table은 1, board는 0을 기준으로 bfs
  const boards = init(game_board, 0);
  const claims = init(table, 1);
  // console.log(boards);
  // console.log(claims);
  let answer = 0;
  answer = count(boards, claims);
  console.log(answer);
  return answer;
};

const game_board = [
  [1, 1, 0, 0, 1, 0],
  [0, 0, 1, 0, 1, 0],
  [0, 1, 1, 0, 0, 1],
  [1, 1, 0, 1, 1, 1],
  [1, 0, 0, 0, 1, 0],
  [0, 1, 1, 1, 0, 0],
];
const table = [
  [1, 0, 0, 1, 1, 0],
  [1, 0, 1, 0, 1, 0],
  [0, 1, 1, 0, 1, 1],
  [0, 0, 1, 0, 0, 0],
  [1, 1, 0, 1, 1, 0],
  [0, 1, 0, 0, 0, 0],
];

const claim = [
  [0, 1],
  [1, 1],
  [0, 1],
];
const answer = solution(game_board, table);

/* 자주하는 실수
함수 parmater 갯수 체크 안해준다.*/

### Overview

- N,M < 100000 , 1 <= K <= 10

- 0이 공백, 1이벽
- 벽만나도 K횟수만큼 뿌실 수 있다.
- start : (0,0) 
  finish : (N-1,M-1)





### Try 

#### 1. 

- BFS

- int형의 2차원 배열 



#### 2. 

- DFS

- 의미없는 백트래킹



#### 3. 

- BFS

- **K값을 이용해서 3차원배열**

```java
static int[][][] countMap;
...
countMap = new int[N][M][K + 1];
```



#### 4.

- BFS
- int를 쓸 필요가 없어서 바꿔줌 (bfs니까)

```java
static boolean[][][] visited;
...
visited = new boolean[N][M][K + 1];
```



- 벽만났을때 ``!visited[ny][nx][p.k]``이거 추가해줬더니 98%

```java
// !visited[ny][nx][p.k] : 벽을 안뿌수고도 간사람이 있다? 그럼 난 안가야지
// !visited[ny][nx][p.k - 1] : 왔던길 안가려고
if (p.k != 0 && !visited[ny][nx][p.k] && !visited[ny][nx][p.k - 1]) {
    visited[ny][nx][p.k - 1] = true;
    queue.offer(new Point(ny, nx, p.k - 1, p.count + 1));
}
```



- finish를 다음꺼말고 현재껄로 검사해야함 (map크기가 1인 경우)

```java
if (p.y == N - 1 && p.x == M - 1) {
    System.out.println(p.count);
    return;
}
```



총 풀이시간 2시간 40분 걸림


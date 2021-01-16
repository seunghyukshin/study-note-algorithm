##### 자주 실수하는 부분

------

dfs 처음 딱 호출할 때, static 값 변경해줘야할 거 있는지, 한번 더 생각하기



`for (int j = 0; j < N; j++) {
	if (map[i][j] == 1 && !visited[j]) {
		visited[j] = true;
		dfs(j, count + 1);
		visited[j] = false;
	}
}`

재귀 내에서는 값 변경 잘해주는데



`visited[i] = true;
dfs(i, 1);
visited[i] = false;`

시작할때 자주 잊는다.
``````sjava
fw(n) = { fw(n-1) + fb(n-1) } * ...(자식 노드들)
fb(n) = fw(n-1) * ...(자식 노드들)
``````

이 식까지 도달하기에 시간이 오래걸렸다.

###### 주어진 테스트케이스를 분석하고 테스트케이스 만들어보는 훈련할 것.



---



시작점을 어디로 잡아도 간선은 바뀌지 않으므로, 갯수의 총합 또한 바뀌지 않는다.



----



간선을 이차원으로 표시할 때, 이차원 배열이 아닌 일차원 배열과 리스트의 조합을 사용하면 힙메모리 터질 가능성이 낮다.

```java
ArrayList<Integer>[] map = new ArrayList[N];
```



---



#### mod 언제 해줘야하나?

```JAVA
for() {  // 1
	white *= (childNode[0] % MOD + childNode[1] % MOD) % MOD;
	black *= childNode[0] % MOD;
}
// FAIL

for() { // 2
    white = (white * (childNode[0] + childNode[1])) % MOD;
    black = (black * childNode[0]) % MOD;		
}
// PASS
```

overflow가 발생할 것 같은 곳에 해주면된다(**보통 곱셈**)

같은 변수를 반복해서 사용하는 2번보다 1번코드를 줄 곧 써와서, 오류 찾기가 쉽지 않았다.

**곱해진 값을 나머지**해야하는데 1번은 되지 않고 있다.
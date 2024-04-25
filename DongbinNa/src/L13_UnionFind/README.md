# 서로소 집합
- 공통 원소가 없는 두 집합
- {1,2}와 {3,4}

- **합집합 (UNION)** : 두 개의 원소가 포함된 집합을 하나의 집합으로 합치는 연산
- **찾기 (FIND)** : 특정한 원소가 속한 집합이 어떤 집합인지 알려주는 연산


1. 합집합 연산을 확인하여, 서로 연결된 두 노드 A,B를 확인
   1. A와 B의 루트노드 A', B'를 각각 찾기
   2. A'를 B'의 부모 노드로 설정
2. 모든 합집합 연산을 처리할때까지 1. 반복

# 서로소 집합 자료구조:연결성

- 루트 노드에 즉시 접근 할 수 없음.
  - 부모 테이블을 계속 확인하며 거슬러 올라가야함

# 서로소 집합 자료구조:기본적인 구현 방법의 문제점
- union()이 편향되게 이루어진 경우 find()가 비효율적
- 최악의 경우 find()가 모든 노드를 다 확인하게되어 시간복잡도가 O(V)
  - 1 <- 2 <- 3 <- 4 <- 5

# 서로소 집합 자료구조:경로 압축
- find() 함수를 최적화하기 위한 방법으로 경로 압축(Path Compression)
  - 재귀 호출 한 뒤 부모 테이블 값을 바로 갱신

```java
void find(int parent, int x){
    if(parent[x] != x) {
        parent[x] = find(parent, parent[x])
    }
    return parent[x];
}
```

- find() 함수 호출 이후 해당 노드의 루트 노드가 바로 부모 노드로.
- ** 모든 UNION()이후 각 원소에 대하여 FIND() 수행하면 다음과 같은 형태로 갱신 **

| 노드번호 | 1 | 2 | 3 | 4 | 5 | 
|---| --- |---|---|---|---|
| 부모   | 1 | 1 | 1 | 1 | 1 |



# 서로소 집합을 활용한 사이클 판별

- 서로소 집합은 **무방향 그래프 내에서의 사이클을 판별할때 ** 사용가능
    - (방향그래프에서의 사이클 여부는 DFS로)
  
### 사이클 판별 알고리즘
0. 모든 노드에 대하여 자기 자신을 부모로 설정하는 형태로 부모테이블 초기화
1. **각 간선**을 하나씩 확인하며 두 노드의 루트 노드를 확인
   1. 루트 노드가 다르다면 두 노드에 대하여 UNION연산 수행
   2. 루트 노드가 같다면 사이클 발생한 것임
2. 그래프에 포함되어 있는 모든 간선에 대하여 1. 반복
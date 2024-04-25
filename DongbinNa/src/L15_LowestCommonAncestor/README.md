# 최소 공통 조상 (Low Common Ancestor)

## 알고리즘
1. 모든 노드에 대한 깊이(depth)를 계산
2. 최소 공통 조상을 찾을 두 노드를 확인
   1. 먼저 두 노드의 깊이(depth)가 동일하도록 거슬러 올라감
   2. 이후에 부모가 같아질 때까지 반복적으로 두 노드의 부모 방향으로 거슬러 올라감
3. 모든 LCA(a,b)에 대하여 2. 반복


# 시간복잡도 분석
- 매 쿼리마다 부모방향으로 거슬로 올라가기 위해 최악의 경우 O(N)
  - 따라서 모든 쿼리를 처리할때의 시간복잡도는 O(NM)

# 알고리즘 개선하기
- 각 노드가 거슬러 올라가는 속도를 빠르게 만드는 방법
  - 15칸을 8칸 -> 4칸 -> 2칸 -> 1칸
- 2의 제곱형태로 거슬로 올라가도록하면 O(logN)의 시간복잡도
- 메모리를 조금더 사용하여 2^i 번째 부모에 대한 정보를 기록
- DP 혹은 Segment Tree
- O(MlogN)


> ※주의※ 이차원리스트배열 만들때, `Arrays.fill(array, new ArrayList<>());` 하면 안된다. 주소값 공유함!!!
> 11438 주기적으로 연습 필요
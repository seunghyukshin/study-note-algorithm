# 신장트리
- 그래프에서 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프를 의미
  - 모든 노드가 포함되어 서로 연결되면서 사이클이 존재하지 않는다는 조건은 트리의 조건이기도 함


# 최소 신장 트리
-  최소한의 비용으로 구성되는 신장트리를 찾아야할때는 어떻게 해야하나?

# 크루스칼 알고리즘
- 대표적인 **최소 신장 트리 알고리즘**
- Greedy

### 동작과정
1. 간선 데이터를 비용에 따라 **오름차순**
2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인
   1. 발생하지 않는 경우 최소 신장 트리에 포함
   2. 발생하는 경우 최소 신장 트리에 포함x
3. 모든 간선에 대하여 2. 반복

# 성능분석
- 간선 개수가 E개일 때, 시간복잡도 : O(ElogE)

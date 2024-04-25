# 최단경로 문제

- 가장 짧은 경로를 찾는 알고리즘

### 다양한 문제 상황
- 한 지점에서 다른 한 지점까지의 최단 경로
- 한 지점에서 다른 모든 지점까지의 최단 경로
- 모든 지점에서 다른 모든 지점까지의 최단 경로
- 각 지점 : 노드 of 그래프
- 지점간 도로 : 간선 of 그래프


# 다익스트라 최단경로
- **특정한 노드**에서 출발하여 **다른 모든 노드**로 가는 최단경로를 계산
- 그리디 알고리즘
  - **매 상황에서 가장 비용이 적은 노드를 선택**해 임의의 과정을 반복

### 동작과정
1. 출발노드 설정
2. 최단 거리 테이블 초기화
3. 방문 안한 노드 중 최단 거리가 짧은 노드 선택
4. 해당 노트를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블 갱신
5. 3~4번 반복

### 간단한 구현 : 성능 분석
- 총 O(V)번에 걸쳐서 최단거리가 가장 짧은 노드를 매번 선형탐색 해야함
- 따라서 전체 시간 복잡도는 O(V^2)
- 일반적으로 전체 노드 개수가 5000개 이하라면 해결가능
  - 노드 개수가 10000이상의 문제라면?

### 개선된 구현 
- 3번을 위해 최소 Heap을 이용
- 성능분석
- ElogE = ElogV^2 = 2ElogV = **O(ElogV)**
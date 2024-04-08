# 선택정렬
- 처리되지 않은 데이터 중에서 **가장 작은 데이터를 선택해 맨앞에 있는 데이터와 바꾸는 것**



### 시간복잡도

- N번만큼 가장 작은 수를 찾아서 맨 앞으로 보내야 함.

- 전체연산횟수 =
N + (N-1) + (N-2) + ... + 2
= (N^2 + N - 2) / 2 = O(N^2)


# 삽입정렬
- 처리되지 않은 데이터를 하나씩 골라 **적절한 위치에 삽입** 

### 시간복잡도
- O(N^2)
- 현재 리스트의 데이터가 거의 정렬되어 있는 상태라면 매우 빠르게 동작
- 최선의 경우 O(N)
- 인덱스 i가 i-1만 확인 후 다음 loop로


# 퀵정렬
- 기준 데이터를 설정하고 그 **기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법**
- 가장 기본적인 퀵 정렬은 **첫 번째 데이터를 기준 데이터 (pivot)으로 설정**

### 분할(Divide)
1.  pivot보다 큰 값을 왼쪽에서부터 찾고, pivot보다 작은 값을 왼쪽에서부터 찾는다. 
2. 두 위치를 바꿔준다.
3. 만약, 두 위치가 엇갈리면 **pivot과 작은 값의 위치를 바꾼다**

pivot을 기준으로 좌/우 분할 완료
좌/우묶음에서 각각 정렬 수행


### 시간복잡도
퀵 정렬이 빠른 이유(직관적으로)
너비 x 높이 = N * logN = O(NlogN)
평균의 경우 : O(NlogN)
최악 : O(N^2)

# 계수 정렬
- 특정한 조건이 부합할 때만 사용할 수 있지만 **매우 빠르게 동작**하는 정렬 알고리즘
  -  **데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을때**

1. COUNT 배열 생성
2. 인덱스를 COUNT만큼 출력 (0 0 1 1 2 2 3 4 5 5 6 7 8 9 9)


### 시간복잡도
데이터의 개수가 N, 데이터(양수) 중 최대값이 K일때 최악의 경우에도 O(N+K) 보장

데이터가 0, 999999 단 2개만 존재하면 최악

동일한 값을 가지는 데이터가 여러개 등장할때 효과적



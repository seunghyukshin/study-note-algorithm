# Segment Tree

용도 : 특정 범위의 데이터 합 구할 때 사용

시간 복잡도 : O(N) -> O(logN)

###### 아이디어 : 구간합 트리 생성

![image](https://user-images.githubusercontent.com/31649100/112465837-81678780-8da8-11eb-9d2d-42083b8691c7.png)



#### 예시

![image](https://user-images.githubusercontent.com/31649100/112465742-685ed680-8da8-11eb-8c9c-0fe7e1c11f9c.png)



#### 구현

배열의 크기 : N

높이(H) : [log2N]

```java
H = (int) Math.ceil(log2(N));
```

```java
public double log2(int x){
    return Math.log(x) / Math.log(2);
}
```



트리 배열의 크기 : 2^(H+1)

```java
int treeSize = 1 << (H + 1);
```



트리생성

```java
init(1, 0, N - 1);
```

```java
public static int init(int node, int start, int end) {
    if (start == end) {
    	// node가 리프노드인 경우
        return tree[node] = input[start];
    } else {
        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid)
            + init(node * 2 + 1, mid + 1, end);
    }
}
```



구간합 구하기

```java
left = 3;
right = 9;
int result = sum(1, 0, N - 1);
```

```java
// [start, end] : node가 담당하는 구간
// [left, right] : 구해야하는 합의 범위
public static int sum(int node, int start, int end) {
    // 1. [left,right]와 [start,end]가 겹치지 않는 경우
    if (left > end || right < start) {
        return 0;
    }

    // 2. [left,right]가 [start,end]를 완전히 포함하는 경우
    if (left <= start && end <= right) {
        return tree[node];
    }
	
    // 3. [start,end]가 [left,right]를 완전히 포함하는 경우
    // 4. [left,right]와 [start,end]가 겹쳐져 있는 경우 (1, 2, 3 제외한 나머지 경우)
    int mid = (start + end) / 2;
    return sum(node * 2, start, mid) + sum(node * 2 + 1, mid + 1, end);
}

```



특정값 수정하기

```java
// 5번째 인덱스 값을 -5만큼 더하기
update(1, 0, N - 1, 5, -5);
```

```java
public static void update(int node, int start, int end, int index, int diff) {
    if (index < start || index > end)
        return;

    tree[node] = tree[node] + diff;
    if (start != end) {
        // 리프노드가 아닌 경우
        int mid =  (start + end) / 2;
        update(node * 2, start, mid, index, diff);
        update(node * 2 + 1, mid + 1, end, index, diff);
    }
}
```




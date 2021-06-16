#### 풀이

- 하나의 max 변수를 이용하여 좌측에서 만드는 배열과 
  또 하나의 max 변수를 이용하여 우측에서 만드는 배열

- 두 배열값 중 최소값을 택해서 모두 더 한다. (= 고여있는 빗물)

```java
int result = 0;

int[] lefts = new int[height.length];
int left = height[0];
for (int i = 1; i < height.length; i++) {
    if (height[i] > left) {
        left = height[i];
    } else {
        lefts[i] = left - height[i];
    }
}
int right = height[height.length - 1];
for (int i = height.length - 2; i >= 0; i--) {
    if (height[i] > right) {
        right = height[i];
    } else {
        result += Math.min(lefts[i], right - height[i]);
    }
}

return result;
```


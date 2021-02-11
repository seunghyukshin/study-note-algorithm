## Try

l 과 r을배열의 양끝 값으로 고정하고 p = l+1로 취한다.

sum([l]+[p]+[r])의 값에 따라 p 값이 l과 r 사이에서 움직인다.

그러나 but, subSum([l]+[r])으로 l과 r을 조정하면 miss되는 값 존재하거나 O(n^3)으로 짜야한다.



## Solution

p를 0으로 고정하고 l = p+1, r = arr[length-1] 로 취한다.

sum([p]+[l]+[r]) 값에 따라 l과 r 을 조정한다.

결과 : O(n^2); 



## Java Script

1. ```list.sort()``` : 오름차순 정렬 아니다.
   -  [-1, -2, -3, -4, 0, 1, 2, 3, 4] 순으로 정렬됨.
   - 오름차순 정렬 ```list.sort((a, b) => a - b);``` 

2. es6에서 나온 Set

   1. 선언

      ```const set = new Set([1, 2]);```

   2. 문법

      ```javascript
      set.add(1); // [1,2];
      
      set.has(1); // true
      ```

   - Object, Array의 값에 대해서는 중복 제거를 제공해주지 않음.

3. 중복 값 제거하기 위해 list에서 filter 사용

   ```javascript
   // 이중반복. list : 이차원배열 
   const result = list.filter((item, i) => {
       return (
           list.findIndex((item2, j) => {
               // list를 string으로 변경해서 비교
               return item.toString() === item2.toString();
           }) === i
       );
   });
   ```

   => 시간초과.


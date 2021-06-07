## 주의

1. Arrays.asList()는 얕은 복사다.
   주소값을 참조하기 때문에 배열값도 변경된다.

   ```java
   for (int sco : scoville) {
   	list.add(sco);
   }
   ```

2. PriorityQueue는 이진트리 구조로 되어있다.
   오름차순, 내림차순 안되어있다고 당황하지 마라.

3. while문의 종료조건이 여러개일 때, 어느 종료 조건이 먼저 올 지 생각
   **여러개의 종료조건을 만족하는** 테스트케이스를 만들어라.

   ```java
   while(true){
       if (pq.peek() >= K) {
           break;
       }
       if (pq.size() == 1) {
           count = -1;
           break;
       }
   }
   ```


###### 풀이

h[i]< h[k] < h[j] 를 만족하는 k들을 찾는다

k를 기준으로 i와 j의 개수를 찾는다

이때 i는 k와 비교하는 것이 아니라 i+1이랑 비교해야됨 !

i 개수 * j 개수를 더해나가면 됨



###### 주의해야할 것

BufferedReader를 썼을때 런타임에러 생겼음. 

BufferedReader 크기 : 16384 byte= 8192 char

Scanner로 해결
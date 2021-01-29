#### nPr 

```java
static void nPr(int count, boolean[] isGo){
    if(count == R){ // ㉠
        return;
    }
    for(int i=0; i<N; i++){ // ㉡
        if(isGo[i]) continue;
        isGo[i] = true;
        nPr(count+1, isGo);
    	isGo[i] = false;
    }
}
```

합계 구할때는 ㉠에서 for문 돌리지말고 **int sum 매개변수 추가하기**



㉡에서 조건을 줘도 될지. ㉠까지 와서 처리할지. 신중하게 생각하기
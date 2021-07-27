# KMP

용도 : 부분 문자열 찾기

O(N*M) → O(N+M)





#### prefix(접두사)

ABCD의 접두사

A
AB
ABC
ABCD

#### subfix(접미사)

ABCD의 접미사

D
CD
BCD
ABCD



#### Pi 배열 만들기

접두사와 접미사가 같은 부분 문자열 중에서 길이가 가장 큰 값

ABAABAB의 pi 배열

| i    | 부분문자열         | pi[i] |
| ---- | ------------------ | ----- |
| 0    | A                  | 0     |
| 1    | AB                 | 0     |
| 2    | <u>A</u>B**A**     | 1     |
| 3    | <u>A</u>BA**A**    | 1     |
| 4    | <u>AB</u>A**AB**   | 2     |
| 5    | <u>ABA</u>**ABA**  | 3     |
| 6    | <u>AB</u>AAB**AB** | 2     |



#### 구현코드

```javascript
const makePi = (s) => {
    const m = s.length;
    const pi = new Array(m);
    pi.fill(0);
    
    let j = 0;
    for(let i = 1; i < m; i++){
        while(j > 0 && s[i] != s[j]) j = pi[j - 1]; // JUMP!
    	if(s[i] == s[j]) pi[i] = ++j;
    }
    return pi;
}
```

접두사와 접미사가 같은 패턴이라는 것을 이용하여 점프를 해준다!



```javascript
// s : "ABABABC" , p : "ABABC"
const kmp = (s, p) => {
    const n = s.length;
    const m = p.length;
    const result = [];
    
    const pi = makePi(p);
    
    let j = 0;
    for(let i = 0; i < n; i++){
        while(j > 0 && s[i] != p[j]) j = pi[j - 1]; // jump
       	if(s[i] == p[j]) {
            if(j != m - 1) {
                j++;
            }else{ // 찾았다! j가 끝까지 도달했으니!
                result.push(i - m + 1);
                j = pi[j]; // jump
            }
        }
    }
    return result;
}
```

s-i
p-j


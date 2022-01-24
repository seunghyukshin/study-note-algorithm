# [a, b, c] => a^2 + b^2 + c^2



##### before

```ja
.map((v) => Math.pow(v, 2))
.reduce((a, b) => a + b);
```

배열 한번 순회하면서 제곱으로 바꿔주고, 다시 순회하면서 더해주고



##### after

```javascript
.reduce((a, b) => a + Math.pow(b, 2), 0);
```


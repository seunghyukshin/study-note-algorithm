## JavaScript



```javascript
const regex = \(?:https?:\/\/)?(?:www\.)?youtu.be\/([a-zA-Z0-9]{11});
const url = 'https://www.youtu.be/-ZClicWm0zM';

url.match(regex);
// 0: "https://www.youtu.be/-ZClicWm0zM"
// 1: "-ZClicWm0zM"
// groups: undefined
// index: 0
// input: "https://www.youtu.be/-ZClicWm0zM"
// length: 2

const result = url.match(regex);
console.log(result[0]);
```




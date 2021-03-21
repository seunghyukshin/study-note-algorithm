## Java



```java
// 조건: 대문자, 소문자, 숫자, 주어진특수문자 이외의 것들어오면 안된다.
// 주어진 특수문자: ~!@#$%^&*
String inp_str = "AaTa+!12-3";
Pattern pattern = Pattern.compile("[^a-zA-Z0-9~!@#$%^&*]");
Matcher matcher = pattern.matcher(inp_str);

matcher.find();
// true 
// +들어있어서
```




## Quiz

1. 전화번호 찾기

010-898-0893
010 898 0893
010.898.0893

######  

###### 오답

````re
\d{2,3}[-.\s]\d{3}[-.\s]\d{4}
````



###### 풀이

````
\d\d\d-\d\d\d-\d\d\d\d
````

````re
\d{2,3}[- .]\d{3}[- .]\d{4}
````



2. 이메일 찾기

dream.coder.ellie@gmail.com

hello@daum.net

hello@daum.co.kr



###### 오답

````
\w@{1}\w.(com|co.kr|net)
````



###### 풀이

````
[a-zA-Z0-9._+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9.]+
````



3. youtube주소에서 아이디값 찾기

https://www.youtu.be/-ZClicWm0zM
https://youtu.be/-ZClicWm0zM
youtu.be/-ZClicWm0zM



###### 오답

````
\/[a-zA-Z-]\b
````



###### 풀이

````
(https?:\/\/)?(www\.)?youtu.be\/([a-zA-Z0-9]{11})
````


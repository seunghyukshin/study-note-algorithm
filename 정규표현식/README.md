# Regulation Expression

[연습사이트](https://regexr.com/5mhou)

[퀴즈사이트](https://regexone.com)

------



#### 그룹, 레인지

##### () 그룹

````
(Hi|Hello)|(And)
````

=> Hi, Hello, And



````
gr(e|a)y
````

=> gray, grey



##### (?:) : 찾지만 기억하지 않음 (그룹넘버 안새김)



##### [] 문자셋 : 괄호안의 어떤문자든

````
gr(e|a|d)y
gr[aed]y
````

grey, gray, grdy



````
gr[abcdef]y
gr[a-f]y
````

````
[a-zA-Z0-9]
````



##### ^ : 뒷 문자들을 제외한 나머지

````
[^a-zA-Z0-9]
````

#### 

------



#### 수량

##### ?  : 있거나 없을 때 (zero or one)

````
gra?y
````

gray, gry



##### * : 있거나 없거나 많을 때 (zero or more)

````
gra*y
````

gray, gry, graay, graaay

#### 

##### +  : 하나 있거나 많을 때 (one or more)

````
gra+y
````

gray, graay, graaay



##### {n} : n번 반복

````
gra{2}y
````

graay



##### {min, max} : 최소, 최대 개수

````
gra{3,5}y
````

graaay, graaaay, graaaay



##### {min, } : 최소 개수

````
gra{3,}y
````

graaay, graaaay, graaaay, graaaaay



------



#### 단어경계

##### \b : 단어 뒤나 앞에서 쓰이는 부분만 

````
\bYa
````

**Ya**, **Ya**YaYa



````
Ya\b
````

**Ya**, YaYa**Ya**



##### \B : \b 반대로 (뒤에나 앞에서 쓰이지 않는 단어들)

````
Ya\B
````

**YaYa**Ya

Ya는 Ya로 시작하면서 Ya로 끝나는 문자이기 때문에 매칭되지 않음



##### ^ : 문장의 시작 단어 

````
^Ya
````

**Ya** ya YaYaYa Ya



##### $ : 문장의 끝 단어 

````
Ya$
````

Ya ya YaYaYa **Ya**  



------



#### 문자

##### .  :  모든 문자열

````
.
````

**graay Ya ya YaYaYa Ya**



##### \\ : 정규표현식에서 사용되는 특수문자를 찾을 때

````
\[\]\{\}
````

.**[]{}**()\^$|?*+



##### \d : 모든 숫자

##### \D : 숫자가 아닌 모든 것



##### \w : 모든 문자

##### \W : 문자가 아닌 모든 것



##### \s : 띄어쓰기 

##### \S : 띄어쓰기를 제외한 모든 것


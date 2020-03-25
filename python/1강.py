Python 3.5.3 (v3.5.3:1880cb95a742, Jan 16 2017, 15:51:26) [MSC v.1900 32 bit (Intel)] on win32
Type "copyright", "credits" or "license()" for more information.
>>> print("python,)
      
SyntaxError: EOL while scanning string literal
>>> print("Python,\"Python\"")
Python,"Python"
>>> print(1,2,3,4,sep=\r)
SyntaxError: unexpected character after line continuation character
>>> print(1,2,3,4,sep="\r")
1234
>>> print('다음 줄에 이어서\r출력')
다음 줄에 이어서출력
>>> print('Python, \'python\'')
Python, 'python'
>>> print(이름,최수지,sep=":")
Traceback (most recent call last):
  File "<pyshell#6>", line 1, in <module>
    print(이름,최수지,sep=":")
NameError: name '이름' is not defined
>>> print('이름','최수지',sep=':')
이름:최수지
>>> print('전화번호','010-1234-5678',sep=':')
전화번호:010-1234-5678
>>> print('주소', '서울시 종로구 종로3가',sep=":")
주소:서울시 종로구 종로3가
>>> 

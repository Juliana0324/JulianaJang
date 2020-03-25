from random import random
x=int(random()*90)+10
y=int(random()*90)+10

print('문제 : {} + {} 를 구하시오'.format(x,y))
z= int(input('{} + {} = '.format(x,y)))

if z == x+y :
   print('정답입니다.')
else :
   print('오답입니다.')

'''
a = 1
add = 0
while a <=5:
   num=(int(input('정수값 : ')))
   add = add + num
   print(num, add)
   if add > 50:
      break
   a = a + 1
'''
from random import random
num = int(input('임의값 : '))
tot = 0
while True:
   rand = int(random()*10) + 1
   tot= tot+ rand
   if num <= tot :
      tot = tot - rand
      print('누적합 : {}/n 반복횟수 : {}'.format(tot, rand))
      break

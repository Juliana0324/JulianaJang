#cnt 는 누적값
from random import random
num = int(input('정수값1 : '))

tot=0
cnt=0
while True:
   rand = int(random()*10)+1
   tot= tot + rand
   cnt = cnt + 1
   if num <= tot :
      tot = tot - rand
      print('누적합 : {}/n반복횟수 : {}'.format(tot, cnt))
      break

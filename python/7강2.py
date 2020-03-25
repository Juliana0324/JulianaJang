from random import random

a = int(random() * 99)+ 1

print('{} : {}'.format(a , not bool(a % 2)))
print('{} : {}'.format(a , a % 2==0))

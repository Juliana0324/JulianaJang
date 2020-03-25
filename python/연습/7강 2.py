from random import random
print(chr(int(random()*26) + 65))

a = int(random()*99)+1
print('{} : {}'.format(a, a % 2 == 0))

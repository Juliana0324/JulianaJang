
from random import randint
'''
for y in range(10):
   for x in range(8):
      st= randint(97,122)
      print(chr(st), end='')
   print()
'''
for y in range(10):
   for x in range(16):
      z= randint(0,2)
      if z==0:
         st=randint(97,122)
         print(chr(st),end=' ')
      elif z==1:
         st=randint(65,90)
         print(chr(st),end=' ')
      elif z==2:
         st=randint(0,9)
         print(st,end=' ')
   print()


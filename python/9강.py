'''
for x in range (1,21,1):
   if x %2==0 :
      print(x,end='')
'''
'''
3.
for x in range (100, 50,-1):
   if x%2==1:
      print(x, end=' ')
혹은
for x in range (99, 50, -2):
      print(x, end=' ')
'''
'''
4.
for x in range (1,51):
   if x % 5 == 0:
      print(x)
   else:
      print(x, end=' ')
'''
'''
5.
total = 0
for x in range (1,101):
   total = total + x

print(total)
'''
st='Python'
cnt = 0
for x in st :
   if x != ' ':
      cnt = cnt + 1
print(cnt)

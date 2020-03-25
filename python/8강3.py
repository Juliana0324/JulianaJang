x=int(input('정수값 1 : '))
y=int(input('정수값 2 : '))

if (x%2==0 and y%2==0) or
   (x%2==1 and y%2==1) :
   print('{}'.format(x+y))
else:
   print('{}'.format(x*y))

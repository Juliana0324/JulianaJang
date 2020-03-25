year = int(input('년도를 쓰시오 : '))

if year % 4  == 0 :
   if year  % 100 == 0:
      if year % 400 ==0:
         print('윤년이다')
      else:
         print('평년이다.')
   else: 
       print('윤년이다.')
else :
   print('평년이다')

year = int(input('생각나는 연도수를 작성하시오 : '))

if year % 4 ==0:
   if year % 100 ==0:
      if year%400==0 :
         print('{}는 윤년입니다'.format(year))
      else :
         print('{}는 평년입니다.'.format(year))
   else :
      print('{}는 윤년입니다'.format(year))
else:
   print('{}는 평년입니다'.format(year))

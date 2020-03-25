name= input('이름 : ')
height = float(input('키 : '))
weight = float(input('체중 : '))

average = (height-100)*0.9
fat=weight / average * 100

if fat<100 :
   print('{}님은 {:,.2f}저체중입니다'.format(name, fat))
elif 100 <= fat < 110 :
   print('{}님은 {:,.2f}정상입니다'.format(name, fat))
elif 110 <= fat <120 :
   print('{}님은 {:,.2f}과체중입니다'.format(name, fat))
elif 120 <=fat < 130:
   print('{}님은 {:,.2f}비만입니다'.format(name, fat))
elif 130 <=fat < 140 :
   print('{}님은 {:,.2f}고도비입니다'.format(name, fat))

num= int(input('정수값 : '))
결과 = ' '
while True:
   나머지 = num % 2 
   num = num // 2
   결과 = str(나머지) + 결과
   if num == 0:
      print(결과)
      break

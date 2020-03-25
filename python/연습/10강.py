print('모든 메뉴를 정한 후 exit을 입력하세요')

menu = (('칼국수',6000), ('비빔밥',5500),
        ('돼지국밥',7000),  ('돈까스', 7000),
        ('김밥', 2000),  ('라면', 2500))

tot = 0
while True:
   a = input('메뉴입력 : ')
   for x,y in menu:
      if x == a:
         tot = tot + y
   if a == 'exit':
      print('총 가격은 {:,}입니다.'.format(tot))
      break

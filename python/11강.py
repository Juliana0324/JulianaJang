menu = (('칼국수',6000), ('비빔밥',5500),
        ('돼지국밥',7000),  ('돈까스', 7000),
        ('김밥', 2000),  ('라면', 2500))
'''
1번 
print(menu[4][1])
print(menu[5][1])

2번
for x,y in menu:
   if y ==7000 :
      print(x , y)
3번
for x, y in menu:
   if y <= 6000:
      print(x, y)

for idx in range(len(menu)):
   if menu[idx][1] <= 6000:
      print(menu[idx][0], menu[idx][1])
      
a = input('메뉴를 입력하세요 : ')
cnt = 0
for x,y in menu:
   if a == x :
      cnt = cnt + 1
      print(x, y)
if cnt == 0 :
   print('해당 메뉴가 존재하지 않습니다.')
   
'''
tot=0
while True:
   a = input('메뉴 입력: ')
   for x,y in menu :
      if x == a:
         tot = tot + y 
   if a == 'exit':
      print('총가격은 {:,}이다. '.format(tot))
      break
   

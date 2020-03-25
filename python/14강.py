from random import random
menu = [
   ['칼국수', 6000], ['비빔밥', 5500],
        ['돼지국밥', 7000], ['돈까스', 7000],
        ['김밥', 2000], ['라면', 2500]]

'''
1번
for x,y in menu:
   if x in ('비빔밥', '돈까스'):
      print('{}는 {}입니다.'.format(x,y))

2번
s = input('메뉴명 : ')
p = int(input('가격 : '))
menu.append([s, p])
print(menu)

3번
s = input('메뉴명 : ')
p = int(input('가격 : '))
flag = 0
for idx in range(len(menu)):
   if menu[idx][0] == s :
      flag = 1
      menu[idx][1] = p
if flag == 0:
   menu.append([s,p])

print(menu)

'''
rand = int(random()*len(menu))

print('메뉴 : { }, 가격 : { }'.format(menu[rand][0], menu[rand][1]))

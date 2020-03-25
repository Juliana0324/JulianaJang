from random import random
menu = {'칼국수':6000, '비빔밥': 5500,
     '돼지국밥':7000, '돈까스' : 7000,
     '김밥': 2000, '라면':2500
     }
'''
1번

print (menu)

2번
for key in menu.keys():
   if menu[key] < 6000:
      print('{} : {}'.format(key, menu[key]))

3번
s= input('메뉴 명 : ')
p = int(input('가격 : '))

menu.update({s:p})

print(menu)
'''
key = list(menu.keys())
rand = int(random()*len(key))

print('{} : {}' .format(key[rand], menu[key[rand]]))

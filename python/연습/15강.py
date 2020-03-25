from random import random
menu = {'칼국수':6000, '비빔밥': 5500,
     '돼지국밥':7000, '돈까스' : 7000,
     '김밥': 2000, '라면':2500
        }

key = list(menu.keys())
rand = int(random() * len(key))

print('{} : {}'.format(key[rand], menu[key[rand]]))

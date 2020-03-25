name= input('이름 : '.format({}))
height=float(input('키 : '.format({})))
weight=float(input('체중 : '.format({})))

std_weight=(height-100)*0.9
fat=weight/std_weight*100
print('{}님의 비만도는 {:,.2f}입니다.'.format(name, fat))

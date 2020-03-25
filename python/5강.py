name = input('이름을 입력하세요.: ')
height = float(input('키를입력하세요.(cm) : '))
weight = float(input('체중을 입력하세요.(kg) : '))

std_weight =(height-100) * 0.9
fat = weight / std_weight *100
print('{}님의 비만도는 {:,.2f}입니다.'.format(name,fat))

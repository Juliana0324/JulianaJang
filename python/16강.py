while True: 
   un = input('아이디를 입력하세요. : ')
   if len(un) < 10 :
      print ('아이디는 반듯이 10자리 이상 입력하시오')
   else:
      break

while True:
   pw = input('패스워드 : ')
   if 8 <= len(pw) <= 16 :
      if un not in pw :
         chk = 0
         for s in ' ~!@#$^&*_?' :
            if s in pw :
               chk = 1
               break
            else:
               print()
         if chk == 0:
            print('패스워드에는 특수문자가 하나이상 포함시키세요 ')
         else:
            break
      else :
         print('아이디가 패스워드애 포함안됨')
   else:
      print('패스워드는 8자리 이상 16자리 이하로 구성')

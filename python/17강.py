def pyMax(*args):
   mx = args[0]
   for x in args[1:]:
      if mx < x :
         mx = x
   return mx
print(pyMax(26,234,2646,4351,7392))

def pyMin():
   pass

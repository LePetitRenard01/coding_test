n = int(input())
result = 0
tmp = n
count = 0
while tmp != 0:
  tmp = tmp//10
  count+=1

# 일 : 1~9 = 9개
# 십 : 10~99 = 90개
# 백 : 100~999 = 900개
if count ==1 :
  result = n
elif count ==2:
  result = 9 + (n-9)*count
else :
  a=[]
  for i in range(count):
    a.append(9*(10**(i-1)))
  for i in range(1,count):
    result += i * a[i]
  #ex) 120 : 100~120? -> 21
  # 3x) 500 : 100~500 -> n - 10**(count-1) +1
  result += (n - 10**(count-1) +1)*count
print(result)
import math
s = input().split('-')
for i, shorts in enumerate(s):
  tmp = list(map(int,shorts.split('+')))
  s[i] = sum(tmp)
sum = s[0]
for i in s[1:]:
  sum -= i
print(sum)
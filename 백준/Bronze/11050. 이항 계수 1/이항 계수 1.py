from itertools import combinations
n, k = map(int,input().split())
sum=1
if k==0:
  print(1)
else:
  for i in range(1,k+1):
    sum*=(n-i+1)
    sum//=i
  print(sum)
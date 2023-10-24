for _ in range(int(input())):
  n, m = map(int,input().split())
  #m개중에 n개 순서x 선택 mCn
  a,b = 1,1
  for i in range(m,m-n,-1):
    a*=i
  for j in range(1,n+1):
    b*=j
  print(a//b)
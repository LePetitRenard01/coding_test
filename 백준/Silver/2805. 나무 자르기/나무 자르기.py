n, m = map(int,input().split())
log = list(map(int,input().split()))

i = 0
j = max(log)
result = 0
while i<=j:
  mid = (i+j)//2
  sum = 0
  for k in log:
    if k > mid:
      sum += k - mid
  if sum < m :
    j = mid -1
  else :
    i = mid + 1
    result = mid
print(result)
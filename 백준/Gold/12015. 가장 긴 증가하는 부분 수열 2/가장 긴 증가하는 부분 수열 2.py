n = int(input())
a = list(map(int,input().split()))

sq = [a[0]]

for i in range(n):
  if a[i] > sq[-1]:
    sq.append(a[i])
  else:
    #이분탐색
    low = 0
    high = len(sq)-1
    mid = 0
    while low<high:
      mid = (low+high)//2
      if sq[mid] < a[i]:
        low = mid + 1
      else:
        high = mid
    sq[high] = a[i]
print(len(sq))
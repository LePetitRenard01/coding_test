n = int(input())
a = list(map(int,input().split()))

def binary_search(target):
  low = 0
  high = len(lis)-1
  while low < high:
    mid = (low+high)//2
    if target <= lis[mid] :
      high = mid
    else :
      low = mid + 1
  lis[high] = target

lis = []
lis.append(a[0])
for i in range(1, n):
  if a[i] > lis[-1] :
    lis.append(a[i])
  else:
    binary_search(a[i])
print(len(lis))
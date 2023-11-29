n = int(input())
a = list(map(int,input().split()))

increasingSeq = [1 for _ in range(len(a))]
decreasingSeq = [1 for _ in range(len(a))]
for i in range(len(a)):
  for j in range(i):
    if a[j] < a[i]:
      increasingSeq[i] = max(increasingSeq[i], increasingSeq[j]+1)

for i in range(len(a)-1, -1, -1):
  for j in range(len(a)-1, i , -1):
    if a[j] < a[i]:
      decreasingSeq[i] = max(decreasingSeq[i], decreasingSeq[j]+1)

res = 0
for i in range(len(a)):
  tmp = increasingSeq[i] + decreasingSeq[i]
  res = res if res > tmp else tmp

print(res-1)
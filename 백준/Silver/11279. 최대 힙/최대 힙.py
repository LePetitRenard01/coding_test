import heapq
from sys import stdin

h = []
for i in range(int(stdin.readline())):
  x = int(stdin.readline())
  if x != 0:
    heapq.heappush(h, -x)
  elif h:
    print(-heapq.heappop(h))
  else:
    print(0)
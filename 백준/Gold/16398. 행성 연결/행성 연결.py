#prim
from sys import stdin
import heapq
def solution():
  n = int(stdin.readline())
  graph = [[] for _ in range(n)]
  for i in range(n):
    tmp = list(map(int,stdin.readline().split()))
    for j in range(n):
      if i == j:
        continue
      graph[i].append((tmp[j],j))
  
  q = [(0,0)]
  inMST = [False] * n
  res = 0
  cnt = 0
  while q:
    dist, current = heapq.heappop(q)
    if inMST[current]:
      continue
    inMST[current] = True
    res += dist
    cnt += 1
    if cnt == n:
      break
    for weight, next in graph[current]:
      if not inMST[next]:
        heapq.heappush(q, (weight, next))
  print(res)

if __name__ == '__main__':
  solution()
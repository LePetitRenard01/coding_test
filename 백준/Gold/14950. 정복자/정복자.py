# t + 2t + ... (n-2)t = t((n-1)(n-2)//2)
#MST prim
from sys import stdin
import heapq
def solution():
  n, m, t = map(int, stdin.readline().split())
  edge = [[] for _ in range(n+1)]
  for _ in range(m):
    tmp = list(map(int, stdin.readline().split()))
    edge[tmp[0]].append((tmp[2],tmp[1]))
    edge[tmp[1]].append((tmp[2],tmp[0]))
  
  inMST = [False] * (n+1)
  h = [(0,1)]
  res = 0
  cnt = -1

  while h:
    weight, current = heapq.heappop(h)
    if inMST[current]:
      continue
    inMST[current] = True
    res += weight
    cnt += 1
    if cnt == n - 1:
      break
    for w, next in edge[current]:
      if not inMST[next]:
        heapq.heappush(h, (w, next))
  
  print(res + t*(n-1)*(n-2)//2)

if __name__ == '__main__':
  solution()
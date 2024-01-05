# MST Prim - node
from sys import stdin
import heapq
def test(n, m):
  graph = [[] for _ in range(m)]
  total = 0
  for _ in range(n):
    tmp = list(map(int, stdin.readline().split()))
    graph[tmp[0]].append((tmp[2], tmp[1]))
    graph[tmp[1]].append((tmp[2],tmp[0]))
    total += tmp[2]
  
  h = [(0,0)]
  inMST = [False] * m
  mst = 0
  cnt = 0
  while h:
    dist, current = heapq.heappop(h)
    if inMST[current]:
      continue
    inMST[current] = True
    mst += dist
    cnt += 1
    if cnt == m:
      break
    for weight, next in graph[current]:
      heapq.heappush(h, (weight, next))
  
  print(total - mst)

if __name__ == '__main__':
  while True:
    m, n = map(int,stdin.readline().split())
    if m == 0 and n== 0:
      break
    test(n, m)
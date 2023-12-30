import heapq
from sys import stdin
def prim():
  mstSet = [False] * (v+1)
  h = [(0, 1)] # weight, node
  total = 0
  cnt = 0

  while h:
    weight, current = heapq.heappop(h)
    if not mstSet[current]:
      for dest, dist in graph[current]:
        heapq.heappush(h,(dist,dest))
      mstSet[current] = True
      total += weight
      cnt += 1
      if cnt == v:
        break
  
  print(total)

if __name__ == '__main__':
  v, e = map(int,stdin.readline().split())
  graph = [[] for _ in range(v+1)]
  for i in stdin.read().splitlines():
    i = list(map(int,i.split()))
    graph[i[0]].append((i[1],i[2]))
    graph[i[1]].append((i[0], i[2]))
  prim()
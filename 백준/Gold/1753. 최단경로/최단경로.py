from sys import stdin
import heapq
def solution():
  v, e = map(int, stdin.readline().split())
  k = int(stdin.readline())
  edge = [[] for _ in range(v+1)]
  for _ in range(e):
    tmp = list(map(int, stdin.readline().split()))
    edge[tmp[0]].append((tmp[1], tmp[2]))

  distance = [float('INF')] * (v+1)
  distance[k] = 0
  q = [(0, k)]

  while q:
    dist, current = heapq.heappop(q)
    if dist > distance[current] :
      continue
    for next, weight in edge[current] :
      if distance[next] <= dist + weight:
        continue
      distance[next] = dist + weight
      heapq.heappush(q, (distance[next], next))
  
  for i, d in enumerate(distance[1:]):
    if d == float('INF'):
      print('INF')
    else:
      print(d)

if __name__ == '__main__':
  solution()
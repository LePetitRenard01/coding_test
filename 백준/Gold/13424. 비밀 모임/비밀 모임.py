import heapq
from sys import stdin
def dijkstra(total, edge, idx):
  n = len(edge) - 1
  distance = [float('INF') for _ in range(n+1)]
  distance[idx] = 0
  h = [(0,idx)]

  while h :
    dist, current = heapq.heappop(h)
    if distance[current] < dist:
      continue
    for weight, next in edge[current]:
      if distance[next] <= dist + weight:
        continue
      distance[next] = dist + weight
      heapq.heappush(h, (distance[next], next))
  
  for i in range(1, n+1):
    total[i] += distance[i]

def solution():
  n, m = map(int, stdin.readline().split())
  edge = [[] for _ in range(n+1)]
  for _ in range(m):
    tmp = list(map(int, stdin.readline().split()))
    edge[tmp[0]].append((tmp[2], tmp[1]))
    edge[tmp[1]].append((tmp[2], tmp[0]))
  
  k = int(stdin.readline())
  friend = list(map(int, stdin.readline().split()))

  total = [0] * (n+1)
  for i in range(k):
    dijkstra(total, edge, friend[i])
  
  res = 0
  minimum = float('INF')
  for i in range(1,n+1):
    if minimum > total[i]:
      minimum = total[i]
      res = i

  print(res)

if __name__ == '__main__':
  for _ in range(int(stdin.readline())):
    solution()
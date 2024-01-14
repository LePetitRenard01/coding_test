import heapq
from sys import stdin
def dijkstra():
  n, m = map(int, stdin.readline().split())
  graph = [[] for _ in range(n+1)]
  for _ in range(m):
    tmp = list(map(int, stdin.readline().split()))
    graph[tmp[0]].append((tmp[1],tmp[2]))
    graph[tmp[1]].append((tmp[0], tmp[2]))
  s, t = map(int, stdin.readline().split())
  h = [s]
  distance = [float('INF')] * (n+1)
  distance[s] = 0

  while h:
    cur = heapq.heappop(h)
    for next, weight in graph[cur]:
      if distance[next] <= distance[cur] + weight :
        continue
      distance[next] = distance[cur] + weight
      heapq.heappush(h, next)
  
  print(distance[t])

if __name__ == '__main__':
  dijkstra()
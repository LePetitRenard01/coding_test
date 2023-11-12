from sys import stdin
import heapq

INF = float('inf')
v, e = map(int,stdin.readline().split())
k = int(stdin.readline())
graph = [[] for _ in range(v+1)]
dist = [INF for _ in range(v+1)]
dist[k] = 0
for i in stdin.read().splitlines():
  i = list(map(int,i.split()))
  graph[i[0]].append((i[2],i[1]))

def dijkstra(graph, start):
  q = []
  heapq.heappush(q,(0, start))
  while q:
    current_d, u = heapq.heappop(q)
    if current_d > dist[u] :
      continue
    for i in graph[u]:
      distance = i[0] + current_d
      if dist[i[1]] > distance:
        dist[i[1]] = distance
        heapq.heappush(q,(distance,i[1]))

dijkstra(graph,k)

for i in dist[1:]:
  print(i if i !=INF else 'INF')
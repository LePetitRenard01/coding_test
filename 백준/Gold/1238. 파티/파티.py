#n개의 마을 x번 마을 파티 m개의 단방향 도로
#한 마을에 대한 모든 마을의 최단거리 = 다익스트라 = 우선순위큐
import heapq
from sys import stdin
def dijkstra(graph, x):
  h = []
  distance = [float('INF') for _ in range(n+1)]
  heapq.heappush(h,(0,x))
  distance[x] = 0

  while h:
    accum, current = heapq.heappop(h)
    if accum > distance[current]:
      continue
    for next, dist in graph[current]:
      if distance[next] < accum + dist:
        continue
      distance[next] = accum + dist
      heapq.heappush(h,(distance[next],next))
  
  return distance

if __name__ == '__main__':
  n, m, x = map(int,stdin.readline().split())
  graph = [[] for _ in range(n+1)]
  for i in stdin.read().splitlines():
    i = list(map(int,i.split()))
    graph[i[0]].append((i[1],i[2]))
  
  distance = dijkstra(graph, x)
  for i in range(1,n+1):
    distance[i] += dijkstra(graph, i)[x]
  
  print(max(distance[1:]))
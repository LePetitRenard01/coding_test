# 중간노드 k를 거치는 최단 경로를 가지는가?
# if s ~ k + k ~ d == s ~ d : True
# else : False
from sys import stdin
import heapq
def dijkstra(edge, start):
  v = len(edge) - 1
  distance = [float('INF')] * (v+1)
  distance[start] = 0
  h = [(0, start)]
  while h :
    dist, current = heapq.heappop(h)
    if distance[current] < dist :
      continue
    for weight, next in edge[current]:
      if distance[next] <= weight + dist:
        continue
      distance[next] = weight + dist
      heapq.heappush(h, (distance[next], next))
  
  return distance

def solution():
  v, e, p = map(int, stdin.readline().split())
  edge = [[] for _ in range(v+1)]
  for _ in range(e):
    tmp = list(map(int, stdin.readline().split()))
    edge[tmp[0]].append((tmp[2], tmp[1]))
    edge[tmp[1]].append((tmp[2], tmp[0]))
  
  distance = dijkstra(edge,1)
  routeP = distance[p]
  routeD = distance[-1]
  distance = dijkstra(edge,p)
  routePD = distance[-1]
  print('SAVE HIM' if routeD == routeP + routePD else 'GOOD BYE')

if __name__ == '__main__':
  solution()
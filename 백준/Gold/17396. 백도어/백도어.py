import heapq
from sys import stdin
def solution():
  n, m = map(int, stdin.readline().split())
  node = list(map(int, stdin.readline().split()))
  graph = [[] for _ in range(n)]
  for _ in range(m):
    tmp = list(map(int, stdin.readline().split()))
    if tmp[0] != n-1 and node[tmp[0]] == 1:
      continue
    if tmp[1] != n-1 and node[tmp[1]] == 1:
      continue
    graph[tmp[0]].append((tmp[2],tmp[1]))
    graph[tmp[1]].append((tmp[2],tmp[0]))
  
  #dijkstra
  h = [(0,0)]
  distance = [float('INF')] * n
  distance[0] = 0
  while h:
    dist, current = heapq.heappop(h)
    if distance[current] < dist :
      continue
    for weight, next in graph[current] :
      if distance[next] <= dist + weight :
        continue
      distance[next] = dist + weight
      heapq.heappush(h,(distance[next], next))
  
  print(distance[-1] if distance[-1] != float('INF') else -1)

if __name__ == '__main__':
  solution()
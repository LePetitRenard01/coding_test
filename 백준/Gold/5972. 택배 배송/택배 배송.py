from sys import stdin
import heapq
def solution():
  n, m = map(int,stdin.readline().split())
  graph = [[] for _ in range(n+1)]
  for _ in range(m):
    tmp = list(map(int, stdin.readline().split()))
    graph[tmp[0]].append((tmp[2], tmp[1]))
    graph[tmp[1]].append((tmp[2], tmp[0]))
  
  distance = [float('INF')] * (n+1)
  distance[1] = 0
  h = [(0,1)]
  while h:
    dist, current = heapq.heappop(h)
    if distance[current] < dist:
      continue
    for weight, next in graph[current]:
      if distance[next] <= dist + weight:
        continue
      distance[next] = dist + weight
      heapq.heappush(h, (distance[next], next))
  
  print(distance[n])

if __name__ == '__main__':
  solution()
import heapq
from sys import stdin
def solution():
  n, m = map(int, stdin.readline().split())
  graph = [[] for _ in range(n+1)]
  for _ in range(m):
    tmp = list(map(int, stdin.readline().split()))
    graph[tmp[0]].append((tmp[1],tmp[2]))
    graph[tmp[1]].append((tmp[0],tmp[2]))
  
  distance = [float('INf')] * (n+1)
  parent = [i for i in range(n+1)]
  h = [(0,1)]
  distance[1] = 0
  while h :
    dist, current = heapq.heappop(h)
    if distance[current] < dist:
      continue
    for next, weight in graph[current]:
      if distance[next] <= dist + weight:
        continue
      distance[next] = dist + weight
      parent[next] = current
      heapq.heappush(h, (distance[next], next))
  
  cnt = 0
  for i in range(n+1):
    if parent[i] != i:
      cnt += 1
  print(cnt)
  for i in range(n+1):
    if parent[i] != i:
      print(i, parent[i])

if __name__ == '__main__':
  solution()
import heapq
from sys import stdin
def dijkstra(edge, idx):
  distance = [float('INF')] * len(edge)
  distance[idx] = 0
  h = [(0, idx)]

  while h:
    dist, current = heapq.heappop(h)
    if distance[current] < dist :
      continue
    for next in edge[current]:
      if distance[next] <= dist + 1:
        continue
      distance[next] = dist + 1
      heapq.heappush(h,(distance[next], next))
  
  return distance
  
def solution():
  n, k = map(int, stdin.readline().split())
  edge = [[] for _ in range(n+1)]
  for _ in range(k):
    tmp = list(map(int, stdin.readline().split()))
    edge[tmp[0]].append(tmp[1]) # 앞 -> 뒤
  
  distance = [[]]
  for i in range(1, n+1):
    distance.append(dijkstra(edge, i))
  
  for _ in range(int(stdin.readline())):
    tmp = list(map(int, stdin.readline().split()))
    if distance[tmp[0]][tmp[1]] != float('INF'):
      print(-1)
    elif distance[tmp[1]][tmp[0]] != float('INF'):
      print(1)
    else:
      print(0)
  
if __name__ == '__main__':
  solution()
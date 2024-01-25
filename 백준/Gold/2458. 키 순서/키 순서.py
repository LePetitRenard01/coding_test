#키순서를 알려면 다른 노드가 이 노드까지 오는 길이 있던지 / 아니면 이 노드에서 다른 노드까지 가는 길이 있던지
# 모든 노드에 대해서 다익스트라하고 어느 두 노드가 서로 거리가 무한대가 아니면(루트가 있으면) 순서가 정해져있는 쌍
# 모든 노드에 대해 거리가 무한대가 아닌 노드 = 순서를 명확히 알 수 있는 노드
from sys import stdin
import heapq
def solution():
  n, m = map(int, stdin.readline().split())
  edge = [[] for _ in range(n+1)]
  for _ in range(m):
    a, b = map(int, stdin.readline().split())
    edge[a].append(b)
  
  res = [0] * (n+1)
  for i in range(1, n+1):
    h = [(0, i)]
    distance = [float('INF')] * (n+1)
    while h:
      dist, current = heapq.heappop(h)
      if distance[current] < dist :
        continue
      for next in edge[current]:
        if distance[next] <= dist + 1:
          continue
        distance[next] = dist + 1
        heapq.heappush(h,(distance[next],next))
    
    for k in range(1,n+1):
      if i == k:
        continue
      if distance[k] != float('INF'):
        res[i] += 1
        res[k] += 1
  cnt = 0
  for i in range(1, n+1):
    if res[i] == n - 1:
      cnt += 1
  print(cnt)

if __name__ == '__main__':
  solution()
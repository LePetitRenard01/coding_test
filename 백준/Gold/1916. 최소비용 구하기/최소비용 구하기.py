from sys import stdin
import heapq
a = int(stdin.readline())
b = int(stdin.readline())
s = stdin.read().splitlines()
graph = [[]for _ in range(a+1)]
for i in s[:-1]:
  edge = list(map(int,i.split()))
  graph[edge[0]].append((edge[2], edge[1])) # w, dst

stt, des = map(int,s[-1].split())
dist = [float('inf')]*(a+1)
dist[stt] = 0
def dijkstra(stt):
  h = []
  heapq.heappush(h,(0,stt))
  while h :
    d, v = heapq.heappop(h)
    if d > dist[v]:
      continue
    for i in graph[v]:
      w, u = i
      new_dist = d + w
      if dist[u] > new_dist :
        dist[u] = new_dist
        heapq.heappush(h,(new_dist, u))
dijkstra(stt)
print(dist[des])
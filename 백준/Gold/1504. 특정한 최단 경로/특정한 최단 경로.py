#dijkstra for 1, i, j, n
#min((1,i)+(i,j)+(j,n) , (1,j)+(j,i)+(i,n))
from sys import stdin
import heapq
if __name__ == '__main__':
  n, e = map(int,stdin.readline().split())
  graph = [[] for _ in range(n+1)]
  for _ in range(e):
    tmp = list(map(int,stdin.readline().split()))
    graph[tmp[0]].append((tmp[2],tmp[1]))
    graph[tmp[1]].append((tmp[2],tmp[0]))
  v1, v2 = map(int,stdin.readline().split())

  def dijkstra(start,dest):
    q = []
    distance = [float('INF')]*(n+1)
    distance[start] = 0
    heapq.heappush(q,(0,start))
    while q:
      dist, loc = heapq.heappop(q)
      if distance[loc] < dist :
        continue
      for i in graph[loc] :
        if distance[i[1]] > dist + i[0]:
          distance[i[1]] = dist + i[0]
          heapq.heappush(q,(distance[i[1]],i[1]))

    return distance[dest]
  
  res = min(dijkstra(1,v1)+dijkstra(v1,v2)+dijkstra(v2,n),
            dijkstra(1,v2)+dijkstra(v2,v1)+dijkstra(v1,n))
  print(res if res != float('INF') else -1)
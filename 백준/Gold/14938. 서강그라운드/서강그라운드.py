import heapq
def dijkstra(item, graph, start, m):
  h = []
  distance = [float('INF') for _ in range(len(graph))]
  heapq.heappush(h,(0,start))
  distance[start] = 0

  while h:
    dist, current = heapq.heappop(h)
    if distance[current] < dist:
      continue
    for weight, next in graph[current]:
      if distance[next] > dist + weight:
        distance[next] = dist + weight
        heapq.heappush(h, (distance[next], next))

  res = 0
  for i,dist in enumerate(distance):
    if dist <= m:
      res += item[i]
  return res

def solution():
  n, m, r = map(int, input().split())
  item = list(map(int, input().split()))
  graph = [[] for _ in range(n)]
  for _ in range(r):
    a, b, l = map(int, input().split())
    graph[a-1].append((l, b-1))
    graph[b-1].append((l, a-1))
  
  res = 0
  for i in range(n):
    res = max(res, dijkstra(item, graph, i, m))
  print(res)

if __name__ == '__main__':
  solution()
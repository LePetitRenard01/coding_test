# 최단경로 : 가장 먼저 들를 노드 구하기
# dijkstra 구현 : 부모 배열 구하기
from sys import stdin
import heapq
def dijkstra(edge, idx):
  n = len(edge) - 1
  h = [(0,idx)]
  distance = [float('INF')] * (n+1)
  distance[idx] = 0
  parent = [i for i in range(n+1)]

  while h:
    dist, current = heapq.heappop(h)
    if distance[current] < dist:
      continue
    for weight, next in edge[current]:
      if distance[next] <= dist + weight :
        continue
      distance[next] = dist + weight
      parent[next] = current
      heapq.heappush(h, (distance[next], next))
  
  res = [0] * (n+1)
  for i in range(1, n+1):
    if parent[i] == i :
      continue
    elif parent[i] == idx :
      res[i] = i
    else:
      parent[i] = find(parent, i, idx)
      res[i] = parent[i]
  return res

#parent 거슬러 올라가기
def find(parent, num, root):
  if parent[num] == root:
    return num
  if parent[parent[num]] != root:
    parent[num] = find(parent, parent[num], root)
  return parent[num]

def solution():
  n, m = map(int, stdin.readline().split())
  edge = [[] for _ in range(n+1)]
  for _ in range(m):
    tmp = list(map(int, stdin.readline().split()))
    edge[tmp[0]].append((tmp[2], tmp[1]))
    edge[tmp[1]].append((tmp[2], tmp[0]))

  res = []
  for i in range(1,n+1):
    res.append(dijkstra(edge, i))
  
  for i in res:
    for j in i[1:]:
      print('-' if i[j] == 0 else i[j], end = ' ')
    print()

if __name__ == '__main__':
  solution()
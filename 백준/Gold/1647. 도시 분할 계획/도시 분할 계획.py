#MST kruskal - edge 중심
from sys import stdin
if __name__ == '__main__':
  n, m = map(int,stdin.readline().split())
  graph = []
  for _ in range(m):
    tmp = list(map(int,stdin.readline().split()))
    graph.append(tmp)
  graph.sort(key = lambda x : x[2])
  parent = [i for i in range(n+1)]
  def find(n):
    if n != parent[n]:
      parent[n] = find(parent[n])
    return parent[n]
  
  maxWeight = 0
  res = 0
  cnt = 0
  for i in graph:
    p1 = find(i[0])
    p2 = find(i[1])
    if p1 == p2 :
      continue
    if p1 > p2 :
      parent[p1] = p2
    else:
      parent[p2] = p1
    maxWeight = i[2]
    res += i[2]
    cnt += 1
    if cnt == n-1:
      break
  
  print(res - maxWeight)
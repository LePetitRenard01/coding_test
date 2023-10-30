from sys import stdin
from collections import deque
def dfs(graph, v, visited):
  visited[v] = 1
  print(v, end=' ')
  for i in graph[v]:
    if not visited[i]:
      visited[i] = True
      dfs(graph, i, visited)
  return

def bfs(graph, v, visited):
  queue = deque()
  print(v, end=' ')
  visited[v] = True
  queue.append(v)
  while queue:
    v = queue.popleft()
    for i in graph[v]:
      if not visited[i]:
        print(i, end=' ')
        visited[i] = True
        queue.append(i)


n, m, v = map(int, stdin.readline().split())
vertex = [[int(j) for j in i.split()] for i in stdin.read().splitlines()]
graph = [[] for _ in range(n+1)]
count=0

for i in vertex:
  graph[i[0]].append(i[1])
  graph[i[1]].append(i[0])

for i in graph:
  i.sort()

visited = [False]*(n+1)
dfs(graph,v,visited)
print()
visited = [False]*(n+1)
bfs(graph,v,visited)
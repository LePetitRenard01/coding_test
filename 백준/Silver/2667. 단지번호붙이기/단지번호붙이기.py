from collections import deque
def bfs(graph, i,j):
  dx = (-1, +1, 0, 0)
  dy = (0, 0, -1, +1)
  queue = deque()
  queue.append((i,j))
  graph[i][j] = 0
  count = 1
  while queue:
    x,y = map(int,queue.popleft())
    for k in range(4):
      nx = x + dx[k]
      ny = y + dy[k]
      if not(nx<n and ny<n and nx>-1 and ny>-1):
        continue
      if graph[nx][ny]==1:
        queue.append((nx, ny))
        graph[nx][ny] = 0
        count+=1
  return count

n = int(input())
graph = [[] for _ in range(n)] 
for i in range(n):
  for j in input():
    graph[i].append(int(j))

count = []
for i in range(n):
  for j in range(n):
    if graph[i][j]==1:
      count.append(bfs(graph,i,j))

count.sort()
print(len(count))
print("\n".join(str(i) for i in count))
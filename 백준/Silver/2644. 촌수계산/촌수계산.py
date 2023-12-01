from collections import deque
def bfs(a, b, n, graph):
  visited = [-1]*(n+1)
  q = deque()
  q.append(a)
  visited[a] = 0

  while q:
    now = q.popleft()
    for i in graph[now]:
      if visited[i] == -1 :
        q.append(i)
        visited[i] = visited[now] + 1
  
  return visited[b]


if __name__ == '__main__':
  n = int(input())
  a, b = map(int,input().split())
  graph = [[]for _ in range(n+1)]
  for _ in range(int(input())):
    x, y = map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)
  print(bfs(a, b, n, graph))
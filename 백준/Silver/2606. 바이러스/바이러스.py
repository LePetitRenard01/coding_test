def dfs(graph, visited, v):
  count = 0
  visited[v] = True
  for i in graph[v]:
    if not visited[i]:
      count += dfs(graph,visited,i) + 1
  return count

n = int(input())
m = int(input())
graph =[[] for _ in range(n+1)]
visited = [False]*(n+1)
for i in range(m):
  i, j = map(int,input().split())
  graph[i].append(j)
  graph[j].append(i)

print(dfs(graph,visited, 1))
n,m = map(int,input().split())
graph = [[]for _ in range(n)]
visited = [False]*n
for _ in range(m):
  ins = list(map(int,input().split()))
  graph[ins[0]].append(ins[1])
  graph[ins[1]].append(ins[0])

def dfs(graph,visited,start,depth):
  visited[start] = True
  bool = False
  if depth >=4:
    return True
  for i in graph[start]:
    if not visited[i]:
      depth+=1
      bool = bool or dfs(graph,visited,i, depth)
      depth+=-1
  visited[start] = False
  return bool

bool = False
for i in range(n):
  bool = bool or dfs(graph,visited, i, 0)
  visited = [False]*n
  if bool : break
if bool : print(1)
else : print(0)
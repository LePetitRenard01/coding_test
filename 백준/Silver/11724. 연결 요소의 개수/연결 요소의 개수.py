from sys import stdin
import sys
sys.setrecursionlimit(10**9)
n,m = map(int,stdin.readline().split())
graph = [[] for _ in range(n+1)] #간선
visited = [False] * (n+1) #방문
for i in stdin.read().splitlines():
  i = list(map(int,i.split()))
  graph[i[0]].append(i[1])
  graph[i[1]].append(i[0])

def dfs(graph,visited,start):
  visited[start] = True
  for i in graph[start]:
    if not visited[i]:
      dfs(graph,visited,i)
  return bool

count = 0
for i in range(1,n+1):
  if not visited[i]:
    bool = dfs(graph,visited,i)
    count+=1
print(count)
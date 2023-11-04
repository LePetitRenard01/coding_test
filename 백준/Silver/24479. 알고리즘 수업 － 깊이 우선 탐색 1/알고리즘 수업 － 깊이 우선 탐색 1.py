from sys import stdin
import sys

sys.setrecursionlimit(10**6)

n, m, r = map(int,stdin.readline().split())
visited = [0]*(n+1)
graph = [[] for _ in range(n+1)]
for i in stdin.read().splitlines():
  tmp = list(map(int,i.split()))
  graph[tmp[0]].append(tmp[1])
  graph[tmp[1]].append(tmp[0])

for i in range(1,n+1):
  graph[i].sort()

def dfs(graph, visited, start, stack):
  visited[start] = 1
  stack.append(start)
  for i in graph[start]:
    if visited[i] == 0:
      dfs(graph,visited,i,stack)

stack=[]
dfs(graph,visited,r,stack)

count = 1
for i in stack:
  visited[i] = count
  count+=1

for i in range(1,n+1):
  print(visited[i])
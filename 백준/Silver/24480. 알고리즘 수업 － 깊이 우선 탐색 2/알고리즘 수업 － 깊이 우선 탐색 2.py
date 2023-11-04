from sys import stdin
import sys

sys.setrecursionlimit(10**6)

n, m, r = map(int,stdin.readline().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
for i in stdin.read().splitlines():
  i = list(map(int,i.split()))
  graph[i[0]].append(i[1])
  graph[i[1]].append(i[0])

for i in graph:
  i.sort(key=lambda x : -x)

def dfs(graph, visited, start, stack):
  visited[start] = 1
  stack.append(start)
  for i in graph[start]:
    if visited[i] == 0:
      dfs(graph, visited, i, stack)

stack = []
dfs(graph, visited, r, stack)
count = 1
for i in stack:
  visited[i] = count
  count+=1
for i in visited[1:]:
  print(i)
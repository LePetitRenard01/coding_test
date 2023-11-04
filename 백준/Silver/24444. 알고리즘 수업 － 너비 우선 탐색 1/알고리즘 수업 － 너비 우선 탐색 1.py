from sys import stdin
from collections import deque

n, m, r = map(int,stdin.readline().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
for i in stdin.read().splitlines():
  i = list(map(int,i.split()))
  graph[i[0]].append(i[1])
  graph[i[1]].append(i[0])

for i in graph:
  i.sort()

queue = deque()
queue.append(r)
visited[r] = 1
count = 1
while queue:
  now = queue.popleft()
  for i in graph[now]:
    if visited[i] == 0:
      queue.append(i)
      count+=1
      visited[i] = count


for i in visited[1:]:
  print(i)
from collections import deque
from sys import stdin
if __name__ == '__main__':
  n, m = map(int,stdin.readline().split())
  graph = [[] for _ in range(n+1)]
  inDegree = [0] * (n+1)
  q = deque()
  semester = [0] * (n+1)
  
  for _ in range(m):
    tmp = list(map(int,stdin.readline().split()))
    graph[tmp[0]].append(tmp[1])
    inDegree[tmp[1]] += 1

  for i, degree in enumerate(inDegree):
    if degree == 0:
      q.append(i)
      semester[i] = 1
  
  while q:
    current = q.popleft()
    for i in graph[current]:
      inDegree[i] -= 1
      semester[i] = max(semester[i],semester[current]+1)
      if inDegree[i] == 0:
        q.append(i)
  
  print(*semester[1:])
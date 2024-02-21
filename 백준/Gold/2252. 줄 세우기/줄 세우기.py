#topological
# queue
from sys import stdin
from collections import deque
def solution():
  n, m = map(int, stdin.readline().split())
  inDegree = [0] * (n+1)
  edge = [[] for _ in range(n+1)]
  for _ in range(m):
    a, b = map(int, stdin.readline().split())
    inDegree[b] += 1
    edge[a].append(b)
  
  q = deque()
  for i in range(1, n+1):
    if inDegree[i] == 0:
      q.append(i)
  
  res = []
  while q:
    current = q.pop()
    res.append(current)
    for next in edge[current]:
      inDegree[next] -= 1
      if inDegree[next] == 0:
        q.append(next)
  
  if len(res) != n :
    print(-1)
  else:
    print(*res)

if __name__ == '__main__':
  solution()
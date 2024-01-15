from sys import stdin
from collections import deque
def solution():
  n = int(stdin.readline())
  graph = [[] for _ in range(n+1)]
  inDegree = [0] * (n+1)
  time = [0] * (n+1)
  for i in range(1, n+1):
    tmp = list(map(int, stdin.readline().split()))
    time[i] = tmp[0]
    for j in range(1, len(tmp) - 1):
      graph[tmp[j]].append(i)
      inDegree[i] += 1
  
  q = deque()
  for i, d in enumerate(inDegree):
    if d == 0:
      q.append(i)
  q.popleft()

  res = [0] * (n+1)

  while q:
    cur = q.popleft()
    res[cur] += time[cur]
    for next in graph[cur]:
      inDegree[next] -= 1
      res[next] = max(res[next], res[cur])
      if inDegree[next] == 0:
        q.append(next)
  
  for i in range(1, n+1):
    print(res[i])

if __name__ == '__main__':
  solution()
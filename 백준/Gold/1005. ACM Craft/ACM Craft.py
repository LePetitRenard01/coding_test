from sys import stdin
from collections import deque
def test():
  n, k = map(int,stdin.readline().split())
  time = [0]
  time.extend(list(map(int,stdin.readline().split())))
  maxTime = [0] * (n+1)
  graph = [[]for _ in range(n+1)]
  inDegree = [0] * (n+1)
  q = deque()

  for _ in range(k):
    tmp = list(map(int,stdin.readline().split()))
    graph[tmp[0]].append(tmp[1])
    inDegree[tmp[1]] += 1
  
  w = int(stdin.readline())

  for i, degree in enumerate(inDegree):
    if degree == 0:
      q.append(i)
      maxTime[i] = time[i]

  while q:
    current = q.popleft()
    if current == w: 
      break
    for i in graph[current]:
      inDegree[i] -= 1
      maxTime[i] = max(maxTime[i],maxTime[current]+time[i])
      if inDegree[i] == 0:
        q.append(i)
  print(maxTime[w])

if __name__ == '__main__':
  for _ in range(int(stdin.readline())):
    test()
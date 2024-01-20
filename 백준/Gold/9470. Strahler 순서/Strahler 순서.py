# Deque
# inDegree 차감할 때마다 maximum of previous order 저장해줘야함(카운트도)
from collections import deque
from sys import stdin
def solution():
  k, m, p = map(int, stdin.readline().split())
  inDegree = [0] * (m+1)
  graph = [[]for _ in range(m+1)]
  for _ in range(p):
    tmp = list(map(int, stdin.readline().split()))
    graph[tmp[0]].append(tmp[1])
    inDegree[tmp[1]] += 1
  
  q = deque()
  order = [[-1, -1] for _ in range(m+1)] #maximum, count
  for i in range(1, m+1):
    if inDegree[i] == 0:
      q.append(i)
      order[i][0] = 1
      order[i][1] = 1
  
  res = 0
  while q :
    current = q.popleft()
    o = order[current][0] if order[current][1] < 2 else order[current][0] + 1 #이전 순서 기반 현재 순서
    for next in graph[current]:
      inDegree[next] -= 1
      if order[next][0] < o :
        order[next][0] = o
        order[next][1] = 1
      elif order[next][0] == o :
        order[next][1] += 1

      if inDegree[next] == 0:
        q.append(next)
        tmp = order[next][0] if order[next][1] < 2 else order[next][0] + 1
        res = max(res, tmp)
  
  print(k, res)
if __name__ == '__main__':
  for _ in range(int(stdin.readline())):
    solution()
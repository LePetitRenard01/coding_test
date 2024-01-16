import sys
from sys import stdin
sys.setrecursionlimit(10**6)
def solution():
  n, m = map(int, stdin.readline().split())
  graph = [[] for _ in range(n+1)]
  for _ in range(m):
    tmp = list(map(int, stdin.readline().split()))
    graph[tmp[0]].append(tmp[1])
    graph[tmp[1]].append(tmp[0])
  
  visited = [False] * (n+1)
  color = [False] * (n+1)

  def dfs(flag, num):
    if visited[num] :
      if color[num] == flag:
        return True
      else:
        return False
    color[num] = flag
    visited[num] = True
    res = True
    for i in graph[num]:
      res = dfs(not flag, i)
      if not res:
        break    
    return res

  res = True
  for i in range(1, n+1):
    if not visited[i]:
      res = dfs(True, i)
      if not res:
        break
  print('possible' if res else 'impossible')

if __name__ == '__main__':
  for _ in range(int(stdin.readline())):
    solution()
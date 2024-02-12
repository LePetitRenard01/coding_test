from sys import stdin
from collections import deque
def d(x,y,z):
  yield (x+1, y, z)
  yield (x-1, y, z)
  yield (x, y+1, z)
  yield (x, y-1, z)
  yield (x, y, z+1)
  yield (x, y, z-1)

def bfs(container, tomato):
  h = len(container)
  n = len(container[0])
  m = len(container[0][0])

  q = deque()
  visited = [[[-1 for _ in range(m)] for _ in range(n)] for _ in range(h)]
  for i,j,k in tomato:
    visited[i][j][k] = 0
    q.append((i,j,k))
  
  while q:
    x, y, z = q.popleft()
    for nx, ny, nz in d(x, y, z):
      if not (0<=nx<h and 0<=ny<n and 0<=nz<m):
        continue
      if visited[nx][ny][nz] != -1 :
        continue
      if container[nx][ny][nz] == 0:
        visited[nx][ny][nz] = visited[x][y][z] + 1
        q.append((nx, ny, nz))
  
  res = 0
  for i in range(h):
    for j in range(n):
      for k in range(m):
        if container[i][j][k] == 0 and visited[i][j][k] == -1:
          return -1
      res = max(res, max(visited[i][j]))

  return res

def solution():
  m, n, h = map(int, stdin.readline().split())
  container = [[] for _ in range(h)]
  for i in range(h):
    for _ in range(n):
      container[i].append(list(map(int, stdin.readline().split())))
  
  tomato = []
  isAllRipe = True
  for i in range(h):
    for j in range(n):
      for k in range(m):
        if container[i][j][k] == 1 :
          tomato.append((i,j,k))
        if container[i][j][k] == 0 :
          isAllRipe = False
  
  if isAllRipe :
    print(0)
    return
  
  print(bfs(container, tomato))

if __name__ == '__main__':
  solution()
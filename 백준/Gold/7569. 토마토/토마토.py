from sys import stdin
from collections import deque
m, n, h = map(int,stdin.readline().split())
box = [[[] for _ in range(n)]for _ in range(h)]
dist = [[[0 for _ in range(m)]for _ in range(n)]for _ in range(h)]
isAllRipe = True
start=[]
tomato = h*n*m
for i in range(h):
  for j in range(n):
    l = list(map(int,stdin.readline().split()))
    for k in range(m):
      box[i][j].append(l[k])
      if l[k] == 1:
        start.append((i,j,k))
      elif l[k] == 0 :
        isAllRipe = False
      else:
        tomato-=1

def bfs(box,start):
  dx = [1, -1, 0, 0, 0, 0]
  dy = [0, 0, 1, -1, 0, 0]
  dz = [0, 0, 0, 0, 1, -1]
  q = deque()
  for i in start:
    q.append(i)
  count = len(start)
  while q:
    x,y,z = q.popleft()
    for i in range(6):
      nx = x + dx[i]
      ny = y + dy[i]
      nz = z + dz[i]
      if 0<=nx<h and 0<=ny<n and 0<=nz<m and box[nx][ny][nz] == 0:
        q.append((nx,ny,nz))
        dist[nx][ny][nz] = dist[x][y][z] + 1
        box[nx][ny][nz] = 1
        count+=1
  return count

if isAllRipe:
  result = 0
else:
  if bfs(box, start) == tomato :
    maximum = 0
    for i in range(h):
      for j in range(n):
        for k in range(m):
          if dist[i][j][k] > maximum:
            maximum = dist[i][j][k]
    result = maximum
  else :
    result = -1
print(result)
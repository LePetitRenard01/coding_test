from sys import stdin
from collections import deque
def d(x,y):
  yield (x+1, y)
  yield (x-1, y)
  yield (x, y+1)
  yield (x, y-1)
#녹는 양 계산
def melt():
  melted = [[0 for _ in range(m)]for _ in range(n)]
  for i in range(n):
    for j in range(m):
      if glacier[i][j]:
        for nx,ny in d(i,j):
          if not (0<=nx<n and 0<=ny<m):
            continue
          if not glacier[nx][ny]:
            melted[i][j] += 1
  
  for i in range(n):
    for j in range(m):
      if not glacier[i][j]:
        continue
      glacier[i][j] -= melted[i][j]
      if glacier[i][j] < 0:
        glacier[i][j] = 0

#빙하 개수 세기
def bfs(visited, x,y):
  q = deque()
  q.append((x,y))
  visited[x][y] = True

  while q:
    x,y = q.popleft()
    for nx,ny in d(x,y):
      if not (0<=nx<n and 0<=ny<m):
        continue
      if visited[nx][ny] or not glacier[nx][ny]:
        continue
      visited[nx][ny] = True
      q.append((nx,ny))

def count():
  visited = [[False for _ in range(m)] for _ in range(n)]
  cnt = 0
  for i in range(n):
    for j in range(m):
      if not visited[i][j] and glacier[i][j]:
        cnt+=1
        bfs(visited,i,j)
  return cnt

if __name__ == '__main__':
  n, m = map(int,stdin.readline().split())
  glacier = []
  for _ in range(n):
    glacier.append(list(map(int,stdin.readline().split())))
  
  year = 0
  while True:
    melt()
    cnt = count()
    year += 1
    if cnt > 1:
      break
    if cnt == 0:
      year = 0
      break
  print(year)
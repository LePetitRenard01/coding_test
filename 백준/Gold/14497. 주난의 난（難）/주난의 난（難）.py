from sys import stdin
from collections import deque
def solution():
  n, m = map(int, stdin.readline().split())
  x1, y1,  x2, y2 = map(int, stdin.readline().split())
  x1 -= 1
  y1 -= 1
  x2 -= 1
  y2 -= 1
  field = []
  for _ in range(n):
    field.append(list(map(str, stdin.readline().rstrip())))
  
  def d(x, y):
    yield (x+1, y)
    yield (x-1, y)
    yield (x, y+1)
    yield (x, y-1)

  def bfs():
    q = deque()
    visited = [[False for _ in range(m)] for _ in range(n)]
    visited[x1][y1] = True
    q.append((x1, y1))

    while q:
      x, y = q.popleft()
      for nx, ny in d(x,y):
        if not (0<=nx<n and 0<=ny<m):
          continue
        if visited[nx][ny] :
          continue

        visited[nx][ny] = True
        if field[nx][ny] == '1':
          field[nx][ny] = '0'
          continue
        q.append((nx,ny))

    if visited[x2][y2] :
      return True
    else :
      return False
  
  cnt = 1
  while True:
    if bfs():
      break
    cnt += 1
  print(cnt)

if __name__ == '__main__':
  solution()
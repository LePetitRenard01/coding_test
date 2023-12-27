from collections import deque

def d(x,y):
  yield (x+1,y)
  yield (x-1,y)
  yield (x,y+1)
  yield (x,y-1)
def bfs(x,y):
  visited = [[-1 for _ in range(m)] for _ in range(n)]
  visited[x][y] = 0
  q = deque()
  q.append((x,y))
  max_dist = 0

  while q:
    x, y = q.popleft()

    for nx, ny in d(x,y):
      if not (0<=nx<n and 0<=ny<m):
        continue
      if visited[nx][ny] > -1 or field[nx][ny] =='W':
        continue
      visited[nx][ny] = visited[x][y] + 1
      q.append((nx,ny))
      if max_dist < visited[nx][ny]:
        max_dist = visited[nx][ny]  
  return max_dist

if __name__ == '__main__':
  n, m = map(int,input().split())
  field = []
  for _ in range(n):
    field.append(list(map(str,input())))
  res = 0
  for i in range(n):
    for j in range(m):
      if field[i][j] == 'L':
        res = max(res, bfs(i,j))
  
  print(res)
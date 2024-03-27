from sys import stdin
from collections import deque
def solution():
  h, w = map(int, stdin.readline().split())
  field = []
  for _ in range(h):
    field.append(list(map(str, stdin.readline().rstrip())))
  visited = [[False for _ in range(w)] for _ in range(h)]
  answer = 0

  for i in range(h):
    for j in range(w):
      if not visited[i][j] and field[i][j] == '#':
        bfs(field, visited, i, j)
        answer += 1 
  print(answer)

def d(x,y):
  yield (x+1, y)
  yield (x-1, y)
  yield (x, y+1)
  yield (x, y-1)

def bfs(field, visited, x, y):
  h = len(field)
  w = len(field[0])
  q = deque()
  q.append((x,y))
  visited[x][y] = True
  while q:
    x, y = q.popleft()
    for nx, ny in d(x,y):
      if not (0<=nx<h and 0<=ny<w):
        continue
      if not visited[nx][ny] and field[nx][ny] == '#':
        visited[nx][ny] = True
        q.append((nx,ny))

if __name__ == '__main__':
  for _ in range(int(stdin.readline())):
    solution()
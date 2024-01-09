from itertools import combinations
from collections import deque
def d(x,y):
  yield (x+1, y)
  yield (x-1, y)
  yield (x, y+1)
  yield (x, y-1)

def bfs(field, virus):
  q = deque()
  distance = [[float('INF') for _ in range(len(field))] for _ in range(len(field))]
  for i,j in virus:
    distance[i][j] = 0
    q.append((i,j))
  
  while q:
    x, y = q.popleft()
    for nx, ny in d(x,y):
      if not (0<=nx<len(field) and 0<=ny<len(field)):
        continue
      if field[nx][ny] == 1: #wall
        continue
      if distance[nx][ny] <= distance[x][y] + 1:
        continue
      distance[nx][ny] = distance[x][y] + 1
      q.append((nx,ny))
  
  res = 0
  for i in range(len(field)):
    for j in range(len(field)):
      if field[i][j] == 1: #wall
        continue
      if field[i][j] == 2: # virus
        continue
      else: # aisle
        if distance[i][j] == float('INF'):
          return float('INF') # not reached
      res = max(res, distance[i][j])
  
  return res


def solution():
  n, m = map(int, input().split())
  field = []
  for _ in range(n):
    field.append(list(map(int, input().split())))
  candidate = []
  for i in range(n):
    for j in range(n):
      if field[i][j] == 2:
        candidate.append((i,j))
  
  res = float('INF')
  for virus in combinations(candidate, m):
    res = min(res,bfs(field, virus))
  print(res if res != float('INF') else -1)

if __name__ == '__main__':
  solution()
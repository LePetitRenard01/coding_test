from sys import stdin
import heapq
def d(x,y):
  yield (x+1, y)
  yield (x-1, y)
  yield (x, y+1)
  yield (x, y-1)
def solution():
  m, n = map(int, stdin.readline().split())
  field = []
  for _ in range(n):
    field.append(list(map(int, input())))
  
  h = [(0,0,0)]
  wall = [[float('INF') for _ in range(m)]for _ in range(n)]
  wall[0][0] = 0
  while h :
    currentWall, x, y = heapq.heappop(h)
    if currentWall > wall[x][y]:
      continue
    for nx, ny in d(x,y):
      if not (0<=nx<n and 0<=ny<m):
        continue
      newWall = currentWall
      if field[nx][ny] == 1:
        newWall += 1
      if wall[nx][ny] <= newWall:
        continue
      wall[nx][ny] = newWall
      heapq.heappush(h, (newWall, nx, ny))
  print(wall[n-1][m-1])

if __name__ == '__main__':
  solution()
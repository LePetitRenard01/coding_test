from collections import deque
def calculate(num):
  west = num%2
  north = (num//2)%2
  east = (num//4)%2
  south = (num//8)%2
  return (west,north,east,south)

def countRoom(field, visited, mark, start):
  q = deque()
  q.append(start)
  d = [(0,-1),(-1,0),(0,1),(1, 0)]
  visited[start[0]][start[1]] = True
  area = 1
  while q:
    x, y = q.popleft()
    dir = calculate(field[x][y])
    field[x][y] = mark
    for i in range(4):
      if dir[i]:
        continue
      nx = x + d[i][0]
      ny = y + d[i][1]
      if not (0<=nx<len(field) and 0<=ny<len(field[0])):
        continue
      if visited[nx][ny] :
        continue
      visited[nx][ny] = True
      q.append((nx,ny))
      area += 1

  return area

def solution():
  n, m = map(int, input().split())
  field = []
  for _ in range(m):
    field.append(list(map(int,input().split())))
  
  visited = [[False for _ in range(n)] for _ in range(m)]
  mark = 0
  area = []
  for i in range(m):
    for j in range(n):
      if not visited[i][j]:
        area.append(countRoom(field,visited,mark,(i,j)))
        mark += 1

  res3 = 0
  for i in range(m):
    for j in range(n):
      for nx,ny in ((i+1,j),(i,j+1)):
        if not (0<=nx<m and 0<=ny<n):
          continue
        if field[i][j] == field[nx][ny] :
          continue
        res3 = max(res3, area[field[i][j]]+area[field[nx][ny]])
  print(len(area))
  print(max(area))
  print(res3)
if __name__ == '__main__':
  solution()
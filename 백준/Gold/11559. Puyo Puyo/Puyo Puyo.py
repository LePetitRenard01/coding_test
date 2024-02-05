from collections import deque
def d(x,y):
  yield (x+1, y)
  yield (x-1, y)
  yield (x, y+1)
  yield (x, y-1)

def bfs(field):
  flag = False
  visited = [[False for _ in range(6)] for _ in range(12)]
  for i in range(12):
    for j in range(6):
      if field[i][j] == '.':
        continue
      if visited[i][j] :
        continue
      std = field[i][j]
      q = deque()
      q.append((i,j))
      field[i][j] = '.'
      puyo = [(i,j)]
      visited[i][j] = True
      while q:
        x, y = q.popleft()
        for nx, ny in d(x,y):
          if not (0 <= nx < 12 and 0 <= ny < 6):
            continue
          if not field[nx][ny] == std:
            continue
          if visited[nx][ny]:
            continue
          visited[nx][ny] = True
          field[nx][ny] = '.'
          puyo.append((nx,ny))
          q.append((nx, ny))
      if len(puyo) < 4 :
        for x, y in puyo:
          field[x][y] = std
      else :
        # print(i, j, std)
        # print(puyo)
        flag = True
  return flag

def sort(field):
  # 가장 아랫줄부터 올라가면서 빈 공간이면 그 열의 가장 첫번째 안 빈 공간의 뿌요을 밑으로 내리기
  for i in range(11, 0, -1):
    for j in range(6):
      if field[i][j] == '.':
        for k in range(i, -1, -1):
          if field[k][j] != '.':
            field[i][j] = field[k][j]
            field[k][j] = '.'
            break

def solution():
  field = []
  for _ in range(12):
    field.append(list(map(str, input())))
  
  cnt = 0
  while True:
    # for i in field:
    #   print(*i)
    if bfs(field):
      cnt += 1
      sort(field)
    else:
      break

  print(cnt)

if __name__ == '__main__':
  solution()
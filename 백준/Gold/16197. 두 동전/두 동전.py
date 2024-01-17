from collections import deque
def solution():
  n, m = map(int, input().split())
  field = []
  for _ in range(n):
    field.append(list(map(str, input())))
  coin = []
  for i in range(n):
    for j in range(m):
      if field[i][j] == 'o':
        coin.append((i,j))
  
  q = deque()
  q.append((coin[0][0], coin[0][1], coin[1][0],coin[1][1],0))

  while q:
    x1, y1, x2, y2, cnt = q.popleft()
    if cnt >= 10:
      break
    for i in ((1,0),(-1,0),(0,1),(0,-1)):
      nx1 = x1 +i[0]
      nx2 = x2 +i[0]
      ny1 = y1 +i[1]
      ny2 = y2 +i[1]
      if not(0<=nx1<n and 0<=ny1<m) :
        if 0<=nx2<n and 0<=ny2<m:
          print(cnt+1)
          return
        else:
          continue
      if not(0<=nx2<n and 0<=ny2<m) :
        if 0<=nx1<n and 0<=ny1<m:
          print(cnt+1)
          return
        else:
          continue
      if field[nx1][ny1] == '#':
        nx1 = x1
        ny1 = y1
      if field[nx2][ny2] == '#':
        nx2 = x2
        ny2 = y2
      if nx1==nx2 and ny1==ny2:
        continue
      q.append((nx1,ny1,nx2,ny2,cnt+1))

  print(-1)
  
if __name__ == '__main__':
  solution()
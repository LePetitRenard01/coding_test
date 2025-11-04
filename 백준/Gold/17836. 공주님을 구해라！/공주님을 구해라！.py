from sys import stdin
from collections import deque

if __name__ == '__main__':
  n,m,t = map(int,stdin.readline().split())
  field = [[] for _ in range(n)]

  for i in range(n):
    tmp = list(map(int,stdin.readline().split()))
    for j in range(m):
      field[i].append(tmp[j])
      if field[i][j] == 2:
        sword = (i,j)

  def bfs(start):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    q = deque()
    q.append(start)
    distance[start[0]][start[1]] = 0
    #그람 획득
    if field[start[0]][start[1]] == 2:
      gram = True
    else:
      gram = False

    while q:
      x, y = q.popleft()
      for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if not (start[0] <= nx < n and start[1] <= ny < m):
          continue
        if not gram and field[nx][ny] == 1:
          continue
        if distance[nx][ny] != float('INF'):
          continue
        distance[nx][ny] = distance[x][y] + 1
        q.append((nx,ny))

  with_sword = 0
  without_sword = 0

  #without_sword
  distance = [[float('INF') for _ in range(m)] for _ in range(n)]
  bfs((0,0))
  without_sword = distance[-1][-1]
  to_sword = distance[sword[0]][sword[1]]

  #with_sword
  with_sword = to_sword + (n-1 - sword[0]) + (m-1 - sword[1])

  result = min(without_sword,with_sword)
  print(result if result <= t else 'Fail')
from collections import deque
def dfs(maze):
  dx = [-1, 1, 0, 0]
  dy = [0, 0, -1, 1]
  queue = deque()
  queue.append((0,0))
  maze[0][0] = 1
  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx<0 or nx>n-1 or ny<0 or ny>m-1 :
        continue
      if maze[nx][ny] == -1:
        maze[nx][ny] = maze[x][y]+1
        queue.append((nx,ny))


n, m = map(int, input().split())
maze = [[] for _ in range(n)]
for i in range(n):
  for j in input():
    maze[i].append(int(j)-2) # 0-> -2 // 1-> -1

dfs(maze)
print(maze[n-1][m-1])
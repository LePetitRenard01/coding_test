from sys import stdin
from collections import deque

def bfs(a, location):
  dx = [1, -1, 0, 0]
  dy = [0, 0, 1, -1]

  queue = deque()
  queue.append(location)
  a[location[0]][location[1]] = 'X'
  count=0
  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x+dx[i]
      ny = y+dy[i]
      if nx>n-1 or nx<0 or ny>m-1 or ny<0:
        continue
      if a[nx][ny]=='X':
        continue
      elif a[nx][ny]=='P':
        count+=1
      a[nx][ny] = 'X'
      queue.append((nx,ny))
  return count

n, m = map(int,stdin.readline().split())
s = stdin.read().splitlines()
arr = [[j for j in line]for line in s]
location = None
for i in range(n):
  for j in range(m):
    if arr[i][j] == 'I':
      location = (i,j)
count = bfs(arr, location)
print(count if count>0 else 'TT')
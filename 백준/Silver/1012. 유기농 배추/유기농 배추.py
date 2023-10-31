import sys
sys.setrecursionlimit(10000)
def dfs(a, i, j):
  dx = [-1, 1, 0, 0]
  dy = [0, 0, -1, 1]
  a[i][j] = 0
  for k in range(4):
    nx = i + dx[k]
    ny = j + dy[k]
    if not (nx<len(a) and nx>-1 and ny<len(a[0]) and ny>-1):
      continue
    if a[nx][ny] == 1:
      dfs(a, nx, ny)

def find():
  m, n, k = map(int,input().split())
  field = [[0 for _ in range(n)] for _ in range(m)]
  for i in range(k):
    p, q = map(int, input().split())
    field[p][q] = 1
  count = 0
  for i in range(m):
    for j in range(n):
      if field[i][j] == 1:
        dfs(field,i,j)
        count+=1
  print(count)

t = int(input())
for i in range(t):
  find()
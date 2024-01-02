if __name__ == '__main__':
  n,m = map(int,input().split())
  field = []
  for _ in range(n):
    field.append(list(map(str,input())))
  
  visited = [[False for _ in range(m)] for _ in range(n)]
  def dfs(x,y,std):
    visited[x][y] = True
    if std == '-':
      if y+1 < m and field[x][y+1] == std:
        dfs(x,y+1,std)
    else :
      if x+1 < n and field[x+1][y] == std:
        dfs(x+1,y,std)
  
  cnt = 0
  for i in range(n):
    for j in range(m):
      if not visited[i][j]:
        dfs(i,j,field[i][j])
        cnt += 1
  
  print(cnt)
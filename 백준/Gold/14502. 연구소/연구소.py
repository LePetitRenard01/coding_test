#모든 0 구간에 벽을 세워둬본다? 근데 그러면 너무 많이 시도해봐야하지 않나
#combination으로 3점씩 뽑아서 bfs 돌리고 마지막에 0갯수 세서 max_safe랑 비교하면 되지 않나?
from itertools import combinations
from collections import deque
from sys import stdin
if __name__ == '__main__':
  n, m = map(int,input().split())
  lab = [list(map(int,i.split())) for i in stdin.read().splitlines()]
  candidate = []
  src = []
  result = 0
  for i in range(n):
    for j in range(m):
      if lab[i][j] == 0:
        candidate.append((i,j))
      elif lab[i][j] == 2:
        src.append((i,j))
  
  dx = [1, -1, 0, 0]
  dy = [0, 0, 1, -1]
  def bfs(start):
    q = deque()
    q.append(start)
    visited[start[0]][start[1]] = True
    count = 0
    while q:
      curx, cury = q.popleft()
      for i in range(4):
        nx = curx+dx[i]
        ny = cury+dy[i]
        if not(0<=nx<n and 0<=ny<m):
          continue
        if visited[nx][ny] or lab[nx][ny] != 0:
          continue
        visited[nx][ny] = True
        q.append((nx,ny))
        count+=1
    return count

  combi = list(combinations(candidate,3))
  for i in combi:
    #벽세우기
    for j in i:
      lab[j[0]][j[1]] = 1
    
    #해당 벽 조합에 대한 bfs
    visited = [[False for _ in range(m)] for _ in range(n)]
    count = 0
    for j in src:
      count += bfs(j)
    result = max(result,len(candidate) - count - 3)
    #벽 철거
    for j in i:
      lab[j[0]][j[1]] = 0
  print(result)
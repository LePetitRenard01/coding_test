from sys import stdin
from collections import deque
dx = [1,1,1,-1,-1,-1,0,0]
dy = [1,0,-1,1,0,-1,1,-1]

def bfs(seaMap, visited, start, scope):
  q = deque()
  q.append(start)
  while q:
    x, y = q.popleft()
    for i in range(len(dx)):
      nx = x + dx[i]
      ny = y + dy[i]
      if not (0<=nx<scope[0] and 0<=ny<scope[1]) :
        continue
      if not visited[nx][ny] and seaMap[nx][ny]==1:
        q.append((nx,ny))
        visited[nx][ny] = 1

def test(w, h):
  visited = [[False for _ in range(w)]for _ in range(h)]
  seaMap = []
  for _ in range(h):
    seaMap.append(list(map(int,stdin.readline().split())))
  
  cnt_island = 0
  for i in range(h):
    for j in range(w):
      if not visited[i][j] and seaMap[i][j] == 1:
        bfs(seaMap, visited, (i,j), (h,w))
        cnt_island+=1
  print(cnt_island)

if __name__ == '__main__':
  w, h = map(int, stdin.readline().split())
  while w!=0 or h!=0:
    test(w,h)
    w, h = map(int, stdin.readline().split())

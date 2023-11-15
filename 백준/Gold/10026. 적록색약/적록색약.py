from collections import deque
from sys import stdin
n = int(input())
graph = [[j for j in i]for i in stdin.read().splitlines()]
visited = [[False for _ in range(n)] for _ in range(n)]
visited_b = [[False for _ in range(n)] for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bsf(stt, isBlind):
  q = deque()
  q.append(stt)
  if isBlind:
    visited_b[stt[0]][stt[1]] = True
    blind(q, graph[stt[0]][stt[1]])
  else:
    visited[stt[0]][stt[1]] = True
    not_blind(q, graph[stt[0]][stt[1]])

def blind(q,target): #(R,G)/B
  while q:
    x,y = q.popleft()
    for i in range(4):
      nx = x+dx[i]
      ny = y+dy[i]
      if 0<=nx<n and 0<=ny<n and not visited_b[nx][ny]:
        if (target=='R' or target == 'G') and graph[nx][ny] == 'B':
          continue
        elif (target=='B') and graph[nx][ny] != 'B':
          continue
        visited_b[nx][ny] = True
        q.append((nx,ny))

def not_blind(q,target): #R/G/B
  while q:
    x,y = q.popleft()
    for i in range(4):
      nx = x+dx[i]
      ny = y+dy[i]
      if 0<=nx<n and 0<=ny<n and not visited[nx][ny] and graph[nx][ny]==target:
        visited[nx][ny] = True
        q.append((nx,ny))

cnt = 0
cnt_b = 0
for i in range(n):
  for j in range(n):
    if not visited[i][j]:
      bsf((i,j), False)
      cnt += 1
    if not visited_b[i][j]:
      bsf((i,j), True)
      cnt_b += 1

print(cnt, cnt_b)
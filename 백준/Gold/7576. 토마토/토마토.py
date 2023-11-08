from collections import deque
m, n = map(int,input().split())

box = [[] for _ in range(n)]
startRipe = []
isAllRipe = True
for i in range(n):
  row = list(map(int,input().split()))
  for j in range(m):
    box[i].append(row[j])
    if row[j] == 1:
      startRipe.append((i,j))
    elif row[j] == 0:
      isAllRipe = False

def bfs(box, start):
  dh = [1, -1, 0, 0]
  dw = [0, 0, 1, -1]
  queue = deque()
  result = 0
  for i in start:
    queue.append(i)
  while queue:
    h, w = queue.popleft()
    for i in range(4):
      nh = h+dh[i]
      nw = w+dw[i]
      if 0<=nh<n and 0<=nw<m and box[nh][nw] == 0:
        box[nh][nw] = box[h][w]+1
        result = box[h][w]+1
        queue.append([nh,nw])
  return result

if isAllRipe:
  result = 0
else:
  result = bfs(box, startRipe) -1
  for i in range(n):
    for j in range(m):
      if box[i][j] == 0:
        result = -1
        break

print(result)
from collections import deque
RANGE = 100_001
n, k = map(int,input().split())
dist = [-1 for _ in range(RANGE)]

def bfs(start):
  q = deque()
  q.append(start)
  dist[start] = 0
  while q:
    loc = q.popleft()
    if loc - 1 >= 0 and (dist[loc - 1] == -1 or dist[loc - 1] > dist[loc] + 1):
      dist[loc - 1] = dist[loc] + 1
      if loc == k :
        break
      q.append(loc - 1)
    if loc + 1 < RANGE and (dist[loc + 1] == -1 or dist[loc + 1] > dist[loc] + 1):
      dist[loc + 1] = dist[loc] + 1
      if loc == k :
        break
      q.append(loc + 1)
    if 2 * loc < RANGE and (dist[2 * loc] == -1 or dist[2 * loc] > dist[loc]):
      dist[2 * loc] = dist[loc]
      if loc == k :
        break
      q.append(2 * loc)

bfs(n)
print(dist[k])
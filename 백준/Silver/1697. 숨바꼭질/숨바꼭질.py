from collections import deque
n, k = map(int,input().split())
road = [0] * 100_001

queue = deque()
road[n] = 0
queue.append(n)

while queue:
  x = queue.popleft()
  if x == k :
    print(road[x])
    break
  if x-1 >= 0 and road[x-1]==0:
    queue.append(x-1)
    road[x-1] = road[x]+1
  if x+1 <= 100_000 and road[x+1]==0:
    queue.append(x+1)
    road[x+1] = road[x]+1
  if 2*x <= 100_000 and road[2*x]==0:
    queue.append(2*x)
    road[2*x] = road[x]+1
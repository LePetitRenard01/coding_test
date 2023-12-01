from collections import deque

f, s, g, u, d = map(int,input().split())
button = [-1]*(f+1)
direction = [u, -d]
#bfs
q = deque()
q.append(s)
button[s] = 0

while q:
  present_floor = q.popleft()
  for i in direction:
    new_floor = present_floor + i 
    if not (1 <= new_floor <= f):
      continue
    if button[new_floor] == -1 or button[new_floor] > button[present_floor] + 1 :
      q.append(new_floor)
      button[new_floor] = button[present_floor] + 1

print(button[g] if button[g]!=-1 else 'use the stairs')
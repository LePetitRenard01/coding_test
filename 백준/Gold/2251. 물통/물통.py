from collections import deque
from itertools import permutations
def pour(bottle, a, b): # a->b
  if bottle[a] + bottle[b] <= limit[b]:
    newA = 0
    newB = bottle[a] + bottle[b]
  else:
    newA = bottle[a] - (limit[b] - bottle[b])
    newB = limit[b]
  return (newA, newB)

if __name__ == '__main__':
  limit = list(map(int, input().split()))
  record = set()
  q = deque()
  q.append([0,0,limit[2]])
  visited = set()
  while q:
    bottle = q.popleft()
    for a,b,c in permutations(range(3),3):
      newA, newB = pour(bottle,a,b)
      next = [0,0,0]
      next[a] = newA
      next[b] = newB
      next[c] = bottle[c]
      if tuple(next) in visited:
        continue
      if next[0] == 0:
        record.add(next[2])
      visited.add(tuple(next))
      q.append(next)
  record = list(record)
  record.sort()
  print(*record)
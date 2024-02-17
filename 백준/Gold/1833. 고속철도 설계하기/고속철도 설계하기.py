# MST
# Kruskal : edge find-union
# The point of problem ; utilize mst but the result could not be mst.(it can have more edges in advance.)
# 1. n-1 original road : it can have redundant ones, so check their parent
# 2. less than n-1 : check their parents after paving n-1th road
from sys import stdin
def find(parent, num):
  if parent[num] != num:
    parent[num] = find(parent,parent[num])
  return parent[num]
def union(parent, a, b):
  p1 = find(parent, a)
  p2 = find(parent, b)
  if p1 < p2 :
    parent[p1] = p2
  elif p1 > p2 :
    parent[p2] = p1
  else:
    return False # already in same group
  return True

def isSameParent(parent):
  tmp = parent[0]
  for i in (1, len(parent)) :
    if tmp != find(parent, i):
      return False
  return True

def solution():
  n = int(stdin.readline())
  plan = []
  parent = [i for i in range(n+1)]
  road = 0
  length = 0

  for i in range(1, n+1):
    tmp = list(map(int, stdin.readline().split()))
    for j in range(i+1, n+1):
      if tmp[j-1] < 0 :
        # grouping
        union(parent, i, j)
        road += 1
        length -= tmp[j-1]
      else:
        plan.append((i,j,tmp[j-1]))
  
  plan.sort(key = lambda x : -x[2])
  constructed = []
  while plan:
    x, y, dist = plan.pop()
    if find(parent, x) == find(parent, y): # already connected
      continue
    if road >= n - 1 and isSameParent(parent):
      break

    union(parent, x, y)
    length += dist
    constructed.append((x, y))
  
  print(length, len(constructed))
  for x, y in constructed:
    print(x,y)

if __name__ == '__main__':
  solution()
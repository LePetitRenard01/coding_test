#mst kruskal edge 중심
from sys import stdin
class God :
  def __init__(self,x, y) -> None:
    self.x = x
    self.y = y
  def getDistance(god1, god2):
    return ((god1.x - god2.x)**2 + (god1.y - god2.y)**2)**0.5

def find(parent, num):
  if num != parent[num]:
    parent[num] = find(parent, parent[num])
  return parent[num]

def union(parent, p1, p2):
  if p1 > p2 :
    parent[p1] =  p2
  else:
    parent[p2] = p1

def solution():
  n, m = map(int, stdin.readline().split())
  god = []
  for _ in range(n):
    god.append(God(*map(float,stdin.readline().split())))
  
  graph = []
  for i in range(n):
    for j in range(i+1,n):
      graph.append((i,j,God.getDistance(god[i], god[j])))
  graph.sort(key = lambda x : x[2])

  parent = [i for i in range(n)]
  res = 0
  for _ in range(m): # 이미 결정된 루트
    tmp = list(map(int,stdin.readline().split()))
    tmp[0] -= 1
    tmp[1] -= 1
    p1 = find(parent, tmp[0])
    p2 = find(parent, tmp[1])
    union(parent, p1, p2)
  
  for i in graph:
    p1 = find(parent, i[0])
    p2 = find(parent, i[1])
    if p1 == p2:
      continue
    union(parent, p1, p2)
    res += i[2]  
  print("{:.2f}".format(res))

if __name__ == '__main__':
  solution()
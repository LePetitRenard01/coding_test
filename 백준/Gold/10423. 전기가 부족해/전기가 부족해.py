from sys import stdin
def solution():
  n, m, k = map(int, stdin.readline().split())
  edge = []
  generator = set(map(int, stdin.readline().split()))
  for _ in range(m):
    edge.append(list(map(int, stdin.readline().split())))
  edge.sort(key = lambda x : -x[2])

  parent = [i for i in range(n+1)]
  res = 0
  cnt = 0
  def find(num):
    if num != parent[num]:
      parent[num] = find(parent[num])
    return parent[num]
  def union(a, b):
    p1 = find(a)
    p2 = find(b)
    if p1 in generator:
      parent[p2] = p1
    elif p2 in generator:
      parent[p1] = p2
    elif p1 > p2:
      parent[p1] = p2
    else:
      parent[p2] = p1
  
  while edge:
    u, v, w = edge.pop()
    if find(u) in generator and find(v) in generator:
      continue
    if find(u) == find(v):
      continue
    res += w
    union(u, v)
  print(res)

if __name__ == '__main__':
  solution()
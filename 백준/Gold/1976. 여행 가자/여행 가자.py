from sys import stdin
def find(num):
  if num != parent[num]:
    parent[num] = find(parent[num])
  return parent[num]

def union(a, b):
  p1 = find(a)
  p2 = find(b)
  if p1 > p2 :
    parent[p1] = p2
  elif p1 < p2:
    parent[p2] = p1

if __name__ == '__main__':
  n = int(stdin.readline())
  m = int(stdin.readline())
  parent = [i for i in range(n+1)]
  for i in range(1,n+1):
    tmp = list(map(int, stdin.readline().split()))
    for j in range(1, n+1):
      if tmp[j-1] != 0:
        union(i,j)
  
  plan = list(map(int, stdin.readline().split()))
  previous = find(plan[0])
  res = True
  for i in plan:
    if previous != find(i):
      res = False
      break
  print('YES' if res else 'NO')
from sys import stdin
def find(parent, num):
  if num != parent[num]:
    parent[num] = find(parent, parent[num])
  return parent[num]
def union(parent, a, b):
  p1 = find(parent, a)
  p2 = find(parent, b)
  if p1 > p2 :
    parent[p1] = p2
  elif p1 < p2 :
    parent[p2] = p1
  else :
    return True
  return False

def solution():
  n, m = map(int, stdin.readline().split())
  parent = [i for i in range(n)]
  res = 0
  for i in range(m):
    tmp = list(map(int, stdin.readline().split()))
    flag = union(parent,tmp[0],tmp[1])
    if flag:
      res = i+1
      stdin.read().splitlines()
      break
  print(res)

if __name__ == '__main__':
  solution()
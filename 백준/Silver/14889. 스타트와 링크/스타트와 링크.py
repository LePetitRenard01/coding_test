# back tracking
from sys import stdin
from itertools import combinations
def addAll(d, team):
  res = 0
  for x, y in combinations(team, 2):
    res += d[(x,y)]
  return res

def solution():
  n = int(stdin.readline())
  matrix = [[i for i in map(int, stdin.readline().split())] for _ in range(n)]

  d = dict()
  for i in range(1, n+1):
    for j in range(1, n+1):
      if i == j:
        continue
      if i < j :
        d[(i,j)] = matrix[i-1][j-1]
      else :
        d[(j,i)] += matrix[i-1][j-1]
  
  res = float('INF')
  for start in combinations(range(1,n+1), n//2):
    link = []
    for i in range(1,n+1):
      if not i in start:
        link.append(i)
    tmp1 = addAll(d, link)
    tmp2 = addAll(d, start)
    res = min(res, tmp1 - tmp2) if tmp1 > tmp2 else min(res, tmp2 - tmp1)
    if res == 0:
      break
  
  print(res)

if __name__ == '__main__':
  solution()
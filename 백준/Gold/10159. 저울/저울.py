#a->b로 가는 경로가 있든 b->a로 가는 경로가 있든 연결되어야 비교 가능
from sys import stdin
def solution():
  n = int(stdin.readline())
  m = int(stdin.readline())  
  #floyd- warshall
  distance = [[float('INF') for _ in range(n+1)] for _ in range(n+1)]
  for i in range(n+1):
    distance[i][i] = 0
  for _ in range(m):
    tmp = list(map(int, stdin.readline().split()))
    distance[tmp[0]][tmp[1]] = 1

  for k in range(n+1):
    for i in range(n+1):
      for j in range(n+1):
        if distance[i][j] > distance[i][k] + distance[k][j]:
          distance[i][j] = distance[i][k] + distance[k][j]
  
  res = [n-1] * (n+1)
  for i in range(1, n+1):
    for j in range(1, n+1):
      if i == j:
        continue
      if distance[i][j] != float('INF'):
        res[i] -= 1
        res[j] -= 1
  print('\n'.join(map(str,res[1:])))

if __name__ == '__main__':
  solution()
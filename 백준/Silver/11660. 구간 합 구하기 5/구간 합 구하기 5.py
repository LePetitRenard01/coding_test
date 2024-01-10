from sys import stdin
def solution():
  n, m = map(int, stdin.readline().split())
  matrix = []
  for _ in range(n):
    matrix.append(list(map(int, stdin.readline().split())))
  for i in range(n):
    for j in range(1,n):
      matrix[i][j] += matrix[i][j-1]
  
  for i in range(1, n):
    for j in range(n):
      matrix[i][j] += matrix[i-1][j]
  
  for _ in range(m):
    x1, y1, x2, y2 = map(int, stdin.readline().split())
    x1 -= 2; y1 -= 2;
    x2 -= 1; y2 -= 1;
    res = matrix[x2][y2]
    if x1 < 0 and y1 < 0:
      print(res)
      continue
    elif x1 < 0 :
      res -= matrix[x2][y1]
    elif y1 < 0 :
      res -= matrix[x1][y2]
    else :
      res = res - matrix[x2][y1] - matrix[x1][y2] + matrix[x1][y1]
    print(res)
if __name__ == '__main__':
  solution()
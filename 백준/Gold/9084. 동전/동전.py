from sys import stdin
def solution():
  n = int(stdin.readline())
  coin = list(map(int, stdin.readline().split()))
  m = int(stdin.readline())

  memo = [[0 for _ in range(m+1)] for _ in range(n+1)]
  for i in range(1, n+1):
    if coin[i-1] > m :
      memo[i][m] = memo[i-1][m]
      continue
    for j in range(1, m+1):
      if coin[i-1] <= j:
        tmp = 0
        for k in range(j//coin[i-1]+1):
          tmp += memo[i-1][j - k * coin[i-1]]
        if j%coin[i-1] == 0:
          tmp += 1
        memo[i][j] = tmp
      else:
        memo[i][j] = memo[i-1][j]

  print(memo[n][m])

if __name__ == '__main__':
  for _ in range(int(stdin.readline())):
    solution()
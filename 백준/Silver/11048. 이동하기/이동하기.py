def solution():
  n, m = map(int, input().split())
  field = []
  for _ in range(n):
    field.append(list(map(int, input().split())))
  dp = [[0 for _ in range(m)] for _ in range(n)]
  dp[0][0] = field[0][0]
  for i in range(1,m):
    dp[0][i] = dp[0][i-1] + field[0][i]
  for i in range(1,n):
    dp[i][0] = dp[i-1][0] + field[i][0]
  
  for i in range(1, n):
    for j in range(1, m):
      dp[i][j] = max(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + field[i][j]
  
  print(dp[n-1][m-1])

if __name__ == '__main__':
  solution()
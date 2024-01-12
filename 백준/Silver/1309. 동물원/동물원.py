if __name__ == '__main__':
  n = int(input())
  dp = [[0 for _ in range(n)]for _ in range(3)] #left, right, neither
  for i in range(3):
    dp[i][0] = 1
  for i in range(1,n):
    #left
    dp[0][i] = dp[1][i-1] + dp[2][i-1]
    #right
    dp[1][i] = dp[0][i-1] + dp[2][i-1]
    #neither
    dp[2][i] = dp[0][i-1] + dp[1][i-1] + dp[2][i-1]
    
    for j in range(3):
      dp[j][i] %= 9901
  
  res = 0
  for i in range(3):
    res += dp[i][n-1]
  print(res%9901)
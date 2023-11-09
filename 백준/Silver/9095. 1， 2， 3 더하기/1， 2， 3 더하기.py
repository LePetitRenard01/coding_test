t = int(input())
for k in range(t):
  n = int(input())
  dp = [0 for i in range(n+1)]
  dp[1] = 1
  if n!=1:
    dp[2] = 2
    if n!=2:
      dp[3] = 4
  for i in range(4,n+1):
    dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
  print(dp[n]%10007)
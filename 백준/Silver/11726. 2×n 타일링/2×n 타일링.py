# 1, 2로 n 만들기
#dp[i] = dp[i-2]+1 + dp[i-1]+1
n = int(input())
dp = [0 for i in range(n+1)]
dp[1] = 1
if n!=1:
  dp[2] = 2
for i in range(3,n+1):
  dp[i] = dp[i-1] + dp[i-2]
print(dp[n]%10007)
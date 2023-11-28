# knapsack algorithm == dp[n번째 아이템][무게]
from sys import stdin
def calculate(weight, value, n, w):
  dp = [[0 for _ in range(w+1)] for _ in range(n+1)]
  for i in range(1,n+1):
    for j in range(1,w+1):
      if weight[i] <= j:
        dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])
      else:
        dp[i][j] = dp[i-1][j]
  return dp[n][w]


if __name__=='__main__':
  n, k = map(int,stdin.readline().split())
  dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
  weight = [0]
  value = [0]
  for i in stdin.read().splitlines():
    tmp = list(map(int,i.split()))
    weight.append(tmp[0])
    value.append(tmp[1])
  
  print(calculate(weight, value, n, k))
def solution():
  n, k = map(int, input().split())
  coin = []
  for _ in range(n):
    coin.append(int(input()))
  coin.sort()
  
  dp = [0] * (k+1)
  dp[0] = 1
  for i in range(n):
    for j in range(1, k+1): 
      # 1~k원에 대해 coin[i]
      if j >= coin[i]:
        dp[j] += dp[j - coin[i]]
  
  print(dp[-1])

if __name__ == '__main__':
  solution()
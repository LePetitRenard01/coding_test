def test():
  n = int(input())
  sticker = []
  sticker.append(list(map(int, input().split())))
  sticker.append(list(map(int, input().split())))

  dp = [[0 for _ in range(n)] for _ in range(2)] # upper, down
  dp[0][0] = sticker[0][0]
  dp[1][0] = sticker[1][0]
  if n > 1:
    dp[0][1] = dp[1][0] + sticker[0][1]
    dp[1][1] = dp[0][0] + sticker[1][1]

  for i in range(2, n):
    dp[0][i] = max(dp[1][i-1] + sticker[0][i], dp[0][i-2] + sticker[0][i], dp[1][i-2] + sticker[0][i])
    dp[1][i] = max(dp[0][i-1] + sticker[1][i], dp[0][i-2] + sticker[1][i], dp[1][i-2] + sticker[1][i])
  
  print(max(dp[0][n-1], dp[1][n-1]))


if __name__ == '__main__':
  for _ in range(int(input())):
    test()
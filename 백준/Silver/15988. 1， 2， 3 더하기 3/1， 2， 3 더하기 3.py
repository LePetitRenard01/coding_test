from sys import stdin
NUM = 1_000_000_009
def solution():
  dp = [0] * 1_000_001
  dp[1] = 1
  dp[2] = 2
  dp[3] = 4 # 1111 112 121 211 3

  for i in range(4, 1_000_001):
    dp[i] = (dp[i-3] + dp[i-2] + dp[i-1])%NUM

  for _ in range(int(stdin.readline())):
    print(dp[int(stdin.readline())])

if __name__ == '__main__':
  solution()
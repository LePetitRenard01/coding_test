from sys import stdin
def solution():
  n, k = map(int, stdin.readline().split())
  # knapsack = [[cost]item]
  memo = [[0 for _ in range(n+1)] for _ in range(k+1)]
  value = [0]
  time = [0]
  for _ in range(k):
    v, t = map(int, stdin.readline().split())
    value.append(v)
    time.append(t)
  
  for i in range(1, k+1):
    for j in range(1, n+1):
      if time[i] <= j:
        memo[i][j] = max(memo[i-1][j], memo[i-1][j-time[i]] + value[i])
      else:
        memo[i][j] = memo[i-1][j]
  
  res = 0
  for i in memo:
    res = max(res,max(i))
  print(res)

if __name__ == '__main__':
  solution()
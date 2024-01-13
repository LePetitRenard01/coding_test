if __name__ == '__main__':
  n = int(input())
  num = list(map(int, input().split()))
  dp = [1] * n
  parent = [i for i in range(n)]
  for i in range(n):
    for j in range(i):
      if num[j] < num[i] and dp[i] < dp[j] + 1:
        dp[i] = dp[j] + 1
        parent[i] = j

  stack = []
  def find(x):
    if x != parent[x]:
      find(parent[x])
    stack.append(num[x])

  length = max(dp)
  find(dp.index(length))
  print(length)
  print(*stack)
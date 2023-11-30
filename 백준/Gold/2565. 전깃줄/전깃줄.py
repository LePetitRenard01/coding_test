n = int(input())
line = []
for _ in range(n):
  line.append(tuple(map(int,input().split())))
line.sort(key = lambda x : x[0])

dp = [1 for _ in range(n)]
for i in range(n):
  for j in range(i):
    if line[j][1] < line[i][1] :
      dp[i] = max(dp[i], dp[j]+1)
print(n - max(dp))
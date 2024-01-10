if __name__ == '__main__':
  n = int(input())
  t = [0]
  p = [0]
  for _ in range(n):
    a, b = map(int, input().split())
    t.append(a)
    p.append(b)
  
  dp = [0] * (n+1)
  if t[n] == 1:
    dp[n] = p[n]

  for i in range(1, n):
    if t[n-i] == 1:
      dp[n-i] = dp[n-i+1] + p[n-i]
      continue
    if t[n-i] <= i+1 : # 근무가능한 기간
      if n-i + t[n-i] - 1 == n :
        tmp = p[n-i]
      else :
        tmp = dp[n-i + t[n-i]] + p[n-i]
      for j in range(1, t[n-i]):
        tmp = max(tmp, dp[n-i+j])
      dp[n-i] = tmp
    else: # 근무 불가능
      dp[n-i] = dp[n-i + 1]
  
  print(dp[1])
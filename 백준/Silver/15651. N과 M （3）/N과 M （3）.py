def dfs(arr):
  if len(arr) == m :
    print(*arr)
    return
  for i in range(n):
    arr.append(num[i])
    dfs(arr)
    arr.pop()


n, m = map(int,input().split())
num = [i for i in range(1,n+1)]
dfs([])
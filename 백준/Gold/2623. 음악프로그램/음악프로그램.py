from collections import deque
def solution():
  n, m = map(int, input().split())
  graph = [[] for _ in range(n+1)]
  inDegree = [0] * (n+1)
  for _ in range(m):
    tmp = list(map(int, input().split()))
    prev = tmp[1]
    for i in range(2,len(tmp)):
      graph[prev].append(tmp[i])
      inDegree[tmp[i]] += 1
      prev = tmp[i]
  
  q = deque()
  for i, d in enumerate(inDegree):
    if d == 0:
      q.append(i)
  
  cnt = 0
  res = []
  q.popleft()
  while q:
    cur = q.popleft()
    res.append(cur)
    for next in graph[cur]:
      inDegree[next] -= 1
      if inDegree[next] == 0:
        q.append(next)
    cnt += 1
  
  if cnt != n:
    print(0)
  else:
    print("\n".join(map(str, res)))

if __name__ == '__main__':
  solution()
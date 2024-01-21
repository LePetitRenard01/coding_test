import heapq
from sys import stdin
def solution():
  n = int(stdin.readline())
  edge = [[]for _ in range(n)]
  total = 0
  for i in range(n):
    tmp = list(map(str, stdin.readline().rstrip()))
    for j in range(n):
      if tmp[j] == '0':
        continue
      elif ord(tmp[j]) - ord('a') >= 0:
        line = ord(tmp[j]) - ord('a') + 1
      else :
        line = ord(tmp[j]) - ord('A') + 27
      total += line
      if i == j:
        continue
      edge[i].append((line, j))
      edge[j].append((line, i))

  #MST Prim
  inMST = [False] * n
  h = [(0,0)]
  cnt = 0
  mstLen = 0
  while h:
    weight, current = heapq.heappop(h)
    if inMST[current] :
      continue
    inMST[current] = True
    mstLen += weight
    cnt += 1
    if cnt == n:
      break
    for w, next in edge[current]:
      if not inMST[next]:
        heapq.heappush(h,(w,next))
  
  print(total - mstLen if cnt == n else -1)

if __name__ == '__main__':
  solution()
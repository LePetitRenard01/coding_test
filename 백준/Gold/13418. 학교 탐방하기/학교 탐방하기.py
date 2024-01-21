# 입구 숫자0 오르막길 최소 피로도는 오르막길 **2 최초조사된 길 기준
import heapq
from sys import stdin
def prim(graph,isBest):
  inMST = [False] *len(graph)
  h = [(0,0)]
  cnt = 0
  res = 0
  while h:
    weight, current = heapq.heappop(h)
    if inMST[current]:
      continue
    inMST[current] = True
    res += weight
    cnt += 1
    if cnt == len(graph):
      break
    for weight, next in graph[current]:
      if inMST[next]:
        continue
      if isBest :
        heapq.heappush(h,(-weight,next))
      else:
        heapq.heappush(h, (weight, next))
  
  if isBest :
    return (len(graph)-1 + res)**2
  else :
    return (len(graph)-1 - res)**2
def solution():
  n, m = map(int, input().split())
  graph = [[] for _ in range(n+1)]
  for _ in range(m+1):
    tmp = list(map(int, stdin.readline().split()))
    graph[tmp[0]].append((tmp[2], tmp[1]))
    graph[tmp[1]].append((tmp[2], tmp[0]))
  
  #최악 : 오르막길
  worst = prim(graph, False)
  
  #최선 : 내리막길
  best = prim(graph, True)
  
  print(worst - best)

if __name__ == '__main__':
  solution()
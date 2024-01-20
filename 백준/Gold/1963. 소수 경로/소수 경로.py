from sys import stdin
from collections import deque
def sieve():
  prime = [True] * 10000
  for i in range(2,int(10000**0.5)+1):
    j = 2
    while i * j < 10000:
      prime[i*j] = False
      j += 1
  return prime

def solution():
  start, dest = map(int, stdin.readline().split())
  visited = [float('INF')] * 10000
  visited[start] = 0
  q = deque()
  q.append(start)

  while q:
    current = q.popleft()
    if current == dest:
      break

    for i in range(4):
      str_cur = list(map(int, str(current)))
      for j in range(10):
        str_cur[i] = j
        next = 0
        for k in range(4):
          next += str_cur[k] * (10 ** (3-k))
        if next <= 1000:
          continue
        if visited[next] <= visited[current] + 1:
          continue
        if not prime[next] :
          continue
        visited[next] = visited[current] + 1
        q.append(next)

  print(visited[dest] if visited[dest] != float('INF') else 'Impossible')

if __name__ == '__main__':
  prime = sieve()
  for _ in range(int(stdin.readline())):
    solution()
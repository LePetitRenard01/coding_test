from sys import stdin
def solution():
  n, m, w = map(int, stdin.readline().split())
  edge = []
  for _ in range(m):
    tmp = list(map(int, stdin.readline().split()))
    edge.append((tmp[0], tmp[1], tmp[2]))
    edge.append((tmp[1], tmp[0], tmp[2]))
  for _ in range(w):
    tmp = list(map(int, stdin.readline().split()))
    edge.append((tmp[0],tmp[1], -tmp[2]))
  
  edge.sort(key = lambda x : x[2])
  distance = [0] * (n+1)

  for _ in range(n-1):
    for u, v, w in edge:
      if distance[v] > distance[u] + w:
        distance[v] = distance[u] + w
  
  for u, v, w in edge:
    if distance[v] > distance[u] + w:
      print('YES')
      return
  
  print('NO')

if __name__ == '__main__':
  for _ in range(int(stdin.readline())):
    solution()
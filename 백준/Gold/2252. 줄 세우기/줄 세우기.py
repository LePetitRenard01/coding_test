from sys import stdin
def topological_sort(visited,s):
  visited[s] = True
  for i in graph[s]:
    if not visited[i]:
      topological_sort(visited,i)
  stack.append(s)
if __name__ == '__main__':
  n, m = map(int,input().split())
  graph = [[]for _ in range(n+1)]
  for _ in range(m):
    tmp = list(map(int,stdin.readline().split()))
    graph[tmp[0]].append(tmp[1])
  
  stack = []
  visited = [False] * (n+1)
  for i in range(1, n+1):
    if not visited[i]:
      topological_sort(visited,i)
  print(*stack[::-1])
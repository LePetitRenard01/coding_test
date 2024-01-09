from sys import stdin
def solution():
  n = int(stdin.readline())
  distance = [[float('INF') for _ in range(n+1)]for _ in range(n+1)]
  relation = stdin.read().splitlines()[:-1]
  for i in relation:
    i = list(map(int, i.split()))
    distance[i[0]][i[1]] = 1
    distance[i[1]][i[0]] = 1
  for i in range(n+1):
    distance[i][i] = 0
  
  for k in range(1,n+1):
    for i in range(1,n+1):
      for j in range(1,n+1):
        if distance[i][j] > distance[i][k] + distance[k][j]:
          distance[i][j] = distance[i][k] + distance[k][j]
  
  president = []
  presidentScore = float('INF')
  for i in range(1,n+1):
    score = max(distance[i][1:])
    if presidentScore > score:
      president.clear()
      president.append(i)
      presidentScore = score
    elif presidentScore == score:
      president.append(i)
  
  print(presidentScore, len(president))
  print(*president)

if __name__ == '__main__':
  solution()
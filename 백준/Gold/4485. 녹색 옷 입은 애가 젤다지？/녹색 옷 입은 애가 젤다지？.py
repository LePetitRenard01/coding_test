from sys import stdin
import sys
import heapq
def dijkstra(cave, start): #heap 이용해서 누적비용 적은 edge부터 접근
  accumulated = [[sys.maxsize for _ in range(len(cave))]for _ in range(len(cave))]
  dx = [1, -1, 0, 0]
  dy = [0, 0, 1, -1]
  q = []
  heapq.heappush(q, (cave[start[0]][start[1]], start))
  while q:
    cost, loc = heapq.heappop(q)
    if accumulated[loc[0]][loc[1]] < cost :
      continue
    for i in range(len(dx)):
      nx = loc[0] + dx[i]
      ny = loc[1] + dy[i]
      if not (0<=nx<len(cave) and 0<=ny<len(cave)):
        continue
      if accumulated[nx][ny] > cost + cave[nx][ny]:
        accumulated[nx][ny] = cost + cave[nx][ny]
        heapq.heappush(q, (accumulated[nx][ny],(nx,ny)))

  return accumulated[-1][-1]

def test(n, t):
  cave = []
  for _ in range(n):
    cave.append(list(map(int,stdin.readline().split())))
  print(f'Problem {t}: {dijkstra(cave,(0,0))}')

if __name__ == '__main__':
  n = int(stdin.readline())
  test_cnt = 1
  while n != 0:
    test(n, test_cnt)
    test_cnt += 1
    n = int(stdin.readline())
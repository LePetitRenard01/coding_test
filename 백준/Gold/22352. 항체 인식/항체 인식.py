# before after 비교 해서 변화 있는 칸을 changed에 체크
# changed 값이 모두 False => Yes 
# changed 값이 True인 아무 칸에서 before bfs 시작
# bfs visited와 changed 일치하는지 비교 => 같으면 yes 같지 않으면 no
# changed True인 아무 칸에서 after bfs 시작
# changed True 인데 after visited False인 칸이 있다 => NO
from sys import stdin
from collections import deque
input = stdin.readline
def bfs(graph, changed, loc_x, loc_y):
    n = len(graph)
    m = len(graph[0])
    visited = [[False for _ in range(m)] for _ in range(n)]
    q = deque()
    q.append((loc_x, loc_y))
    std = graph[loc_x][loc_y]
    visited[loc_x][loc_y] = True

    while q:
        x, y = q.popleft()
        for nx, ny in ((x+1,y),(x-1,y),(x,y+1),(x,y-1)):
            if not (0<=nx<n and 0<=ny<m):
                continue
            if visited[nx][ny]:
                continue
            if graph[nx][ny] == std :
                q.append((nx,ny))
                visited[nx][ny] = True
    
    return visited

def solution():
    n, m = map(int, input().split())
    before = []
    after = []
    for _ in range(n):
        before.append(list(map(int, input().split())))
    for _ in range(n):
        after.append(list(map(int, input().split())))
    
    changed = [[False for _ in range(m)] for _ in range(n)]
    # check change
    cnt = 0
    loc_x, loc_y = 0,0
    for i in range(n):
        for j in range(m):
            if before[i][j] != after[i][j]:
                changed[i][j] = True
                cnt += 1
                loc_x, loc_y = i, j
    
    # no change
    if cnt == 0:
        print('YES')
        return
    
    res = True
    # before-bfs
    visited = bfs(before, changed,loc_x, loc_y)
    for i in range(n):
        for j in range(m):
            if changed[i][j] != visited[i][j]:
                print('NO')
                return
    # after-bfs
    visited = bfs(after, changed, loc_x, loc_y)
    for i in range(n):
        for j in range(m):
            if changed[i][j] and not visited[i][j]:
                print('NO')
                return
    print('YES')

if __name__ == '__main__':
    solution()
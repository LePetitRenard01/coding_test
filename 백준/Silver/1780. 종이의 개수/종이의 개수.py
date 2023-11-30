def split_paper(paper, count, n, start):
  std = paper[start[0]][start[1]]
  isAllSame = True
  for i in range(n):
    if not isAllSame:
      break
    for j in range(n):
      if std != paper[start[0]+i][start[1]+j]:
        isAllSame = False
  if isAllSame:
    count[std+1] += 1
  else:
    coordinate = [(start[0],start[1]),(start[0]+n//3,start[1]),(start[0]+n//3*2,start[1]),(start[0],start[1]+n//3),
    (start[0]+n//3,start[1]+n//3), (start[0]+n//3*2,start[1]+n//3),(start[0],start[1]+n//3*2),(start[0]+n//3,start[1]+n//3*2),
    (start[0]+n//3*2,start[1]+n//3*2)]
    for i in coordinate:
      split_paper(paper, count, n//3, i)

if __name__ == '__main__':
  n = int(input())
  paper = []
  count = [0,0,0] # -1, 0, 1 in order
  for _ in range(n):
    paper.append(list(map(int,input().split())))
  split_paper(paper, count, n, (0,0))
  for i in count:
    print(i)
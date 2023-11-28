from sys import stdin
n = int(input())
square = [list(map(int,i.split())) for i in stdin.read().splitlines()]

def splitPaper(square,startX, startY, n):
  std = square[startX][startY]
  isOneColor = True
  white, blue = 0, 0
  for i in range(n):
    for j in range(n):
      if square[startX+i][startY+j] != std:
        isOneColor = False
  if not isOneColor:
    tmp = []
    tmp.append(splitPaper(square,startX,startY,n//2))
    tmp.append(splitPaper(square,startX+n//2,startY,n//2))
    tmp.append(splitPaper(square,startX,startY+n//2,n//2))
    tmp.append(splitPaper(square,startX+n//2,startY+n//2,n//2))
    for i, j in tmp:
      white += i
      blue += j
  elif std == 0 :
    white += 1
  else :
    blue += 1
  return white, blue

white, blue = splitPaper(square,0,0,n)
print(white)
print(blue)
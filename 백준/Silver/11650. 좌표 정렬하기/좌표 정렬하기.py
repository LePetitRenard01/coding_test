from sys import stdin
dots = [list(map(int, line.split())) for line in stdin.readlines()[1:]]
dots.sort(key=lambda dot : (dot[0],dot[1]))

for dot in dots:
  print(*dot)
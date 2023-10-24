from sys import stdin
dots = [list(map(int, line.split())) for line in stdin.readlines()[1:]]
dots.sort(key=lambda dot : (dot[1]+dot[0]/1_000_000))

for dot in dots:
  print(*dot)
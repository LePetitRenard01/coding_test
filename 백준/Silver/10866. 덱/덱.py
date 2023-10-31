from sys import stdin
from collections import deque
n = int(stdin.readline())
ins = stdin.read().splitlines()
deq = deque()
for i in ins:
  i = i.split()
  if i[0]=='push_front':
    deq.appendleft(i[1])
  elif i[0]=='push_back':
    deq.append(i[1])
  elif i[0]=='pop_front':
    print(deq.popleft() if deq else -1)
  elif i[0]=='pop_back':
    print(deq.pop() if deq else -1)
  elif i[0]=='size':
    print(len(deq))
  elif i[0]=='empty':
    print(0 if deq else 1)
  elif i[0]=='front':
    print(deq[0] if deq else -1)
  elif i[0]=='back':
    print(deq[-1] if deq else -1)
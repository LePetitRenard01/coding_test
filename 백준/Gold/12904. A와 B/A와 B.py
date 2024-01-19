if __name__ == '__main__':
  s = input()
  t = list(map(str,input()))
  dp = set()

  while t :
    if t[-1] == 'B':
      t.pop()
      t.reverse()
    else:
      t.pop()
    dp.add(tuple(t))
  
  print(1 if tuple(s) in dp else 0)
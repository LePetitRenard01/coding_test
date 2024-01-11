if __name__ == '__main__':
  s = int(input())
  num = [1]
  rest = s - 1
  i = 2
  while rest :
    if rest // i == 1:
      i = rest
    if i > rest :
      rest += num.pop()
    num.append(i)
    rest -= i
    i += 1
  print(len(num))
def solution():
  n = int(input())
  share = n // 5
  rest = n % 5
  res = 0

  if n == 1 or n == 3:
    print(-1)
    return
  
  if rest % 2 == 1:
    res += (rest + 5) // 2
    share -= 1
  else:
    res += rest // 2
  
  res += share
  print(res)

if __name__ == '__main__':
  solution()
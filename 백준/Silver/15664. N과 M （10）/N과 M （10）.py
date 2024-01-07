if __name__ == '__main__':
  n, m = map(int, input().split())
  array = list(map(int,input().split()))
  stack = []
  idx = []
  record = set()

  def make_stack(i):
    if len(stack) == m and tuple(stack) not in record:
      print(*stack)
      record.add(tuple(stack))
      return
    for j in range(i+1,n):
      if j in idx:
        continue
      stack.append(array[j])
      idx.append(j)
      make_stack(j)
      stack.pop()
      idx.pop()

  array.sort()
  make_stack(-1)
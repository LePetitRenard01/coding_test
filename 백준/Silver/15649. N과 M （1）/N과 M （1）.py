def make_stack(arr,stack, m):
  if len(stack) == m:
    print(*stack)
    return
  for i in arr:
    if not i in stack:
      stack.append(i)
      make_stack(arr,stack, m)
      stack.pop()

n, m = map(int,input().split())

arr = [i for i in range(1,n+1)]
stack = []
make_stack(arr,stack, m)
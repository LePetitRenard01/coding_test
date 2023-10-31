from sys import stdin
n = int(stdin.readline())
arr = [int(i) for i in stdin.read().splitlines()]
stack = []
result = []
now = 0 
arr_i = 0
length = len(arr)
while now <= n and arr_i < len(arr):
  if now < arr[arr_i]:
    now+=1
    stack.append(now)
    result.append('+')
  elif now == arr[arr_i]:
    stack.pop()
    result.append('-')
    arr_i += 1
  elif now > arr[arr_i] and stack:
    previous = stack.pop()
    if previous == arr[arr_i]:
      result.append('-')
      arr_i += 1
    else:
      result.clear()
      result.append('NO')
      break
  else:
    result.clear()
    result.append('NO')
    break
print("\n".join(result))
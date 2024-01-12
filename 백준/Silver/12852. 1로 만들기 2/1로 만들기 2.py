if __name__ == '__main__':
  n = int(input())
  operation = [i for i in range(n,-1, -1)]
  parent = [i for i in range(1,n+2)]
  operation[n] = 0
  parent[n] = n
  for i in range(n,1, -1):
    if i % 3 == 0 and operation[i//3] > operation[i] + 1:
      operation[i//3] = operation[i] + 1
      parent[i//3] = i
    if i % 2 == 0 and operation[i//2] > operation[i] + 1:
      operation[i//2] = operation[i] + 1
      parent[i//2] = i
    if operation[i-1] > operation[i] + 1:
      operation[i-1] = operation[i] + 1
      parent[i-1] = i
  
  stack = []
  i = 1
  while i != parent[i]:
    stack.append(i)
    i = parent[i]
  stack.append(n)
  stack.reverse()
  print(operation[1])
  print(*stack)
import math
if __name__ == '__main__':
  n = int(input())
  a = list(map(int,input().split()))
  left_operator = list(map(int,input().split())) # + - * /
  operator = ['+','-','*','/']
  result = [float('-INF'), float('INF')] #최대, 최소
  stack = []
  def getResult(target):
    result[0] = max(result[0], target)
    result[1] = min(result[1], target)
  def calculate(current):
    if current == len(a)-1:
      getResult(stack[current])
    for i in range(4):
      if left_operator[i] == 0:
        continue
      if i == 0: tmp = stack[current] + a[current+1]
      elif i == 1: tmp = stack[current] - a[current+1]
      elif i == 2: tmp = stack[current] * a[current+1]
      elif i == 3: 
        tmp = stack[current] // a[current+1]
        if stack[current]*a[current+1] < 0 and stack[current] % a[current+1] != 0:
          tmp += 1
      left_operator[i] -= 1
      stack.append(tmp)
      calculate(current+1)
      left_operator[i] += 1
      stack.pop()
  
  stack.append(a[0])
  calculate(0)
  print(result[0])
  print(result[1])
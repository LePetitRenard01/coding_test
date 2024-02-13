# a+b*c = abc*+
# a*b+c = ab*c+
# a+b-c = ab+c-
# current operator <= previous operator : print all of previous ones
operator = ['+','-', '*','/','(',')']
def level(c):
  if c in ('*','/'):
    return 2
  return 1

def solution():
  s = input()

  stack = []
  res = []

  for i in s:
    if i not in operator:
      res.append(i)
    elif i == '(':
      stack.append(i)
    elif i == ')':
      while stack and stack[-1] != '(':
        res.append(stack.pop())
      stack.pop()
    elif not stack or level(i) > level(stack[-1]):
      stack.append(i)
    else :
      while stack and level(i) <= level(stack[-1]):
        if stack[-1] == '(':
          break
        res.append(stack.pop())
      stack.append(i)

  while stack:
    res.append(stack.pop())
  
  print(''.join(res))

if __name__ == '__main__':
  solution()
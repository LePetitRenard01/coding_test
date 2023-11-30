def multiply(a,b,c):
  if b == 1:
    return a % c
  res = multiply(a,b//2,c) ** 2 % c
  if b%2 == 1:
    res *= a
    res %= c
  return res

a, b, c  = map(int, input().split())
print(multiply(a,b,c))
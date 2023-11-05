n, k = map(int,input().split())

p = -1
table = [i for i in range(1, n+1)]
result = []
while table :
  p = (p + k) % n
  n -= 1
  result.append(table.pop(p))
  p += -1
print("<" + ", ".join(str(i) for i in result) + ">")
n = int(input())
length = [0]*(n+1)
length[1] = 1
if n > 1 : length[2] = 2
for i in range(3, n+1):
  length[i] = (length[i-1] + length[i-2])%15746
print(length[n])
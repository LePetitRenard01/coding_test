from sys import stdin
num = list(int(line) for line in stdin.readlines()[1:])
length = len(num)
print(round(sum(num)/length))
num.sort()
print(num[length//2])


count = [0]*8001
for i in num:
  if i < 0:
    i = -i + 4000
  count[i]+=1
most_frequent = []
for i,n in enumerate(count):
  if n == max(count):
    if i > 4000:
      i = -(i - 4000)
    most_frequent.append(i)
most_frequent.sort()
print(most_frequent[0] if len(most_frequent)==1 else most_frequent[1])

print(max(num)-min(num))
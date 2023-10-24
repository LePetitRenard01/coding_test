n = int(input())
x = list(map(int,input().split()))
scope = list(set(x))

scope.sort()

# x를 압축한 좌표값으로 바꾼 후
dict = {}
for i,dot in enumerate(scope):
  dict[dot] = i
# 출력하기

for i in x:
  print(dict[i], end=' ')
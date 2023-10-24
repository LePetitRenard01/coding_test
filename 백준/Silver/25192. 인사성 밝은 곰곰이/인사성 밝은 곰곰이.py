import sys
fi = sys.stdin.read().splitlines()[2:]
gomgom = set()
sum=0
for i in fi:
  if i == "ENTER":
    sum+=len(gomgom)
    gomgom.clear()
  else:
    gomgom.add(i)
sum+=len(gomgom)
print(sum)
table = []
n,k = map(int,input().split())
for i in range(1,n+1):
  table.append(i)

i=0
result=[]
while n!=0:
  if i==-1 : i=0
  i = (i+k)%n-1
  result.append(table.pop(i))
  n+=-1
print("<"+', '.join(map(str,result))+">")
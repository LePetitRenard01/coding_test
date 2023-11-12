import copy
n = int(input())
dist = list(map(int,input().split()))
price = [(i,p)for i,p in enumerate(list(map(int,input().split())))]

result = 0
while price :
  cprice = copy.deepcopy(price)
  cprice.sort(key = lambda x : x[1])
  result += sum(dist[cprice[0][0]::])*cprice[0][1]
  price = price[:cprice[0][0]]
  dist = dist[:cprice[0][0]]

print(result)
how_many = int(input())
aliquot = list(map(int,input().split()))

print(min(aliquot)*max(aliquot))
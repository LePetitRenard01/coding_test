from sys import stdin
string = stdin.read().splitlines()
n = int(string[0])
name = [[] for _ in range(202)]
for i in range(1,n+1):
  member = string[i].split()
  name[int(member[0])].append(member[1])

for age, member in enumerate(name):
  for i in member:
    print(age, i)
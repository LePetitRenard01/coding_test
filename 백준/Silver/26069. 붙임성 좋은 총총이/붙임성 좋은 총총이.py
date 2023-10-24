from sys import stdin
record = [string for line in stdin.read().splitlines()[1:] for string in line.split()]
start = record.index("ChongChong")
infected = {"ChongChong"}
for i in range(start, len(record)):
  if record[i] in infected:
    if i%2==0: infected.add(record[i+1])
    else : infected.add(record[i-1])

print(len(infected))
from sys import stdin

def find_prime(m):
  sqrt = int(2*m**0.5)+1
  for k in range(3,sqrt,2):
    # 방법1. target을 일일이 3~root(target)까지 다 나눠보고 소수인지 확인하기
    # 방법2. n = 3~ sqrt(target)일 때 n*1 부터 n*m//n까지 다 prime배열에서 false로 전환
    j = 3
    while j < 2*m//k+1:
      prime[k*j] = False
      j+=2

a = list(map(int,stdin.read().splitlines()[:-1]))
m = max(a)
prime = [False, False, True] + [True if i%2!=0 else False for i in range(3, m*2+1)]
find_prime(m)
for i in a:
  print(prime[i+1:2*i+1].count(True))
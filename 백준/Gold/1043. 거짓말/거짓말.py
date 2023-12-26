# 진실 set()
# 진실 set()이 더 늘지 않을 때까지 경우 돌려서 진실을 알고 있거나 알게 될 사람들 확정해
# 진실 set에 없는 사람들로만 구성되어있으면 그 파티 참석해

if __name__ == '__main__':
  n, m = map(int,input().split())
  truth = list(map(int,input().split()))
  party = []
  for _ in range(m):
    party.append(set(map(int,input().split()[1:])))
  if truth[0] == 0:
    print(m)
  
  else:
    truth = set(truth[1:])    
    previous_cnt = len(truth)
    #결국 진실 알게 되는 사람 set 구하기
    countedParty = [False] * m
    while True :
      for i in range(m):
        if countedParty[i]:
          continue
        for j in party[i]:
          if j in truth:
            for k in party[i]:
              truth.add(k)
            countedParty[i] = True
            break
      if previous_cnt == len(truth):
        break
      previous_cnt = len(truth)
    #갈 수 있는 파티 수 구하기
    party_cnt = 0
    for i in range(m):
      canLie = True
      for j in party[i]:
        if j in truth:
          canLie = False
          break
      if canLie:
        party_cnt += 1
    
    print(party_cnt)

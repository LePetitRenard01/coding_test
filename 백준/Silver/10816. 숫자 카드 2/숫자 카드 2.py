import sys
fi = sys.stdin.readline
#dict 써서 key : 카드 value:장 수
possess = dict()
fi()
cards = list(map(int,fi().split()))
for card in cards:
  if card in possess:
    possess[card] = possess[card]+1
  else:
    possess[card] = 1
fi()
m = list(map(int,fi().split()))
for i in m:
  print(possess[i] if i in possess else 0, end=' ')
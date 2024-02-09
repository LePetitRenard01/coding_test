# 테이프 : 항상 구멍에서부터 막음
# 테이프 영향권 : 구멍 ~ 구멍 + 테이프 길이 - 1
def solution():
  n, l = map(int, input().split())
  hole = list(map(int, input().split()))
  hole.sort()
  res = 0
  realm = 0
  for i in hole:
    if realm >= i:
      continue
    realm = i + l - 1
    res += 1
    if realm > 1000:
      break
  print(res)

if __name__ == '__main__':
  solution()
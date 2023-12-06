if __name__ == '__main__':
  n, k = map(int,input().split())
  temp = list(map(int,input().split()))
  cur_sum = sum(temp[0:k])
  max_sum = cur_sum
  for i in range(n-k):
    cur_sum = cur_sum - temp[i] + temp[i+k]
    if max_sum < cur_sum:
      max_sum = cur_sum
  print(max_sum)
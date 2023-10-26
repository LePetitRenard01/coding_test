from sys import stdin
import math
a = stdin.read().splitlines()
for i in a[1:]:
  is_palindrome = 1
  count=0
  for j in range(0,len(i)//2+1):
    count+=1
    if not i[j] == i[-j-1]:
      is_palindrome = 0
      break
  print(is_palindrome, count)
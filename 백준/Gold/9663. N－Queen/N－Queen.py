if __name__ == '__main__':
  n = int(input())

  way = 0 #놓는 가지 수
  col = set()
  pos_diag = set()
  neg_diag = set()
  def put_queen(r):
    for i in range(n):
      if (i not in col
      and r+i not in pos_diag
      and r-i not in neg_diag):
        if r == n-1:
          global way
          way+=1
          continue
        col.add(i)
        pos_diag.add(r+i)
        neg_diag.add(r-i)
        put_queen(r+1)
        col.remove(i)
        pos_diag.remove(r+i)
        neg_diag.remove(r-i)
  put_queen(0)
  print(way)
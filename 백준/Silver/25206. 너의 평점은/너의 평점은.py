average, sum = 0,0
operand=0
for i in range(20):
  grade = list(map(str,input().split()))
  if grade[2]=='P' : continue
  else:
    score = 0
    if grade[2]=='A+' : score = 4.5
    elif grade[2]=='A0' : score = 4.0
    elif grade[2]=='B+' : score = 3.5
    elif grade[2]=='B0' : score = 3.0
    elif grade[2]=='C+' : score = 2.5
    elif grade[2]=='C0' : score = 2.0
    elif grade[2]=='D+' : score = 1.5
    elif grade[2]=='D0' : score = 1.0
    elif grade[2]=='F' : score = 0.0
    operand+=float(grade[1])
    sum+=float(grade[1])*score
average = sum/operand
print(average)
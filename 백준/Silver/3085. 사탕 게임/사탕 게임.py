from sys import stdin
n = int(input())
board = [[j for j in i] for i in stdin.read().splitlines()]

def swap_right(board, i, j):
    if (0<=j+1<n and board[i][j] != board[i][j+1]):
        board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
        return True
    return False
def swap_downward(board, i, j):
    if (0<=i+1<n and board[i][j] != board[i+1][j]):
        board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
        return True
    return False
def count_vertical(board,j):
    total = 0
    previous = board[0][j]
    maximum = 0
    for i in range(n):
        if previous == board[i][j]:
            total+=1
        else:
            previous = board[i][j]
            total = 1
        if maximum <= total :
            maximum = total
    return maximum
def count_horizontal(board,i):
    total = 0
    previous = board[i][0]
    maximum = 0
    for j in range(n):
        if previous == board[i][j]:
            total+=1
        else:
            previous = board[i][j]
            total = 1
        if maximum <= total :
            maximum = total
    return maximum

maximum = 0
for i in range(n):
    maximum = max(maximum,count_vertical(board, i),count_horizontal(board,i))


for i in range(n):
    for j in range(n):
        tmp1, tmp2 = 0,0
        if swap_right(board,i,j):
            tmp1 = max((count_horizontal(board,i), count_vertical(board,j), count_vertical(board,j+1)))
            swap_right(board,i,j)
        if swap_downward(board,i,j):
            tmp2 = max((count_vertical(board,j),count_horizontal(board,i),count_horizontal(board,i+1)))
            swap_downward(board,i,j)
        maximum = max((maximum, tmp1, tmp2))
        if maximum == n:
            break
    if maximum == n:
        break
print(maximum)
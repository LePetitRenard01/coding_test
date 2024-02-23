#knapsack
def solution():
    n = int(input())
    cost = [0]+list(map(int, input().split()))
    joy = [0]+list(map(int, input().split()))

    dp = [[0 for _ in range(100)] for _ in range(n+1)]

    for i in range(1, n+1):
        for j in range(100):
            if cost[i] <= j : #해당 체력에서 만나도 괜찮은 사람
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-cost[i]] + joy[i])
            else:
                dp[i][j] = dp[i-1][j]
    print(dp[-1][-1])

if __name__ == '__main__':
    solution()
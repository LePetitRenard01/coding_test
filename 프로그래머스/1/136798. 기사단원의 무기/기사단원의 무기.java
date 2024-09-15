class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] factor = new int[number + 1];
        
        // 약수 구하기 (효율적으로)
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    factor[i]++; // j는 i의 약수
                    if (j != i / j) {
                        factor[i]++; // i / j도 i의 약수 (j와 다를 때만)
                    }
                }
            }
        }
        
        // 공격력 계산하기
        for (int i = 1; i <= number; i++) {
            if (factor[i] <= limit) {
                answer += factor[i];
            } else {
                answer += power;
            }
        }
        
        return answer;
    }
}

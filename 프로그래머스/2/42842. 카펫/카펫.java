import java.lang.Math;
class Solution {
    public int[] solution(int brown, int yellow) {
        //x*y = yellow
        //(x+2)*(y+2) = brown + yellow
        //xy +2 (x+y) + 4 = brown + xy => x+y = brown/2 - 2
        int[] answer = new int[2];
        for (int i = 1; i < Math.sqrt(yellow)+1; i++){
            if (yellow % i != 0)
                continue;
            int x = Math.max(i, yellow/i);
            int y = Math.min(i, yellow/i);
            if(x+y == brown/2-2){
                answer[0] = x+2;
                answer[1] = y+2;
                break;
            }
        }
        return answer;
    }
}
import java.lang.Math;
class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        while (n>0){
            sb.append(n%3);
            n/= 3;
        }
        System.out.println(sb);
        for(int i = 0; i < sb.length();i++){
            int d = sb.charAt(sb.length()-1-i)-'0';
            answer += Math.pow(3,i) * d;
        }
        return answer;
    }
}
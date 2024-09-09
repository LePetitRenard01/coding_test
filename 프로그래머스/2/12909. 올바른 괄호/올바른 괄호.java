import java.util.StringTokenizer;
class Solution {
    boolean solution(String s) {
        int bracket = 0;
        for(char c : s.toCharArray()){
            if(c=='(')
                bracket++;
            else
                bracket--;
            if(bracket<0)
                break;
        }
        
        return (bracket==0)?true:false;
    }
}
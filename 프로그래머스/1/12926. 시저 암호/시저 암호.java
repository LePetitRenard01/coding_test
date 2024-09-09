import java.lang.Character;
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c==' '){
                sb.append(c);
                continue;
            }
            if (Character.isUpperCase(c))
                sb.append((char)((c+n-'A')%26+'A'));
            else
                sb.append((char)((c+n-'a')%26+'a'));
                
        }
        return sb.toString();
    }
}
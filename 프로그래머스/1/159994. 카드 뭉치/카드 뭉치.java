import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        ArrayDeque<String> a1 = new ArrayDeque<>();
        a1.addAll(Arrays.asList(cards1));
        ArrayDeque<String> a2 = new ArrayDeque<>();
        a2.addAll(Arrays.asList(cards2));
        
        for(String s: goal){
            if(!a1.isEmpty() && a1.peek().equals(s)){
                a1.removeFirst();
            }
            else if(!a2.isEmpty() && a2.peek().equals(s)){
                a2.removeFirst();
            }
            else
                return "No";
        }
        
        return "Yes";
    }
}
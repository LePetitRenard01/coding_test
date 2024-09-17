import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++){
            map.put(players[i],i);
        }
        for (String c : callings){
            int idx = map.get(c);
            map.put(c,idx-1);
            String front = answer[idx-1];
            map.put(front, idx);
            
            answer[idx-1] = c;
            answer[idx] = front;
        }
        return answer;
        
    }
}
import java.util.HashMap;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int answer[] = new int[targets.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        configMap(keymap, map);
        press : for (int i = 0; i < targets.length; i++){
            int sum = 0;
            for (char c : targets[i].toCharArray()){
                if (!map.containsKey(String.valueOf(c))){
                    answer[i] = -1;
                    continue press;
                }
                sum += map.get(String.valueOf(c));
            }
            answer[i] = sum;
        }
        
        return answer;
    }
    
    void configMap(String[] keymap, HashMap<String,Integer> map){
        //map에 1. key알파벳이 없거나 2. value가 이번 것이 더 작으면 update
        for (String s : keymap){
            for (int i=0; i < s.length();i++){
                String now = s.substring(i,i+1);
                if(!map.containsKey(now))
                    map.put(now, i+1);
                else if (map.get(now) > i+1)
                    map.replace(now, i+1);
            }
        }
    } 
}
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> food = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        
        for (int i : scoville){
            food.add(i);
        }

        int res = 0;

        while(food.size() > 1){
            if(food.peek() >= K)
                break;
            int a = food.poll();
            int b = food.poll();
            food.add(a+b*2);
            res++;
        }
        
        return food.peek() >= K ? res : -1;
    }
}
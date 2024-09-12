import java.util.*;
class Solution {
    public int solution(int[] nums) {
        // 전체 종류가 몇 종류냐? => 전체 > n/2 ? n/2 : 전체
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(Integer.valueOf(i));
        return (set.size() > n/2)? n/2 : set.size();
    }
}
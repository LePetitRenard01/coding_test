import java.lang.Math;
class Solution {
    public long solution(long n) {
        long a = (int)Math.sqrt(n);
        if(a*a==n)
            return (a+1)*(a+1);
        return -1;
    }
}
// https://leetcode.com/problems/count-collisions-of-monkeys-on-a-polygon

class Solution {
    public int monkeyMove(int n) {
        
        // to solov (2^n-2)%m
        long mod = (long)1e9+7;
        int res = (int)fastPow(2, n, mod);
        return (int)((res - 2 + mod) % mod);
    }
    
    private long fastPow(long a, long b, long m){
        long ans = 1;
        while(b>0){
            if(b % 2 == 1)
                ans = (ans * a)%m;;
            b >>= 1;
            a =  (a*a)%m;
        }
        return ans;
    }
}
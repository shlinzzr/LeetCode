// https://leetcode.com/problems/count-collisions-of-monkeys-on-a-polygon

class Solution {
    public int monkeyMove(int n) {
        
        // to solov (2^n-2)%m
        
        return fastPow(2, n, (int)1e9+7)-2;
    }
    
    private int fastPow(int a, int b, int m){
        
        int ans = 1;
        while(b>0){
            if(b % 2 == 1)
                ans = (ans * a)%m;;
            b >>= 1;
            a =  (a*a)%m;
        }
        return ans;

        
        
    }
}
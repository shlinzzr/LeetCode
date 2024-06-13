// https://leetcode.com/problems/factorial-trailing-zeroes

class Solution {
    public int trailingZeroes(int n) {
        
        int res = 0;
        int mod5 =0, mod2=0;
        for(int i=1; i<=n; i++){
            if(i%10==0)
                res++;
            else if(i%5==0){
                mod5++;
                
            }else if(i%2==0)
                mod2++;
        }
        
        return res + Math.min(mod2, mod5);
        
    }
}
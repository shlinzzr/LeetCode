// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        
        int[] res = new int[n+1];
         
        
        // 0 ->   0 
        // 1 ->   1 -> dp[n-1] +1 =1
        // 2 ->  10 -> dp[n-2] +1 =1
        // 3 ->  11 -> dp[n-2] +1 =2
        // 4 -> 100 -> dp[n-4] +1 =1
        //.     ....
    
        
        // dp[i] = dp[i-offset]  +1;
        
        int offset = 1;
        
        int cnt = 0; 
        for(int i=1; i<=n; i++){
            cnt++;
            res[i] = res[i-offset]+1;
            if(cnt==offset){
                offset*=2;    
                cnt=0;
            }
        }
        
        
        return res;
    }
}
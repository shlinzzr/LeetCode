// https://leetcode.com/problems/minimum-cost-to-equalize-array

class Solution {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
       
        
        
        int max = 0;
        for(int n : nums)
             max= Math.max(max, n);
        
        int len = nums.length;
        int[] need = new int[len];
        
        for(int i=0; i<len; i++){
            need[i] = max - nums[i];
        }
        
        int M = (int) 1e9+7;
        long[] dp = new long[len+1]; // minimum cost to make the first i element zero
        dp[1] = need[0]*cost1 %M;
        
//         if(need[i-1]==0) dp[i] = dp[i-1]
//         if(need[i-1]>0)  dp[i] = Math.min( dp[i], dp[i-1]-cost1+ cost2);
        //  [0, 3], cost1 = 5, cost2 = 2
        // dp[1] = 0
        // dp[2] = 20 - 5 +2
        
        
        for(int i=2; i<=len; i++){
            dp[i]= dp[i-1];
            
            if(need[i-1]>0){
                
                int cnt = bs(dp[i-1], cost1, cost2, 0, need[i-1]);
                
                dp[i] += need[i-1]*cost1 %M;
                
                System.out.println(dp[i]+" " +cnt);
                dp[i] = Math.min(dp[i], (dp[i]-(cost1*cnt%M)+ (cost2*cnt%M))%M);
                
            }
        }
        
        return (int)dp[len]%M;
        
        
        
        
             
             
    }
    
// 0 , 5, 2, 0, 3
    
    
    private int bs(long val, int cost1, int cost2, int st, int ed){
         int M = (int) 1e9+7;
        while(st<ed){ //0, 3
            
            int m = st+(ed-st)/2; // 1
            
            long v = val-(cost1*val)%M + cost2*val%M;//
            
            
            // if(v==0) return m;
            
            if(v<0){
                st=m+1; ///1
            }else{
                ed=m;
            }
        }
        
        return st;
        
    }
}
// https://leetcode.com/problems/maximize-the-profit-as-the-salesman

class Solution {
    
    int[] dp = new int[100005];
    
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Map<Integer, int[]> map = new HashMap<>();
        for(List<Integer> of: offers){
            map.put(of.get(1)+1, new int[]{of.get(0)+1, of.get(2)}); // <ed, int[]{st, gold}>
        }
        
        for(int i=1; i<=n; i++){
            
            dp[i] = dp[i-1];
            for(Map.Entry<Integer, int[]>en : map.entrySet()){
                
                int ed = en.getKey();
                int st = en.getValue()[0];
                int val = en.getValue()[1];
                
                dp[i] = Math.max(dp[i], dp[st-1]+val);
            }
            
            
        }
        
        return dp[n];
        
        
        
        
    }
    
    /* x x x x [j x x i]
    
    dp[i] = dp[j1-1] + val
            dp[j2-1] + val
            ...
            dp[i-1] (no sale = prev)
            find max*/
}
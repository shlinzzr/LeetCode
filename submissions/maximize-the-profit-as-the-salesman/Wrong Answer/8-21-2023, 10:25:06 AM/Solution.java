// https://leetcode.com/problems/maximize-the-profit-as-the-salesman

class Solution {
    
    int[] dp = new int[100005];
    
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {

        
        int len = offers.size();
        
        int[][] jobs = new int[len][3];
        
        for(int i=0; i<len; i++){
            List<Integer> of = offers.get(i);
            int[] arr = new int[]{of.get(0), of.get(1), of.get(2)};
            jobs[i] = arr;
        }
        
        Arrays.sort(jobs, (a,b) ->  a[1]==b[1]? b[2]-a[2] : a[1]-b[1]);
        
        int dp[] = new int[n+1];
        dp[0] = jobs[0][2];
        for(int i=1; i<=len; i++){
            dp[i] = Math.max(jobs[i-1][2], dp[i-1]);
            
            for(int j=i-1; j>0; j--){
                if(jobs[j-1][1]<=jobs[i-1][0]){
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i-1][2]);
                    break;
                }
            }
        }
        
        
        return dp[len];
        
        
        
        
    }
    
    /* x x x x [j x x i]
    
    dp[i] = dp[j1-1] + val
            dp[j2-1] + val
            ...
            dp[i-1] (no sale = prev)
            find max*/
}
// https://leetcode.com/problems/distinct-subsequences

class Solution {
    
     int res = 0;
    
    public int numDistinct(String s, String t) {
        
        // helper(s, t, 0, 0);
        // return res;
        
        //  huifeng wodage https://www.youtube.com/watch?v=-Q6XfyMiYUc 
        int m = s.length();
        int n = t.length();
        
        
        int[][] dp = new int[m+1][n+1];
        
        
        for(int i=0; i<=m; i++){
            dp[i][0] = 1;
        }
        
        for(int i=1; i<=m; i++){
            
            for(int j=1; j<=n; j++){
                
                dp[i][j] = dp[i-1][j];
                
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]+=dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
        
        
        
        
        
        
    }
    
    
//     private void helper(String s,  String t, int s_idx, int t_idx){
        
//         if(t_idx==t.length()){
//             res++;
//             return ;
//         }
            
        
//         for(int i=s_idx; i<s.length(); i++){
            
//             if(s.charAt(i)==t.charAt(t_idx)){
//                 helper(s, t, i+1, t_idx+1);
//             }
//         }
//     }
    
    
    
    
    
}
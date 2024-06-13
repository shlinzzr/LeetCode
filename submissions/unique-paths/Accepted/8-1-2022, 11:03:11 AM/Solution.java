// https://leetcode.com/problems/unique-paths

// class Solution {
//     public int uniquePaths(int m, int n) {
//         if((m==2 && n==1) ||( n==2&&m==1))
//             return 1;
        
//         if(m==2 && n==2)
//             return 2;
            
            
//         int totalpath = 0;
        
//         for(int i=0; i<n; i++){
//             for(int j=0; j<m; j++){
                
//                 if(i==0 && j==0)        
//                     continue;
                
//                 totalpath += uniquePaths(m-j, n-i);
                
//             }
//         }
        
//         return totalpath;
        
//     }
// }

class Solution {
    public int uniquePathsUtil(int m, int n, int[][] dp) {
        if(m == 1 || n == 1) return 1;
        if(dp[m][n] != 0)
            return dp[m][n];
        return dp[m][n] = uniquePathsUtil(m-1, n, dp) + uniquePathsUtil(m, n-1, dp);
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        return uniquePathsUtil(m, n, dp);
                
    }
}
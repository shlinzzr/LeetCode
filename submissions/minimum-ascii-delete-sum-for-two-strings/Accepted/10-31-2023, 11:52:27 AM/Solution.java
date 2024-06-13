// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];// dp[ 刪了幾個i char ] [ 刪了幾個j char ]

        for (int i = 1; i <= m; i++) //有幾個char 就有幾個op, 每個op根據ascii有不同成本
            dp[i][0] = dp[i-1][0]+s1.charAt(i-1);
        
        for (int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j-1]+s2.charAt(j-1);
        

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; // 如果char equal 可以bypass
                }else{

                    int up = dp[i-1][j] + s1.charAt(i-1); // 刪up
                    int left = dp[i][j-1] + s2.charAt(j-1); // 刪left
                    dp[i][j] = Math.min(up, left); //看刪除up還是left成本比較小
                }

            }
        }

        return dp[m][n];
            
    }
}
// https://leetcode.com/problems/delete-operation-for-two-strings

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){ // 有幾個char 就要幾個operation
            dp[i][0] = i;
        }

        for(int j=0; j<=n; j++){
            dp[0][j]= j;
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){

                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];

                }else{
                    int upleft = dp[i-1][j-1];
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];

                    dp[i][j] = 1+ Math.min(upleft, Math.min(up, left));
                }
            }
        }

        return dp[m][n];
        
    }
}
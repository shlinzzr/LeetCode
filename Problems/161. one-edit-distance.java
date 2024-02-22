// https://leetcode.com/problems/one-edit-distance

class Solution {
    public boolean isOneEditDistance(String s, String t) {
         int len1 = s.length();
         int len2 = t.length();

         int[][] dp = new int[len1+1][len2+1];

         for(int i=0; i<=len1; i++){
             dp[i][0] = i;
         }

         for(int j=0; j<=len2; j++){
             dp[0][j] = j;
         }


         for(int i=1; i<=len1; i++){
             for(int j=1; j<=len2; j++){

                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    int upleft = dp[i-1][j-1];

                    dp[i][j] = 1 + Math.min(up, Math.min(left, upleft));
                }
             }
         }

         return dp[len1][len2]==1;

    }
}
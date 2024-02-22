// https://leetcode.com/problems/edit-distance

class Solution {
    public int minDistance(String word1, String word2) {

        //https://www.youtube.com/watch?v=MiqoA-yF-0M&t=975s

        int len1= word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];

        for(int i=0; i<=len1; i++){
            dp[i][0] = i; // basic insertion
        }

        for(int j=0; j<=len2; j++){
            dp[0][j] = j;  // basic insertion
        }

        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];

                }else{
                    int upleft = dp[i-1][j-1];
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];

                    dp[i][j] = 1 + Math.min(upleft, Math.min(up, left));
                }
            }
        }

        return dp[len1][len2];

    }
}
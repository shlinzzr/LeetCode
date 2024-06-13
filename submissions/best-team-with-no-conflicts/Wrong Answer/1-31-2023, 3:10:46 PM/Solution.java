// https://leetcode.com/problems/best-team-with-no-conflicts

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        int[][] pairs = new int[len][2]; // ages, scores;
        
        for(int i=0; i<len; i++){
            pairs[i][0] = ages[i];
            pairs[i][1] = scores[i];
        }
        
        Arrays.sort(pairs, (a,b) -> a[0]==b[0]?a[1]-b[1] : a[0]-b[0]);
        
        int[] dp = new int[len];
        dp[0] = pairs[0][1];
        
        for(int i=1; i<len; i++){
            
            dp[i] = pairs[i][1];
            for(int j=0; j<i; j++){
                dp[i]=Math.max(dp[i], dp[j]+pairs[i][1]);
            }
        }

        int ret= 0;
        for(int i=0; i<len;i++){
            ret = Math.max(ret, dp[i]);
        }
        
        return ret;
        
        
    }
}
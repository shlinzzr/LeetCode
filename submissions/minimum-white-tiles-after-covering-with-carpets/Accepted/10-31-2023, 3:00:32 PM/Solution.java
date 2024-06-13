// https://leetcode.com/problems/minimum-white-tiles-after-covering-with-carpets

class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = floor.length(); 
        int n = numCarpets;


        char[] arr = floor.toCharArray();
        int[][] dp = new int[m+1][n+1]; // dp [# of tiles][# of carpets]

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){

                dp[i][j]= Integer.MAX_VALUE/2;

                if(j==0){ // when not using carpet
                    dp[i][j] = dp[i-1][j] + (arr[i-1]=='1' ? 1 : 0);

                }else if(i<= carpetLen){ // cover all floor
                    dp[i][j] = 0;

                }else{

                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + (arr[i-1]=='1' ? 1 : 0));
                    dp[i][j] = Math.min(dp[i][j], dp[i-carpetLen][j-1]);

                }

            }
        }
        return dp[m][n];
    }
}
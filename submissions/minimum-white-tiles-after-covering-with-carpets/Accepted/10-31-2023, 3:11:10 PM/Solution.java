// https://leetcode.com/problems/minimum-white-tiles-after-covering-with-carpets

class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = floor.length(); 
        int n = numCarpets;

        char[] arr = floor.toCharArray();
        int[][] dp = new int[m+1][n+1]; // dp [# of tiles][# of carpets]

        // dp定義：走到第 i 個tiles時候用了 j 個carpets 的 minimumWhiteTiles

        for(int i=1; i<=m; i++){ // 考慮第1 ~ m個floor
            for(int j=0; j<=n; j++){ // ***重要*** 考慮0~n個carpets

                dp[i][j]= Integer.MAX_VALUE/2;

                if(j==0){ // when not using carpet, 不能考慮j-1的狀況
                    dp[i][j] = dp[i-1][j] + (arr[i-1]=='1' ? 1 : 0); // 跟i-1 floor相同 + 另外check現在是不是white tile

                }else if(i<= carpetLen){ //考慮j>0的狀況 // cover all floor 
                    dp[i][j] = 0;

                }else{ //考慮j>0, 且 i>carpetLen

                    //1. 不增加carpet -> 跟i-1 floor相同 + 另外check現在是不是white tile
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + (arr[i-1]=='1' ? 1 : 0)); 

                    //2. 增加carpet的時候 -> 就等於 i-carpetLen時的 minimumWhiteTiles
                    dp[i][j] = Math.min(dp[i][j], dp[i-carpetLen][j-1]);

                }

            }
        }
        return dp[m][n];
    }
}
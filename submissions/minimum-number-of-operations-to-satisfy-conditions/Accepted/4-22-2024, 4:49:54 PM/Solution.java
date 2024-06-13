// https://leetcode.com/problems/minimum-number-of-operations-to-satisfy-conditions

class Solution {
    public int minimumOperations(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;

        int[][] dp = new int[w][10]; // choose first j col with selecting p as last num;

        // dp[j][p] = Math.min(dp[j][p], dp[j-1][q] + cost with select p where p!=q

        for(int j=0; j<w; j++){
            Arrays.fill(dp[j], Integer.MAX_VALUE);

            for(int p=0; p<10; p++){
                
                int cost = 0;
                for(int i=0;i<h; i++){
                    cost += (p==grid[i][j]) ? 0 : 1;
                }

                if(j==0){
                    dp[j][p] = cost;
                }else{
                    for(int q =0; q<10; q++){
                        if(p==q) continue;

                        dp[j][p] = Math.min(dp[j][p], dp[j-1][q]+ cost);
                    }   
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int p=0; p<10; p++){
            min = Math.min (dp[w-1][p], min); 
        }
        return min;


        // int[][] cost = new int[w][10];
        // for(int j=0; j<w; j++){
        //     int[] cnt = new int[10];
        //     for(int i = 0; i < h; i++) {
        //         cnt[grid[i][j]]++;
        //     }
        //     for(int k = 0; k < 10; k++) {
        //         cost[j][k] = h-cnt[k];
        //     }
        // }


        // int[][] dp = new int[w][10];
        // for(int k=0; k<10; k++) dp[0][k] = cost[0][k];

        // for(int j=1; j<w; j++) {
        //     for(int p = 0; p < 10; p++) { // prev 0~9
        //         int min = 1000000;
        //         for(int q = 0; q < 10; q++) { // next 0~9
        //             if(p!=q) min = Math.min(min, dp[j-1][q]); //前一個最小的cost
        //         }
        //         dp[j][p] = min + cost[j][p];
        //     }
        // }
        // int ans = Integer.MAX_VALUE;
        // for(int k=0; k<10; k++) ans = Math.min(ans, dpp[w-1][k]);
        
        // return ans;
    }
}
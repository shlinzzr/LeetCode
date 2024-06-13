// https://leetcode.com/problems/cherry-pickup-ii

class Solution {
    public int cherryPickup(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;

        int[][][] dp = new int[h][w][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE); 
            }
        }

        dp[0][0][w-1] = grid[0][0] + grid[0][w-1];

        for(int i=1; i<h; i++){

            for(int c1=0; c1<w; c1++){
                for(int c2=0; c2<w; c2++){

                    for(int a = c1-1; a<=c1+1; a++){
                        for(int b=c2-1; b<=c2+1; b++){

                            if(a<0 || a>=w || b<0 || b>=w) continue;

                            if(c1==c2){
                                dp[i][c1][c2] = Math.max(dp[i][c1][c2], dp[i-1][a][b] + grid[i][c1]);
                            }else{
                                dp[i][c1][c2] = Math.max(dp[i][c1][c2], dp[i-1][a][b]+ grid[i][c1] + grid[i][c2]);
                            }
                        }
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int c1=0; c1<w; c1++){
            for(int c2=0; c2<w; c2++){
                max = Math.max(dp[h-1][c1][c2], max);
            }   
        }
       

       return max;
    }
}
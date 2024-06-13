// https://leetcode.com/problems/cherry-pickup-ii

class Solution {
    public int cherryPickup(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;

        int[][] dp = new int[w][w];
        for(int j=0; j<w; j++){
            Arrays.fill(dp[j], -1); 
        }

        dp[0][w-1] = grid[0][0] + grid[0][w-1];

        for(int i=1; i<h; i++){

            int[][] dpp = new int[w][w];
            for(int j=0; j<w; j++){
                dpp[j] = Arrays.copyOf(dp[j],w);
            }
            

            for(int c1=0; c1<w; c1++){
                for(int c2=0; c2<w; c2++){

                    for(int a = c1-1; a<=c1+1; a++){
                        for(int b=c2-1; b<=c2+1; b++){

                            if(a<0 || a>=w || b<0 || b>=w|| dpp[a][b]==-1) continue;

                            if(c1==c2){
                                dp[c1][c2] = Math.max(dp[c1][c2], dpp[a][b] + grid[i][c1]);
                            }else{
                                dp[c1][c2] = Math.max(dp[c1][c2], dpp[a][b]+ grid[i][c1] + grid[i][c2]);
                            }
                        }
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int c1=0; c1<w; c1++){
            for(int c2=0; c2<w; c2++){
                max = Math.max(dp[c1][c2], max);
            }   
        }
       

       return max;
    }
}
// https://leetcode.com/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip

class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;




        // how to find bottleneck
        // bfs & find single dir node
        // sol : greedy like : 
        // find top-right most v.s. bottom-left most line 
        // if it hit critical point then we've found the point we can flip

        // first we cut tree here 
        for(int i=h-1; i>=0; i--){
            for(int j=w-1; j>=0; j--){

                if(i==h-1 && j==w-1) continue;
                if( (i+1>=h || grid[i+1][j]==0) && (j+1>=w || grid[i][j+1]==0 ))
                    grid[i][j] = 0; // cut tree
            }
        }
        if(grid[0][0]==0) return true;

        
        // second, check top-right most & bottom-left most
        int x1=0, y1=0, x2=0, y2=0;

        // total steps : h-1 + w-1 -1
        for(int i=0; i<h+w-3; i++){
            
            //go down first
            if(y1+1<h && grid[y1+1][x1]==1)
                y1++;
            else 
                x1++;
            
            //go right first
            if(x2+1<w && grid[y2][x2+1]==1){
                x2++;
            }else{
                y2++;
            }

            if(x1==x2 && y1==y2)
                return true;
        }

        return false;


        






        // int[][] dp = new int[h][w];
        // for(int i=0; i<h; i++){
        //     dp[i][0]= i==0? grid[0][0] : dp[i-1][0]+grid[i][0];
        // }

        // for(int j=0; j<w; j++){
        //     dp[0][j] = j==0 ? grid[0][0] = 
        // }

    }
}
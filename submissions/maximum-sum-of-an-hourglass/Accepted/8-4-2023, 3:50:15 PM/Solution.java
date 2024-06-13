// https://leetcode.com/problems/maximum-sum-of-an-hourglass

class Solution {
    public int maxSum(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
     
        
        long max =0 ;
        
        for(int i=0; i+2<h; i++){
            for(int j=0; j+2<w; j++){
                
                //3*3
                int sum = 0;
                for(int r=i; r<i+3; r++){
                    for(int c=j; c<j+3; c++){
                        
                        if(r==i+1 && (c==j || c==j+2))
                            continue;
                        sum+= grid[r][c];
                    }
                }
                
                max = Math.max(max, sum);
            }
        }
        
        return (int)max;
        
        
        
    }
}
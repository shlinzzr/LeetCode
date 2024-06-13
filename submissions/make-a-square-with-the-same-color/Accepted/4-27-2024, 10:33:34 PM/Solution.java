// https://leetcode.com/problems/make-a-square-with-the-same-color

class Solution {
    public boolean canMakeSquare(char[][] grid) {
        
        
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                
                int black=0, w=0;
                for(int a=i; a<i+2; a++){
                    for(int b=j; b<j+2; b++){
                        
                        if(grid[a][b]=='W') w++;
                        else black++;
                        
                    }
                }
                
                if(black>=3 || w>=3) return true;
                
                
            }
        }
        
        return false;
        
    }
}
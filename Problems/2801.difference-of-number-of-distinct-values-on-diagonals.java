// https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        
        int[][] ans = new int[h][w];
        
        for(int i=0; i<h; i++){
            
            for(int j=0; j<w; j++){
                
                ans[i][j] = checkDia(grid, i, j);
            }
        }
        
        return ans;
    }
    
    
    private int checkDia(int[][] grid, int i, int j){
        int h = grid.length;
        int w = grid[0].length;
        
        
        HashSet<Integer> topLeft = new HashSet<>();
        HashSet<Integer> rightBottom = new HashSet<>();
        
        int left=j-1;
        int top=i-1;
        while(left>=0 && top>=0){
            topLeft.add(grid[top--][left--]);
        }
        
        int right = j+1;
        int bottom = i+1;
        while(right<w && bottom<h){
            rightBottom.add(grid[bottom++][right++]);
        }
        
        return Math.abs(topLeft.size()-rightBottom.size());
        
        
    }
}
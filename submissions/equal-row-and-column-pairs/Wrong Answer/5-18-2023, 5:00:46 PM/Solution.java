// https://leetcode.com/problems/equal-row-and-column-pairs

class Solution {
    public int equalPairs(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        
        
        for(int i=0; i<h; i++){
            
            int r =0;
            int c = 0;
            
            for(int j=0; j<w; j++){
                
                r=r*10+grid[i][j];
                c=c*10+grid[j][i];
            }
            
            row.put(r, row.getOrDefault(r,0)+1);
            col.put(c, col.getOrDefault(c,0)+1);
        }
        
        
        
        int cnt=0;
        for(int r : row.keySet()){
            if(col.containsKey(r)){
                cnt+= col.get(r)*row.get(r);
            }
                
        }
    
        return cnt;
        
        
        
    }
}
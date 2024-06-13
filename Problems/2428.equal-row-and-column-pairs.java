// https://leetcode.com/problems/equal-row-and-column-pairs

class Solution {
    public int equalPairs(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        HashMap<String, Integer> row = new HashMap<>();
        HashMap<String, Integer> col = new HashMap<>();
        
        
        for(int i=0; i<h; i++){
            
            String r = "";
            String c = "";
            
            for(int j=0; j<w; j++){
                
                r+=String.valueOf(grid[i][j]) + "_";
                c+=String.valueOf(grid[j][i]) + "_";
            }
            
            row.put(r, row.getOrDefault(r,0)+1);
            col.put(c, col.getOrDefault(c,0)+1);
        }
        
        
        
        int cnt=0;
        for(String r : row.keySet()){
            if(col.containsKey(r)){
                cnt+= col.get(r)*row.get(r);
            }
        }
    
        return cnt;
        
        
        
    }
}
// https://leetcode.com/problems/delete-greatest-value-in-each-row

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        // boolean [][] bool = new boolean[h][w];
        
        
        List<int[]> list = new ArrayList<>();
        
        int res = 0;
        
        for(int i=0; i<h; i++){
            
            int[] row= grid[i];
            Arrays.sort(row);
            list.add(row);
        }
        
        
      
        for(int j=0; j<w; j++){
            int max = 0;
            for(int i=0; i<h; i++){
                max = Math.max(max , list.get(i)[j]);
            }
            
            // System.out.println(max);
            res+=max;
        }
        
        return res;
        
    }
}
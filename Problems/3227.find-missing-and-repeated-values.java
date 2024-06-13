// https://leetcode.com/problems/find-missing-and-repeated-values

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int h = grid.length;
        int w= grid[0].length;
        
        
        Set<Integer> set2 = new HashSet<>();
        
         for(int i=0;i<h*h;i++){
                set2.add(i+1);
                
         }
        
        int[] res = new int[2];
        TreeSet<Integer> set = new TreeSet<>();
        
        
        for(int i=0;i<h;i++){
            for(int j=0; j<w ;j++){
                set2.remove(grid[i][j]);
                
               
                if(set.add(grid[i][j])==false){
                    res[0]=grid[i][j];
                }
            }
          
        }
        
        res[1] = new ArrayList<>(set2).get(0);
        
        return res;
        
        
    }
}
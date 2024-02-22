// https://leetcode.com/problems/find-champion-i

class Solution {
    public int findChampion(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        boolean[] lose = new boolean[h];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<h; i++){
            set.add(i);
        }
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==1){
                    set.remove(j);
                }
            }
        }
        
        return new ArrayList<>(set).get(0);
    }
}
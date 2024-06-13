// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column

class Solution {
    public int removeStones(int[][] stones) {
        
        int lands =0;
        
        Set<int[]> visited = new HashSet<>();
        
        for(int[] s1 : stones){
                
            if(!visited.contains(s1)){
                dfs(s1, stones, visited);
                lands++;    
            }
        }
        
        
        return stones.length - lands;
        
        
        
    }
    
    
    private void dfs(int[] s1, int[][]stones, Set<int[]>visited){
        
        visited.add(s1);
        for(int[] s2 : stones){
            if(!visited.contains(s2)){
                if(s1[0]==s2[0] || s1[1]==s2[1]){
                    dfs(s2, stones, visited);
                }            
            }
        }
    }
    
    
    /*
    1, 1, 0 
    1, 0, 1
    0, 1, 1
    
    */
}
// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        
       
        
        int num = 0;
        
        for(int y=0; y<grid.length;y++){
            for(int x=0; x<grid[0].length; x++){
                
                if(grid[y][x]=='1'){
                    DFS(grid, x,y);
                     num++;
                }
               
                
            }
        }
        
        return num;
        
        
    }
    
    private void DFS(char[][] grid, int x, int y){
        
         // System.out.println(x + " DFS" + y );
        
        int[] axis = new int[]{x,y};
        Stack<int[]> st = new Stack<>();
        st.push(axis);
        
        while(!st.isEmpty()){
            
            int[] cur = st.pop();
             x = cur[0];
             y = cur[1];
            // System.out.println(x + " " + y );
            
            grid[y][x] = '2';
            
            if(x-1>=0 && grid[y][x-1]=='1')
                st.push(new int[]{x-1, y});
            
            if(y-1>=0 && grid[y-1][x]=='1')
                st.push(new int[]{x, y-1});
            
            if(x+1<grid[0].length && grid[y][x+1]=='1')
                st.push(new int[]{x+1, y});
            
            if(y+1<grid.length && grid[y+1][x]=='1')
                st.push(new int[]{x, y+1});
            
            
        }
        
    }
}
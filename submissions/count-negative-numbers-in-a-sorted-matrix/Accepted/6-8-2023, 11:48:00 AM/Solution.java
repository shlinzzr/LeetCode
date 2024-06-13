// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix

class Solution {
    public int countNegatives(int[][] grid) {
        
        int h= grid.length;
        int w = grid[0].length;
        
        int h_st = find(grid, 0, h-1); // 從高度有負數的開始找 (check grid[i][w-1])
        // System.out.println(h_st);
        if(h_st==-1)
            return 0;
        
        
        int res =0 ;
        for(int i=h_st; i<h; i++){
            
            int[] row = grid[i];
            
            int st=0, ed=w-1;
            while(st<ed){
                
                int mid = st+(ed-st)/2;
                // System.out.println("i=" + i + " mid=" + mid + " " + (row[mid]>0));
                if(row[mid]<0)
                    ed = mid;
                else 
                    st = mid+1;
            }
            // System.out.println("st="+st + " cnt="+(w-st));
            res += (w-st);
        }        
        
        
        return res;
        
        
        
        
    }
    
    private int find(int[][] grid, int st , int ed){
        
        int h= grid.length;
        int w = grid[0].length;
         
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            // System.out.println(mid + " " + (grid[mid][w-1]<0));
            if(grid[mid][w-1]<0){
                ed = mid;
            }else{
                st = mid+1;
            }
            
        }
        return grid[st][w-1] <0 ? st : -1;
    }
    
    /*[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]*/
    
    
}